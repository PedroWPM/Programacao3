import java.util.Scanner;

public class ConversaoNumero {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite um número inteiro: ");
        String input = scanner.nextLine();

        try {
            int numero = Integer.parseInt(input);
            System.out.println("O número digitado foi: " + numero);
        } catch (NumberFormatException e) {
            System.out.println("Erro: Você digitou um valor inválido. Por favor, digite um número inteiro.");
        } finally {
            System.out.println("Encerrando programa...");
            scanner.close();
        }
    }
}
