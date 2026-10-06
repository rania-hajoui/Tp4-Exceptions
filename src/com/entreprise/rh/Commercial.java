package com.entreprise.rh;

import com.entreprise.exceptions.montantInvalideException;

public class Commercial extends Employe implements Augmentable { 
	
	private double fixe;     
	private double chiffreAffaires;      
	
	public Commercial(String nom, double fixe, double chiffreAffaires, String agence) throws montantInvalideException{
		super(nom, agence);         
		if (fixe <= 0) {
            throw new montantInvalideException("fixe", fixe);
        }
        if (chiffreAffaires < 0) {
            throw new montantInvalideException(
                    "chiffreAffaires", chiffreAffaires);
        }
        this.fixe = fixe;
        this.chiffreAffaires = chiffreAffaires;    
		}     
	
	@Override    
	public String getPoste() {
		return "Commercial"; }      
	
	@Override     
	public double getSalaire() { 
		return fixe + chiffreAffaires * 5 / 100; } 
	// fixe + 5 % du CA   
	
	@Override    
	public String toString() {  
		return getPoste() + "[" + super.toString() + ", fixe=" + fixe + ", chiffreAffaires=" + chiffreAffaires + "]"; }

	@Override
	public void augmenter(double taux)
            throws montantInvalideException {

        if (taux <= 0 || taux > TauxMax) {
            throw new montantInvalideException("taux", taux);
        }

        fixe = fixe * (1 + taux);
    }
} 
	

