package br.com.sellcore.model;

public class ProdutoDigital extends Produto{
    private String linkAcesso;
    private String chaveAcesso;

    public ProdutoDigital(Integer idProduto, String nome, Double precoBase, String linkAcesso, String chaveAcesso){
        super(idProduto,nome,precoBase);
        this.linkAcesso = linkAcesso;
        this.chaveAcesso = chaveAcesso;
    }

    @Override
    public double calcularPrecoFinal(){
        //Taxa fixa de Download
        return this.getPrecoBase() * 1.5;
    }

}
