package com.entreprise.rh;

import com.entreprise.exceptions.montantInvalideException;

public class Permanent extends Employe implements Augmentable{
  
	 private double salaireMensuel;
	 
	 public Permanent(String nom, double salaire) throws montantInvalideException {
		 super(nom);         
		 if (salaire <= 0) throw new montantInvalideException("salaire", salaire);        
		 this.salaireMensuel = salaire;    
		 }      
	 
	 public Permanent(String nom, double salaire, String agence)throws montantInvalideException { 
		 super(nom,agence);   
		 if (salaire <= 0) throw new montantInvalideException("salaire", salaire);          
		 this.salaireMensuel = salaire;     }    
	 	   
	 public String getPoste() {
		 return "Permanent"; }     
	 
	 public double getSalaire() {
		 return salaireMensuel; }      
	     
	 public String toString() {  
	 return getPoste() + "[" + super.toString() + ", salaire=" + getSalaire() + "]";    
	 }

	 @Override
	 public void augmenter(double taux) throws montantInvalideException {
		 if (taux <= 0 || taux > TauxMax) {
	            throw new montantInvalideException("taux", taux);
	        }

	        salaireMensuel = salaireMensuel * (1 + taux);
	    }
 }

