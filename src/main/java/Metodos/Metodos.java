package Metodos;

import Variaveis.Padroes;
import Variaveis.Variaveis;
import com.google.gson.Gson;
import lombok.extern.java.Log;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static javax.swing.JOptionPane.*;
import static org.apache.commons.io.FileUtils.copyFile;

@Log
public class Metodos {
    Variaveis v = new Variaveis();
    SalvarLerPadroes slp = new SalvarLerPadroes();
    private static Gson gson = new Gson();
    Padroes p = slp.obterCaminhos();

    public void criarDirChamado() {

        p = slp.obterCaminhos();
        String caminhoChamado = p.getCaminhoChamados() + File.separator +
                "Chamados" + File.separator +
                v.getEmissor() + File.separator +
                v.getChamado();

        Path path = Paths.get(p.getCaminhoChamados() + File.separator +
                "Chamados" + File.separator +
                v.getEmissor() + File.separator +
                v.getChamado() + File.separator +
                "Documentos" + File.separator + ".." + File.separator +
                "Evidencias" + File.separator + ".." + File.separator +
                "Scripts" + File.separator + ".." + File.separator +
                "GMUD" + File.separator +
                "Evidências" + File.separator + ".." + File.separator +
                "Reversão" + File.separator + ".." + File.separator +
                "Scripts");
        String arquivoSQL = p.getCaminhoChamados() + File.separator +
                "Chamados" + File.separator +
                v.getEmissor() + File.separator +
                v.getChamado() + File.separator +
                "Scripts" + File.separator +
                "Consulta.sql";
        File f = new File(arquivoSQL);

        String origem = "\\\\10.19.20.20\\Desenvolvimento\\Sustentacao\\App Sustentação - JAVA\\Arquivos\\Sustentação - Laudo (Template).pptx";
        File laudoOrigem = new File(origem);

        String origem2 = "\\\\10.19.20.20\\Desenvolvimento\\Sustentacao\\App Sustentação - JAVA\\Arquivos\\Formulário - GMUD.Script.xlsx";
        File form1 = new File(origem2);

        String origem3 = "\\\\10.19.20.20\\Desenvolvimento\\Sustentacao\\App Sustentação - JAVA\\Arquivos\\Formulário Objeto.xlsx";
        File form2 = new File(origem3);

        String destino = p.getCaminhoChamados() + File.separator +
                "Chamados" + File.separator +
                v.getEmissor() + File.separator +
                v.getChamado() + File.separator +
                "Documentos" + File.separator +
                "Laudo.pptx";
        File laudoDestino = new File(destino);

        String destino1 = p.getCaminhoChamados() + File.separator +
                "Chamados" + File.separator +
                v.getEmissor() + File.separator +
                v.getChamado() + File.separator +
                "GMUD" + File.separator +
                "Formulário - GMUD Script.xlsx";
        File formDestino1 = new File(destino1);

        String destino2 = p.getCaminhoChamados() + File.separator +
                "Chamados" + File.separator +
                v.getEmissor() + File.separator +
                v.getChamado() + File.separator +
                "GMUD" + File.separator +
                "Formulário - GMUD Objeto.xlsx";
        File formDestino2 = new File(destino2);

        criarDirGenerico(path, form1, form2, formDestino1, formDestino2, f, caminhoChamado, laudoOrigem, laudoDestino);
    }

    public void criarDirProblema() {

        p = slp.obterCaminhos();
        String caminhoProblema = p.getCaminhoProblema() + File.separator +
                "Problemas" + File.separator +
                v.getEmissor() + File.separator +
                v.getChamado();

        Path path = Paths.get(p.getCaminhoProblema() + File.separator +
                "Problemas" + File.separator +
                v.getEmissor() + File.separator +
                v.getChamado() + File.separator +
                "Documentos" + File.separator + ".." + File.separator +
                "Evidencias" + File.separator + ".." + File.separator +
                "Scripts" + File.separator + ".." + File.separator +
                "GMUD" + File.separator +
                "Evidências" + File.separator + ".." + File.separator +
                "Reversão" + File.separator + ".." + File.separator +
                "Scripts");
        String arquivoSQL = p.getCaminhoProblema() + File.separator +
                "Problemas" + File.separator +
                v.getEmissor() + File.separator +
                v.getChamado() + File.separator +
                "Scripts" + File.separator +
                "Consulta.sql";
        File f = new File(arquivoSQL);

        String origem;
        origem = "\\\\10.19.20.20\\Desenvolvimento\\Sustentacao\\App Sustentação - JAVA\\Arquivos\\Sustentação - Laudo - Problemas.pptx";
        File laudoOrigem = new File(origem);

        String origem2;
        origem2 = "\\\\10.19.20.20\\Desenvolvimento\\Sustentacao\\App Sustentação - JAVA\\Arquivos\\Formulário - GMUD.Script.xlsx";
        File form1 = new File(origem2);

        String origem3;
        origem3 = "\\\\10.19.20.20\\Desenvolvimento\\Sustentacao\\App Sustentação - JAVA\\Arquivos\\Formulário Objeto.xlsx";
        File form2 = new File(origem3);

        String destino = p.getCaminhoChamados() + File.separator +
                "Problemas" + File.separator +
                v.getEmissor() + File.separator +
                v.getChamado() + File.separator +
                "Documentos" + File.separator +
                "Laudo.pptx";
        File laudoDestino = new File(destino);

        String destino1 = p.getCaminhoChamados() + File.separator +
                "Problemas" + File.separator +
                v.getEmissor() + File.separator +
                v.getChamado() + File.separator +
                "GMUD" + File.separator +
                "Formulário - GMUD Script.xlsx";
        File formDestino1 = new File(destino1);

        String destino2 = p.getCaminhoChamados() + File.separator +
                "Problemas" + File.separator +
                v.getEmissor() + File.separator +
                v.getChamado() + File.separator +
                "GMUD" + File.separator +
                "Formulário - GMUD Objeto.xlsx";
        File formDestino2 = new File(destino2);

        criarDirGenerico(path, form1, form2, formDestino1, formDestino2, f, caminhoProblema, laudoOrigem, laudoDestino);

    }

    public void obterDados(String tipo) {
        v.setEmissor(showInputDialog("Digite o nome do emissor"));
        v.setChamado(showInputDialog(new StringBuilder().append("Digite o número do ").append(tipo).toString()));
        if (v.getChamado().contains(File.separator)) v.setChamado(v.getChamado().replace(File.separator, "-"));
        if (v.getChamado().contains("/")) v.setChamado(v.getChamado().replace("/", "-"));
        if (v.getChamado().contains("<")) v.setChamado(v.getChamado().replace("<", "-"));
        if (v.getChamado().contains(">")) v.setChamado(v.getChamado().replace(">", "-"));
        if (v.getChamado().contains("*")) v.setChamado(v.getChamado().replace("*", "-"));
        if (v.getChamado().contains("|")) v.setChamado(v.getChamado().replace("|", "-"));
        if (v.getChamado().contains("?")) v.setChamado(v.getChamado().replace("?", "-"));
        if (v.getChamado().contains(":")) v.setChamado(v.getChamado().replace(":", "-"));
        if (v.getChamado().contains("\"")) v.setChamado(v.getChamado().replace("\"", "-"));
    }

    public void criarDirGenerico(Path path, File form1, File form2, File formDestino1, File formDestino2, File f, String caminhoChamado, File laudoOrigem, File laudoDestino) {
        if (!(v.getEmissor().isEmpty()) && !(v.getEmissor().isEmpty())) {
            try {
                Files.createDirectories(path);
                f.getParentFile().mkdirs();
                f.createNewFile();
                copyFile(laudoOrigem, laudoDestino);
                copyFile(form1, formDestino1);
                copyFile(form2, formDestino2);

            } catch (IOException e) {
                System.err.println("Não foi possível criar diretórios - " + e);
            }
            Toolkit.getDefaultToolkit().beep();
            showMessageDialog(null, String.format("Diretório criado com sucesso no caminho:\n%s", caminhoChamado));
            log.fine(String.format("Diretório criado com sucesso no caminho: %s", caminhoChamado));
            slp.abrirPasta(caminhoChamado);
        } else {
            Toolkit.getDefaultToolkit().beep();
            showMessageDialog(null, "Falha ao criar diretório, você não digitou um dos campos!");
            log.warning("Falha ao criar diretório, usuário não digitou um dos campos!");
        }
    }

    public void criarDirGMUD() {

        /*
        obterDadosChamado();
        */
        p = slp.obterCaminhos();
        v.setGmud(showInputDialog("Digite o número da GMUD"));
        String caminhoGMUD = p.getCaminhoGMUD() + v.getGmud();

        int temReversao = 0;

        temReversao = showConfirmDialog(null, "Tem reversão?", "Criar Diretório de GMUD", temReversao);
        System.out.println(temReversao);

        Path p1 = Paths.get(p.getCaminhoGMUD() + File.separator +
                v.getGmud() + File.separator +
                "Evidências");

        try {
            Files.createDirectories(p1);

        } catch (IOException e) {
            showMessageDialog(null, "Falha ao criar diretório!");
            log.warning("Não foi possível criar os diretórios - " + e.toString());
        }

        if (!(v.getGmud().isEmpty())) {

            v.setEmissor(showInputDialog("Digite o nome do Emissor - (aperte ENTER sem digitar para terminar)"));
            while (!(v.getEmissor().isEmpty())) {
                Path p2 = Paths.get(p.getCaminhoGMUD() + File.separator +
                        v.getGmud() + File.separator + "Reversão" + File.separator + v.getEmissor());

                Path p3 = Paths.get(p.getCaminhoGMUD() + File.separator +
                        v.getGmud() + File.separator + "Scripts" + File.separator + v.getEmissor());
                v.setEmissor(showInputDialog("Digite o nome do Emissor - (aperte ENTER sem digitar para terminar)"));

                try {
                    if (temReversao == 0) {
                        Files.createDirectories(p2);
                    }
                    Files.createDirectories(p3);

                } catch (IOException e) {
                    showMessageDialog(null, "Falha ao criar diretório!");
                    log.warning("Não foi possível criar os diretórios - " + e.toString());
                }
            }

            Toolkit.getDefaultToolkit().beep();
            showMessageDialog(null, "Diretório criado com sucesso no caminho:\n" + caminhoGMUD);
            log.fine(String.format("Diretório criado com sucesso no caminho:\n%s", caminhoGMUD));
            slp.abrirPasta(caminhoGMUD);
        } else {
            Toolkit.getDefaultToolkit().beep();
            showMessageDialog(null, "Falha ao criar diretório de GMUD , você não digitou o número da GMUD!");
            log.warning("Falha ao criar diretório de GMUD , usuário não digitou o número da GMUD!");
        }
    }

    public void definirCaminhosPadrao() {
        Padroes p = new Padroes();
        p.setCaminhoChamados(showInputDialog("Digite o caminho padrão para salvar os chamados"));
        p.setCaminhoProblema(showInputDialog("Digite o caminho padrão para salvar os problemas"));
        p.setCaminhoGMUD("\\\\10.1.1.14\\ScriptsDesenv\\");
        try {
            if (!p.getCaminhoChamados().isEmpty()) {
                slp.salvarArquivo(gson.toJson(p));

                Toolkit.getDefaultToolkit().beep();
                showMessageDialog(null, "Caminho para criar diretórios definido com sucesso!");
                log.fine("Caminho para criar diretórios definido com sucesso!");
            }
        } catch (NullPointerException e) {
            Toolkit.getDefaultToolkit().beep();
            showMessageDialog(null, "A operação foi cancelada!");
            log.warning("A operação de definirCaminhosPadrao foi cancelada.");
        }

    }
}
