package Metodos;

import Variaveis.Padroes;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import javax.swing.*;
import java.io.*;
import java.nio.channels.FileChannel;

public class SalvarLerPadroes {

    private static String local = (System.getProperty("user.dir")) + File.separator + "padroes.json";
    private static Gson gson = new Gson();
    Padroes p = new Padroes();

    // Salva o arquivo
    public static void salvarArquivo(String myData) {

        File f = new File(local);

        if (!f.exists()) {
            try {
                File directory = new File(f.getParent());
                if (!directory.exists()) {
                    directory.mkdirs();
                }
                f.createNewFile();
            } catch (IOException e) {
                log("erro ocorreu: " + e.toString());
            }
        }

        try {
            // Convenience class for writing character files
            FileWriter padroes;
            padroes = new FileWriter(f.getAbsoluteFile(), true);

            // Writes text to a character-output stream
            BufferedWriter bufferWriter = new BufferedWriter(padroes);
            bufferWriter.write(myData.toString());
            bufferWriter.close();

            log("Arquivos de diretórios padrões salvos em: " + local + " Dados: " + myData + "\n");
        } catch (IOException e) {
            log("Hmm.. Ocorreu um erro enquanto era salvo o arquivo" + e.toString());
        }
    }

    private static void log(String string) {
        System.out.println(string);
    }

    // Lê o arquivo
    public Padroes obterCaminhos() {
        File arquivoPadroes = new File(local);
        JsonReader myReader;
        InputStreamReader isReader = null;
        Padroes p = new Padroes();

        if (!arquivoPadroes.exists()) {
            JOptionPane.showMessageDialog(null, "Arquivo de Caminhos Padrão não existe!");
            p.setCaminhoChamados(JOptionPane.showInputDialog("Digite o caminho padrão para salvar os chamados"));
            p.setCaminhoGMUD("\\\\10.1.1.14\\ScriptsDesenv\\");
            try {
                if (!p.getCaminhoChamados().isEmpty()) {
                    salvarArquivo(gson.toJson(p));
                }
            }catch (Exception e) {
                log("Hmm.. Ocorreu um erro enquanto era salvo o arquivo" + e.toString());
            }
        }

        try {
            isReader = new InputStreamReader(new FileInputStream(arquivoPadroes), "UTF-8");
        } catch (Exception e) {
            log("erro ao carregar dados de arquivo " + e.toString());
        }
        myReader = new JsonReader(isReader);
        p = gson.fromJson(myReader, Padroes.class);

        log("Caminho chamados: " + p.getCaminhoChamados());
        log("Caminho GMUD: " + p.getCaminhoGMUD());

        log("\nDados de caminho padrão carregados com sucesso do arquivo " + local);
        return p;
    }

    public static void copyFile(File source, File destination) throws IOException {
        if (destination.exists())
            destination.delete();
        FileChannel sourceChannel = null;
        FileChannel destinationChannel = null;
        try {
            sourceChannel = new FileInputStream(source).getChannel();
            destinationChannel = new FileOutputStream(destination).getChannel();
            sourceChannel.transferTo(0, sourceChannel.size(),
                    destinationChannel);
        } finally {
            if (sourceChannel != null && sourceChannel.isOpen())
                sourceChannel.close();
            if (destinationChannel != null && destinationChannel.isOpen())
                destinationChannel.close();
        }
    }

}
