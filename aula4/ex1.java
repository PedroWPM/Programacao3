// Classe abstrata ContaBancaria
public abstract class ContaBancaria {
    protected double saldo;

    public ContaBancaria(double saldoInicial) {
        this.saldo = saldoInicial;
    }

    // Método abstrato para saque
    public abstract boolean sacar(double valor);

    // Método abstrato para depósito
    public abstract void depositar(double valor);

    // Método para exibir saldo
    public void exibirSaldo() {
        System.out.println("Saldo atual: R$ " + saldo);
    }
}

// Subclasse ContaCorrente
public class ContaCorrente extends ContaBancaria {

    private static final double TAXA_SAQUE = 1.00;

    public ContaCorrente(double saldoInicial) {
        super(saldoInicial);
    }

    @Override
    public boolean sacar(double valor) {
        if (valor + TAXA_SAQUE <= saldo) {
            saldo -= (valor + TAXA_SAQUE);
            return true;
        }
        return false;
    }

    @Override
    public void depositar(double valor) {
        saldo += valor;
    }
}

// Subclasse ContaPoupanca
public class ContaPoupanca extends ContaBancaria {

    public ContaPoupanca(double saldoInicial) {
        super(saldoInicial);
    }

    @Override
    public boolean sacar(double valor) {
        if (valor <= saldo) {
            saldo -= valor;
            return true;
        }
        return false;
    }

    @Override
    public void depositar(double valor) {
        saldo += valor;
    }
}

// Programa Principal para testar as operações
public class TesteContaBancaria {
    public static void main(String[] args) {
        ContaBancaria contaCorrente = new ContaCorrente(100.00);
        ContaBancaria contaPoupanca = new ContaPoupanca(200.00);

        System.out.println("Conta Corrente:");
        contaCorrente.exibirSaldo();
        contaCorrente.depositar(50.00);
        contaCorrente.exibirSaldo();
        if (contaCorrente.sacar(120.00)) {
            System.out.println("Saque realizado com sucesso!");
        } else {
            System.out.println("Saque não permitido.");
        }
        contaCorrente.exibirSaldo();

        System.out.println("\nConta Poupanca:");
        contaPoupanca.exibirSaldo();
        contaPoupanca.depositar(100.00);
        contaPoupanca.exibirSaldo();
        if (contaPoupanca.sacar(150.00)) {
            System.out.println("Saque realizado com sucesso!");
        } else {
            System.out.println("Saque não permitido.");
        }
        contaPoupanca.exibirSaldo();
    }
}
