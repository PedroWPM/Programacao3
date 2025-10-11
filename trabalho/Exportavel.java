public interface Exportavel {
    /**
     * Retorna uma linha formatada para exportação, por exemplo:
     * LIVRO;Titulo;Descricao;2025-10-10;Autor;123
     */
    String exportar();
}
