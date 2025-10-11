import java.time.LocalDate;

public abstract class Item {
    private String titulo;
    private String descricao;
    private LocalDate dataCadastro;

    public Item(String titulo, String descricao, LocalDate dataCadastro) {
        setTitulo(titulo);
        setDescricao(descricao);
        setDataCadastro(dataCadastro);
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        if (titulo == null || titulo.isBlank()) {
            throw new IllegalArgumentException("O título não pode estar vazio.");
        }
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        if (descricao == null || descricao.isBlank()) {
            throw new IllegalArgumentException("A descrição não pode estar vazia.");
        }
        this.descricao = descricao;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDate dataCadastro) {
        if (dataCadastro == null) {
            throw new IllegalArgumentException("A data de cadastro não pode ser nula.");
        }
        this.dataCadastro = dataCadastro;
    }

    public abstract String exibirDetalhes();
}
