import java.util.ArrayList;

public abstract class Vehicule {
    private int id;
    private String marque;
    private String modele;
    private int annee;
    private double kilometrage;
    private String proprietaire;

    private double valeur;
    private double indice;
    private ArrayList<String> historique;

    public Vehicule(int id, String marque, String modele, int annee, double kilometrage, String proprietaire) {
        this.id = id;
        this.marque = marque;
        this.modele = modele;
        this.annee = annee;
        this.kilometrage = kilometrage;
        this.proprietaire = proprietaire;
        this.valeur = calculerValeur();
        this.indice = calculerIndice();
        this.historique = new ArrayList<>();
        historique.add("Véhicule créé pour " + proprietaire + " avec valeur " + valeur);
    }

    private double calculerValeur() {
        int age = 2025 - annee;
        double prixBase = 20000;
        double depreciation = age * 1200 + kilometrage * 0.02;
        return Math.max(prixBase - depreciation, 0);
    }

    private double calculerIndice() {
        return Math.max(100 - ((2025 - annee) * 5 + kilometrage / 10000), 0);
    }

    public void entretien(double montant) {
        valeur += montant;
        indice = calculerIndice();
        historique.add("Entretien effectué: +" + montant + " valeur");
    }

    public void usure(double montant) {
        valeur -= montant;
        if (valeur < 0) valeur = 0;
        indice = calculerIndice();
        historique.add("Usure subie: -" + montant + " valeur");
    }

    public void transfert(String nouveauProprietaire) {
        historique.add("Transféré de " + proprietaire + " à " + nouveauProprietaire);
        proprietaire = nouveauProprietaire;
    }

    public void afficherInfos() {
        System.out.println("ID: " + id);
        System.out.println("Propriétaire: " + proprietaire);
        System.out.println("Marque: " + marque + ", Modèle: " + modele);
        System.out.println("Année: " + annee + ", Kilométrage: " + kilometrage);
        System.out.println("Valeur actuelle: " + valeur);
        System.out.println("Indice technique: " + indice);
        System.out.println("Historique: " + historique);
        System.out.println("-----------------------------");
    }

    // Getters nécessaires
    public int getId() { return id; }
    public double getValeur() { return valeur; }
    public int getAnnee() { return annee; }
}
