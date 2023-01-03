package br.com.gustavo.Loja;

import java.util.Scanner;

public class MenuVenda {

    private Scanner sc = new Scanner(System.in);

    public Scanner getSc() {
        return sc;
    }

    public void setSc(Scanner sc) {
        this.sc = sc;
    }

    public void mostrarMenu() {

        String opcao = "";

        while (!opcao.equals("0")) {
            System.out.println("+++++++++++++++++++++++++++++++++");
            System.out.println("        MENU VENDA");
            System.out.println("+++++++++++++++++++++++++++++++++");

            System.out.println("");
            System.out.println("1. Inserir");
            System.out.println("2. Excluir");
            System.out.println("3. Pesquisar");
            System.out.println("0. Sair");

            System.out.println("");
            System.out.print("Escolha uma opção: ");

            opcao = sc.nextLine();

            System.out.println("Opção escolhida : " + opcao);

            if (opcao.equals("1")) {

                Venda venda = new Venda();
                venda.Inserir();
            }

            if (opcao.equals("2")) {

                Venda venda = new Venda();
                venda.excluir();

            }

            if (opcao.equals("3")) {

                Venda venda = new Venda();
                venda.pesquisar();

            }

        }

    }
}
