// Interface Corredor
interface Corredor {
    void correr();  // Método que define o comportamento de correr
}

// Interface Nadador
interface Nadador {
    void nadar();  // Método que define o comportamento de nadar
}

// Interface Ciclista
interface Ciclista {
    void pedalar();  // Método que define o comportamento de pedalar
}

// Classe Triatleta implementa Corredor, Nadador e Ciclista
class Triatleta implements Corredor, Nadador, Ciclista {

    @Override
    public void correr() {
        System.out.println("O triatleta está correndo.");
    }

    @Override
    public void nadar() {
        System.out.println("O triatleta está nadando.");
    }

    @Override
    public void pedalar() {
        System.out.println("O triatleta está pedalando.");
    }
}

// Programa Principal
public class TesteTriatleta {
    public static void main(String[] args) {
        // Instanciando a classe Triatleta
        Triatleta triatleta = new Triatleta();

        // Chamando os métodos das interfaces implementadas
        triatleta.correr();
        triatleta.nadar();
        triatleta.pedalar();
    }
}
