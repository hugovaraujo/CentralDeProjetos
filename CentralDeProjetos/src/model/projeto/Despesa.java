package model.projeto;

import java.io.Serializable;

public class Despesa implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private double montanteBolsas = 0;
	private double montanteCusteio = 0;
	private double montanteCapital = 0;
	
	public double getMontanteBolsas() {
		return montanteBolsas;
	}
	
	public double getMontanteCapital() {
		return montanteCapital;
	}
	
	public double getMontanteCusteio() {
		return montanteCusteio;
	}
	
	public void setMontanteBolsas(double montanteBolsas) {
		this.montanteBolsas = montanteBolsas;
	}
	
	public void setMontanteCapital(double montanteCapital) {
		this.montanteCapital = montanteCapital;
	}
	
	public void setMontanteCusteio(double montanteCusteio) {
		this.montanteCusteio = montanteCusteio;
	}
	

}