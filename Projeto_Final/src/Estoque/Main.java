package Estoque;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int escolha;

        ControleEstoque controle = new ControleEstoque();
        ArrayList<Fornecedor> fornecedores = new ArrayList<>();

        do {
            System.out.println("MENU PRINCIPAL");
            System.out.println("1 - Cadastrar Fornecedor");
            System.out.println("2 - Cadastrar Produto");
            System.out.println("3 - Registrar Saída");
            System.out.println("4 - Gerar Relatório");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma Opção: ");
            escolha = sc.nextInt();
            sc.nextLine();

            switch (escolha){
                case 1:
                    System.out.println("\n--- Cadastro de Fornecedor ---");
                    System.out.print("Nome: ");
                    String nomeFornecedor = sc.nextLine();
                    System.out.print("CNPJ: ");
                    String cnpj = sc.nextLine();
                    fornecedores.add(new Fornecedor(nomeFornecedor, cnpj));
                    System.out.println("Fornecedor Cadastrado!\n");
                    break;

                case 2:
                    if (fornecedores.isEmpty()) {
                        System.out.println("Erro: Cadastre um fornecedor primeiro!\n");
                        break;
                    }

                    System.out.println("\n--- Cadastro de Produto ---");
                    System.out.print("Nome do Fornecedor para vincular: ");
                    String buscaFornecedor = sc.nextLine();

                    Fornecedor fornecedorSelecionado = null;
                    for (Fornecedor fItem : fornecedores) {
                        if (fItem.getNome().equalsIgnoreCase(buscaFornecedor)) {
                            fornecedorSelecionado = fItem;
                            break;
                        }
                    }

                    if (fornecedorSelecionado == null) {
                        System.out.println("Erro: Fornecedor não encontrado!\n");
                        break;
                    }

                    System.out.print("Nome do Produto: ");
                    String nomeProduto = sc.nextLine();
                    System.out.print("Quantidade: ");
                    int quantidade = sc.nextInt();
                    System.out.print("Estoque Mínimo: ");
                    int estoqueMinimo = sc.nextInt();
                    System.out.print("Garantia (Meses): ");
                    int garantiaMeses = sc.nextInt();

                    Produto novoP = new ProdutoEletronico(nomeProduto, quantidade, estoqueMinimo, fornecedorSelecionado, garantiaMeses);

                    controle.cadastrarProduto(novoP);
                    System.out.println("Produto Cadastrado com sucesso!\n");
                    break;

                case 3:
                    System.out.println("\n--- Registrar Saída ---");
                    System.out.print("Nome do Produto: ");
                    String nomeBusca = sc.nextLine();
                    System.out.print("Quantidade a retirar: ");
                    int qtdSaida = sc.nextInt();

                    Produto produtoEncontrado = controle.buscarProduto(nomeBusca);

                    if (produtoEncontrado != null) {
                        controle.registrarSaida(produtoEncontrado, qtdSaida);
                        System.out.println("Saída registrada!\n");
                    } else {
                        System.out.println("Produto não encontrado!\n");
                    }
                    break;

                case 4:
                    controle.gerarRelatorio();
                    System.out.println("");
                    break;

                case 0:
                    System.out.println("Encerrando Sistema...");
                    break;

                default:
                    System.out.println("Opção inválida!\n");
            }

        } while (escolha != 0);
    }
}