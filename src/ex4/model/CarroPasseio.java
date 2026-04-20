package ex4.model;

import ex4.exception.VeiculoException;

public final class CarroPasseio extends Veiculo {

    public CarroPasseio(String placa, String marca, double valorLocacaoDiaria,
                        int anoFabricacao, double precoFipe) throws VeiculoException {
        super(placa, marca, valorLocacaoDiaria, anoFabricacao, precoFipe);
    }

    @Override
    public double alugarVeiculo(double pesoCarga, int dias) throws VeiculoException {

        if (dias <= 0)
            throw new VeiculoException("Dias inválidos.");

        return valorLocacaoDiaria * dias;
    }

    @Override
    public double calcularIpva() {

        if (getIdade() > 20)
            return 0.0;

        return precoFipe * 0.04;
    }
}