public class Moto extends Vehicule {
    private int cylindree;

    public Moto(String matricule, String marque, String modele, int annee, double kilometrage,
                String proprietaire, int cylindree) {
        super(matricule, marque, modele, annee, kilometrage, proprietaire);
        this.cylindree = cylindree;
    }

    @Override
    public void afficherInfos() {
        super.afficherInfos();
        System.out.println("Type: Moto, Cylindrée: " + cylindree + " cc");
    }
}
