package br.com.gustavo.Loja;

import java.sql.ResultSet;
import java.util.Scanner;

public class Usuario {

    private Scanner teclado = new Scanner(System.in);

    private Integer usuario_id;
    private String nome;
    private String email;
    private String senha;

    public Scanner getTeclado() {
        return teclado;
    }

    public void setTeclado(Scanner teclado) {
        this.teclado = teclado;
    }

    public Integer getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(Integer usuario_id) {
        this.usuario_id = usuario_id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void incluir() {

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

        // Comando para o Banco de dados
        String sqlInsert = "insert into usuario ( usuario_id, nome, email, senha) "
                + " values ( " + usuario_id + ",'" + nome + "','" + email + "','" + senha + "')";

        ConexaoDB conexao = new ConexaoDB();

        conexao.executeUpdate(sqlInsert);

    }

    public void alterarNome() {

        System.out.println(" ID do usuario : ");
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

    public void alterarEmail() {

        System.out.println(" ID do usuario : ");
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

    public void excluir() {

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

    public void listar() {

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
        try {
            while (dadosRetornado.next()) {
                System.out.println(
                        dadosRetornado.getInt("usuario_id") + "     " +
                                dadosRetornado.getString("nome") + "     " +
                                dadosRetornado.getString("email")

                );
            }
        } catch (Exception erro) {
            System.out.println("Erro : " + erro.getMessage());
        }

    }

    public void alterarSenha() {

        System.out.println(" ID do usuario : ");
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
