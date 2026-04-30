import java.util.Scanner;

public class NumToWords {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Digite um número de 1 a 5: ");
        int numero = scanner.nextInt();
        
        if (numero == 1) {
            System.out.println("Número: Um");
        } else if (numero == 2) {
            System.out.println("Número: Dois");
        } else if (numero == 3) {
            System.out.println("Número: Três");
        } else if (numero == 4) {
            System.out.println("Número: Quatro");
        } else if (numero == 5) {
            System.out.println("Número: Cinco");
        } else {
            System.out.println("Número fora do intervalo solicitado!");
        }
        
        scanner.close();
    }
}