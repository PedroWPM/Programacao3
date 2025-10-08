import java.util.Scanner;

public class DivisaoSegura {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o primeiro número (dividendo): ");
        int numero1 = scanner.nextInt();

        System.out.print("Digite o segundo número (divisor): ");
        int numero2 = scanner.nextInt();

        try {
            int resultado = numero1 / numero2;
            System.out.println("Resultado da divisão: " + resultado);
        } catch (ArithmeticException e) {
            System.out.println("Erro: Não é possível dividir por zero. Tente novamente com um divisor diferente de zero.");
        } finally {
            scanner.close();
        }
    }
}
