import java.util.*;

public class Atividade9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Aluno> alunos = new ArrayList<>();
        
        System.out.println("Quantos alunos deseja cadastrar?");
        int qtdAlunos = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < qtdAlunos; i++) {
            System.out.print("Nome do aluno (min. 3 caracteres): ");
            String nome = sc.nextLine();
            
            double[] notas = new double[3];
            for (int j = 0; j < 3; j++) {
                notas[j] = lerNotaValida(sc, j + 1);
            }
            alunos.add(new Aluno(nome, notas));
        }

        gerarRelatorios(alunos);
        sc.close();
    }

    private static double lerNotaValida(Scanner sc, int num) {
        double nota = -1;
        while (nota < 0 || nota > 100) {
            try {
                System.out.print("Digite a nota " + num + " (0-100): ");
                nota = Double.parseDouble(sc.nextLine());
                boolean valida = (nota >= 0 && nota <= 100);
                int check = (valida) ? 1 : 0;
                switch (check) {
                    case 0 -> { 
                        System.out.println("Nota inválida!"); 
                        nota = -1; 
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Digite um número.");
            }
        }
        return nota;
    }

    private static void gerarRelatorios(List<Aluno> alunos) {
        double maiorMedia = 0, menorMedia = 100, somaGeral = 0;
        int aprovados = 0, recuperacao = 0, reprovados = 0;

        System.out.println("\n--- 1. Relatório Individual ---");
        for (Aluno a : alunos) {
            System.out.println(a);
            double m = a.getMedia();
            somaGeral += m;
            
            maiorMedia = Math.max(maiorMedia, m);
            menorMedia = Math.min(menorMedia, m);

            switch (a.getStatus()) {
                case "APROVADO" -> aprovados++;
                case "RECUPERAÇÃO" -> recuperacao++;
                case "REPROVADO" -> reprovados++;
            }
        }

        System.out.println("\n--- 2. Estatísticas da Turma ---");
        System.out.printf("Maior média: %.2f\n", maiorMedia);
        System.out.printf("Menor média: %.2f\n", menorMedia);
        System.out.printf("Média geral: %.2f\n", (somaGeral / alunos.size()));

        System.out.println("\n--- 3. Distribuição de Resultados ---");
        System.out.println("APROVADOS: " + aprovados);
        System.out.println("RECUPERAÇÃO: " + recuperacao);
        System.out.println("REPROVADOS: " + reprovados);

        System.out.println("\n--- 4. Melhor(es) Aluno(s) ---");
        for (Aluno a : alunos) {
            int eMelhor = (a.getMedia() == maiorMedia) ? 1 : 0;
            switch (eMelhor) {
                case 1 -> System.out.println(a.getNome() + " com média " + a.getMedia());
            }
        }
    }
}

class Aluno {
    private String nome;
    private double[] notas;
    private double media;

    public Aluno(String nome, double[] notas) {
        this.nome = nome;
        this.notas = notas;
        this.media = (notas[0] + notas[1] + notas[2]) / 3.0;
    }

    public String getStatus() {
        int faixa = (media >= 70) ? 2 : (media >= 50) ? 1 : 0;
        return switch (faixa) {
            case 2 -> "APROVADO";
            case 1 -> "RECUPERAÇÃO";
            default -> "REPROVADO";
        };
    }

    public String getNome() { return nome; }
    public double getMedia() { return media; }

    @Override
    public String toString() {
        return String.format("%s | Notas: %.1f, %.1f, %.1f | Média: %.2f | %s", 
                nome, notas[0], notas[1], notas[2], media, getStatus());
    }
}