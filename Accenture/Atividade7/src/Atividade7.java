public class Atividade7 {
    public static void main(String[] args) {
        Joao joao = new Joao();
        Casa minhaCasa = new Casa("Rua das Flores, 123");
        Carro meuCarro = new Carro("Conversível Vermelho");
        Arvore carvalho = new Arvore("Carvalho");

        joao.morar(minhaCasa);
        joao.dirigir(meuCarro);

        System.out.println("No cenário existe uma árvore do tipo: " + carvalho.getEspecie());
    }
}