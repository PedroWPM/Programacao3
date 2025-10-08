import java.util.Scanner;

public class CalculadoraRaiz {
    
    // Método que calcula a raiz quadrada de um número
    public static double calcularRaiz(int numero) throws IllegalArgumentException {
        if (numero < 0) {
            throw new IllegalArgumentException("Erro: Não é possível calcular a raiz quadrada de um número negativo.");
        }
        return Math.sqrt(numero);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite um número para calcular a raiz quadrada: ");
        int numero = scanner.nextInt();

        try {
            double resultado = calcularRaiz(numero);
            System.out.println("A raiz quadrada de " + numero + " é: " + resultado);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
