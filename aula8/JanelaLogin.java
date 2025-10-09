import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JanelaLogin {

    public static void main(String[] args) {
        // Criar a janela (JFrame)
        JFrame janela = new JFrame("Tela de Login");

        // Configurar o fechamento da janela
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Definir o layout da janela (GridBagLayout para melhor controle de posicionamento)
        janela.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

        // Criar os componentes para o nome de usuário
        JLabel labelUsuario = new JLabel("Nome de Usuário:");
        JTextField campoUsuario = new JTextField(20);

        // Criar os componentes para a senha
        JLabel labelSenha = new JLabel("Senha:");
        JPasswordField campoSenha = new JPasswordField(20);

        // Criar o botão "Entrar"
        JButton botaoEntrar = new JButton("Entrar");

        // Adicionar os componentes à janela com controle de layout
        constraints.gridx = 0;
        constraints.gridy = 0;
        janela.add(labelUsuario, constraints);

        constraints.gridx = 1;
        janela.add(campoUsuario, constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        janela.add(labelSenha, constraints);

        constraints.gridx = 1;
        janela.add(campoSenha, constraints);

        constraints.gridx = 1;
        constraints.gridy = 2;
        janela.add(botaoEntrar, constraints);

        // Configurar ação para o botão "Entrar"
        botaoEntrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obter o nome de usuário e a senha
                String nomeUsuario = campoUsuario.getText();
                char[] senha = campoSenha.getPassword();

                // Verificar se o nome de usuário foi preenchido
                if (nomeUsuario.isEmpty()) {
                    JOptionPane.showMessageDialog(janela, "Por favor, insira o nome de usuário.");
                } else {
                    // Exibir a mensagem de boas-vindas com o nome de usuário
                    JOptionPane.showMessageDialog(janela, "Bem-vindo, " + nomeUsuario + "!");
                }
            }
        });

        // Definir o tamanho da janela
        janela.setSize(400, 250);

        // Tornar a janela visível
        janela.setVisible(true);
    }
}
