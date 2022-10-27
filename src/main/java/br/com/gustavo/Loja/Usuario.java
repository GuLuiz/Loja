package br.com.gustavo.Loja;

import java.sql.ResultSet;
import java.util.Scanner;


public class Usuario {

    Scanner teclado = new Scanner(System.in);


    Integer usuario_id;
    String nome;
    String email;
    String senha;



 public void incluir(){

    System.out.println("+++++++++++++++++++++++++++++++++");
    System.out.println("        USUÁRIO INCLUIR");
    System.out.println("+++++++++++++++++++++++++++++++++");

    System.out.println("");

    System.out.println("Digite o código : ");
    usuario_id = teclado.nextInt();
    teclado.nextLine();
    System.out.println("Digite o nome : ");
    nome = teclado.nextLine();
    System.out.println("Digite o email : ");
    email = teclado.nextLine();
    System.out.println("Digite a senha : ");
    senha = teclado.nextLine();


    //Comando para o Banco de dados
    String sqlInsert = "insert into usuario ( usuario_id, nome, email, senha) "
    + " values ( " + usuario_id + ",'" + nome + "','" + email + "','" + senha + "')";

    ConexaoDB conexao = new ConexaoDB();

    conexao.executeUpdate(sqlInsert);


 }


 public void alterarNome(){

    System.out.println(" ID do usuario : " );
    usuario_id = teclado.nextInt();
    teclado.nextLine();
    System.out.println("Novo Nome : ");
    nome = teclado.nextLine();


      
      String sqlAlterar = "update usuario set nome = '" + nome + "' where usuario_id = '" 
      + usuario_id + "'";
      
      System.out.println(sqlAlterar);

      ConexaoDB conexao = new ConexaoDB();

      conexao.executeUpdate(sqlAlterar);


      }

      public void alterarEmail(){

        System.out.println(" ID do usuario : " );
        usuario_id = teclado.nextInt();
        teclado.nextLine();
        System.out.println("Novo email : ");
        email = teclado.nextLine();
    
    
          
          String sqlAlterar = "update usuario set email = '" + email + "' where usuario_id = '" 
          + usuario_id + "'";
          
          System.out.println(sqlAlterar);
    
          ConexaoDB conexao = new ConexaoDB();
    
          conexao.executeUpdate(sqlAlterar);
    
    
          }
         

    
    public void excluir (){

        System.out.println("+++++++++++++++++++++++++++++++++");
        System.out.println("        USUÁRIO EXCLUIR");
        System.out.println("+++++++++++++++++++++++++++++++++");
    
        System.out.println("");
    
        System.out.println("Digite o código : ");
        usuario_id = teclado.nextInt();
        teclado.nextLine();

        String sqlDelete = "delete from usuario where categoria_id = " 
        + usuario_id;

        ConexaoDB conexao = new ConexaoDB();

        conexao.executeUpdate(sqlDelete);

    }






    public void listar (){

        System.out.println("+++++++++++++++++++++++++++++++++");
        System.out.println("        USUÁRIO LISTAR");
        System.out.println("+++++++++++++++++++++++++++++++++");
    
        System.out.println("");

        String sqlSelect = "select * from usuario";

        ConexaoDB conexao = new ConexaoDB();

        ResultSet dadosRetornado = conexao.executeSelect(sqlSelect);

        System.out.println("+++++++++++++++++++++++++++++++++");
        System.out.println("Cod.    Nome    Email   ");
        System.out.println("+++++++++++++++++++++++++++++++++");
        try{
        while ( dadosRetornado.next()){
            System.out.println(
            dadosRetornado.getInt("usuario_id")+ "     " +
            dadosRetornado.getString("nome")+ "     " +
            dadosRetornado.getString("email")

            );
        }
    } catch( Exception erro){
        System.out.println("Erro : " + erro.getMessage());
    }

    }


    public void alterarSenha() {

        System.out.println(" ID do usuario : " );
        usuario_id = teclado.nextInt();
        teclado.nextLine();
        System.out.println("Nova Senha : ");
        senha = teclado.nextLine();
    
    
          
          String sqlAlterar = "update usuario set senha = '" + senha + "' where usuario_id = '" 
          + usuario_id + "'";
          
          System.out.println(sqlAlterar);
    
          ConexaoDB conexao = new ConexaoDB();
    
          conexao.executeUpdate(sqlAlterar);

    }


}
