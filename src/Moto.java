public class Moto extends Vehicule {
    private int cylindree;

    public Moto(int id, String marque, String modele, int annee, double kilometrage,
                String proprietaire, int cylindree) {
        super(id, marque, modele, annee, kilometrage, proprietaire);
        this.cylindree = cylindree;
    }

    @Override
    public void afficherInfos() {
        super.afficherInfos();
        System.out.println("Cylindrée: " + cylindree + " cc");
        System.out.println("-----------------------------");
    }
}
