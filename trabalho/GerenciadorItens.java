import java.io.*;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class GerenciadorItens {
    private final List<Item> itens;

    public GerenciadorItens() {
        this.itens = new ArrayList<>();
    }

    public void adicionarItem(Item item) throws CampoVazioException {
        if (item == null) {
            throw new CampoVazioException("item");
        }
        itens.add(item);
    }

    public List<Item> listarTodos() {
        List<Item> copia = new ArrayList<>(itens);
        copia.sort(Comparator.comparing(Item::getTitulo, String.CASE_INSENSITIVE_ORDER));
        return copia;
    }

    public List<Item> buscarPorTitulo(String titulo) throws CampoVazioException {
        if (titulo == null || titulo.isBlank()) {
            throw new CampoVazioException("título");
        }
        String termo = titulo.toLowerCase();
        return itens.stream()
                .filter(i -> i.getTitulo().toLowerCase().contains(termo))
                .sorted(Comparator.comparing(Item::getTitulo, String.CASE_INSENSITIVE_ORDER))
                .collect(Collectors.toList());
    }

    public Map<String, Long> contarPorTipo() {
        return itens.stream()
                .collect(Collectors.groupingBy(i -> i.getClass().getSimpleName(), Collectors.counting()));
    }

    // Exporta itens que implementam Exportavel em um arquivo (cada item em uma linha)
    public void exportarParaArquivo(File arquivo) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(arquivo))) {
            for (Item item : itens) {
                if (item instanceof Exportavel) {
                    bw.write(((Exportavel) item).exportar());
                    bw.newLine();
                }
            }
        }
    }

    // Importa itens do arquivo, adicionando-os à coleção.
    // Formato esperado por linha:
    // LIVRO;titulo;descricao;yyyy-MM-dd;autor;numeroPaginas
    // FILME;titulo;descricao;yyyy-MM-dd;diretor;duracaoMinutos
    public void importarDeArquivo(File arquivo) throws IOException {
        List<Item> carregados = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            int linhaNum = 0;
            while ((linha = br.readLine()) != null) {
                linhaNum++;
                if (linha.isBlank()) continue;
                String[] partes = linha.split(";");
                try {
                    String tipo = partes[0].trim().toUpperCase();
                    if (tipo.equals("LIVRO")) {
                        if (partes.length < 6) throw new IllegalArgumentException("Formato inválido para LIVRO na linha " + linhaNum);
                        String titulo = partes[1].trim();
                        String descricao = partes[2].trim();
                        LocalDate data = LocalDate.parse(partes[3].trim());
                        String autor = partes[4].trim();
                        int paginas = Integer.parseInt(partes[5].trim());
                        Livro l = new Livro(titulo, descricao, data, autor, paginas);
                        carregados.add(l);
                    } else if (tipo.equals("FILME")) {
                        if (partes.length < 6) throw new IllegalArgumentException("Formato inválido para FILME na linha " + linhaNum);
                        String titulo = partes[1].trim();
                        String descricao = partes[2].trim();
                        LocalDate data = LocalDate.parse(partes[3].trim());
                        String diretor = partes[4].trim();
                        int duracao = Integer.parseInt(partes[5].trim());
                        Filme f = new Filme(titulo, descricao, data, diretor, duracao);
                        carregados.add(f);
                    } else {
                        // ignora linhas desconhecidas
                        System.err.println("Tipo desconhecido na linha " + linhaNum + ": " + tipo);
                    }
                } catch (Exception e) {
                    // não interrompe a importação inteira, apenas reporta
                    System.err.println("Falha ao processar linha " + linhaNum + ": " + e.getMessage());
                }
            }
        }
        // adiciona carregados à lista
        itens.addAll(carregados);
    }

    // Getter direto (cópia) se necessário
    public List<Item> getItens() {
        return new ArrayList<>(itens);
    }
}
