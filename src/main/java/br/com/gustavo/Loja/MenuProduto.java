package br.com.gustavo.Loja;

import java.util.Locale;
import java.util.Scanner;

public class MenuProduto {

    public void mostrarMenu() {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        String opcao = "";

        while (!opcao.equals("0")) {
            System.out.println("+++++++++++++++++++++++++++++++++");
            System.out.println("        MENU PRODUTO");
            System.out.println("+++++++++++++++++++++++++++++++++");

            System.out.println("");
            System.out.println("1. Incluir");
            System.out.println("2. Excluir");
            System.out.println("3. Alterar");
            System.out.println("4. Listar");
            System.out.println("0. Sair");

            System.out.println("");
            System.out.print("Escolha uma opção: ");

            opcao = sc.nextLine();

            System.out.println("Opção escolhida : " + opcao);

            if (opcao.equals("1")) {

                Produto produto = new Produto();
                produto.incluir();

            }

            if (opcao.equals("2")) {

                Produto produto = new Produto();
                produto.excluir();
            }

            if (opcao.equals("3")) {

                MenuAlterar menuAlterar = new MenuAlterar();
                menuAlterar.mostrarMenuprod();
            }

            if (opcao.equals("4")) {

                Produto produto = new Produto();
                produto.listar();

            }
        }
    }

}
