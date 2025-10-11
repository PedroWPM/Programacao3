import java.time.LocalDate;

public class Filme extends Item implements Exportavel {
    private String diretor;
    private int duracaoMinutos;

    public Filme(String titulo, String descricao, LocalDate dataCadastro, String diretor, int duracaoMinutos) {
        super(titulo, descricao, dataCadastro);
        setDiretor(diretor);
        setDuracaoMinutos(duracaoMinutos);
    }

    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        if (diretor == null || diretor.isBlank()) {
            throw new IllegalArgumentException("O diretor não pode estar vazio.");
        }
        this.diretor = diretor;
    }

    public int getDuracaoMinutos() {
        return duracaoMinutos;
    }

    public void setDuracaoMinutos(int duracaoMinutos) {
        if (duracaoMinutos <= 0) {
            throw new IllegalArgumentException("A duração deve ser positiva.");
        }
        this.duracaoMinutos = duracaoMinutos;
    }

    @Override
    public String exibirDetalhes() {
        return "Filme: " + getTitulo() +
                "\nDiretor: " + diretor +
                "\nDescrição: " + getDescricao() +
                "\nDuração (min): " + duracaoMinutos +
                "\nData cadastro: " + getDataCadastro();
    }

    @Override
    public String exportar() {
        return String.join(";",
                "FILME",
                escape(getTitulo()),
                escape(getDescricao()),
                getDataCadastro().toString(),
                escape(diretor),
                String.valueOf(duracaoMinutos)
        );
    }

    private String escape(String s) {
        return s.replace("\n", " ").replace(";", ",");
    }
}
