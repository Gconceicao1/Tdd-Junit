package br.com.alura.tdd.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.alura.tdd.modelo.Funcionario;

class BonusServiceTest {
	
	private BonusService bonusService;
	private Funcionario funcionario;
	
	@BeforeEach
	public void init() {
		this.funcionario = new Funcionario("gabriel",LocalDate.now(), null);
		bonusService = new BonusService();
	}

	@Test
	void zeroBonusWithHighSalary() {
		funcionario.setSalario(new BigDecimal(130000));
		assertThrows(IllegalArgumentException.class ,() -> bonusService.calcularBonus(funcionario));
	}
	
	@Test
	void bonusSalaryTenPercent() {
		funcionario.setSalario(new BigDecimal(5000.00));
		BigDecimal ValueBonus = bonusService.calcularBonus(funcionario);
		
		assertEquals( new BigDecimal("500.00"), ValueBonus);
	}
	
	@Test
	void bonusSalaryThousand() {
		funcionario.setSalario(new BigDecimal(10000));
		BigDecimal ValueBonus = bonusService.calcularBonus(funcionario);
		
		assertEquals( new BigDecimal("1000.00"), ValueBonus);
	}
}
