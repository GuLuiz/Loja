package br.com.gustavo.Loja;

import java.util.Scanner;

public class MenuUsuario {

     private Scanner teclado = new Scanner(System.in);

    public Scanner getTeclado() {
        return teclado;
    }

    public void setTeclado(Scanner teclado) {
        this.teclado = teclado;
    }

    public void mostrarMenu() {

        String opcao = "";

        while( ! opcao.equals("0")){
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
        System.out.println("0. Sair");

        System.out.println("");
        System.out.print("Escolha uma opção: ");

         opcao = teclado.nextLine();

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

}
