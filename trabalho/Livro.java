import java.time.LocalDate;

public class Livro extends Item implements Exportavel {
    private String autor;
    private int numeroPaginas;

    public Livro(String titulo, String descricao, LocalDate dataCadastro, String autor, int numeroPaginas) {
        super(titulo, descricao, dataCadastro);
        setAutor(autor);
        setNumeroPaginas(numeroPaginas);
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        if (autor == null || autor.isBlank()) {
            throw new IllegalArgumentException("O autor não pode estar vazio.");
        }
        this.autor = autor;
    }

    public int getNumeroPaginas() {
        return numeroPaginas;
    }

    public void setNumeroPaginas(int numeroPaginas) {
        if (numeroPaginas <= 0) {
            throw new IllegalArgumentException("O número de páginas deve ser positivo.");
        }
        this.numeroPaginas = numeroPaginas;
    }

    @Override
    public String exibirDetalhes() {
        return "Livro: " + getTitulo() +
                "\nAutor: " + autor +
                "\nDescrição: " + getDescricao() +
                "\nPáginas: " + numeroPaginas +
                "\nData cadastro: " + getDataCadastro();
    }

    @Override
    public String exportar() {
        return String.join(";",
                "LIVRO",
                escape(getTitulo()),
                escape(getDescricao()),
                getDataCadastro().toString(),
                escape(autor),
                String.valueOf(numeroPaginas)
        );
    }

    private String escape(String s) {
        // simples: remove quebras de linha e ponto-e-vírgula para não quebrar o formato CSV simples.
        return s.replace("\n", " ").replace(";", ",");
    }
}
