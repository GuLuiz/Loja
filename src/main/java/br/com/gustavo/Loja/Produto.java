package br.com.gustavo.Loja;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Locale;
import java.util.Scanner;

import javax.lang.model.util.ElementScanner6;

public class Produto {

    Scanner sc = new Scanner(System.in);

    public int getIs_favoritoInt() {
        return is_favoritoInt;
    }

    public void setIs_favoritoInt(int is_favoritoInt) {
        this.is_favoritoInt = is_favoritoInt;
    }

    private int produto_id, categoria_id = 0;
    private String nome = "";
    private Double preco, estoque;
    private int is_favoritoInt;
    private Boolean is_favorito;

    public Scanner getSc() {
        return sc;
    }

    public void setSc(Scanner sc) {
        this.sc = sc;
    }

    public int getProduto_id() {
        return produto_id;
    }

    public void setProduto_id(int produto_id) {
        this.produto_id = produto_id;
    }

    public int getCategoria_id() {
        return categoria_id;
    }

    public void setCategoria_id(int categoria_id) {
        this.categoria_id = categoria_id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Boolean getIs_favorito() {
        return is_favorito;
    }

    public void setIs_favorito(Boolean is_favorito) {
        this.is_favorito = is_favorito;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Double getEstoque() {
        return estoque;
    }

    public void setEstoque(Double estoque) {
        this.estoque = estoque;
    }

    public void incluir() {

        System.out.println("+++++++++++++++++++++++++++++++++");
        System.out.println("        USUÁRIO INCLUIR");
        System.out.println("+++++++++++++++++++++++++++++++++");

        System.out.println("");

        String sqlSelect = "select * from categoria";

        ConexaoDB conexao = new ConexaoDB();

        ResultSet dadosRetornado = conexao.executeSelect(sqlSelect);

        System.out.println("+++++++++++++++++++++++++++++++++");
        System.out.println("Cod.    Nome    Criado   ");
        System.out.println("+++++++++++++++++++++++++++++++++");
        try {
            while (dadosRetornado.next()) {
                System.out.println(
                        dadosRetornado.getInt("categoria_id") + "     " +
                                dadosRetornado.getString("nome") + "     " +
                                dadosRetornado.getString("Criado")

                );
            }
        } catch (Exception erro) {
            System.out.println("Erro : " + erro.getMessage());
        }

        System.out.println("Digite a categoria desejada : ");
        categoria_id = sc.nextInt();
        sc.nextLine();

        sqlSelect = "select * from categoria where categoria_id = " + categoria_id;

        conexao = new ConexaoDB();

        dadosRetornado = conexao.executeSelect(sqlSelect);

        try {
            if (!dadosRetornado.next()) {

                System.out.println("Categoria inválida");
                return;
            }

        } catch (Exception erro) {
            System.out.println("Erro : " + erro.getMessage());
        }

        System.out.println("Digite o nome : ");
        nome = sc.nextLine();
        if (nome.equals("")) {
            System.out.println("");
            System.out.println("Nome inválido");

            return;
        }

        System.out.println("Digite o preco : ");
        preco = sc.nextDouble();
        if (preco <= 0) {
            System.out.println("Valor inválido");
            return;

        }

        System.out.println("Digite o estoque : ");
        estoque = sc.nextDouble();
        if (estoque <= 0) {
            System.out.println("Valor inválido");
            return;
        }
        System.out.println("Deseja favoritar? ");
        System.out.println("1. Sim ");
        System.out.println("2. Não ");
        is_favoritoInt = sc.nextInt();
        if (is_favoritoInt == 1) {

            is_favorito = true;
        } else if (is_favoritoInt == 2) {

            is_favorito = false;
        } else {

            System.out.println("Opção inválida");
            return;
        }

        String sqlInsert = "insert into produto ( nome, preco, estoque, categoria_id, is_favorito, criado , precoatualizado) "
                + " values ('" + nome + "'," + preco + "," + estoque + "," + categoria_id + ",'" + is_favorito
                + "' , now() , now())";

        System.out.println(sqlInsert);

        conexao.executeUpdate(sqlInsert);

    }

    public void excluir() {

        System.out.println("+++++++++++++++++++++++++++++++++");
        System.out.println("        PRODUTO EXCLUIR");
        System.out.println("+++++++++++++++++++++++++++++++++");

        System.out.println("");

        System.out.println("Digite o codigo : ");
        produto_id = sc.nextInt();
        sc.nextLine();

        String sqlDelete = "delete from produto where produto_id = "
                + produto_id;

        ConexaoDB conexao = new ConexaoDB();

        conexao.executeUpdate(sqlDelete);

    }

    public void alterarNome() {

        System.out.println(" ID do produto : ");
        produto_id = sc.nextInt();
        System.out.println("Novo Nome : ");
        String nomeNovo = sc.nextLine();

        String sqlAlterar = "update produto set nome = '" + nomeNovo + "' where produto_id = '"
                + produto_id + "'";

        System.out.println(sqlAlterar);

        ConexaoDB conexao = new ConexaoDB();

        conexao.executeUpdate(sqlAlterar);

    }

    public void alterarPreco() {

        System.out.println("ID do produto : ");
        produto_id = sc.nextInt();
        System.out.println("Novo preco : ");
        int novoPreco = sc.nextInt();

        String sqlAlterar = "update produto set preco = '" + novoPreco + "' where produto_id = '"
                + produto_id + "'";

        System.out.println(sqlAlterar);

        ConexaoDB conexao = new ConexaoDB();

        conexao.executeUpdate(sqlAlterar);

    }

    public void alterarEstoque() {

        System.out.println("ID do produto : ");
        produto_id = sc.nextInt();
        System.out.println("Novo estoque : ");
        int novoEstoque = sc.nextInt();

        String sqlAlterar = "update produto set estoque = '" + novoEstoque + "' where produto_id = '"
                + produto_id + "'";

        System.out.println(sqlAlterar);

        ConexaoDB conexao = new ConexaoDB();

        conexao.executeUpdate(sqlAlterar);

    }

    public void alterarFav() {

        System.out.println("ID do produto : ");
        produto_id = sc.nextInt();

        String sqlSelect = "select is_favorito from produto where produto_id = " + produto_id;

        ConexaoDB conexao = new ConexaoDB();

        ResultSet dadosRetornado = conexao.executeSelect(sqlSelect);

        try {
            if (dadosRetornado.next()) {

                System.out.println("Valor atual : " + dadosRetornado.getBoolean("is_favorito"));
                System.out.println("Oque deseja fazer?");

                System.out.println("1. Favoritar ");
                System.out.println("2. Desfavoritar ");
                is_favoritoInt = sc.nextInt();

            }
            if (is_favoritoInt == 1) {

                String sqlAlterar = "update produto set is_favorito = TRUE where produto_id = '"
                        + produto_id + "'";

                System.out.println(sqlAlterar);

                conexao = new ConexaoDB();

                conexao.executeUpdate(sqlAlterar);

            } else if (is_favoritoInt == 2) {

                String sqlAlterar = "update produto set is_favorito = FALSE where produto_id = '"
                        + produto_id + "'";

                System.out.println(sqlAlterar);

                conexao = new ConexaoDB();

                conexao.executeUpdate(sqlAlterar);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void listar() {

        System.out.println("+++++++++++++++++++++++++++++++++");
        System.out.println("        PRODUTO LISTAR");
        System.out.println("+++++++++++++++++++++++++++++++++");

        System.out.println("");

        String sqlSelect = "select produto_id , produto.nome nome_do_produto , preco, categoria.nome from produto inner join categoria on produto.categoria_id = categoria.categoria_id";

        ConexaoDB conexao = new ConexaoDB();

        ResultSet dadosRetornado = conexao.executeSelect(sqlSelect);

        System.out.println("+++++++++++++++++++++++++++++++++");
        System.out.println("Cod.    Nome    Preco    Categoria");
        System.out.println("+++++++++++++++++++++++++++++++++");
        try {
            while (dadosRetornado.next()) {
                System.out.println(
                        dadosRetornado.getInt("produto_id") + "     " +
                                dadosRetornado.getString("nome_do_produto") + "     " +
                                dadosRetornado.getDouble("preco") + "     " +
                                dadosRetornado.getString("Nome"));
            }
        } catch (Exception erro) {
            System.out.println("Erro : " + erro.getMessage());
        }

    }
}
