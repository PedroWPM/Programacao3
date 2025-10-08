public class TesteUsuario {
    public static void main(String[] args) {
        // Criando usuários com diferentes níveis de acesso
        Usuario usuario1 = new Usuario("Carlos", NivelAcesso.BASICO);
        Usuario usuario2 = new Usuario("Ana", NivelAcesso.INTERMEDIARIO);
        Usuario usuario3 = new Usuario("João", NivelAcesso.ADMIN);

        // Exibindo as mensagens personalizadas
        usuario1.exibirMensagemAcesso();
        usuario2.exibirMensagemAcesso();
        usuario3.exibirMensagemAcesso();
    }
}
