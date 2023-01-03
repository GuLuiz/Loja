package br.com.gustavo.Loja;

import java.sql.ResultSet;
import java.util.Scanner;

import javax.sound.midi.Soundbank;

public class Venda {

    private Scanner sc = new Scanner(System.in);
    private Integer venda_id;
    private Integer cliente_id = 0;
    private Double total = 0.00;
    private Double pago = 0.00;
    private boolean is_orcamento;
    private String comentario;
    int contador = 0;

    public Scanner getSc() {
        return sc;
    }

    public void setVenda_id(Integer venda_id) {
        this.venda_id = venda_id;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public boolean isIs_orcamento() {
        return is_orcamento;
    }

    public void setIs_orcamento(boolean is_orcamento) {
        this.is_orcamento = is_orcamento;
    }

    public void setSc(Scanner sc) {
        this.sc = sc;
    }

    public Integer getVenda_id() {
        return venda_id;
    }

    public void setVendaId(Integer vendaId) {
        this.venda_id = vendaId;
    }

    public Integer getCliente_id() {
        return cliente_id;
    }

    public void setCliente_id(Integer cliente_id) {
        this.cliente_id = cliente_id;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Double getPago() {
        return pago;
    }

    public void setPago(Double pago) {
        this.pago = pago;
    }

    public void Inserir() {

        System.out.println("");
        total = 0.00;
        pago = 0.00;
        is_orcamento = false;

        String sqlInsert = "insert into venda (data , total, pago , is_orcamento , cliente_id)"
                + " values (now()," + total + "," + pago + ",'" + is_orcamento + "'," + cliente_id + ")";

        ConexaoDB conexao = new ConexaoDB();

        int id = conexao.executeInsertGetId(sqlInsert);

        venda_id = id;
        int resposta = 1;
        while (resposta == 1) {
            System.out.println("+++++++++++++++++++++++++++++++++");
            System.out.println("           Carrinho");
            System.out.println("+++++++++++++++++++++++++++++++++");

            System.out.println("Digite o ID do Produto desejado.");
            int produto_id = sc.nextInt();
            System.out.println("Qual a quantidade desejada?");
            int quantidade = sc.nextInt();
            System.out.println("Desconto");
            int desconto = sc.nextInt();

            String sqlSelectProduto = "select preco from produto where produto_id = " + produto_id;
            ResultSet dadosRetornado = conexao.executeSelect(sqlSelectProduto);

            Double preco = 0.0;
            try {
                while (dadosRetornado.next()) {
                    preco = dadosRetornado.getDouble("preco")

                    ;
                }
            } catch (Exception erro) {
                System.out.println("Erro : " + erro.getMessage());
            }

            contador = contador + 1;

            total = total + (quantidade * preco) - desconto;

            comentario = "";

            sqlInsert = "insert into venda_produto (venda_id , produto_id, preco , quantidade , comentario)"
                    + " values (" + venda_id + "," + produto_id + "," + preco + "," + quantidade + ",'" + comentario
                    + "')";

            conexao.executeUpdate(sqlInsert);

            if (contador <= 4) {
                System.out.println("Deseja inserir outro produto?");
                System.out.println("1 - Sim");
                System.out.println("2 - Não");
                resposta = sc.nextInt();
            }
            if (resposta == 2 || contador == 5) {

                String sqlAlterar = "update venda set total = " + total + " , pago =" + total + ", desconto ="
                        + desconto
                        + "where venda_id = "
                        + venda_id;

                conexao.executeUpdate(sqlAlterar);
            }
            if (contador == 5) {
                System.out.println("Quantidade de itens excedido");

                break;
            }

        }

    }

    public void excluir() {

        System.out.println("+++++++++++++++++++++++++++++++++");
        System.out.println("        VENDA EXCLUIR");
        System.out.println("+++++++++++++++++++++++++++++++++");

        System.out.println("");

        System.out.println("Digite o código : ");
        venda_id = sc.nextInt();
        sc.nextLine();
        System.out.println("O ID escolhido foi: " + venda_id);
        System.out.println("Deseja exlui-lo?");
        System.out.println("1 - Sim");
        System.out.println("2 - Não");
        int excluir = sc.nextInt();

        if (excluir == 1) {
            String sqlDelete = "delete from venda where venda_id = "
                    + venda_id + "; delete from venda_produto where venda_id = " + venda_id;

            ConexaoDB conexao = new ConexaoDB();

            conexao.executeUpdate(sqlDelete);

        }
    }

    public void pesquisar() {

        System.out.println("+++++++++++++++++++++++++++++++++");
        System.out.println("        VENDA PESQUISAR");
        System.out.println("+++++++++++++++++++++++++++++++++");

        System.out.println("");
        System.out.println("Digite o ID da venda que deseja consultar");
        venda_id = sc.nextInt();

        String sqlSelect = "SELECT vp.venda_id produto_venda_id , v.cliente_id , vp.produto_id produto, p.nome, v.venda_id , vp.quantidade , p.preco , v.desconto , v.total   , v.data"
                + " "
                + "from venda_produto vp" + " "
                + "inner join produto p on vp.produto_id = p.produto_id " + " "
                + "inner join venda v on vp.venda_id = v.venda_id where v.venda_id =" + venda_id;
        System.out.println(sqlSelect);

        ConexaoDB conexao = new ConexaoDB();

        ResultSet dadosRetornado = conexao.executeSelect(sqlSelect);

        System.out.println(
                "+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("Cod.    Cliente_id    Produto    Nome    Quantidade    Preco    Desconto   Total   Data");
        System.out.println(
                "+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        try {
            while (dadosRetornado.next()) {
                System.out.println(
                        dadosRetornado.getInt("produto_venda_id") + "     " +
                                dadosRetornado.getString("cliente_id") + "     " +
                                dadosRetornado.getString("produto") + "     " +
                                dadosRetornado.getString("nome") + "     " +
                                dadosRetornado.getInt("quantidade") + "     " +
                                dadosRetornado.getDouble("preco") + "     " +
                                dadosRetornado.getDouble("desconto") + "     " +
                                dadosRetornado.getDouble("total") + "     " +
                                dadosRetornado.getTimestamp("data")

                );
            }
        } catch (Exception erro) {
            System.out.println("Erro : " + erro.getMessage());
        }

    }

}
