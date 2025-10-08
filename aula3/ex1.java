public class Livro {
    // Atributos
    private String titulo;
    private String autor;

    // Construtor sem parâmetros (atributos com valores padrão)
    public Livro() {
        this.titulo = "Título Padrão";
        this.autor = "Autor Padrão";
    }

    // Construtor com parâmetros para inicializar os atributos
    public Livro(String titulo, String autor) {
        this.titulo = titulo;
        this.autor = autor;
    }

    // Métodos para obter os dados
    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    // Método main para testar os construtores
    public static void main(String[] args) {
        // Instanciando um objeto utilizando o construtor sem parâmetros
        Livro livro1 = new Livro();
        
        // Instanciando um objeto utilizando o construtor com parâmetros
        Livro livro2 = new Livro("1984", "George Orwell");

        // Exibindo os dados dos livros
        System.out.println("Livro 1:");
        System.out.println("Título: " + livro1.getTitulo());
        System.out.println("Autor: " + livro1.getAutor());

        System.out.println("\nLivro 2:");
        System.out.println("Título: " + livro2.getTitulo());
        System.out.println("Autor: " + livro2.getAutor());
    }
}
