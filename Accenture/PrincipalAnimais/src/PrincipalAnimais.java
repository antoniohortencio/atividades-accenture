public class PrincipalAnimais {
    public static void main(String[] args) {

        Gato meuGato = new Gato("Mingau", 3);

        Dog meuDog = new Dog("Rex", 5);

        meuGato.emitirSom();
        meuDog.emitirSom();
    }
}