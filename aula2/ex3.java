import java.util.ArrayList;
import java.util.Iterator;

public class ListaDeAlunos {

    public static void main(String[] args) {
        // Criando a ArrayList para armazenar os nomes dos alunos
        ArrayList<String> alunos = new ArrayList<>();

        // Adicionando nomes de alunos na lista
        alunos.add("João");
        alunos.add("Maria");
        alunos.add("Pedro");
        alunos.add("Ana");
        alunos.add("Lucas");

        // Usando um Iterator para percorrer e imprimir a lista de alunos
        Iterator<String> iterator = alunos.iterator();
        System.out.println("Lista de alunos:");
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        // Removendo um aluno (exemplo: removendo "Pedro")
        alunos.remove("Pedro");

        // Exibindo a lista atualizada
        System.out.println("\nLista de alunos após remoção de Pedro:");
        for (String aluno : alunos) {
            System.out.println(aluno);
        }
    }
}
