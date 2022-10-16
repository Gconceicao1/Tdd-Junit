package br.com.alura.tdd.modelo;

import java.math.BigDecimal;

public enum Performance {
	BASIC(1, "Basic performance recive 3% rise salary", new BigDecimal("0.03")),
	GOOD(2, "Good performance recive 15% rise salary", new BigDecimal("0.15")),
	GREAT(3, "Great performance recive 20% rise salary", new BigDecimal("0.20"));

	private Integer id;
	private String description;
	private BigDecimal readjustmentPercentage;
	
	private Performance(Integer id, String description, BigDecimal readjustmentPercentage ) {
		this.id = id;
		this.description = description;
		this.readjustmentPercentage = readjustmentPercentage;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public BigDecimal getReadjustmentPercentage() {
		return readjustmentPercentage;
	}


	public void setReadjustmentPercentage(BigDecimal readjustmentPercentage) {
		this.readjustmentPercentage = readjustmentPercentage;
	}


	public static Performance toEnum(Integer id) {
		
		if(id == null) {
			return null;
		}
		
		for(Performance performace: Performance.values()){
			if(id.equals(performace.getId())) {
				return performace;
			}
		} 
		throw new  IllegalArgumentException("id inválido: " + id);
	}
}
