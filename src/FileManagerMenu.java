import java.util.Scanner;

public class FileManagerMenu {

    private static GestionParc gestionParc = new GestionParc();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        gestionParc.charger();

        int choix;
        do {
            afficherMenu();
            choix = sc.nextInt(); sc.nextLine();

            switch (choix) {
                case 1 -> gestionParc.afficher();
                case 2 -> ajouterVehicule();
                case 3 -> supprimerVehicule();
                case 4 -> entretienVehicule();
                case 5 -> usureVehicule();
                case 6 -> transfertVehicule();
                case 0 -> {
                    System.out.println("Fermeture du programme. Sauvegarde finale...");
                    gestionParc.sauvegarder();
                }
                default -> System.out.println("Choix invalide !");
            }
        } while (choix != 0);

        sc.close();
    }

    private static void afficherMenu() {
        System.out.println("\n=== MENU GESTION PARC ===");
        System.out.println("1. Afficher le parc");
        System.out.println("2. Ajouter un véhicule");
        System.out.println("3. Supprimer un véhicule");
        System.out.println("4. Entretien d'un véhicule");
        System.out.println("5. Usure d'un véhicule");
        System.out.println("6. Transfert de propriété");
        System.out.println("0. Quitter");
        System.out.print("Choix : ");
    }

    private static void ajouterVehicule() {
        System.out.print("Type (1:Voiture, 2:Camion, 3:Moto, 4:Velo): ");
        int type = sc.nextInt(); sc.nextLine();

        System.out.print("Matricule: "); String matricule = sc.nextLine();
        System.out.print("Marque: "); String marque = sc.nextLine();
        System.out.print("Modèle: "); String modele = sc.nextLine();
        System.out.print("Année: "); int annee = sc.nextInt(); sc.nextLine();
        System.out.print("Kilométrage: "); double km = sc.nextDouble(); sc.nextLine();
        System.out.print("Propriétaire: "); String proprio = sc.nextLine();

        switch (type) {
            case 1 -> gestionParc.ajouter(new Voiture(matricule, marque, modele, annee, km, proprio, 4, "Essence"));
            case 2 -> gestionParc.ajouter(new Camion(matricule, marque, modele, annee, km, proprio, 5.0, 2));
            case 3 -> gestionParc.ajouter(new Moto(matricule, marque, modele, annee, km, proprio, 150));
            case 4 -> gestionParc.ajouter(new Velo(matricule, marque, modele, annee, km, proprio, false));
            default -> System.out.println("Type invalide !");
        }
        gestionParc.sauvegarder();
    }

    private static void supprimerVehicule() {
        System.out.print("Matricule du véhicule à supprimer: ");
        String matricule = sc.nextLine();
        gestionParc.supprimer(matricule);
        gestionParc.sauvegarder();
    }

    private static void entretienVehicule() {
        System.out.print("Matricule du véhicule pour entretien: ");
        String matricule = sc.nextLine();
        Vehicule v = gestionParc.chercher(matricule);
        if (v != null) {
            System.out.print("Montant entretien: ");
            double montant = sc.nextDouble(); sc.nextLine();
            v.entretien(montant);
            gestionParc.sauvegarder();
        } else System.out.println("Véhicule introuvable !");
    }

    private static void usureVehicule() {
        System.out.print("Matricule du véhicule pour usure: ");
        String matricule = sc.nextLine();
        Vehicule v = gestionParc.chercher(matricule);
        if (v != null) {
            System.out.print("Montant usure: ");
            double montant = sc.nextDouble(); sc.nextLine();
            v.usure(montant);
            gestionParc.sauvegarder();
        } else System.out.println("Véhicule introuvable !");
    }

    private static void transfertVehicule() {
        System.out.print("Matricule du véhicule pour transfert: ");
        String matricule = sc.nextLine();
        Vehicule v = gestionParc.chercher(matricule);
        if (v != null) {
            System.out.print("Nouveau propriétaire: ");
            String nouveauProprio = sc.nextLine();
            v.transfert(nouveauProprio);
            gestionParc.sauvegarder();
        } else System.out.println("Véhicule introuvable !");
    }
}
