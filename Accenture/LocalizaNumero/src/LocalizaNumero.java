import java.util.Scanner;

public class LocalizaNumero {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        
        int vetor[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        
        System.out.print("Digite o número que deseja encontrar: ");
        int numeroProcurado = teclado.nextInt();
        
        boolean achou = false;
        int posicaoEncontrada = -1;

        for (int i = 0; i < vetor.length; i++) {
            if (vetor[i] == numeroProcurado) {
                achou = true;
                posicaoEncontrada = i;
                break; 
            }
        }

        if (achou) {
            System.out.println("Achei!");
            System.out.printf("Na Posição %d está localizado o número %d.\n", posicaoEncontrada, vetor[posicaoEncontrada]);
        } else {
            System.out.println("Número não encontrado no vetor.");
        }

        teclado.close();
    }
}