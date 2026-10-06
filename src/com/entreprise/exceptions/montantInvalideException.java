package com.entreprise.exceptions;

public class montantInvalideException extends Exception {
	
	private double valeur;
	
	public montantInvalideException(String champ,double valeur) {
		super("salaire Invalide" + valeur);
		this.valeur=valeur;
	}
	
	public double getValeur() {
		return valeur ;
	}

}
