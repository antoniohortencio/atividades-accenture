public class ContaCorrente {
    private int numero;
    private String nome;
    private double saldo;
    private String data;

    public ContaCorrente(int numero, String nome, double saldo, String data) {
        this.numero = numero;
        this.nome = nome;
        this.saldo = saldo;
        this.data = data;
    }

    public void depositar(double valor) {
        this.saldo += valor;
        System.out.println("Depósito de R$ " + valor + " realizado com sucesso.");
    }

    public void sacar(double valor) {
        if (valor <= this.saldo) {
            this.saldo -= valor;
            System.out.println("Saque de R$ " + valor + " realizado.");
        } else {
            System.out.println("Saldo insuficiente para saque.");
        }
    }

    public void exibirExtrato() {
        System.out.println("--- Extrato ---");
        System.out.println("Conta nº: " + this.numero); // Agora o 'numero' está sendo usado
        System.out.println("Cliente: " + this.nome);
        System.out.println("Saldo atual: R$ " + this.saldo);
        System.out.println("Data de abertura: " + this.data); // Agora a 'data' está sendo usada
    }

    public void transferir(double valor, ContaCorrente destino) {
        if (this.saldo >= valor) {
            this.saldo -= valor;
            destino.depositar(valor);
            System.out.println("Transferência de R$ " + valor + " para " + destino.getNome() + " concluída.");
        } else {
            System.out.println("Transferência cancelada: Saldo insuficiente na conta de origem.");
        }
    }

    public String getNome() {
        return nome;
    }

    public double getSaldo() {
        return saldo;
    }
}