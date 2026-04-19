package ex3;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private Cliente cliente;
    private List<ItemPedido> itens;
    private String metodoPagamento;

    public Pedido(Cliente cliente) {
        this.cliente = cliente;
        this.itens = new ArrayList<>();
    }

    public void addItem(ItemPedido item) {
        itens.add(item);
    }

    public double calcularTotal() {
        double total = 0;
        for (ItemPedido item : itens) {
            total += item.getSubtotal();
        }
        return total;
    }

    public void fecharPedido(String metodoPagamento) {
        this.metodoPagamento = metodoPagamento;

        double total = calcularTotal();
        double frete = (total > 250) ? 0 : 25;
        double totalFinal = total + frete;

        System.out.println("\n================== RECIBO ==================");
        System.out.println("Cliente: " + cliente.getNome());
        System.out.println("CPF: " + cliente.getCpf());
        System.out.println("Endereço: " + cliente.getEndereco());

        System.out.println("\nItens:");
        for (ItemPedido item : itens) {
            System.out.println(
                item.getProduto().getNome() + 
                " | Qtd: " + item.getQuantidade() + 
                " | Unit: R$" + item.getProduto().getPreco() +
                " | Subtotal: R$" + item.getSubtotal()
            );
        }

        System.out.println("\nTotal: R$" + total);
        System.out.println("Frete: R$" + frete);
        System.out.println("Total Final: R$" + totalFinal);
        System.out.println("Pagamento: " + metodoPagamento);
        System.out.println("============================================\n");
    }
}