package com.entreprise.exceptions;

public class equipeCompleteException extends RuntimeException{
	
	public equipeCompleteException(int capacite) {
		super("équipe complète (capacité :" + capacite +")");
	}
}
