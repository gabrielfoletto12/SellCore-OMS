package br.com.sellcore.view;

import br.com.sellcore.model.Produto;
import br.com.sellcore.model.ProdutoDigital;
import br.com.sellcore.model.ProdutoFisico;
import br.com.sellcore.model.Venda;
import br.com.sellcore.repository.EstoqueRepository;
import java.util.Scanner;

public class MenuCLI {
    private EstoqueRepository repository;
    private Scanner scanner;


    public MenuCLI(EstoqueRepository repository) {
        this.repository = repository;
        this.scanner = new Scanner(System.in);
    }
    public void exibirMenu(){
        int opcao = -1;

        while (opcao != 0 ){
            System.out.println("----------DIGITE O NUMERO DA OPÇÃO DESEJADA--------");
            System.out.println("Opção 1: Gerenciar Produto");
            System.out.println("Opção 2: Gerenciar Venda");
            System.out.println("Opção 0: Sair do menu");
            System.out.println("Digite a opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine();
             switch(opcao){
                 case 1:
                     menuProduto();
                   break;

                 case 2:
                     menuVenda();
                     break;
                 case 0:
                     break;
                 default:
                     System.out.println("Opção inválida, digite umas das opções informadas");
            }
        }
        System.out.println("Você saiu do menu");
    }
    public void menuProduto(){
        int opcaoProduto = -1;
        System.out.println("Escolha uma opção abaixo: ");
        System.out.println("Opção 1: Cadastrar produto fisico");
        System.out.println("Opção 2: Cadastrar produto digital");
        System.out.println("Opção 3: Consultar Estoque");
        System.out.println("Opção 4: Alterar produto");
        System.out.println("Opção 5: Excluir produto");
        System.out.println("Opção 0: Voltar ao menu principal");
        System.out.println("Escolha uma opção: ");


        opcaoProduto = scanner.nextInt();
        scanner.nextLine();

        switch(opcaoProduto){
            case 1:
                cadastrarProdutoFisico();
                break;
            case 2:
                cadastrarProdutodDigitais();
                break;
            case 3:
                listarEstoque();
                break;
            case 4:
                alterarProduto();
                break;
            case 5:
                excluirProduto();
                break;
            case 0:
                break;
            default:
                System.out.println("Opção inválida!");
        }
    }

    public void menuVenda(){
        int opcaoVenda = -1;
        System.out.println("Opção 1: Registrar venda");
        System.out.println("Opção 2: Consultar venda");
        System.out.println("Opção 0: Voltar ao menu principal");
        System.out.println("Escolha uma opção: ");

        //Venda não pode ser excluida nem alterada, pois certamente estaria vinculada a uma NF em um caso real;
        opcaoVenda = scanner.nextInt();
        scanner.nextLine();
        switch(opcaoVenda){
            case 1:
                registrarVenda();
                break;
            case 2:
                listarHistoricoVendas();
                break;
            case 0:
                break;
            default:
                System.out.println("Opção inválida!");
        }
    }

    private void cadastrarProdutoFisico(){
        System.out.println("\n--- CADASTRO DE PRODUTO FÍSICO ---");
        System.out.println("Digite o ID(Numero) ");
        int idProdutoFisico = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Digite o Nome do produto: ");
        String nomeProdutoFisico = scanner.nextLine();
        System.out.println("Digite o valor do Produto: ");
        double preco = scanner.nextDouble();
        System.out.println("Digite o peso em gramas: ");
        int pesoGrama = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Digite a quantidade em estoque: ");
        int quantidadeEstoque = scanner.nextInt();
        scanner.nextLine();

        ProdutoFisico produtoNovo = new ProdutoFisico(idProdutoFisico,nomeProdutoFisico,preco,pesoGrama,quantidadeEstoque);
        repository.adicionarProduto(produtoNovo);
        System.out.println("Produto de ID: "+idProdutoFisico+" Cadastrado com sucesso.");

    }

    public void cadastrarProdutodDigitais(){
        System.out.print("Digite o ID (Número): ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Limpa buffer
        System.out.print("Nome do Produto/Infoproduto: ");
        String nome = scanner.nextLine();
        System.out.print("Preço Base: R$ ");
        double precoBase = scanner.nextDouble();
        scanner.nextLine(); // Limpa buffer
        System.out.print("Link para Download/Acesso: ");
        String linkAcesso = scanner.nextLine();
        System.out.print("Chave/Token de Ativação: ");
        String chaveAcesso = scanner.nextLine();

        ProdutoDigital novoDigital = new ProdutoDigital(id, nome, precoBase, linkAcesso, chaveAcesso);
        repository.adicionarProduto(novoDigital);
        System.out.println("Produto de ID: "+id+" Cadastrado com sucesso.");
    }

    private void listarEstoque() {
        System.out.println("\n--- ESTOQUE ATUAL ---");
        if (repository.consultarProdutos().isEmpty()) {
            System.out.println("Nenhum produto cadastrado.");
            return;
        }

        for (Produto p : repository.consultarProdutos()) {
            if (p instanceof ProdutoFisico) {
                ProdutoFisico pf = (ProdutoFisico) p;
                System.out.printf("[FISICO] ID: %d | Nome: %s | Preco Final: R$ %.2f | Estoque: %d\n",
                        p.getIdProduto(), p.getNome(), p.calcularPrecoFinal(), pf.getQuantidadeEstoque());
            } else {
                System.out.printf("[DIGITAL] ID: %d | Nome: %s | Preco Final: R$ %.2f\n",
                        p.getIdProduto(), p.getNome(), p.calcularPrecoFinal());
            }
        }
    }

    private void alterarProduto() {
        System.out.println("\n--- ALTERAR PREÇO DE PRODUTO ---");
        System.out.println("Digite o ID do produto que deseja atualizar: ");
        int id = scanner.nextInt();
        System.out.println("Digite o novo preco base: ");
        double novoPreco = scanner.nextDouble();
        scanner.nextLine();

        boolean alterado = repository.alterarPrecoProduto(id, novoPreco);
        if (alterado) {
            System.out.println("Preco atualizado com sucesso.");
        } else {
            System.out.println("Erro: Produto nao encontrado.");
        }
    }

    private void excluirProduto() {
        System.out.println("\n--- EXCLUIR PRODUTO DO SISTEMA ---");
        System.out.println("Digite o ID do produto que deseja remover: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        boolean excluido = repository.excluirProduto(id);
        if (excluido) {
            System.out.println("Produto removido com sucesso.");
        } else {
            System.out.println("Erro: Produto nao encontrado.");
        }
    }

    private void registrarVenda() {
        System.out.println("\n--- REGISTRAR NOVA VENDA ---");
        System.out.println("Digite o ID do produto vendido: ");
        int idProduto = scanner.nextInt();
        System.out.println("Digite a quantidade de unidades: ");
        int quantidade = scanner.nextInt();
        scanner.nextLine();

        String mensagemResultado = repository.registrarVenda(idProduto, quantidade);
        System.out.println(mensagemResultado);
    }

    private void listarHistoricoVendas() {
        System.out.println("\n--- HISTORICO DE VENDAS ---");
        if (repository.consultarVendas().isEmpty()) {
            System.out.println("Nenhuma venda registrada.");
            return;
        }

        for (Venda v : repository.consultarVendas()) {
            System.out.println(v);
        }
    }
}



