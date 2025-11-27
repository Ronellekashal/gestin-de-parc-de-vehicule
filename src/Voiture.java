public class Voiture extends Vehicule {
    private int nbPortes;
    private String carburant;

    public Voiture(String matricule, String marque, String modele, int annee, double kilometrage,
                   String proprietaire, int nbPortes, String carburant) {
        super(matricule, marque, modele, annee, kilometrage, proprietaire);
        this.nbPortes = nbPortes;
        this.carburant = carburant;
    }

    @Override
    public void afficherInfos() {
        super.afficherInfos();
        System.out.println("Type: Voiture, Portes: " + nbPortes + ", Carburant: " + carburant);
    }
}
