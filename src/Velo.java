public class Velo extends Vehicule {
    private boolean estElectrique;

    public Velo(int id, String marque, String modele, int annee, double kilometrage,
                String proprietaire, boolean estElectrique) {
        super(id, marque, modele, annee, kilometrage, proprietaire);
        this.estElectrique = estElectrique;
    }

    @Override
    public void afficherInfos() {
        super.afficherInfos();
        System.out.println("Électrique: " + (estElectrique ? "Oui" : "Non"));
        System.out.println("-----------------------------");
    }
}
