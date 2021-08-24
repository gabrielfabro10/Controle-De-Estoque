package ControleDeEstoque;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ControladorDeEstoque {
	private List<Produto> produtos;

	public ControladorDeEstoque() {
		produtos = new ArrayList<>();
	}

	public void cadastrarProdutos(Scanner scanner) {
		int opcao = 9;
		while (opcao != 0) {
			System.out.println("EMPRESA DE IMPORTA��O DE PRODUTOS LTDA. ");
			System.out.println("SISTEMA DE CONTROLE DE ESTOQUE ");
			System.out.println("CADASTRO DE PRODUTOS ");
			System.out.println("1 - INCLUS�O");
			System.out.println("2 - ALTERA��O");
			System.out.println("3 - CONSULTA");
			System.out.println("4 - EXCLUS�O");
			System.out.println("0 - RETORNAR");
			System.out.println("OP��O: ");
			opcao = Integer.parseInt(scanner.nextLine());
			switch (opcao) {
				case 1:
					incluirProduto(scanner);
					break;
				case 2:
					alterarProduto(scanner);
					break;
				case 3:
					consultarProduto(scanner);
					break;
				case 4:
					removerProduto(scanner);
					break;
			}
		}
		
	}

	private void incluirProduto(Scanner scanner) {
		String opcao = "S";
		while (opcao.toUpperCase().trim().equals("S")) {
			Produto produto = new Produto();
			System.out.println("EMPRESA DE IMPORTA��O DE PRODUTOS LTDA. ");
			System.out.println("SISTEMA DE CONTROLE DE ESTOQUE ");
			System.out.println("INCLUS�O DE PRODUTO ");
			System.out.println("NOME:");
            String nome = "";
			if (scanner.hasNextLine()) {
			    nome = scanner.nextLine();
			} 
			produto.setNome(nome);
			// valida��o do valor do produto
			while (produto.getPreco() <= 0) {
				System.out.println("PRE�O:");
				double preco = Double.parseDouble(scanner.nextLine());
				produto.setPreco(preco);
				if (produto.getPreco() <= 0) {
					System.out.println("O pre�o deve ser maior que zero.");
				}
			}
			// fim da valida��o do valor do produto

			//scanner.nextLine();
			System.out.println("UNIDADE:");
			String unidade = scanner.nextLine();
			produto.setUnidade(unidade);

			while (produto.getQuantidade() <= 0) {
				System.out.println("QUANTIDADE:");
				double quantidade = Double.parseDouble(scanner.nextLine());
				produto.setQuantidade(quantidade);
				if (produto.getQuantidade() <= 0) {
					System.out.println("A quantidade deve ser maior que zero.");
				}
			}

			System.out.println("CONFIRMA INCLUS�O(S/N)?");
			String inserir = scanner.nextLine();

			if ("S".equals(inserir.toUpperCase())) {
				produtos.add(produto);
			}
			
			System.out.println("REPETIR OPERA��O (S/N)?");
			opcao = scanner.nextLine();
		}
	}

	private void alterarProduto(Scanner scanner) {
		String opcao = "S";
		while (opcao.toUpperCase().trim().equals("S")) {
			System.out.println("EMPRESA DE IMPORTA��O DE PRODUTOS LTDA. ");
			System.out.println("SISTEMA DE CONTROLE DE ESTOQUE ");
			System.out.println("ALTERA��O DE PRODUTO ");
			// Aqui eu percorro a lista, e verifico se existe algum produto
			// com o nome q eu digitei
			// se encontrar, vou modificar ele, caso contr�rio vai exibir mensagem
			System.out.println("NOME:");
			String nome = scanner.nextLine();
			Produto produtoASerAlterado = null;
			for (Produto produto : produtos) {
				if (nome.equals(produto.getNome())) {
					produtoASerAlterado = produto;
				}
			}
//
			if (produtoASerAlterado != null) {
				System.out.println("PRE�O: ");
				double preco = Double.parseDouble(scanner.nextLine());
				produtoASerAlterado.setPreco(preco);
				if (produtoASerAlterado.getPreco() <= 0) {
					System.out.println("O pre�o deve ser maior que zero.");
				}
				while (produtoASerAlterado.getPreco() <= 0) {
					System.out.println("PRE�O:");
					preco = Double.parseDouble(scanner.nextLine());
					produtoASerAlterado.setPreco(preco);
					if (produtoASerAlterado.getPreco() <= 0) {
						System.out.println("O pre�o deve ser maior que zero.");
					}
				}

				System.out.println("UNIDADE:");
				String unidade = scanner.nextLine();
				produtoASerAlterado.setUnidade(unidade);

				System.out.println("QUANTIDADE:");
				double quantidade = Double.parseDouble(scanner.nextLine());
				produtoASerAlterado.setQuantidade(quantidade);
				if (produtoASerAlterado.getQuantidade() <= 0) {
					System.out.println("A quantidade deve ser maior que zero.");
				}
				while (produtoASerAlterado.getQuantidade() <= 0) {
					System.out.println("QUANTIDADE:");
					quantidade = Double.parseDouble(scanner.nextLine());
					produtoASerAlterado.setQuantidade(quantidade);
					if (produtoASerAlterado.getQuantidade() <= 0) {
						System.out.println("A quantidade deve ser maior que zero.");
					}
				}

				System.out.println("CONFIRMA INCLUS�O(S/N)?");
				String inserir = scanner.nextLine();

				if ("S".equals(inserir)) {
					produtos.remove(produtoASerAlterado);
					produtos.add(produtoASerAlterado);
				}
			} else {
				System.out.println("Produto n�o cadastrado.");
			}
			System.out.println("REPETIR OPERA��O (S/N)?");
			opcao = scanner.nextLine();
		}
	}

	private void consultarProduto(Scanner scanner) {
		String opcao = "S";
		while (opcao.toUpperCase().trim().equals("S")) {
			System.out.println("NOME:");
			String nome = scanner.nextLine();
			Produto produtoConsultado = null;
			for (Produto produto : produtos) {
				if (nome.equals(produto.getNome())) {
					produtoConsultado = produto;
				}
			}
			if (produtoConsultado != null) {
				System.out.println("PRE�O: " + produtoConsultado.getPreco());
				System.out.println("UNIDADE: " + produtoConsultado.getUnidade());
				System.out.println("QUANTIDADE: " + produtoConsultado.getQuantidade());
			} else {
				System.out.println("Produto n�o cadastrado.");
			}
			System.out.println("REPETIR OPERA��O (S/N)? ");
			opcao = scanner.nextLine();
		}
	}

	private void removerProduto(Scanner scanner) {
		String opcao = "S";
		while (opcao.toUpperCase().trim().equals("S")) {
			System.out.println("NOME:");
			String nome = scanner.nextLine();
			Produto produtoASerRemovido = null;
			for (Produto produto : produtos) {
				if (nome.equals(produto.getNome())) {
					produtoASerRemovido = produto;
				}
			}
			if (produtoASerRemovido != null) {
				System.out.println("PRE�O: " + produtoASerRemovido.getPreco());
				System.out.println("UNIDADE: " + produtoASerRemovido.getUnidade());
				System.out.println("QUANTIDADE: " + produtoASerRemovido.getQuantidade());
				System.out.println("CONFIRMA EXCLUS�O(S/N)?");
				String inserir = scanner.nextLine();

				if ("S".equals(inserir)) {
					produtos.remove(produtoASerRemovido);
				}

			} else {
				System.out.println("Produto n�o cadastrado.");
			}
			System.out.println("REPETIR OPERA��O (S/N)? ");
			opcao = scanner.nextLine();
		}
	}

	public void relatorio() {
		if (!produtos.isEmpty()) {
			System.out.println("=============================");
			System.out.println("          RELAT�RIO          ");
			System.out.println("=============================");
			for (Produto produto : produtos) {
				System.out.println("NOME: " + produto.getNome());
				System.out.println("PRE�O: " + produto.getPreco());
				System.out.println("UNIDADE: " + produto.getUnidade());
				System.out.println("QUANTIDADE: " + produto.getQuantidade());
				System.out.println("=============================");
			}
		} else {
			System.out.println("N�o existem produtos cadastrados!\n");
		}

	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
}
