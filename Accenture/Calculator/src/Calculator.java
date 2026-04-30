import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        
        Scanner leitor = new Scanner(System.in);
       
        System.out.println("--- CALCULADORA JAVA ---");
        System.out.println("Escolha uma operação:");
        System.out.println("1. Soma (+)");
        System.out.println("2. Subtração (-)");
        System.out.println("3. Multiplicação (*)");
        System.out.println("4. Divisão (/)");
        System.out.print("Opção: ");
        
        int opcao = leitor.nextInt();

        System.out.print("Digite o primeiro número: ");
        double num1 = leitor.nextDouble();
        
        System.out.print("Digite o segundo número: ");
        double num2 = leitor.nextDouble();

        double resultado = 0;

        switch (opcao) {
            case 1:
                resultado = num1 + num2;
                System.out.println("Resultado da Soma: " + resultado);
                break;
            case 2:
                resultado = num1 - num2;
                System.out.println("Resultado da Subtração: " + resultado);
                break;
            case 3:
                resultado = num1 * num2;
                System.out.println("Resultado da Multiplicação: " + resultado);
                break;
            case 4:
                if (num2 != 0) {
                    resultado = num1 / num2;
                    System.out.println("Resultado da Divisão: " + resultado);
                } else {
                    System.out.println("Erro: Não é possível dividir por zero!");
                }
                break;
            default:
                System.out.println("Opção inválida!");
                break;
        }

        leitor.close();
    }
}