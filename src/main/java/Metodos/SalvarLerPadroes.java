package Metodos;

import Variaveis.Padroes;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import lombok.extern.java.Log;

import java.awt.*;
import java.io.*;

import static javax.swing.JOptionPane.showInputDialog;
import static javax.swing.JOptionPane.showMessageDialog;

@Log
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
                log.fine(String.format("erro ocorreu: %s", e.toString()));
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

            log.fine(String.format("Arquivos de diretórios padrões salvos em: %s Dados: %s\n", local, myData));
        } catch (IOException e) {
            log.warning(String.format("Hmm.. Ocorreu um erro enquanto era salvo o arquivo%s", e.toString()));
        }
    }

    public static void abrirPasta(String caminho) {
        try {
            Desktop.getDesktop().open(new File(caminho));
            log.fine(String.format("Diretório %s foi aberto com sucesso.", caminho));
        } catch (IOException e) {
            log.warning(String.format("Ocorreu um erro ao abrir a pasta: %s", caminho));
            e.printStackTrace();
        }
    }

    // Lê o arquivo
    public Padroes obterCaminhos() {
        File arquivoPadroes = new File(local);
        JsonReader myReader;
        InputStreamReader isReader = null;
        Padroes p = new Padroes();

        if (!arquivoPadroes.exists()) {
            Toolkit.getDefaultToolkit().beep();
            showMessageDialog(null, "Arquivo de Caminhos Padrão não existe!");
            log.warning("Arquivo de Caminhos Padrão não existe!");
            p.setCaminhoChamados(showInputDialog("Digite o caminho padrão para salvar os chamados"));
            p.setCaminhoProblema(showInputDialog("Digite o caminho padrão para salvar os problemas"));
            p.setCaminhoGMUD("\\\\10.1.1.14\\ScriptsDesenv\\");
            try {
                if (!p.getCaminhoChamados().isEmpty()) {
                    salvarArquivo(gson.toJson(p));
                }
            } catch (Exception e) {
                log.warning(String.format("Hmm.. Ocorreu um erro enquanto era salvo o arquivo%s.", e.toString()));
            }
        }

        try {
            isReader = new InputStreamReader(new FileInputStream(arquivoPadroes), "UTF-8");
        } catch (Exception e) {
            log.warning(String.format("erro ao carregar dados de arquivo %s.", e.toString()));
        }
        myReader = new JsonReader(isReader);
        p = gson.fromJson(myReader, Padroes.class);

        log.fine(String.format("Caminho chamados: %s", p.getCaminhoChamados()));
        log.fine(String.format("Caminho GMUD: %s", p.getCaminhoGMUD()));

        log.fine(String.format("\nDados de caminho padrão carregados com sucesso do arquivo %s.", local));
        return p;
    }

}
