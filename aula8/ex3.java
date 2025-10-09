import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class CalculadoraSimples {

    public static void main(String[] args) {
        // Criar a janela
        JFrame janela = new JFrame("Calculadora Simples");
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setLayout(new FlowLayout());

        // Componentes
        JTextField campoNumero1 = new JTextField(10);
        JTextField campoNumero2 = new JTextField(10);
        JComboBox<String> comboOperacao = new JComboBox<>(new String[]{"Somar", "Subtrair", "Multiplicar", "Dividir"});
        JCheckBox checkBoxMostrarResultado = new JCheckBox("Mostrar em JOptionPane");
        JButton botaoCalcular = new JButton("Calcular");

        // Adicionar os componentes
        janela.add(new JLabel("Número 1:"));
        janela.add(campoNumero1);
        janela.add(new JLabel("Número 2:"));
        janela.add(campoNumero2);
        janela.add(comboOperacao);
        janela.add(checkBoxMostrarResultado);
        janela.add(botaoCalcular);

        // Ação do botão
        botaoCalcular.addActionListener((ActionEvent e) -> {
            try {
                double num1 = Double.parseDouble(campoNumero1.getText());
                double num2 = Double.parseDouble(campoNumero2.getText());
                String operacao = (String) comboOperacao.getSelectedItem();
                double resultado = switch (operacao) {
                    case "Somar" -> num1 + num2;
                    case "Subtrair" -> num1 - num2;
                    case "Multiplicar" -> num1 * num2;
                    case "Dividir" -> num2 != 0 ? num1 / num2 : Double.NaN;
                    default -> Double.NaN;
                };

                if (resultado == Double.NaN) {
                    JOptionPane.showMessageDialog(janela, "Erro: Divisão por zero!", "Erro", JOptionPane.ERROR_MESSAGE);
                } else {
                    String mensagem = "Resultado: " + resultado;
                    if (checkBoxMostrarResultado.isSelected()) {
                        JOptionPane.showMessageDialog(janela, mensagem);
                    } else {
                        JOptionPane.showMessageDialog(janela, mensagem);
                    }
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(janela, "Por favor, insira números válidos.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        });

        // Configurar janela
        janela.setSize(300, 200);
        janela.setVisible(true);
    }
}
