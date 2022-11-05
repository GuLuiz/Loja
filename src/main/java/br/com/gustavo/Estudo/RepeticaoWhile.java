package br.com.gustavo.Estudo;

import java.util.Date;
import java.util.Scanner;


public class RepeticaoWhile {
    
    public static void main(String a[]){

    exemploContinue();
    exemploString();


    }

    private static void exemploString(){

        Scanner sc = new Scanner(System.in);

        String frase = "";
        // condição ou expressão lógica
        //números : == , != , > , < , >= , <=
        // String : equals , ! equals



        while (! frase.equals("sair")){
        
            System.out.println("linha : " + new Date());

            System.out.println("Para sair digite : sair ");
            frase = sc.nextLine();

            sc.close();
        }

        System.out.println("Fim");

    }

    private static void exemploContinue(){

        int contador = 0;
        while (contador < 10){
            System.out.println("Linha : " + new Date());
            contador = contador + 1;


        }
        System.out.println("Fim");

    }




}