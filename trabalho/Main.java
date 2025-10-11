import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class Main {
    private final GerenciadorItens gerenciador = new GerenciadorItens();
    private final JFrame frame = new JFrame("Gerenciador de Itens");
    private final DefaultTableModel tableModel = new DefaultTableModel(new Object[]{"Tipo", "Título", "Descrição", "Data", "Atributo1", "Atributo2"}, 0);
    private final JTable table = new JTable(tableModel);
    private final JTextField searchField = new JTextField(20);
    private final JLabel statusLabel = new JLabel("Pronto");

    // Cor de fundo pedida
    private final Color fundo = Color.decode("#f9fc7e");

    public static void main(String[] args) {
        // inicializa GUI na EDT
        SwingUtilities.invokeLater(() -> {
            Main m = new Main();
            m.createAndShowGui();
        });
    }

    private void createAndShowGui() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(900, 600);
        frame.setLocationRelativeTo(null);

        JPanel root = new JPanel(new BorderLayout());
        root.setBackground(fundo);
        frame.setContentPane(root);

        // Top: controle
        JPanel topPanel = new JPanel();
        topPanel.setBackground(fundo);
        JButton btnAdicionarLivro = new JButton("Adicionar Livro");
        JButton btnAdicionarFilme = new JButton("Adicionar Filme");
        JButton btnExportar = new JButton("Exportar Dados");
        JButton btnImportar = new JButton("Importar Dados");
        JButton btnContar = new JButton("Contar por Tipo");
        JButton btnListar = new JButton("Listar Todos");

        topPanel.add(btnAdicionarLivro);
        topPanel.add(btnAdicionarFilme);
        topPanel.add(new JLabel("Pesquisar título:"));
        topPanel.add(searchField);
        JButton btnBuscar = new JButton("Buscar");
        topPanel.add(btnBuscar);
        topPanel.add(btnListar);
        topPanel.add(btnContar);
        topPanel.add(btnExportar);
        topPanel.add(btnImportar);

        root.add(topPanel, BorderLayout.NORTH);

        // Center: tabela com rolagem
        table.setFillsViewportHeight(true);
        JScrollPane scroll = new JScrollPane(table);
        scroll.getViewport().setBackground(fundo);
        root.add(scroll, BorderLayout.CENTER);

        // Bottom: status
        JPanel bottom = new JPanel(new BorderLayout());
        bottom.setBackground(fundo);
        bottom.add(statusLabel, BorderLayout.WEST);
        frame.add(bottom, BorderLayout.SOUTH);

        // Actions
        btnAdicionarLivro.addActionListener(e -> abrirDialogLivro());
        btnAdicionarFilme.addActionListener(e -> abrirDialogFilme());

        btnListar.addActionListener(e -> atualizarTabela(gerenciador.listarTodos()));

        btnBuscar.addActionListener(e -> {
            String termo = searchField.getText();
            try {
                List<Item> encontrados = gerenciador.buscarPorTitulo(termo);
                atualizarTabela(encontrados);
                statusLabel.setText("Encontrados: " + encontrados.size());
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
        });

        btnContar.addActionListener(e -> {
            Map<String, Long> map = gerenciador.contarPorTipo();
            StringBuilder sb = new StringBuilder();
            map.forEach((k, v) -> sb.append(k).append(": ").append(v).append("\n"));
            if (sb.length() == 0) sb.append("Nenhum item cadastrado.");
            JOptionPane.showMessageDialog(frame, sb.toString(), "Contagem por Tipo", JOptionPane.INFORMATION_MESSAGE);
        });

        btnExportar.addActionListener(e -> {
            JFileChooser fc = new JFileChooser();
            int escolha = fc.showSaveDialog(frame);
            if (escolha == JFileChooser.APPROVE_OPTION) {
                File arquivo = fc.getSelectedFile();
                try {
                    gerenciador.exportarParaArquivo(arquivo);
                    JOptionPane.showMessageDialog(frame, "Exportado com sucesso para: " + arquivo.getAbsolutePath());
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(frame, "Erro ao exportar: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        btnImportar.addActionListener(e -> {
            JFileChooser fc = new JFileChooser();
            int escolha = fc.showOpenDialog(frame);
            if (escolha == JFileChooser.APPROVE_OPTION) {
                File arquivo = fc.getSelectedFile();
                try {
                    gerenciador.importarDeArquivo(arquivo);
                    atualizarTabela(gerenciador.listarTodos());
                    JOptionPane.showMessageDialog(frame, "Importado com sucesso de: " + arquivo.getAbsolutePath());
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(frame, "Erro ao importar: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Preenche com alguns itens de exemplo (opcional)
        try {
            gerenciador.adicionarItem(new Livro("Clean Code", "Boas práticas", LocalDate.now(), "Robert C. Martin", 464));
            gerenciador.adicionarItem(new Filme("Matrix", "Ficção científica", LocalDate.now(), "Wachowski", 136));
        } catch (Exception ignored) {}

        atualizarTabela(gerenciador.listarTodos());
        frame.setVisible(true);
    }

    private void atualizarTabela(List<Item> itens) {
        tableModel.setRowCount(0);
        for (Item it : itens) {
            if (it instanceof Livro) {
                Livro l = (Livro) it;
                tableModel.addRow(new Object[]{"Livro", l.getTitulo(), l.getDescricao(), l.getDataCadastro(), "Autor: " + l.getAutor(), "Páginas: " + l.getNumeroPaginas()});
            } else if (it instanceof Filme) {
                Filme f = (Filme) it;
                tableModel.addRow(new Object[]{"Filme", f.getTitulo(), f.getDescricao(), f.getDataCadastro(), "Diretor: " + f.getDiretor(), "Duração: " + f.getDuracaoMinutos() + "m"});
            } else {
                tableModel.addRow(new Object[]{it.getClass().getSimpleName(), it.getTitulo(), it.getDescricao(), it.getDataCadastro(), "", ""});
            }
        }
        statusLabel.setText("Total de itens: " + itens.size());
    }

    private void abrirDialogLivro() {
        JDialog dialog = new JDialog(frame, "Adicionar Livro", true);
        dialog.setSize(400, 320);
        dialog.setLocationRelativeTo(frame);
        JPanel p = new JPanel();
        p.setBackground(fundo);
        p.setLayout(new GridLayout(0, 2, 6, 6));

        JTextField titulo = new JTextField();
        JTextField descricao = new JTextField();
        JTextField autor = new JTextField();
        JTextField paginas = new JTextField();

        p.add(new JLabel("Título:"));
        p.add(titulo);
        p.add(new JLabel("Descrição:"));
        p.add(descricao);
        p.add(new JLabel("Autor:"));
        p.add(autor);
        p.add(new JLabel("Número de páginas:"));
        p.add(paginas);

        JButton salvar = new JButton("Salvar");
        JButton cancelar = new JButton("Cancelar");
        JPanel bottom = new JPanel();
        bottom.setBackground(fundo);
        bottom.add(salvar);
        bottom.add(cancelar);

        dialog.getContentPane().add(p, BorderLayout.CENTER);
        dialog.getContentPane().add(bottom, BorderLayout.SOUTH);

        salvar.addActionListener(e -> {
            try {
                String t = titulo.getText();
                String d = descricao.getText();
                String a = autor.getText();
                int pg = Integer.parseInt(paginas.getText().trim());
                Livro l = new Livro(t, d, LocalDate.now(), a, pg);
                gerenciador.adicionarItem(l);
                atualizarTabela(gerenciador.listarTodos());
                dialog.dispose();
            } catch (NumberFormatException nfe) {
                JOptionPane.showMessageDialog(dialog, "Número de páginas inválido.", "Erro", JOptionPane.ERROR_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(dialog, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
        });

        cancelar.addActionListener(e -> dialog.dispose());

        dialog.setVisible(true);
    }

    private void abrirDialogFilme() {
        JDialog dialog = new JDialog(frame, "Adicionar Filme", true);
        dialog.setSize(400, 300);
        dialog.setLocationRelativeTo(frame);
        JPanel p = new JPanel();
        p.setBackground(fundo);
        p.setLayout(new GridLayout(0, 2, 6, 6));

        JTextField titulo = new JTextField();
        JTextField descricao = new JTextField();
        JTextField diretor = new JTextField();
        JTextField duracao = new JTextField();

        p.add(new JLabel("Título:"));
        p.add(titulo);
        p.add(new JLabel("Descrição:"));
        p.add(descricao);
        p.add(new JLabel("Diretor:"));
        p.add(diretor);
        p.add(new JLabel("Duração (min):"));
        p.add(duracao);

        JButton salvar = new JButton("Salvar");
        JButton cancelar = new JButton("Cancelar");
        JPanel bottom = new JPanel();
        bottom.setBackground(fundo);
        bottom.add(salvar);
        bottom.add(cancelar);

        dialog.getContentPane().add(p, BorderLayout.CENTER);
        dialog.getContentPane().add(bottom, BorderLayout.SOUTH);

        salvar.addActionListener(e -> {
            try {
                String t = titulo.getText();
                String d = descricao.getText();
                String dir = diretor.getText();
                int dur = Integer.parseInt(duracao.getText().trim());
                Filme f = new Filme(t, d, LocalDate.now(), dir, dur);
                gerenciador.adicionarItem(f);
                atualizarTabela(gerenciador.listarTodos());
                dialog.dispose();
            } catch (NumberFormatException nfe) {
                JOptionPane.showMessageDialog(dialog, "Duração inválida.", "Erro", JOptionPane.ERROR_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(dialog, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
        });

        cancelar.addActionListener(e -> dialog.dispose());

        dialog.setVisible(true);
    }
}
