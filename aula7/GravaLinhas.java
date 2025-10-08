import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class GravaLinhas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try (PrintStream ps = new PrintStream("saida.txt")) {
            System.out.println("Digite linhas de texto. Para encerrar, digite 'FIM'.");

            while (true) {
                String linha = scanner.nextLine();
                if (linha.equalsIgnoreCase("FIM")) {
                    break;  // Para o loop, não grava "FIM"
                }
                ps.println(linha);
            }

            System.out.println("Texto gravado em 'saida.txt'.");

        } catch (FileNotFoundException e) {
            System.out.println("Erro ao criar o arquivo: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
