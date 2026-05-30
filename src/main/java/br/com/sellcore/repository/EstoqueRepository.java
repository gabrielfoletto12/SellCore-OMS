package br.com.sellcore.repository;

import br.com.sellcore.model.Produto;
import br.com.sellcore.model.ProdutoFisico;
import br.com.sellcore.model.Venda;
import java.util.ArrayList;
import java.util.List;

public class EstoqueRepository {

    private List<Produto> produtos = new ArrayList<>();
    private ArrayList<Venda> vendas = new ArrayList<>();

    public void adicionarProduto(Produto produto) {
        produtos.add(produto);
    }

    public List<Produto> consultarProdutos() {
        return produtos;
    }

    public List<Venda> consultarVendas() {
        return vendas;
    }

    public boolean alterarPrecoProduto(int idProduto, double novoPrecoBase) {
        for (Produto p : produtos) {
            if (p.getIdProduto() == idProduto) {
                p.setPrecoBase(novoPrecoBase);
                return true;
            }
        }
        return false;
    }

    public boolean excluirProduto(int idProduto) {
        for (Produto p : produtos) {
            if (p.getIdProduto() == idProduto) {
                produtos.remove(p);
                return true;
            }
        }
        return false;
    }

    public String registrarVenda(int idProduto, int quantidadeVendida) {
        for (Produto p : produtos) {
            if (p.getIdProduto() == idProduto) {
                if (p instanceof ProdutoFisico) {
                    ProdutoFisico pf = (ProdutoFisico) p;
                    if (pf.getQuantidadeEstoque() < quantidadeVendida) {
                        return "Erro: Estoque insuficiente! Disponível: " + pf.getQuantidadeEstoque();
                    }
                    pf.setQuantidadeEstoque((pf.getQuantidadeEstoque() - quantidadeVendida));
                }

                double valorTotal = p.calcularPrecoFinal() * quantidadeVendida;

                Venda novaVenda = new Venda(vendas.size() + 1, p, quantidadeVendida, valorTotal);
                vendas.add(novaVenda);

                return String.format("Venda realizada! Total: R$ %.2f", valorTotal);
            }
        }
        return "Produto não encontrado";
    }
}