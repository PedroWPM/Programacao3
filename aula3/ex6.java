public class Main {
    public static void main(String[] args) {
        // Criando duas contas com o mesmo número
        ContaBancaria conta1 = new ContaBancaria(12345);
        ContaBancaria conta2 = new ContaBancaria(12345);

        // Comparando as contas com equals()
        if (conta1.equals(conta2)) {
            System.out.println("As contas são iguais.");
        } else {
            System.out.println("As contas são diferentes.");
        }

        // Imprimindo uma conta diretamente (toString será chamado)
        System.out.println("Dados da conta: " + conta1);
    }
}
// Classe ContaBancaria
public class ContaBancaria {
    // Atributo
    private int numero;

    // Construtor
    public ContaBancaria(int numero) {
        this.numero = numero;
    }

    // Getter
    public int getNumero() {
        return numero;
    }

    // Sobrescrevendo o método toString
    @Override
    public String toString() {
        return "ContaBancaria{numero=" + numero + "}";
    }

    // Sobrescrevendo o método equals
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true; // mesmo objeto
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false; // tipo diferente ou nulo
        }
        ContaBancaria outraConta = (ContaBancaria) obj;
        return this.numero == outraConta.numero;
    }
}
