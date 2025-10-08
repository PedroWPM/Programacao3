import java.util.Scanner;

public class ClasseEleitoral {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Entrada da idade
        System.out.print("Digite a idade da pessoa: ");
        int idade = scanner.nextInt();

        // Verificação da classe eleitoral
        if (idade < 16) {
            System.out.println("Não pode votar.");
        } else if ((idade >= 16 && idade < 18) || idade > 65) {
            System.out.println("Voto facultativo.");
        } else {
            System.out.println("Voto obrigatório.");
        }

        scanner.close();
    }
}
