import java.util.Scanner;

public class MediaNumerosPositivos {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numero;
        int soma = 0;
        int quantidade = 0;

        System.out.println("Digite números inteiros (maiores ou iguais a zero).");
        System.out.println("Digite um número negativo para encerrar.");

        while (true) {
            System.out.print("Digite um número: ");
            numero = scanner.nextInt();

            if (numero < 0) {
                break; // Encerra o laço
            }

            soma += numero;
            quantidade++;
        }

        if (quantidade > 0) {
            double media = (double) soma / quantidade;
            System.out.println("\nQuantidade de números digitados: " + quantidade);
            System.out.printf("Média dos números digitados: %.2f\n", media);
        } else {
            System.out.println("\nNenhum número válido foi digitado.");
        }

        scanner.close();
    }
}

