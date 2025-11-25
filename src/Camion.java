public class Camion extends Vehicule {
    private double capaciteChargement;
    private int nombreEssieux;

    public Camion(int id, String marque, String modele, int annee, double kilometrage,
                  String proprietaire, double capaciteChargement, int nombreEssieux) {
        super(id, marque, modele, annee, kilometrage, proprietaire);
        this.capaciteChargement = capaciteChargement;
        this.nombreEssieux = nombreEssieux;
    }

    @Override
    public void afficherInfos() {
        super.afficherInfos();
        System.out.println("Capacité de chargement: " + capaciteChargement + " tonnes");
        System.out.println("Nombre d’essieux: " + nombreEssieux);
        System.out.println("-----------------------------");
    }
}
