import java.util.Scanner;

public class CalculadoraEstadio {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        int precoA = 50;
        int precoB = 30;
        int precoC = 20;

        System.out.print("Quantos ingressos da Classe A foram vendidos? ");
        int qtdA = entrada.nextInt();

        System.out.print("Quantos ingressos da Classe B foram vendidos? ");
        int qtdB = entrada.nextInt();

        System.out.print("Quantos ingressos da Classe C foram vendidos? ");
        int qtdC = entrada.nextInt();

        int rendaTotal = (qtdA * precoA) + (qtdB * precoB) + (qtdC * precoC);

        System.out.println("---");
        System.out.println("Renda total gerada: R$ " + rendaTotal);
        
        entrada.close();
    }
}