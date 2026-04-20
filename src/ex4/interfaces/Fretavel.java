package ex4.interfaces;

import ex4.exception.VeiculoException;

public interface Fretavel {
    double alugarVeiculo(double pesoCarga, int dias) throws VeiculoException;
}
