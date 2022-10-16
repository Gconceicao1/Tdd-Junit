package br.com.alura.tdd.service;

import java.math.BigDecimal;
import java.math.RoundingMode;

import br.com.alura.tdd.modelo.Funcionario;
import br.com.alura.tdd.modelo.Performance;

public class ReajustmentService {

	public void applyReajustment(Funcionario funcionario,Performance performance) {
		BigDecimal reajustment ;
		reajustment = funcionario.getSalario().multiply(performance.getReadjustmentPercentage());
		
		funcionario.setSalario(funcionario.getSalario().add(reajustment).setScale(2,RoundingMode.HALF_UP));
	}
}
