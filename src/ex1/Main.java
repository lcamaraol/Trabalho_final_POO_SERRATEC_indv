package ex1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double saldo = 0.0;
        int opcao;
        int saques = 0;
        double saque;
        double deposito;

        do {
            System.out.println("\n===== MENU CAIXA =====");
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
                    System.out.println("Saldo atual: R$ " + saldo);
                    
                    System.out.println("\nPressione ENTER para continuar.");
                    sc.nextLine(); 

                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    break;

                case 2:
                    System.out.print("Digite o valor para depósito: R$ ");
                    deposito = sc.nextDouble();
                    sc.nextLine();
                    
                    if (deposito > 0) {
                        saldo += deposito;
                        System.out.println("Depósito realizado.");
                    } else {
                        System.out.println("Valor inválido.");
                    }
                    
                    System.out.println("\nPressione ENTER para continuar.");
                    sc.nextLine();
                    
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    break;

                case 3:
                    if (saques >= 3) {
                        System.out.println("Limite de saques diários atingido.");
                        
                        System.out.println("\nPressione ENTER para continuar.");
                        sc.nextLine();
                        
                        System.out.print("\033[H\033[2J");
                        System.out.flush();
                        break;
                    }

                    System.out.print("Digite o valor para saque: R$ ");
                    saque = sc.nextDouble();
                    sc.nextLine();

                    if (saque > 1000) {
                        System.out.println("Valor máximo por saque é R$ 1.000,00.");
                    } else if (saque > saldo) {
                        System.out.println("Saldo insuficiente.");
                    } else if (saque <= 0) {
                        System.out.println("Valor inválido.");
                    } else {
                        saldo -= saque;
                        saques++;
                        System.out.println("\nSaque realizado.");
                        System.out.println("Saques restantes: " + (3 - saques));
                    }

                    System.out.println("\nPressione ENTER para continuar.");
                    sc.nextLine();
                    
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    break;

                case 0:
                    System.out.println("\nAtendimento finalizado");
                    break;

                default:
                    System.out.println("\nOpção inválida!");

                    System.out.println("Pressione ENTER para continuar.");
                    sc.nextLine();

                    System.out.print("\033[H\033[2J");
                    System.out.flush();
            }

        } while (opcao != 0);

        sc.close();
    }
}