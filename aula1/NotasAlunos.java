import java.util.Scanner;

public class NotasAlunos {
    public static void main(String[] args) {
        final int TOTAL_ALUNOS = 10;
        double[] notas = new double[TOTAL_ALUNOS];
        double soma = 0.0;
        int acimaMedia = 0;
        int abaixoMedia = 0;

        Scanner scanner = new Scanner(System.in);

        // Leitura das notas
        for (int i = 0; i < TOTAL_ALUNOS; i++) {
            System.out.print("Digite a nota do aluno " + (i + 1) + ": ");
            notas[i] = scanner.nextDouble();
            soma += notas[i];
        }

        // Cálculo da média
        double media = soma / TOTAL_ALUNOS;
        System.out.printf("\nMédia da turma: %.2f\n", media);

        // Verificação de notas acima e abaixo da média
        for (double nota : notas) {
            if (nota > media) {
                acimaMedia++;
            } else if (nota < media) {
                abaixoMedia++;
            }
        }

        // Exibição dos resultados
        System.out.println("Quantidade de notas acima da média: " + acimaMedia);
        System.out.println("Quantidade de notas abaixo da média: " + abaixoMedia);

        scanner.close();
    }
}
