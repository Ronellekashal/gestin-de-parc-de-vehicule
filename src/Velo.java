public class Velo extends Vehicule {
    private boolean electrique;

    public Velo(String matricule, String marque, String modele, int annee, double kilometrage,
                String proprietaire, boolean electrique) {
        super(matricule, marque, modele, annee, kilometrage, proprietaire);
        this.electrique = electrique;
    }

    @Override
    public void afficherInfos() {
        super.afficherInfos();
        System.out.println("Type: Vélo, Électrique: " + (electrique ? "Oui" : "Non"));
    }
}
