package br.com.sellcore.model;

import javax.xml.crypto.Data;

public class Venda {
    private Integer idVenda;
    private Produto produto;
    private int quantidade;
    private double valorTotal;

    public Venda(Integer idVenda, Produto produto, int quantidade, double valorTotal) {
        this.idVenda = idVenda;
        this.produto = produto;
        this.quantidade = quantidade;
        this.valorTotal = valorTotal;
    }

    public Integer getIdVenda() {
        return idVenda;
    }
    public Produto getProduto() {
        return produto;
    }
    public int getQuantidade() {
        return quantidade;
    }
    public double getValorTotal() {
        return valorTotal;
    }

}
