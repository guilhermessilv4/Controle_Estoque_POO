package Estoque;

public class ProdutoEletronico extends Produto {
    private int garantiaMeses;

    public ProdutoEletronico(String nome, int quantidade, int estoqueMinimo, Fornecedor fornecedor, int garantiaMeses) {
        super(nome, quantidade, estoqueMinimo, fornecedor);
        this.garantiaMeses = garantiaMeses;
    }

    @Override
    public String getTipo() { return "Eletrônico"; }
}
