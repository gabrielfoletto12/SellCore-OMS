package br.com.sellcore.model;

public class ProdutoFisico extends Produto{
    private int pesoGrama;
    private int quantidadeEstoque;


    public ProdutoFisico(Integer idProduto, String nome, Double precoBase, int pesoGrama, int quantidadeEstoque){
        super(idProduto,nome,precoBase);
        this.pesoGrama = pesoGrama;
        this.quantidadeEstoque = quantidadeEstoque;

    }
    public int getPesoGrama() {
        return pesoGrama;
    }

    public void setPesoGrama(int pesoGrama) {
        this.pesoGrama = pesoGrama;
    }

    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(int quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    @Override
    public double calcularPrecoFinal(){
        return getPrecoBase()+(getPesoGrama() * 0.02);
    }


    }
