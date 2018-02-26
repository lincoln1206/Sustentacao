package Principal;

import Metodos.Metodos;

import javax.swing.*;
import java.awt.*;

public class Principal {

    /* Menu */
    public static void main(String[] args) {
        Metodos m = new Metodos();

        String opcao;

        do {/* Inicio do laço de repetição que só para de "opcao" = 3 */

            /* Menu de opções */
            opcao = JOptionPane.showInputDialog(" #Sustentação# \n0 - Criar Diretório de Chamado \n1 - Criar Diretório de GMUD \n2 - Gerenciar Caminho Padrão para Salvar Chamados \n3 - Sair :");

            switch (opcao) {/* Início do Switch do Menu */
                case "0":/* Criar Diretório de Chamado */
                    m.obterDadosChamado();
                    m.criarDirChamado();
                    break;

                case "1":/* Criar Diretório de GMUD */
                    m.criarDirGMUD();
                    break;

                case "2":/* Alterar/Criar caminhos padrão */
                    m.definirCaminhosPadrao();
                    break;
                case "3":/* Sair */
                    break;
                default:
                    Toolkit.getDefaultToolkit().beep();
                    JOptionPane.showMessageDialog(null, "Opção inválida!");
                    break;

            }/* Fim do Switch do Menu */
        } while (!opcao.contains("3"));/*
         * Fim do laço de repetição que só para de
         * "opcao" = 3
         */
    }
}
