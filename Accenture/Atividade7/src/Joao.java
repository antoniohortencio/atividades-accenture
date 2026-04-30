public class Joao {
    private String nome = "João";

    public void morar(Casa casa) {
        System.out.println(nome + " mora na casa localizada em: " + casa.getEndereco());
    }

    public void dirigir(Carro carro) {
        carro.ligar();
        System.out.println(nome + " está dirigindo o carro.");
    }
}