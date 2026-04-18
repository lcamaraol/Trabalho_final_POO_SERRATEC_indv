package ex2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite o número da conta: ");
        int numero = sc.nextInt();
        sc.nextLine();

        System.out.print("Digite o nome do titular: ");
        String titular = sc.nextLine();

        ContaBancaria conta = new ContaBancaria(numero, titular);

        int opcao;
        double valor;

        do {
            System.out.println("\n===== MENU CAIXA =====");
            System.out.println("Titular: " + conta.getTitular());
            System.out.println("1 - Ver Saldo");
            System.out.println("2 - Depositar");
            System.out.println("3 - Sacar");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            opcao = sc.nextInt();
            sc.nextLine();

            System.out.print("\033[H\033[2J");
            System.out.flush();

            switch (opcao) {
                case 1:
                    System.out.println("Saldo atual: R$ " + conta.getSaldo());

                    System.out.println("\nPressione ENTER para continuar.");
                    sc.nextLine();
                    break;

                case 2:
                    System.out.print("Digite o valor para depósito: R$ ");
                    valor = sc.nextDouble();
                    sc.nextLine();

                    conta.depositar(valor);

                    System.out.println("\nPressione ENTER para continuar.");
                    sc.nextLine();
                    break;

                case 3:
                    System.out.print("Digite o valor para saque: R$ ");
                    valor = sc.nextDouble();
                    sc.nextLine();

                    conta.sacar(valor);

                    System.out.println("\nPressione ENTER para continuar.");
                    sc.nextLine();
                    break;

                case 0:
                    System.out.println("\nAtendimento finalizado");
                    break;

                default:
                    System.out.println("\nOpção inválida!");

                    System.out.println("Pressione ENTER para continuar.");
                    sc.nextLine();
            }

            System.out.print("\033[H\033[2J");
            System.out.flush();

        } while (opcao != 0);

        sc.close();
    }
}