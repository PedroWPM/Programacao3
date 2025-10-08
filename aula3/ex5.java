// Classe Calculadora
public class Calculadora {

    // Método somar para dois inteiros
    public int somar(int a, int b) {
        return a + b;
    }

    // Método somar para dois doubles
    public double somar(double a, double b) {
        return a + b;
    }

    // Método somar para três inteiros
    public int somar(int a, int b, int c) {
        return a + b + c;
    }

}

// Classe principal para testar os métodos sobrecarregados
public class Main {
    public static void main(String[] args) {
        // Criando um objeto da classe Calculadora
        Calculadora calc = new Calculadora();

        // Testando o método somar com dois inteiros
        int resultadoInteiros = calc.somar(10, 20);
        System.out.println("Soma de dois inteiros: " + resultadoInteiros);

        // Testando o método somar com dois doubles
        double resultadoDoubles = calc.somar(10.5, 20.3);
        System.out.println("Soma de dois doubles: " + resultadoDoubles);

        // Testando o método somar com três inteiros
        int resultadoTresInteiros = calc.somar(10, 20, 30);
        System.out.println("Soma de três inteiros: " + resultadoTresInteiros);
    }
}
