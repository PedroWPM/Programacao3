import java.util.HashSet;
import java.util.Scanner;

public class PalavraUnica {
    public static void main(String[] args) {
        // Cria o HashSet para armazenar as palavras
        HashSet<String> palavras = new HashSet<>();
        Scanner scanner = new Scanner(System.in);

        // Loop para ler as palavras até o usuário digitar "fim"
        String palavra;
        do {
            System.out.print("Digite uma palavra (ou 'fim' para encerrar): ");
            palavra = scanner.nextLine();
            
            if (!palavra.equalsIgnoreCase("fim")) {
                palavras.add(palavra);  // Adiciona a palavra ao HashSet
            }

        } while (!palavra.equalsIgnoreCase("fim"));
        
        // Exibe todas as palavras únicas
        System.out.println("\nPalavras únicas digitadas:");
        for (String p : palavras) {
            System.out.println(p);
        }
        
        // Verifica se a palavra "Java" foi digitada
        if (palavras.contains("Java")) {
            System.out.println("\nA palavra 'Java' foi digitada.");
        } else {
            System.out.println("\nA palavra 'Java' NÃO foi digitada.");
        }

        scanner.close();
    }
}
