# SellCore - Sistema de Gerenciamento de Estoque e Vendas

O SellCore é uma aplicação de linha de comando (CLI) desenvolvida em Java para o gerenciamento de produtos e registro de vendas. O sistema demonstra a aplicação prática de conceitos fundamentais de Programação Orientada a Objetos (POO), arquitetura em camadas e manipulação de coleções em memória.

## Funcionalidades

O sistema opera através de um menu interativo no terminal e oferece as seguintes funcionalidades:

* Gerenciamento de Produtos (CRUD):
  * Cadastro de Produtos Físicos (com controle de peso e quantidade em estoque).
  * Cadastro de Produtos Digitais (com links de acesso e chaves de ativação).
  * Listagem completa do estoque atual.
  * Alteração de preço base de produtos cadastrados.
  * Exclusão de produtos do sistema.

* Gerenciamento de Vendas:
  * Registro de novas vendas com validação de estoque em tempo real para itens físicos.
  * Cálculo automático do preço final via Polimorfismo (adicionando frete por peso para físicos ou taxa fixa para digitais).
  * Histórico imutável de vendas realizadas.

## Tecnologias e Conceitos Utilizados

* Linguagem: Java
* Paradigma: Programação Orientada a Objetos (POO)
* Conceitos Aplicados:
  * Herança e Classes Abstratas: Produto como classe mãe abstrata; ProdutoFisico e ProdutoDigital como subclasses.
  * Polimorfismo: Sobrescrita (@Override) do método calcularPrecoFinal() e Polimorfismo de Referência nas listas e vendas.
  * Encapsulamento: Proteção de atributos com modificadores private e uso de Getters/Setters.
  * Injeção de Dependência: Passagem do EstoqueRepository via construtor para a MenuCLI.
  * Estrutura de Dados: Uso de List e ArrayList para persistência de dados em memória.

## Arquitetura do Projeto

O código-fonte é organizado no padrão de pacotes:

* main: Contém a classe Main.java, responsável pelo ponto de entrada da aplicação.
* model: Contém as entidades de negócio (Produto, ProdutoFisico, ProdutoDigital, Venda).
* repository: Contém o EstoqueRepository.java, o motor de regras de negócio e persistência em memória.
* view: Contém a MenuCLI.java, responsável por toda a interface de interação com o usuário.

## Como Executar

1. Clone este repositório para a sua máquina local:
   ```bash
   git clone [https://github.com/SEU-USUARIO/SellCore.git](https://github.com/SEU-USUARIO/SellCore.git)