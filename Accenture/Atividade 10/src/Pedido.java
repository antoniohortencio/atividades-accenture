import java.util.*;

enum StatusPedido { PENDING, RESERVED, PAID, FAILED, CANCELED }

public class Pedido {
    String id;
    String clienteId;
    Map<String, Integer> itens; 
    StatusPedido status;
    double valorTotal;

    public Pedido(String clienteId) {
        this.id = UUID.randomUUID().toString().substring(0, 5);
        this.clienteId = clienteId;
        this.itens = new HashMap<>();
        this.status = StatusPedido.PENDING;
    }
}