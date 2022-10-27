package br.com.gustavo.Loja;

import java.sql.ResultSet;
import java.util.Scanner;

public class Categoria {

    Scanner teclado = new Scanner(System.in);

    Integer categoria_id;
    String id;
    String nomeNovo;
    String iDAntigo;
    String iDNovo;
    String nome;


public void incluir(){


    System.out.println("+++++++++++++++++++++++++++++++++");
    System.out.println("        Categoria INCLUIR");
    System.out.println("+++++++++++++++++++++++++++++++++");

    System.out.println("");

    System.out.println("Digite o código : ");
    categoria_id = teclado.nextInt();
    teclado.nextLine();
    System.out.println("Digite o nome : ");
    nome = teclado.nextLine();

    
    String sqlInsert = "insert into categoria"
    + " values ( " + categoria_id + ",'" + nome + "'," + " now())" ;

    System.out.println( sqlInsert );

    ConexaoDB conexao = new ConexaoDB();

    conexao.executeUpdate(sqlInsert);

    }

    public void excluir (){

        System.out.println("+++++++++++++++++++++++++++++++++");
        System.out.println("        CATEGORIA EXCLUIR");
        System.out.println("+++++++++++++++++++++++++++++++++");
    
        System.out.println("");
    
        System.out.println("Digite o código : ");
        categoria_id = teclado.nextInt();
        teclado.nextLine();

        String sqlDelete = "delete from categoria where categoria_id = " 
        + categoria_id;

        ConexaoDB conexao = new ConexaoDB();

        conexao.executeUpdate(sqlDelete);

    }

     public void alterarNome(){

      System.out.println(" ID da categoria : " );
      id = teclado.nextLine();
      System.out.println("Novo Nome : ");
      nomeNovo = teclado.nextLine();


        
        String sqlAlterar = "update categoria set nome = '" + nomeNovo + "' , criado = now() where categoria_id = '" 
        + id + "'";
        
        System.out.println(sqlAlterar);

        ConexaoDB conexao = new ConexaoDB();

        conexao.executeUpdate(sqlAlterar);


        }

        public void alterarID (){

            System.out.println(" ID a ser alterado : " );
      nome = teclado.nextLine();
      System.out.println("Novo ID : ");
      nome = teclado.nextLine();



        }




    public void listar (){

            System.out.println("+++++++++++++++++++++++++++++++++");
            System.out.println("        CATEGORIA LISTAR");
            System.out.println("+++++++++++++++++++++++++++++++++");
        
            System.out.println("");
    
            String sqlSelect = "select * from categoria";
    
            ConexaoDB conexao = new ConexaoDB();
            
            ResultSet dadosRetornado = conexao.executeSelect(sqlSelect);

            System.out.println("+++++++++++++++++++++++++++++++++");
            System.out.println("Cod.    Nome    Criado   ");
            System.out.println("+++++++++++++++++++++++++++++++++");
            try{
            while ( dadosRetornado.next()){
                System.out.println(
                dadosRetornado.getInt("categoria_id")+ "     " +
                dadosRetornado.getString("nome")+ "     " +
                dadosRetornado.getString("Criado")
    
                );
            }
        } catch( Exception erro){
            System.out.println("Erro : " + erro.getMessage());
        }

        


        }

}