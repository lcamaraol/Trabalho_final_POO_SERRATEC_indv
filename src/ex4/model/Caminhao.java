package ex4.model;

import ex4.exception.VeiculoException;

public final class Caminhao extends Veiculo {

    private final double capacidadeCargaToneladas;

    public Caminhao(
        String placa, 
        String marca, 
        double valorLocacaoDiaria,
        int anoFabricacao, 
        double precoFipe,
        double capacidadeCargaToneladas) throws VeiculoException {

        super(placa, marca, valorLocacaoDiaria, anoFabricacao, precoFipe);

        if (capacidadeCargaToneladas <= 0)
            throw new VeiculoException("Capacidade inválida.");

        this.capacidadeCargaToneladas = capacidadeCargaToneladas;
    }

    @Override
    public double alugarVeiculo(double pesoCarga, int dias) throws VeiculoException {

        if (dias <= 0)
            throw new VeiculoException("Dias inválidos.");

        if (pesoCarga < 0)
            throw new VeiculoException("Peso inválido.");

        double total = valorLocacaoDiaria * dias;

        if (pesoCarga > capacidadeCargaToneladas) {
            total += total * 0.10; 
        }

        return total;
    }

    @Override
    public double calcularIpva() {

        if (getIdade() > 20)
            return 0.0;

        return precoFipe * 0.015; 
    }

    public double getCapacidadeCargaToneladas() {
        return capacidadeCargaToneladas;
    }
}