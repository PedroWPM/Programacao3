import java.io.*;
import java.util.Scanner;

public class LeitorArquivo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o nome do arquivo de texto (com caminho se necessário): ");
        String nomeArquivo = scanner.nextLine();

        // Usando try-with-resources para garantir o fechamento automático dos streams
        try (FileInputStream fis = new FileInputStream(nomeArquivo);
             InputStreamReader isr = new InputStreamReader(fis);
             BufferedReader br = new BufferedReader(isr)) {

            String linha;
            System.out.println("\nConteúdo do arquivo:");

            while ((linha = br.readLine()) != null) {
                System.out.println(linha);
            }

        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado: " + nomeArquivo);
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }

        scanner.close();
    }
}
