public class Carro {
    String marca;
    String CodigoCor;
    double preco;

    public Carro(String marca, String CodigoCor, double preco) {
        this.marca = marca;
        this.CodigoCor = CodigoCor;
        this.preco = preco;
    }

    public void Exibir() {
        System.out.println("--- Dados do Veículo ---");
        System.out.println("Marca: " + this.marca);
        System.out.println("Código da Cor: " + this.CodigoCor);
        System.out.println("Preço: R$ " + this.preco);
    }

    public void Ligar() {
        System.out.println("O carro está ligado.");
    }

    // Método para buzinar
    public void Buzinar() {
        System.out.println("emitir som");
    }

    // Método para movimentar
    public void Movimentar() {
        System.out.println("O carro está em movimento.");
    }

    // Método principal (Main) para testar o código
    public static void main(String[] args) {
        // Criando um objeto (instanciando a classe)
        Carro meuCarro = new Carro("Toyota", "Preto-123", 95000.00);

        // Chamando os métodos
        meuCarro.Exibir();
        meuCarro.Ligar();
        meuCarro.Buzinar();
        meuCarro.Movimentar();
    }
}