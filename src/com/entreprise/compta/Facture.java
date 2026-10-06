package com.entreprise.compta;

public class Facture implements Payable{
	
	private String numero;
	private String fournisseure;
	private double montant;
	
	public Facture(String numero,String fournisseure,double montant) {
		this.numero=numero;
		this.fournisseure=fournisseure;
		this.montant=montant;
	}
	
	@Override
	public double getMontantApayer() {
		return montant;
	}
	
	public String toString() {
		return "Facture F-" + numero +"(" + fournisseure + ") :" + montant ;
	}
}
