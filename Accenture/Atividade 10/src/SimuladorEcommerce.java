import java.util.*;

public class SimuladorEcommerce {
    private Map<String, Produto> produtos = new HashMap<>();
    private List<Pedido> pedidos = new ArrayList<>();

    public void adicionarProduto(Produto p) {
        produtos.put(p.sku, p);
    }

    public void listarProdutos() {
        produtos.values().stream()
            .sorted(Comparator.comparing(p -> p.sku))
            .forEach(p -> System.out.println("SKU: " + p.sku + " | " + p.nome + " | R$" + p.preco + " | Est: " + p.estoque));
    }

    public void gerarRelatorios() {
        System.out.println("\n--- RELATÓRIOS ---");
        double faturamento = pedidos.stream()
                .filter(p -> p.status == StatusPedido.PAID)
                .mapToDouble(p -> p.valorTotal)
                .sum();
        System.out.println("Faturamento Total: R$ " + faturamento);
    }

    public static void main(String[] args) {
        SimuladorEcommerce sistema = new SimuladorEcommerce();
        Scanner sc = new Scanner(System.in);
        int opcao = 0;

        while (opcao != 9) {
            System.out.println("\n1. Adicionar Produto\n2. Listar Produtos\n3. Relatórios\n9. Sair");
            System.out.print("Escolha: ");
            opcao = sc.nextInt();
            sc.nextLine();

            if (opcao == 1) {
                System.out.print("SKU: "); String sku = sc.nextLine();
                System.out.print("Nome: "); String nome = sc.nextLine();
                System.out.print("Categoria: "); String cat = sc.nextLine();
                System.out.print("Preço: "); double pr = sc.nextDouble();
                System.out.print("Estoque: "); int est = sc.nextInt();
                sistema.adicionarProduto(new Produto(sku, nome, cat, pr, est));
            } else if (opcao == 2) {
                sistema.listarProdutos();
            } else if (opcao == 3) {
                sistema.gerarRelatorios();
            }
        }
        sc.close();
    }
}