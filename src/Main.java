public class 1Main {
    public static void main(String[] args) {
        GestionParc parc = new GestionParc();

        parc.ajouterVehicule(new Voiture(1, "Toyota", "Corolla", 2020, 45000, "Alice", 4, "Essence"));
        parc.ajouterVehicule(new Camion(2, "Volvo", "FH", 2018, 120000, "EntrepriseX", 20, 4));
        parc.ajouterVehicule(new Moto(3, "Yamaha", "R6", 2019, 22000, "Bob", 600));
        parc.ajouterVehicule(new Velo(4, "Giant", "Escape 3", 2022, 200, "Charlie", true));

        parc.menu();
    }
}
