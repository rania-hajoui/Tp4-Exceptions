package com.entreprise.rh;

import com.entreprise.exceptions.montantInvalideException;

public interface Augmentable {
	
	public double TauxMax = 0.20;
	
	public abstract void augmenter(double TauxMax) throws montantInvalideException ;
	
	public default void augmenterStandard() throws montantInvalideException {
		augmenter(0.05);
	}

}
