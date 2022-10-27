package br.com.gustavo.Loja;

import java.util.Scanner;

public class MenuUsuario {

    Scanner teclado = new Scanner(System.in);

    public void mostrarMenu() {

        System.out.println("+++++++++++++++++++++++++++++++++");
        System.out.println("        MENU USUÁRIO");
        System.out.println("+++++++++++++++++++++++++++++++++");

        System.out.println("");
        System.out.println("1. Incluir");
        System.out.println("2. Excluir");
        System.out.println("3. Alterar Nome");
        System.out.println("4. Alterar Email");
        System.out.println("5. Alterar Senha");
        System.out.println("6. Listar");

        System.out.println("");
        System.out.print("Escolha uma opção: ");

        String opcao = teclado.nextLine();

        System.out.println("Opção escolhida : " + opcao);

        if (opcao.equals("1")) {

            Usuario usuario = new Usuario();
            usuario.incluir();

        }

        if (opcao.equals("2")) {

            Usuario usuario = new Usuario();
            usuario.excluir();

        }

        if (opcao.equals("3")) {

            Usuario usuario = new Usuario();
            usuario.alterarNome();

        }

        if (opcao.equals("4")) {

            Usuario usuario = new Usuario();
            usuario.alterarEmail();

        }

        if (opcao.equals("5")) {

            Usuario usuario = new Usuario();
            usuario.alterarSenha();

        }

        if (opcao.equals("6")) {

            Usuario usuario = new Usuario();
            usuario.listar();

        }

    }

}
