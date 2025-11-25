public class Voiture extends Vehicule {
    private int nombrePortes;
    private String typeCarburant;

    public Voiture(int id, String marque, String modele, int annee, double kilometrage,
                   String proprietaire, int nombrePortes, String typeCarburant) {
        super(id, marque, modele, annee, kilometrage, proprietaire);
        this.nombrePortes = nombrePortes;
        this.typeCarburant = typeCarburant;
    }

    @Override
    public void afficherInfos() {
        super.afficherInfos();
        System.out.println("Nombre de portes: " + nombrePortes);
        System.out.println("Type de carburant: " + typeCarburant);
        System.out.println("-----------------------------");
    }
}
