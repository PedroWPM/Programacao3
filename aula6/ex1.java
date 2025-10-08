import java.util.ArrayList;
import java.util.Scanner;

public class ProgramaArrayList {
    public static void main(String[] args) {
        // Criação do ArrayList para armazenar os números
        ArrayList<Integer> numeros = new ArrayList<>();
        
        Scanner scanner = new Scanner(System.in);
        
        // Coletando 10 números inteiros do usuário
        System.out.println("Digite 10 números inteiros:");
        for (int i = 0; i < 10; i++) {
            System.out.print("Digite o " + (i + 1) + "º número: ");
            int numero = scanner.nextInt();
            numeros.add(numero);
        }
        
        // Exibindo os números inseridos
        System.out.println("\nNúmeros inseridos:");
        for (int numero : numeros) {
            System.out.print(numero + " ");
        }

        // Calculando a soma e a média
        int soma = 0;
        for (int numero : numeros) {
            soma += numero;
        }
        double media = soma / 10.0;
        
        // Exibindo a soma e a média
        System.out.println("\n\nSoma total: " + soma);
        System.out.println("Média: " + media);
        
        // Removendo números pares da lista
        numeros.removeIf(n -> n % 2 == 0);

        // Exibindo a lista atualizada
        System.out.println("\nLista após remoção dos números pares:");
        for (int numero : numeros) {
            System.out.print(numero + " ");
        }

        // Fechando o scanner
        scanner.close();
    }
}
