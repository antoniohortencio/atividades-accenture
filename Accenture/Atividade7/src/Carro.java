public class Carro {
    private String modelo;

    public Carro(String modelo) {
        this.modelo = modelo;
    }

    public void ligar() {
        System.out.println("O carro " + modelo + " está ligado.");
    }
}