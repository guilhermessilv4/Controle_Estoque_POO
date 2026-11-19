package Estoque;

import java.util.ArrayList;
import java.util.List;

public class ControleEstoque {
    private ArrayList<Produto> produtos = new ArrayList<>();

    public void cadastrarProduto(Produto p) {
        produtos.add(p); }

    public void registrarEntrada(Produto p, int qtd) {
        p.adicionarEstoque(qtd); }

    public void registrarSaida(Produto p, int qtd) {
        p.removerEstoque(qtd); }

    public void gerarRelatorio() {
        System.out.println("--- RELATÓRIO DE ESTOQUE ---");
        for (Produto p : produtos) {
            System.out.println("Produto: " + p.getNome() + " | Qtd: " + p.getQuantidade() + " | Tipo: " + p.getTipo());
            if (p.isEstoqueBaixo()) {
                System.out.println("  [ALERTA] Estoque baixo!");
            }
        }
    }

    public Produto buscarProduto(String nome) {
        for (Produto p : produtos) {
            if (p.getNome().equalsIgnoreCase(nome)) {
                return p;
            }
        }
        return null;
    }
}
