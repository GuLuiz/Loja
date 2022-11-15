package br.com.gustavo.Loja;

import java.util.Scanner;

public class MenuCategoria {

    Scanner teclado = new Scanner(System.in);

    public void mostrarMenu() {

        String opcao = "";

        while (!opcao.equals("0")) {
            System.out.println("+++++++++++++++++++++++++++++++++");
            System.out.println("        MENU CATEGORIA");
            System.out.println("+++++++++++++++++++++++++++++++++");

            System.out.println("");
            System.out.println("1. Incluir");
            System.out.println("2. Excluir");
            System.out.println("3. Alterar");
            System.out.println("4. Listar");
            System.out.println("0. Sair");

            System.out.println("");
            System.out.print("Escolha uma opção: ");

            opcao = teclado.nextLine();

            System.out.println("Opção escolhida : " + opcao);

            if (opcao.equals("1")) {

                Categoria categoria = new Categoria();
                categoria.incluir();

            }

            if (opcao.equals("2")) {

                Categoria categoria = new Categoria();
                categoria.excluir();
            }

            if (opcao.equals("3")) {

                MenuAlterar menuAlterar = new MenuAlterar();
                menuAlterar.mostrarMenucat();
            }

            if (opcao.equals("4")) {

                Categoria categoria = new Categoria();
                categoria.listar();
            }
        }
    }

}
