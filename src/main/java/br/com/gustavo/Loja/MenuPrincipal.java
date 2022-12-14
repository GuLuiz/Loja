package br.com.gustavo.Loja;

import java.util.Scanner;

public class MenuPrincipal {

    Scanner teclado = new Scanner(System.in);

    public void mostrarMenuPrincipal() {

        System.out.println("+++++++++++++++++++++++++++++++++");
        System.out.println("        MENU PRINCIPAL");
        System.out.println("+++++++++++++++++++++++++++++++++");

        System.out.println("");
        System.out.println("1. Usuário");
        System.out.println("2. Categoria");
        System.out.println("3. Produto");
        System.out.println("4. Vendas");

        System.out.println("");
        System.out.print("Escolha uma opção: ");

        String opcao = teclado.nextLine();

        System.out.println("Opção escolhida : " + opcao);

        if (opcao.equals("1")) {

            MenuUsuario menuUsuario = new MenuUsuario();
            menuUsuario.mostrarMenu();
        }

        if (opcao.equals("2")) {

            MenuCategoria menuCategoria = new MenuCategoria();
            menuCategoria.mostrarMenu();
        }
        if (opcao.equals("3")) {

            MenuProduto menuProduto = new MenuProduto();
            menuProduto.mostrarMenu();
        }

        if (opcao.equals("4")) {

            MenuVenda menuVendas = new MenuVenda();
            menuVendas.mostrarMenu();
        }

    }
}
