public class Camion extends Vehicule {
    private double capacite;
    private int nbEssieux;

    public Camion(String matricule, String marque, String modele, int annee, double kilometrage,
                  String proprietaire, double capacite, int nbEssieux) {
        super(matricule, marque, modele, annee, kilometrage, proprietaire);
        this.capacite = capacite;
        this.nbEssieux = nbEssieux;
    }

    @Override
    public void afficherInfos() {
        super.afficherInfos();
        System.out.println("Type: Camion, Capacité: " + capacite + "T, Essieux: " + nbEssieux);
    }
}
