package br.com.sellcore.model;


public abstract class Produto {
    private Integer idProduto;
    private String nome;
    private Double precoBase;

    public Produto(Integer idProduto, String nome, Double precoBase){
        this.idProduto = idProduto;
        this.nome = nome;
        this.precoBase = precoBase;
    }

    public Integer getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Integer idProduto) {
        this.idProduto = idProduto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPrecoBase() {
        return precoBase;
    }

    public void setPrecoBase(Double precoBase) {
        this.precoBase = precoBase;
    }

    public abstract double calcularPrecoFinal();

}




