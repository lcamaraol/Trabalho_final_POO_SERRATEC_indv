package ex4.app;

import java.util.Scanner;

import ex4.exception.VeiculoException;
import ex4.model.Caminhao;
import ex4.model.CarroPasseio;

public class Main {

    public static void limparTela() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {

            Caminhao[] caminhoes = {
                    new Caminhao("AAA-1111", "Volvo FH", 500, 2000, 200000, 5),
                    new Caminhao("BBB-2222", "Scania R450", 700, 2015, 300000, 10),
                    new Caminhao("CCC-3333", "Mercedes Actros", 900, 2022, 400000, 15),
                    new Caminhao("DDD-4444", "Iveco Hi-Way", 650, 2010, 250000, 8),
                    new Caminhao("EEE-5555", "DAF XF", 800, 2018, 350000, 12),
                    new Caminhao("FFF-6666", "Volkswagen Constellation", 550, 2003, 180000, 6)
            };

            CarroPasseio[] carros = {
                    new CarroPasseio("XXX-1111", "Toyota Corolla", 150, 2000, 80000),
                    new CarroPasseio("YYY-2222", "Honda Civic", 180, 2018, 90000),
                    new CarroPasseio("ZZZ-3333", "Hyundai HB20", 200, 2022, 100000),
                    new CarroPasseio("GGG-4444", "Chevrolet Onix", 130, 2010, 60000),
                    new CarroPasseio("HHH-5555", "Volkswagen Golf", 220, 2016, 110000),
                    new CarroPasseio("III-6666", "Fiat Argo", 140, 2021, 70000)
            };

            int opcao;

            do {
                System.out.println("===== MENU VEÍCULOS =====");
                System.out.println("1 - Alugar Caminhão");
                System.out.println("2 - Alugar Carro");
                System.out.println("3 - Ver IPVA Caminhão");
                System.out.println("4 - Ver IPVA Carro");
                System.out.println("0 - Sair");
                System.out.print("Escolha: ");

                opcao = sc.nextInt();
                sc.nextLine();

                limparTela();

                switch (opcao) {

                    case 1:

                        int escolhaC;

                        do {
                            System.out.println("===== ESCOLHA O CAMINHÃO =====");

                            for (int i = 0; i < caminhoes.length; i++) {
                                System.out.println((i + 1) + " - " + caminhoes[i].getMarca() +" | Capacidade: " + caminhoes[i].getCapacidadeCargaToneladas() + " ton | Diária: R$ " + caminhoes[i].getValorLocacaoDiaria());
                            }
                            System.out.println("0 - Voltar");
                            System.out.print("Escolha: ");
                            escolhaC = sc.nextInt();
                            sc.nextLine();

                            if (escolhaC == 0) {
                                limparTela();
                                break;
                            }

                            if (escolhaC < 1 || escolhaC > caminhoes.length) {
                                System.out.println("Opção inválida.");
                                continue;
                            }

                            Caminhao c = caminhoes[escolhaC - 1];

                            limparTela();

                            System.out.println("===== DADOS DO CAMINHÃO =====");
                            System.out.println("Marca: " + c.getMarca());
                            System.out.println("Placa: " + c.getPlaca());
                            System.out.println("Capacidade: " + c.getCapacidadeCargaToneladas());
                            System.out.println("Diária: R$ " + c.getValorLocacaoDiaria());

                            System.out.print("Dias: ");
                            int dias = sc.nextInt();
                            sc.nextLine();

                            System.out.print("Peso: ");
                            double peso = sc.nextDouble();
                            sc.nextLine();

                            double base = c.getValorLocacaoDiaria() * dias;
                            double total = c.alugarVeiculo(peso, dias);

                            limparTela();

                            System.out.println("===== RESUMO =====");
                            System.out.println("Veículo: " + c.getMarca());
                            System.out.println("Valor base: R$ " + base);

                            if (total > base)
                                System.out.println("Taxa (10%): R$ " + (total - base));
                            else
                                System.out.println("Sem taxa.");

                            System.out.println("TOTAL: R$ " + total);

                            break;

                        } while (true);

                        break;

                    case 2:

                        int escolhaCar;

                        do {
                            System.out.println("===== ESCOLHA O CARRO =====");

                            for (int i = 0; i < carros.length; i++) {
                                System.out.println((i + 1) + " - " + carros[i].getMarca() +
                                        " | Diária: R$ " + carros[i].getValorLocacaoDiaria());
                            }
                            System.out.println("0 - Voltar");
                            System.out.print("Escolha: ");
                            escolhaCar = sc.nextInt();
                            sc.nextLine();

                            if (escolhaCar == 0) {
                                limparTela();
                                break;
                            }

                            if (escolhaCar < 1 || escolhaCar > carros.length) {
                                System.out.println("Opção inválida.");
                                continue;
                            }

                            CarroPasseio car = carros[escolhaCar - 1];

                            limparTela();

                            System.out.println("===== DADOS DO CARRO =====");
                            System.out.println("Marca: " + car.getMarca());
                            System.out.println("Placa: " + car.getPlaca());
                            System.out.println("Diária: R$ " + car.getValorLocacaoDiaria());

                            System.out.print("Dias: ");
                            int diasCar = sc.nextInt();
                            sc.nextLine();

                            double totalCar = car.alugarVeiculo(0, diasCar);

                            limparTela();

                            System.out.println("===== RESUMO =====");
                            System.out.println("Veículo: " + car.getMarca());
                            System.out.println("TOTAL: R$ " + totalCar);

                            break;

                        } while (true);

                        break;

                    case 3:
                        System.out.println("===== IPVA CAMINHÕES =====");
                        for (Caminhao cam : caminhoes) {
                            System.out.println(cam.getMarca() + " | Ano: " + cam.getAnoFabricacao() + " | IPVA: R$ " + cam.calcularIpva());
                        }
                        break;

                    case 4:
                        System.out.println("===== IPVA CARROS =====");
                        for (CarroPasseio cp : carros) {
                            System.out.println(cp.getMarca()  + " | Ano: " + cp.getAnoFabricacao() + " | IPVA: R$ " + cp.calcularIpva());
                        }
                        break;
                }

                if (opcao != 0) {
                    System.out.println("\nPressione ENTER para continuar.");
                    sc.nextLine();
                    limparTela();
                }

            } while (opcao != 0);

        } catch (VeiculoException e) {
            System.out.println("Erro: " + e.getMessage());
        }

        sc.close();
    }
}