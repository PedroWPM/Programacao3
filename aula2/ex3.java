import java.util.ArrayList;
import java.util.Iterator;

public class ListaDeAlunos {

    public static void main(String[] args) {
       
        ArrayList<String> alunos = new ArrayList<>();

       
        alunos.add("João");
        alunos.add("Maria");
        alunos.add("Pedro");
        alunos.add("Ana");
        alunos.add("Lucas");

       
        Iterator<String> iterator = alunos.iterator();
        System.out.println("Lista de alunos:");
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        
        alunos.remove("Pedro");

       
        System.out.println("\nLista de alunos após remoção de Pedro:");
        for (String aluno : alunos) {
            System.out.println(aluno);
        }
    }
}
