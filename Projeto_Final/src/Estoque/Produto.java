package Estoque;

public abstract class Produto {
    private String nome;
    private int quantidade;
    private int estoqueMinimo;
    private Fornecedor fornecedor;

    public Produto(String nome, int quantidade, int estoqueMinimo, Fornecedor fornecedor) {
        this.nome = nome;
        this.quantidade = quantidade;
        this.estoqueMinimo = estoqueMinimo;
        this.fornecedor = fornecedor;
    }

    public void adicionarEstoque(int valor) { this.quantidade += valor; }

    public void removerEstoque(int valor) {
        if (valor <= this.quantidade) this.quantidade -= valor;
    }

    public boolean isEstoqueBaixo() {
        return this.quantidade <= this.estoqueMinimo; }

    public String getNome() {
        return nome; }
    public int getQuantidade() {
        return quantidade; }

    public abstract String getTipo();
}
