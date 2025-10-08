import java.util.HashMap;
import java.util.Scanner;

public class CadastroPessoas {
    public static void main(String[] args) {
        // Cria o HashMap para armazenar o nome e a idade
        HashMap<String, Integer> pessoas = new HashMap<>();
        
        // Cadastra pelo menos 5 pessoas no mapa
        pessoas.put("Ana", 25);
        pessoas.put("Carlos", 30);
        pessoas.put("Maria", 22);
        pessoas.put("João", 28);
        pessoas.put("Pedro", 35);
        
        Scanner scanner = new Scanner(System.in);
        
        // Pergunta ao usuário o nome de uma pessoa e exibe a idade correspondente
        System.out.print("Digite o nome de uma pessoa para ver a idade: ");
        String nome = scanner.nextLine();
        
        if (pessoas.containsKey(nome)) {
            System.out.println("A idade de " + nome + " é: " + pessoas.get(nome));
        } else {
            System.out.println("Pessoa não encontrada.");
        }

        // Pergunta ao usuário o nome de uma pessoa para remover
        System.out.print("\nDigite o nome de uma pessoa para remover: ");
        nome = scanner.nextLine();
        
        if (pessoas.containsKey(nome)) {
            pessoas.remove(nome);
            System.out.println(nome + " foi removido.");
        } else {
            System.out.println("Pessoa não encontrada.");
        }
        
        // Exibe o mapa atualizado
        System.out.println("\nMapa atualizado:");
        for (String chave : pessoas.keySet()) {
            System.out.println(chave + " -> " + pessoas.get(chave));
        }
        
        scanner.close();
    }
}
