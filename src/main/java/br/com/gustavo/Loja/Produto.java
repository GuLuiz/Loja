package br.com.gustavo.Loja;

import java.util.Scanner;

public class Produto {
    
    Scanner sc = new Scanner(System.in);

    private int produto_id , categoria_id = 0;
    private String nome , is_favorito = "";
    private Double preco , estoque = 0.0;


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
    public String getIs_favorito() {
        return is_favorito;
    }
    public void setIs_favorito(String is_favorito) {
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

        while(nome.equals("")){

        System.out.println("+++++++++++++++++++++++++++++++++");
        System.out.println("        USUÁRIO INCLUIR");
        System.out.println("+++++++++++++++++++++++++++++++++");
        
        System.out.println("");
        
        
        System.out.println("Digite o nome : ");
        nome = sc.nextLine();
        System.out.println("Digite o preco : ");
        preco = sc.nextDouble();
        System.out.println("Digite o estoque : ");
        estoque = sc.nextDouble();
        
        if (! nome.equals("")){

            
        }

    }

    }
    
}



// Comando para o Banco de dados
//String sqlInsert = "insert into usuario ( nome, email, senha) "
//      + " values ('" + nome + "','" + email + "','" + senha + "')";



//ConexaoDB conexao = new ConexaoDB();

//conexao.executeUpdate(sqlInsert);