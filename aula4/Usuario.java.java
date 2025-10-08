// Classe Usuario que possui nome e nível de acesso
public class Usuario {
    private String nome;
    private NivelAcesso nivelAcesso;

    // Construtor
    public Usuario(String nome, NivelAcesso nivelAcesso) {
        this.nome = nome;
        this.nivelAcesso = nivelAcesso;
    }

    // Método para exibir uma mensagem personalizada de acordo com o nível de acesso
    public void exibirMensagemAcesso() {
        switch (nivelAcesso) {
            case BASICO:
                System.out.println(nome + " tem acesso básico. Apenas leitura de dados.");
                break;
            case INTERMEDIARIO:
                System.out.println(nome + " tem acesso intermediário. Leitura e edição de dados.");
                break;
            case ADMIN:
                System.out.println(nome + " tem acesso administrativo. Leitura, edição e exclusão de dados.");
                break;
            default:
                System.out.println("Nível de acesso inválido para o usuário " + nome);
        }
    }
}
