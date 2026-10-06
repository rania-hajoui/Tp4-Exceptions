package com.entreprise.app;

import com.entreprise.compta.Facture;
import com.entreprise.compta.Payable;
import com.entreprise.exceptions.equipeCompleteException;
import com.entreprise.exceptions.montantInvalideException;
import com.entreprise.rh.Augmentable;
import com.entreprise.rh.ChefProjet;
import com.entreprise.rh.Commercial;
import com.entreprise.rh.Employe;
import com.entreprise.rh.Permanent;

public class Program {

    public static void main(String[] args) {

        Service service = new Service(4);
        try {

            Commercial karim =
                    new Commercial("Karim", 3000, 40000, "Rabat");

            ChefProjet salma =
                    new ChefProjet("Salma", 6000, "Casablanca");

            service.ajouter(karim);
            service.ajouter(salma);

        } catch (montantInvalideException e) {

            System.out.println("Erreur : " + e.getMessage());
        }

        String[] noms = {
            "Nadia",
            "Omar",
            "Yassine",
            "Leila",
            "Hamza"
        };

        String[] salaires = {
            "4500",
            "abc",
            "-800",
            "3800",
            "5200"
        };

        int tentatives = 0;
        for (int i = 0; i < noms.length; i++) {

            try {
                tentatives++;
                
                double salaire =
                        Double.parseDouble(salaires[i]);

                Permanent p =
                        new Permanent(noms[i], salaire);

                service.ajouter(p);

                System.out.println("Embauche de " + noms[i]+ " : " + salaire);

            } catch (NumberFormatException e) {

                System.out.println("Saisie ignorée : \""+ salaires[i]+ "\" n'est pas un montant");

            } catch (montantInvalideException e) {

                System.out.println("Erreur : " + e.getMessage());

            } catch (equipeCompleteException e) {

                System.out.println("Erreur : " + e.getMessage());

            } finally {
            	
            }
        }

        System.out.println("Tentatives : " + tentatives+ ", employés dans le service : "+ service.getNb());

        service.trier();
        service.afficher();

        System.out.println("Masse salariale : "+ service.getMasseSalariale());

        Employe moinsPaye = service.getEmploye(0);

        try {
            Augmentable a = (Augmentable) moinsPaye;

            a.augmenterStandard();

            System.out.println("Après augmentation : "+ moinsPaye);a.augmenter(0.5);

            System.out.println("Cette ligne ne s'affiche jamais");

        } catch (montantInvalideException e) {

            System.out.println("Erreur : " + e.getMessage()+ " [valeur reçue : "+ e.getValeur() + "]");
        }

        try {

            service.getEmploye(7);

        } catch (IllegalArgumentException e) {

            System.out.println("Erreur : " + e.getMessage());
        }

        Payable[] paiements = {
            new Facture("102", "Bureau Plus", 450),
            service.getEmploye(1)
        };

        double total = 0;

        for (Payable p : paiements) {

            System.out.println("À payer : " + p);

            total += p.getMontantApayer();
        }

        System.out.println("Total à payer : " + total);

        System.out.println("Nombre d'employés créés : "+ Employe.getNbEmployes());
    }
}
