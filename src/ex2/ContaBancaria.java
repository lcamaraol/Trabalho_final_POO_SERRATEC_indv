package ex2;

public class ContaBancaria {
    private int numero;
    private String titular;
    private double saldo;
    private int saques;

    public ContaBancaria(int numero, String titular) {
        this.numero = numero;
        this.titular = titular;
        this.saldo = 50.0;
        this.saques = 0;
    }

    public double getSaldo() {
        return saldo;
    }

    public String getTitular() {
        return titular;
    }

    public int getNumero() {
        return numero;
    }

    public int getSaquesRestantes() {
        return 3 - saques;
    }

    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
            System.out.println("Depósito realizado.");
        } else {
            System.out.println("Valor inválido.");
        }
    }

    public void sacar(double valor) {
        if (saques >= 3) {
            System.out.println("Limite de saques diários atingido.");
            return;
        }

        if (valor > 1000) {
            System.out.println("Valor máximo por saque é R$ 1.000,00.");
        } else if (valor > saldo) {
            System.out.println("Saldo insuficiente.");
        } else if (valor <= 0) {
            System.out.println("Valor inválido.");
        } else {
            saldo -= valor;
            saques++;
            System.out.println("\nSaque realizado.");
            System.out.println("Saques restantes: " + getSaquesRestantes());
        }
    }
}