package ex3;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String nome;
        String email;
        String cpf;
        String endereco;
        String metodoPagamento;

        System.out.println("==== CADASTRO ====");
        System.out.print("Nome: ");
        nome = sc.nextLine();

        System.out.print("Email: ");
        email = sc.nextLine();

        System.out.print("CPF: ");
        cpf = sc.nextLine();

        System.out.print("Endereço: ");
        endereco = sc.nextLine();

        System.out.print("\033[H\033[2J");
        System.out.flush();

        Cliente cliente = new Cliente(nome, email, cpf, endereco);
        Pedido pedido = new Pedido(cliente);

        List<Produto> produtos = new ArrayList<>();

        produtos.add(new Produto(1, "Mouse", 80));
        produtos.add(new Produto(2, "Teclado Mecânico", 200));
        produtos.add(new Produto(3, "Headset", 100));
        produtos.add(new Produto(4, "Monitor", 900));
        produtos.add(new Produto(5, "Mousepad", 25));
        produtos.add(new Produto(6, "Webcam", 120));
        produtos.add(new Produto(7, "Microfone", 120));
        produtos.add(new Produto(8, "Controle Gamer", 200));

        int menu = 1;

        while (menu == 1) {

            System.out.println("\n==== PRODUTOS ====");
            for (Produto prod : produtos) {
                System.out.println(
                    prod.getId() + " - " + prod.getNome() + " | R$" + prod.getPreco()
                );
            }

            System.out.print("\nDigite o ID do produto: ");
            int id = sc.nextInt();
            sc.nextLine();

            Produto selecionado = null;
            for (Produto prod : produtos) {
                if (prod.getId() == id) {
                    selecionado = prod;
                    break;
                }
            }

            if (selecionado != null) {
                System.out.print("Quantidade: ");
                int qtd = Integer.parseInt(sc.nextLine());

                pedido.addItem(new ItemPedido(selecionado, qtd));
                System.out.println("Produto adicionado!");
            } else {
                System.out.println("Produto não encontrado!");
            }

            System.out.println("\nDeseja adicionar outro item?");
            System.out.println("1 - Sim");
            System.out.println("2 - Não");
            System.out.print("Escolha: ");
            menu = sc.nextInt();
            sc.nextLine();
            System.out.print("\033[H\033[2J");
            System.out.flush();
        }

        System.out.println("\nMétodo de pagamento:");
        System.out.println("1 - Pix");
        System.out.println("2 - Dinheiro");
        System.out.println("3 - Cartão");

        int pagamento = sc.nextInt();
        sc.nextLine();
        System.out.print("\033[H\033[2J");
        System.out.flush();

        switch (pagamento) {
            case 1:
                metodoPagamento = "Pix";
                break;
            case 2:
                metodoPagamento = "Dinheiro";
                break;
            case 3:
                metodoPagamento = "Cartão";
                break;
            default:
                metodoPagamento = "Método Desconhecido";
        }

        pedido.fecharPedido(metodoPagamento);

        sc.close();
    }
}