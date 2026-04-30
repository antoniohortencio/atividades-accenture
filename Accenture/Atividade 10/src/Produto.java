public class Produto {
    String sku;
    String nome;
    String categoria;
    double preco;
    int estoque;

    public Produto(String sku, String nome, String categoria, double preco, int estoque) {
        this.sku = sku;
        this.nome = nome;
        this.categoria = categoria;
        this.preco = preco;
        this.estoque = estoque;
    }
}