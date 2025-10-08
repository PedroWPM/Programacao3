import java.io.File;
import java.util.Scanner;

public class InfoArquivo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o caminho do arquivo ou diretório: ");
        String caminho = scanner.nextLine();

        File file = new File(caminho);

        if (!file.exists()) {
            System.out.println("O caminho informado NÃO existe.");
        } else {
            System.out.println("Caminho absoluto: " + file.getAbsolutePath());

            if (file.isFile()) {
                System.out.println("É um arquivo.");
                System.out.println("Tamanho do arquivo: " + file.length() + " bytes");
            } else if (file.isDirectory()) {
                System.out.println("É um diretório.");

                // Listar arquivos do diretório
                String[] listaArquivos = file.list();
                if (listaArquivos != null && listaArquivos.length > 0) {
                    System.out.println("Arquivos contidos no diretório:");
                    for (String nomeArquivo : listaArquivos) {
                        System.out.println(" - " + nomeArquivo);
                    }
                } else {
                    System.out.println("O diretório está vazio.");
                }
            } else {
                System.out.println("O caminho existe, mas não é arquivo nem diretório padrão.");
            }
        }

        scanner.close();
    }
}
