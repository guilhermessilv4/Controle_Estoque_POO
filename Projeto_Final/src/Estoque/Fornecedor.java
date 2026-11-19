package Estoque;

public class Fornecedor {
    private String nome;
    private String cnpj;

    public Fornecedor(String nome, String cnpj) {
        this.nome = nome;
        this.cnpj = cnpj;
    }

    public String getNome() {
        return nome; }

    String exibirFornecedor(){
        return "Nome: " + nome + "\tCNPJ: " + cnpj;
    }
}
