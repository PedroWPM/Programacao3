// Classe Pessoa
public class Pessoa {
    // Atributos privados
    private String nome;
    private int idade;

    // Construtor da classe Pessoa
    public Pessoa(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    // Métodos getters e setters para os atributos
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
}

// Subclasse Aluno que herda de Pessoa
public class Aluno extends Pessoa {
    // Atributo privado
    private String matricula;

    // Construtor da classe Aluno
    public Aluno(String nome, int idade, String matricula) {
        // Chama o construtor da classe mãe (Pessoa)
        super(nome, idade);
        this.matricula = matricula;
    }

    // Métodos getters e setters para o atributo matricula
    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    // Método para exibir as informações do aluno
    public void exibirInformacoes() {
        System.out.println("Nome: " + getNome());
        System.out.println("Idade: " + getIdade());
        System.out.println("Matrícula: " + getMatricula());
    }
}

// Classe principal para testar os métodos getters e setters
public class Main {
    public static void main(String[] args) {
        // Instanciando um objeto da classe Aluno
        Aluno aluno = new Aluno("João Silva", 20, "2023456789");

        // Exibindo as informações iniciais
        aluno.exibirInformacoes();

        // Modificando os dados usando os métodos setters
        aluno.setNome("Maria Oliveira");
        aluno.setIdade(22);
        aluno.setMatricula("2029876543");

        // Exibindo as informações após modificação
        System.out.println("\nApós alteração dos dados:");
        aluno.exibirInformacoes();
    }
}
