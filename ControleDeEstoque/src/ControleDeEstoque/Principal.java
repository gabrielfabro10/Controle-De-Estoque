package ControleDeEstoque;


import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		ControladorDeEstoque controladorDeEstoque = new ControladorDeEstoque();
		Movimentacao movimentacao = new Movimentacao();
		int opcao = 9;
		Scanner scanner = new Scanner(System.in);
		while (opcao != 0) {
			System.out.println("EMPRESA DE IMPORTAÇÃO DE PRODUTOS LTDA.");
			System.out.println("SISTEMA DE CONTROLE DE ESTOQUE ");
			System.out.println("MENU PRINCIPAL ");
			System.out.println("1 - CADASTRO DE PRODUTOS");
			System.out.println("2 - MOVIMENTAÇÃO");
			System.out.println("3 - REAJUSTE DE PREÇOS");
			System.out.println("4 - RELATÓRIOS");
			System.out.println("0 - Finalizar");
			System.out.println("OPÇÃO: ");
			opcao = Integer.parseInt(scanner.nextLine());
			switch (opcao) {
			case 1:
				controladorDeEstoque.cadastrarProdutos(scanner);
				break;
			case 2:
				movimentacao.menuMovimentacao(scanner, controladorDeEstoque);
				break;
			case 3:
				movimentacao.reajustePreco(scanner, controladorDeEstoque);
				break;
			case 4:
				controladorDeEstoque.relatorio();
				break;
			}
		}
		scanner.close();
		
	}

}
