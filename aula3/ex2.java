// Classe Pessoa
public class Pessoa {
    // Atributos
    private String nome;
    private int idade;

    // Construtor da classe Pessoa
    public Pessoa(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    // Métodos getters
    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }
}

// Subclasse Aluno que herda de Pessoa
public class Aluno extends Pessoa {
    // Atributo específico de Aluno
    private String matricula;

    // Construtor da classe Aluno
    public Aluno(String nome, int idade, String matricula) {
        // Chama o construtor da classe mãe (Pessoa)
        super(nome, idade);
        this.matricula = matricula;
    }

    // Método getter para matrícula
    public String getMatricula() {
        return matricula;
    }

    // Método para exibir as informações do aluno
    public void exibirInformacoes() {
        System.out.println("Nome: " + getNome());
        System.out.println("Idade: " + getIdade());
        System.out.println("Matrícula: " + getMatricula());
    }
}

// Classe principal para testar a criação do objeto Aluno
public class Main {
    public static void main(String[] args) {
        // Instanciando um objeto da classe Aluno
        Aluno aluno = new Aluno("João Silva", 20, "2023456789");

        // Exibindo as informações do aluno
        aluno.exibirInformacoes();
    }
}
