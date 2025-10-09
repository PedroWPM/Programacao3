import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JanelaExemplo {

    public static void main(String[] args) {
        // Criar a janela (JFrame)
        JFrame janela = new JFrame("Minha Janela Personalizada");

        // Configurar o fechamento da janela
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Criar um JLabel com uma mensagem de boas-vindas
        JLabel mensagem = new JLabel("Bem-vindo à minha aplicação!", JLabel.CENTER);
        mensagem.setFont(new Font("Arial", Font.BOLD, 16));

        // Criar um botão "Fechar"
        JButton botaoFechar = new JButton("Fechar");
        botaoFechar.setFont(new Font("Arial", Font.PLAIN, 14));

        // Adicionar um ouvinte (listener) para o botão de fechar
        botaoFechar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                janela.dispose();  // Fecha a janela
            }
        });

        // Configurar o layout da janela (usando FlowLayout para centralizar os componentes)
        janela.setLayout(new FlowLayout());
        
        // Adicionar o JLabel e o JButton à janela
        janela.add(mensagem);
        janela.add(botaoFechar);

        // Definir o tamanho da janela
        janela.setSize(300, 150);

        // Tornar a janela visível
        janela.setVisible(true);
    }
}
