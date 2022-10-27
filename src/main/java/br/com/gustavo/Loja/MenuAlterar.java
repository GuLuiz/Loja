package br.com.gustavo.Loja;

import java.util.Scanner;

public class MenuAlterar {

    Scanner teclado = new Scanner(System.in); 
    
    public void mostrarMenu(){

        System.out.println("+++++++++++++++++++++++++++++++++");
        System.out.println("        Alterar");
        System.out.println("+++++++++++++++++++++++++++++++++");
        
        System.out.println("");
        System.out.println("1. Categoria_ID");
        System.out.println("2. Nome");
        
        System.out.println("");
        System.out.print("Escolha uma opção: ");
        
        String opcao = teclado.nextLine();
        System.out.println("Opção escolhida : " + opcao);

        if( opcao.equals("2")){

            Categoria categoria = new Categoria();
            categoria.alterarNome();
            }
      



    }
}
