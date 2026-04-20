package ex4.model;

import ex4.exception.VeiculoException;
import ex4.interfaces.Fretavel;
import ex4.interfaces.Tributavel;

public abstract sealed class Veiculo implements Fretavel, Tributavel permits Caminhao, CarroPasseio {

    protected final String placa;
    protected final String marca;
    protected final double valorLocacaoDiaria;
    protected final int anoFabricacao;
    protected final double precoFipe;

    public Veiculo(String placa, String marca, double valorLocacaoDiaria,
            int anoFabricacao, double precoFipe) throws VeiculoException {

        if (placa == null || placa.isEmpty())
            throw new VeiculoException("Placa inválida.");

        if (marca == null || marca.isEmpty())
            throw new VeiculoException("Marca inválida.");

        if (valorLocacaoDiaria <= 0)
            throw new VeiculoException("Valor de locação inválido.");

        if (precoFipe <= 0)
            throw new VeiculoException("Preço FIPE inválido.");

        this.placa = placa;
        this.marca = marca;
        this.valorLocacaoDiaria = valorLocacaoDiaria;
        this.anoFabricacao = anoFabricacao;
        this.precoFipe = precoFipe;
    }

    public int getIdade() {
        return 2026 - anoFabricacao;
    }

    public String getPlaca() {
        return placa;
    }

    public String getMarca() {
        return marca;
    }

    public double getValorLocacaoDiaria() {
        return valorLocacaoDiaria;
    }

    public int getAnoFabricacao() {
        return anoFabricacao;
    }

    public double getPrecoFipe() {
        return precoFipe;
    }
}