package Metodos;

import Variaveis.Padroes;
import Variaveis.Variaveis;
import com.google.gson.Gson;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Metodos {
    Variaveis v = new Variaveis();
    SalvarLerPadroes slp = new SalvarLerPadroes();
    private static Gson gson = new Gson();
    Padroes p = slp.obterCaminhos();

    public void criarDirChamado() {

        p = slp.obterCaminhos();

        Path path = Paths.get(p.getCaminhoChamados() + File.separator +
                "Chamados" + File.separator +
                v.getEmissor() + File.separator +
                v.getChamado() + File.separator +
                "Documentos" + File.separator + ".." + File.separator +
                "Evidencias" + File.separator + ".." + File.separator +
                "Scripts");
        String arquivoSQL = p.getCaminhoChamados() + File.separator +
                "Chamados" + File.separator +
                v.getEmissor() + File.separator +
                v.getChamado() + File.separator +
                "Scripts" + File.separator +
                "Consulta.sql";
        File f = new File(arquivoSQL);

        String origem = "\\\\10.19.20.20\\Desenvolvimento\\Sustentacao\\Laudos\\Sustentação - Laudo (Template).pptx";
        File laudoOrigem = new File(origem);

        String destino = p.getCaminhoChamados() + File.separator +
                "Chamados" + File.separator +
                v.getEmissor() + File.separator +
                v.getChamado() + File.separator +
                "Documentos" + File.separator +
                "Laudo.pptx";
        File laudoDestino = new File(destino);

        if (!(v.getEmissor().isEmpty()) && !(v.getEmissor().isEmpty())) {
            try {
                Files.createDirectories(path);
                f.getParentFile().mkdirs();
                f.createNewFile();
                slp.copyFile(laudoOrigem,laudoDestino);

            } catch (IOException e) {
                System.err.println("Não foi possível criar diretórios - " + e);
            }
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "Diretório criado com sucesso!");
        }else{
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "Falha ao criar diretório, você não digitou um dos campos!");
        }
    }

    public void obterDadosChamado() {
        v.setEmissor(JOptionPane.showInputDialog("Digite o nome do emissor"));
        v.setChamado(JOptionPane.showInputDialog("Digite o número do chamado"));
        if(v.getChamado().contains(File.separator)){
            v.setChamado(v.getChamado().replace(File.separator, "-"));
        }
    }

    public void criarDirGMUD() {

        p = slp.obterCaminhos();
        v.setGmud(JOptionPane.showInputDialog("Digite o número da GMUD"));

        Path p1 = Paths.get(p.getCaminhoGMUD() + File.separator +
                v.getGmud() + File.separator +
                "Evidências");

        try {
            Files.createDirectories(p1);
        } catch (IOException e) {
            System.err.println("Não foi possível criar os diretórios - " + e);
        }

        if(!(v.getGmud().isEmpty())) {

            v.setEmissor(JOptionPane.showInputDialog("Digite o nome do Emissor - (aperte ENTER sem digitar para terminar)"));
            while (!(v.getEmissor().isEmpty())) {
                Path p2 = Paths.get(p.getCaminhoGMUD() + File.separator +
                        v.getGmud() + File.separator + "Reversão" + File.separator + v.getEmissor());
                Path p3 = Paths.get(p.getCaminhoGMUD() + File.separator +
                        v.getGmud() + File.separator + "Scripts" + File.separator + "Data" + File.separator + v.getEmissor());
                v.setEmissor(JOptionPane.showInputDialog("Digite o nome do Emissor - (aperte ENTER sem digitar para terminar)"));
                try {
                    Files.createDirectories(p2);
                    Files.createDirectories(p3);
                } catch (IOException e) {
                    System.err.println("Não foi possível criar os diretórios - " + e);
                }
            }

            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "Diretório criado com sucesso!");
        }else{
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "Falha ao criar diretório de GMUD , você não digitou o número da GMUD!");
        }
    }

    public void definirCaminhosPadrao() {
        Padroes p = new Padroes();
        p.setCaminhoChamados(JOptionPane.showInputDialog("Digite o caminho padrão para salvar os chamados"));
        p.setCaminhoGMUD("\\\\10.1.1.14\\ScriptsDesenv\\");
        try {
            if (!p.getCaminhoChamados().isEmpty()) {
                slp.salvarArquivo(gson.toJson(p));

                Toolkit.getDefaultToolkit().beep();
                JOptionPane.showMessageDialog(null, "Caminho para criar diretórios criado/alterado com sucesso!");
            }
        } catch (NullPointerException e) {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "A operação foi cancelada!");
        }

    }
}
