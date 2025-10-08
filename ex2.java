public class Contador {

    // Atributo estático para contar o número de objetos criados
    private static int totalObjetos = 0;

    // Construtor
    public Contador() {
        totalObjetos++; // Incrementa o contador sempre que um objeto é criado
    }

    // Método estático para exibir o total de objetos criados
    public static void mostrarTotal() {
        System.out.println("Total de objetos criados: " + totalObjetos);
    }

    // Método main para testar a classe
    public static void main(String[] args) {
        // Criando alguns objetos
        Contador c1 = new Contador();
        Contador c2 = new Contador();
        Contador c3 = new Contador();

        // Exibindo o total de objetos criados
        Contador.mostrarTotal();  // Saída esperada: "Total de objetos criados: 3"
    }
}
