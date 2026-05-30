package br.com.sellcore.main;

import br.com.sellcore.repository.EstoqueRepository;
import br.com.sellcore.view.MenuCLI;

public class Main {
    public static void main(String[] args) {

        // 1. Criando o banco de dados temporário
        EstoqueRepository repository = new EstoqueRepository();

        // 2. Criando e iniciando o menu de interface passando o repositório para ele
        MenuCLI menu = new MenuCLI(repository);
        menu.exibirMenu();
    }
}