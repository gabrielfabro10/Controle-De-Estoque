package ControleDeEstoque;

import java.util.Scanner;

public class Movimentacao{
	public void menuMovimentacao(Scanner scanner, ControladorDeEstoque controladorDeEstoque) {
		int opcao = 9;
		while (opcao != 0) {
			System.out.println("EMPRESA DE IMPORTA��O DE PRODUTOS LTDA. ");
			System.out.println("SISTEMA DE CONTROLE DE ESTOQUE ");
			System.out.println("MOVIMENTA��O DE ESTOQUE");
	        System.out.println("1 - ENTRADA");
	        System.out.println("2 - SAIDA");
	        System.out.println("0 - RETORNAR");
	        System.out.println("OP��O: ");
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
			System.out.println("EMPRESA DE IMPORTA��O DE PRODUTOS LTDA. ");
			System.out.println("SISTEMA DE CONTROLE DE ESTOQUE ");
			System.out.println("MOVIMENTA��O - ENTRADA DE PRODUTO: ");
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
				//Adicionar valida��o Igual ao da quantidade menor igual a zero
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
				System.out.println("Produto n�o cadastrado.");
			}
			System.out.println("REPETIR OPERA��O (S/N)?");
			opcao = scanner.nextLine();
		}
	}
   
	private void saidaProduto(Scanner scanner, ControladorDeEstoque controladorDeEstoque) {
		String opcao = "S";
		while (opcao.toUpperCase().trim().equals("S")) {
			System.out.println("EMPRESA DE IMPORTA��O DE PRODUTOS LTDA. ");
			System.out.println("SISTEMA DE CONTROLE DE ESTOQUE ");
			System.out.println("MOVIMENTA��O - SAIDA DE PRODUTO: ");
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
					System.out.println("A quantidade ficar� negativa !");
				}
				//Adicionar valida��o Igual ao da quantidade menor igual a zero
				while (quantidadeSaida <= 0 || produtoASerAlterado.getQuantidade() - quantidadeSaida < 0 ) {
					System.out.println("QUANTIDADE:");
					quantidadeSaida = Double.parseDouble(scanner.nextLine());
					if (quantidadeSaida <= 0) {
						System.out.println("A quantidade deve ser maior que zero.");
					} else if (produtoASerAlterado.getQuantidade() - quantidadeSaida < 0 ) {
						System.out.println("A quantidade ficar� negativa !");
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
				System.out.println("Produto n�o cadastrado.");
			}
			System.out.println("REPETIR OPERA��O (S/N)?");
			opcao = scanner.nextLine();
		}
	}
	public void reajustePreco(Scanner scanner, ControladorDeEstoque controladorDeEstoque) {
		String opcao = "S";
		while (opcao.toUpperCase().trim().equals("S")) {
			System.out.println("EMPRESA DE IMPORTA��O DE PRODUTOS LTDA. ");
			System.out.println("SISTEMA DE CONTROLE DE ESTOQUE ");
			System.out.println("REAJUSTE PRE�O ");
			// Aqui eu percorro a lista, e verifico se existe algum produto
			// com o nome q eu digitei
			// se encontrar, vou modificar o pre�o, caso contr�rio vai exibir mensagem
			System.out.println("NOME:");
			String nome = scanner.nextLine();
			Produto produtoASerAlterado = null;
			for (Produto produto : controladorDeEstoque.getProdutos()) {
				if (nome.equals(produto.getNome())) {
					produtoASerAlterado = produto;
				}
				if (produtoASerAlterado != null) {
					System.out.println("PRE�O ATUAL: " + produtoASerAlterado.getPreco());
					
				}
			}
//
			if (produtoASerAlterado != null) {
				System.out.println("NOVO PRE�O: ");
				double preco = Double.parseDouble(scanner.nextLine());
				produtoASerAlterado.setPreco(preco);
				if (produtoASerAlterado.getPreco() <= 0) {
					System.out.println("O pre�o deve ser maior que zero.");
				}
				while (produtoASerAlterado.getPreco() <= 0) {
					System.out.println("PRE�O:");
					preco = Double.parseDouble(scanner.nextLine());
					if (preco <= 0) {
						System.out.println("O pre�o deve ser maior que zero.");
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
				System.out.println("Produto n�o cadastrado.");
			}
			System.out.println("REPETIR OPERA��O (S/N)?");
			opcao = scanner.nextLine();
		}
	}
}
