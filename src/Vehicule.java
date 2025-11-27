public abstract class Vehicule {
    private String matricule;
    private String marque;
    private String modele;
    private int annee;
    private double kilometrage;
    private String proprietaire;

    public Vehicule(String matricule, String marque, String modele, int annee, double kilometrage, String proprietaire) {
        this.matricule = matricule;
        this.marque = marque;
        this.modele = modele;
        this.annee = annee;
        this.kilometrage = kilometrage;
        this.proprietaire = proprietaire;
    }

    // Méthodes
    public void entretien(double montant) {
        System.out.println("Entretien de " + montant + " pour le véhicule " + matricule);
    }

    public void usure(double montant) {
        System.out.println("Usure de " + montant + " pour le véhicule " + matricule);
    }

    public void transfert(String nouveauProprio) {
        this.proprietaire = nouveauProprio;
        System.out.println("Véhicule " + matricule + " transféré à " + nouveauProprio);
    }

    public void afficherInfos() {
        System.out.println("Matricule: " + matricule + ", Marque: " + marque + ", Modèle: " + modele +
                ", Année: " + annee + ", Km: " + kilometrage + ", Propriétaire: " + proprietaire);
    }

    // Getters
    public String getMatricule() { return matricule; }
    public String getMarque() { return marque; }
    public String getModele() { return modele; }
    public int getAnnee() { return annee; }
    public double getKilometrage() { return kilometrage; }
    public String getProprietaire() { return proprietaire; }
}
