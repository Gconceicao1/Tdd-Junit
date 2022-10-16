package br.com.alura.tdd.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.alura.tdd.modelo.Funcionario;
import br.com.alura.tdd.modelo.Performance;

public class ReajusteServiceTest {
	
	private Funcionario funcionario;
	private ReajustmentService reajustmentService;
	
	@BeforeEach
	public void init() {
		this.funcionario = new Funcionario("Funcionario",LocalDate.now(),new BigDecimal("1000.00"));
		this.reajustmentService = new ReajustmentService();
	}

	@Test
	public void toBeBasicReajustment() {
		reajustmentService.applyReajustment(funcionario,Performance.BASIC );
		assertEquals(new BigDecimal("1030.00"),	funcionario.getSalario());
	}
	
	@Test
	public void toBeGoodReajustment() {
		reajustmentService.applyReajustment(funcionario,Performance.GOOD );
		assertEquals(new BigDecimal("1150.00"),funcionario.getSalario());
	}
	
	@Test
	public void toBeGreatReajustment() {
		reajustmentService.applyReajustment(funcionario,Performance.GREAT );
		assertEquals(new BigDecimal("1200.00"),funcionario.getSalario());
	}
	
}
