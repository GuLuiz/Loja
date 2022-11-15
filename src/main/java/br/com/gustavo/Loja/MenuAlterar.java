package br.com.gustavo.Loja;

import java.util.Scanner;

public class MenuAlterar {

    Scanner teclado = new Scanner(System.in);

    public void mostrarMenucat() {

        String opcao = "";

        while (!opcao.equals("0")) {
            System.out.println("+++++++++++++++++++++++++++++++++");
            System.out.println("        Alterar");
            System.out.println("+++++++++++++++++++++++++++++++++");

            System.out.println("");
            System.out.println("1. Categoria_ID");
            System.out.println("2. Nome");
            System.out.println("0. Sair");

            System.out.println("");
            System.out.print("Escolha uma opção: ");

            opcao = teclado.nextLine();
            System.out.println("Opção escolhida : " + opcao);

            if (opcao.equals("2")) {

                Categoria categoria = new Categoria();
                categoria.alterarNome();
            }

        }

    }

    public void mostrarMenuprod() {

        String opcao = "";

        while (!opcao.equals("0")) {
            System.out.println("+++++++++++++++++++++++++++++++++");
            System.out.println("        Alterar");
            System.out.println("+++++++++++++++++++++++++++++++++");

            System.out.println("");
            System.out.println("1. Nome");
            System.out.println("2. Preco");
            System.out.println("3. Estoque");
            System.out.println("4. Favoritos");
            System.out.println("0. Sair");

            System.out.println("");
            System.out.print("Escolha uma opção: ");

            opcao = teclado.nextLine();
            System.out.println("Opção escolhida : " + opcao);

            if (opcao.equals("1")) {

                Produto produto = new Produto();
                produto.alterarNome();
            }
            if (opcao.equals("2")) {

                Produto produto = new Produto();
                produto.alterarPreco();
            }
            if (opcao.equals("3")) {

                Produto produto = new Produto();
                produto.alterarEstoque();
            }
            if (opcao.equals("4")) {

                Produto produto = new Produto();
                produto.alterarFav();

            }
            if (opcao.equals("0")) {

                return;

            }

        }

    }
}
