package ControleDeEstoque;

import java.util.Scanner;

public class Movimentacao{
	public void menuMovimentacao(Scanner scanner, ControladorDeEstoque controladorDeEstoque) {
		int opcao = 9;
		while (opcao != 0) {
			System.out.println("EMPRESA DE IMPORTAÇÃO DE PRODUTOS LTDA. ");
			System.out.println("SISTEMA DE CONTROLE DE ESTOQUE ");
			System.out.println("MOVIMENTAÇÃO DE ESTOQUE");
	        System.out.println("1 - ENTRADA");
	        System.out.println("2 - SAIDA");
	        System.out.println("0 - RETORNAR");
	        System.out.println("OPÇÃO: ");
	        opcao = Integer.parseInt(scanner.nextLine());
	        switch (opcao) {
	            case 1:
	               entradaProduto(scanner, controladorDeEstoque);
	                break;
	            case 2:
	                saidaProduto(scanner, controladorDeEstoque);
	                break;
	            
		}
        
        }
    }
	
	private void entradaProduto(Scanner scanner, ControladorDeEstoque controladorDeEstoque) {
		String opcao = "S";
		while (opcao.toUpperCase().trim().equals("S")) {
			System.out.println("EMPRESA DE IMPORTAÇÃO DE PRODUTOS LTDA. ");
			System.out.println("SISTEMA DE CONTROLE DE ESTOQUE ");
			System.out.println("MOVIMENTAÇÃO - ENTRADA DE PRODUTO: ");
			System.out.println("PRODUTO:");
			String nome = scanner.nextLine();
			Produto produtoASerAlterado = null;
			for (Produto produto : controladorDeEstoque.getProdutos()) {
				if (nome.equals(produto.getNome())) {
					produtoASerAlterado = produto;
				}
			}
			if (produtoASerAlterado != null) {
				System.out.println("QUANTIDADE ATUAL: " + produtoASerAlterado.getQuantidade());
				System.out.println("QUANTIDADE ENTRADA: ");
				double quantidadeEntrada = Double.parseDouble(scanner.nextLine());
		
				if (quantidadeEntrada <= 0) {
					System.out.println("A quantidade deve ser maior que zero.");
				}
				//Adicionar validação Igual ao da quantidade menor igual a zero
				while (quantidadeEntrada <= 0) {
					System.out.println("QUANTIDADE:");
					quantidadeEntrada = Double.parseDouble(scanner.nextLine());
					if (quantidadeEntrada <= 0) {
						System.out.println("A quantidade deve ser maior que zero.");
					}
				}
			
				System.out.println("QUANTIDADE FINAL: " + (quantidadeEntrada + produtoASerAlterado.getQuantidade()));

				System.out.println("CONFIRMA (S/N)?");
				String inserir = scanner.nextLine();
	
				if ("S".equals(inserir)) {
					produtoASerAlterado.setQuantidade(quantidadeEntrada + produtoASerAlterado.getQuantidade());
					controladorDeEstoque.getProdutos().remove(produtoASerAlterado);
					controladorDeEstoque.getProdutos().add(produtoASerAlterado);
				}
			} else {
				System.out.println("Produto não cadastrado.");
			}
			System.out.println("REPETIR OPERAÇÃO (S/N)?");
			opcao = scanner.nextLine();
		}
	}
   
	private void saidaProduto(Scanner scanner, ControladorDeEstoque controladorDeEstoque) {
		String opcao = "S";
		while (opcao.toUpperCase().trim().equals("S")) {
			System.out.println("EMPRESA DE IMPORTAÇÃO DE PRODUTOS LTDA. ");
			System.out.println("SISTEMA DE CONTROLE DE ESTOQUE ");
			System.out.println("MOVIMENTAÇÃO - SAIDA DE PRODUTO: ");
			System.out.println("PRODUTO:");
			String nome = scanner.nextLine();
			Produto produtoASerAlterado = null;
			for (Produto produto : controladorDeEstoque.getProdutos()) {
				if (nome.equals(produto.getNome())) {
					produtoASerAlterado = produto;
				}
			}
			if (produtoASerAlterado != null) {
				System.out.println("QUANTIDADE ATUAL: " + produtoASerAlterado.getQuantidade());
				System.out.println("QUANTIDADE SAIDA: ");
				double quantidadeSaida = Double.parseDouble(scanner.nextLine());
		
				if (quantidadeSaida <= 0) {
					System.out.println("A quantidade deve ser maior que zero.");
				} else if (produtoASerAlterado.getQuantidade() - quantidadeSaida < 0 ) {
					System.out.println("A quantidade ficará negativa !");
				}
				//Adicionar validação Igual ao da quantidade menor igual a zero
				while (quantidadeSaida <= 0 || produtoASerAlterado.getQuantidade() - quantidadeSaida < 0 ) {
					System.out.println("QUANTIDADE:");
					quantidadeSaida = Double.parseDouble(scanner.nextLine());
					if (quantidadeSaida <= 0) {
						System.out.println("A quantidade deve ser maior que zero.");
					} else if (produtoASerAlterado.getQuantidade() - quantidadeSaida < 0 ) {
						System.out.println("A quantidade ficará negativa !");
					}
				}
			
				System.out.println("QUANTIDADE FINAL: " + ( produtoASerAlterado.getQuantidade() - quantidadeSaida));

				System.out.println("CONFIRMA (S/N)?");
				String inserir = scanner.nextLine();
	
				if ("S".equals(inserir)) {
					produtoASerAlterado.setQuantidade( produtoASerAlterado.getQuantidade() - quantidadeSaida);
					controladorDeEstoque.getProdutos().remove(produtoASerAlterado);
					controladorDeEstoque.getProdutos().add(produtoASerAlterado);
				}
			} else {
				System.out.println("Produto não cadastrado.");
			}
			System.out.println("REPETIR OPERAÇÃO (S/N)?");
			opcao = scanner.nextLine();
		}
	}
	public void reajustePreco(Scanner scanner, ControladorDeEstoque controladorDeEstoque) {
		String opcao = "S";
		while (opcao.toUpperCase().trim().equals("S")) {
			System.out.println("EMPRESA DE IMPORTAÇÃO DE PRODUTOS LTDA. ");
			System.out.println("SISTEMA DE CONTROLE DE ESTOQUE ");
			System.out.println("REAJUSTE PREÇO ");
			// Aqui eu percorro a lista, e verifico se existe algum produto
			// com o nome q eu digitei
			// se encontrar, vou modificar o preço, caso contrário vai exibir mensagem
			System.out.println("NOME:");
			String nome = scanner.nextLine();
			Produto produtoASerAlterado = null;
			for (Produto produto : controladorDeEstoque.getProdutos()) {
				if (nome.equals(produto.getNome())) {
					produtoASerAlterado = produto;
				}
				if (produtoASerAlterado != null) {
					System.out.println("PREÇO ATUAL: " + produtoASerAlterado.getPreco());
					
				}
			}
//
			if (produtoASerAlterado != null) {
				System.out.println("NOVO PREÇO: ");
				double preco = Double.parseDouble(scanner.nextLine());
				produtoASerAlterado.setPreco(preco);
				if (produtoASerAlterado.getPreco() <= 0) {
					System.out.println("O preço deve ser maior que zero.");
				}
				while (produtoASerAlterado.getPreco() <= 0) {
					System.out.println("PREÇO:");
					preco = Double.parseDouble(scanner.nextLine());
					if (preco <= 0) {
						System.out.println("O preço deve ser maior que zero.");
					}
				}

				System.out.println("CONFIRMA REAJUSTE(S/N)?");
				String inserir = scanner.nextLine();

				if ("S".equals(inserir)) {
					produtoASerAlterado.setPreco(preco);
					controladorDeEstoque.getProdutos().remove(produtoASerAlterado);
					controladorDeEstoque.getProdutos().add(produtoASerAlterado);
				}
			} else {
				System.out.println("Produto não cadastrado.");
			}
			System.out.println("REPETIR OPERAÇÃO (S/N)?");
			opcao = scanner.nextLine();
		}
	}
}
