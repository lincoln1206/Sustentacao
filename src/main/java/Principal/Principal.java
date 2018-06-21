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
            opcao = JOptionPane.showInputDialog(" #Sustentação# \n0 - Criar Diretório de Chamado \n1 - Criar Diretório de GMUD \n2 - Criar Diretório de Problema\n3 - Gerenciar Caminhos Padrões Chamados e Problemas \n4 - Sair :");

            switch (opcao) {/* Início do Switch do Menu */
                case "0":/* Criar Diretório de Chamado */
                    m.obterDados("Chamado");
                    m.criarDirChamado();
                    break;

                case "1":/* Criar Diretório de GMUD */
                    m.criarDirGMUD();
                    break;

                case "2":/* Criar Diretório de Problema */
                    m.obterDados("Problema");
                    m.criarDirProblema();
                    break;

                case "3":/* Alterar/Criar caminhos padrão */
                    m.definirCaminhosPadrao();
                    break;

                case "4":/* Sair */
                    break;
                default:
                    Toolkit.getDefaultToolkit().beep();
                    JOptionPane.showMessageDialog(null, "Opção inválida!");
                    break;

            }/* Fim do Switch do Menu */
        } while (!opcao.contains("4"));/*
         * Fim do laço de repetição que só para se
         * "opcao" = 4
         */
    }
}
