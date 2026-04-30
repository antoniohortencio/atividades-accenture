public class PrincipalContaCorrente {
    public static void main(String[] args) {
        ContaCorrente conta1 = new ContaCorrente(101, "João Silva", 500.0, "30/04/2026");
        
        System.out.println("Cliente da Conta 1: " + conta1.getNome());

        System.out.println("Saldo inicial Conta 1: R$ " + conta1.getSaldo());
        conta1.depositar(200.0);
        System.out.println("Saldo após depósito: R$ " + conta1.getSaldo());

        ContaCorrente conta2 = new ContaCorrente(102, "Maria Oliveira", 1000.0, "30/04/2026");

        System.out.println("\n--- Iniciando Transações ---");

        conta1.sacar(100.0);
        conta1.exibirExtrato();

        System.out.println("\nTransferindo da Conta 2 para Conta 1...");
        conta2.transferir(300.0, conta1);
        
        System.out.println("Saldo final Conta 1: R$ " + conta1.getSaldo());
        System.out.println("Saldo final Conta 2: R$ " + conta2.getSaldo());

        System.out.println("\nTentando transferir valor acima do saldo (Conta 1)...");
        conta1.transferir(2000.0, conta2); 
    }
}