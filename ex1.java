public class Carro {

    // Atributos
    String marca;
    String modelo;
    int ano;

    // Construtor
    public Carro(String marca, String modelo, int ano) {
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
    }

    // Método para exibir as informações do carro
    public void exibirInfo() {
        System.out.println("Marca: " + marca);
        System.out.println("Modelo: " + modelo);
        System.out.println("Ano: " + ano);
    }

    // Método main para testar a classe
    public static void main(String[] args) {
        // Criando duas instâncias de Carro
        Carro carro1 = new Carro("Toyota", "Corolla", 2020);
        Carro carro2 = new Carro("Honda", "Civic", 2022);

        // Chamando o método exibirInfo() para cada carro
        System.out.println("Informações do Carro 1:");
        carro1.exibirInfo();
        
        System.out.println("\nInformações do Carro 2:");
        carro2.exibirInfo();
    }
}
