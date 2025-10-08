public class Fibonacci {
    public static void main(String[] args) {
        int n = 30; // Número de elementos a serem impressos
        long primeiro = 1, segundo = 1;

        System.out.print("Série de Fibonacci com " + n + " elementos:\n");

        System.out.print(primeiro + ", " + segundo);

        for (int i = 3; i <= n; i++) {
            long proximo = primeiro + segundo;
            System.out.print(", " + proximo);
            primeiro = segundo;
            segundo = proximo;
        }

        System.out.println(); // Nova linha no final
    }
}
