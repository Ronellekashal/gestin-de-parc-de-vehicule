import java.util.ArrayList;
import java.util.Scanner;

public class GestionParc {
    private ArrayList<Vehicule> parc;

    public GestionParc() {
        parc = new ArrayList<>();
    }

    // Ajouter un véhicule
    public void ajouterVehicule(Vehicule v) {
        parc.add(v);
        System.out.println("[INFO] Véhicule ajouté !");
    }

    // Supprimer un véhicule
    public void supprimerVehicule(int id) {
        Vehicule v = trouverVehicule(id);
        if (v != null) {
            parc.remove(v);
            System.out.println("[INFO] Véhicule supprimé !");
        } else {
            System.out.println("[ERREUR] Véhicule introuvable.");
        }
    }

    // Afficher tous les véhicules
    public void afficherParc() {
        if (parc.isEmpty()) {
            System.out.println("[INFO] Aucun véhicule dans le parc.");
            return;
        }
        System.out.println("\n--- Liste des véhicules ---");
        for (Vehicule v : parc) {
            v.afficherInfos();
        }
    }

    // Trouver un véhicule par ID
    public Vehicule trouverVehicule(int id) {
        for (Vehicule v : parc) {
            if (v.getId() == id) return v;
        }
        return null;
    }

    // Afficher statistiques globales
    public void afficherStatistiques() {
        if (parc.isEmpty()) {
            System.out.println("[INFO] Parc vide.");
            return;
        }

        double valeurTotale = 0;
        Vehicule plusCher = parc.get(0);
        Vehicule plusVieux = parc.get(0);

        for (Vehicule v : parc) {
            valeurTotale += v.getValeur();
            if (v.getValeur() > plusCher.getValeur()) plusCher = v;
            if (v.getAnnee() < plusVieux.getAnnee()) plusVieux = v;
        }

        System.out.println("\n--- Statistiques du parc ---");
        System.out.println("Valeur totale: " + valeurTotale + " $");
        System.out.println("Véhicule le plus cher:");
        plusCher.afficherInfos();
        System.out.println("Véhicule le plus ancien:");
        plusVieux.afficherInfos();
    }

    // Menu principal interactif
    public void menu() {
        Scanner sc = new Scanner(System.in);
        int choix;

        do {
            System.out.println("\n=== MENU GESTION PARC VEHICULES ===");
            System.out.println("1. Afficher tous les véhicules");
            System.out.println("2. Entretien / Réparation");
            System.out.println("3. Usure / Dépréciation");
            System.out.println("4. Transfert de véhicule");
            System.out.println("5. Ajouter un véhicule");
            System.out.println("6. Supprimer un véhicule");
            System.out.println("7. Statistiques du parc");
            System.out.println("0. Quitter");
            System.out.print("Choix: ");
            choix = sc.nextInt();
            sc.nextLine(); // Consommer le retour à la ligne

            switch (choix) {
                case 1 -> afficherParc();

                case 2 -> {
                    System.out.print("ID véhicule: ");
                    int idEntretien = sc.nextInt();
                    sc.nextLine();
                    Vehicule vEntretien = trouverVehicule(idEntretien);
                    if (vEntretien != null) {
                        System.out.print("Montant entretien: ");
                        double montant = sc.nextDouble();
                        sc.nextLine();
                        vEntretien.entretien(montant);
                        System.out.println("[INFO] Entretien appliqué !");
                    } else {
                        System.out.println("[ERREUR] Véhicule introuvable.");
                    }
                }

                case 3 -> {
                    System.out.print("ID véhicule: ");
                    int idUsure = sc.nextInt();
                    sc.nextLine();
                    Vehicule vUsure = trouverVehicule(idUsure);
                    if (vUsure != null) {
                        System.out.print("Montant usure: ");
                        double montant = sc.nextDouble();
                        sc.nextLine();
                        vUsure.usure(montant);
                        System.out.println("[INFO] Usure appliquée !");
                    } else {
                        System.out.println("[ERREUR] Véhicule introuvable.");
                    }
                }

                case 4 -> {
                    System.out.print("ID véhicule: ");
                    int idTransfert = sc.nextInt();
                    sc.nextLine();
                    Vehicule vTransfert = trouverVehicule(idTransfert);
                    if (vTransfert != null) {
                        System.out.print("Nouveau propriétaire: ");
                        String np = sc.nextLine();
                        vTransfert.transfert(np);
                        System.out.println("[INFO] Transfert effectué !");
                    } else {
                        System.out.println("[ERREUR] Véhicule introuvable.");
                    }
                }

                case 5 -> {
                    System.out.println("Type: 1-Voiture 2-Camion 3-Moto 4-Vélo");
                    int type = sc.nextInt();
                    sc.nextLine();

                    System.out.print("ID: "); int id = sc.nextInt(); sc.nextLine();
                    System.out.print("Marque: "); String marque = sc.nextLine();
                    System.out.print("Modèle: "); String modele = sc.nextLine();
                    System.out.print("Année: "); int annee = sc.nextInt(); sc.nextLine();
                    System.out.print("Kilométrage: "); double km = sc.nextDouble(); sc.nextLine();
                    System.out.print("Propriétaire: "); String prop = sc.nextLine();

                    switch (type) {
                        case 1 -> { // Voiture
                            System.out.print("Nombre de portes: "); int np = sc.nextInt(); sc.nextLine();
                            System.out.print("Type carburant: "); String carburant = sc.nextLine();
                            ajouterVehicule(new Voiture(id, marque, modele, annee, km, prop, np, carburant));
                        }
                        case 2 -> { // Camion
                            System.out.print("Capacité chargement (t): "); double cap = sc.nextDouble(); sc.nextLine();
                            System.out.print("Nombre essieux: "); int e = sc.nextInt(); sc.nextLine();
                            ajouterVehicule(new Camion(id, marque, modele, annee, km, prop, cap, e));
                        }
                        case 3 -> { // Moto
                            System.out.print("Cylindrée: "); int cyl = sc.nextInt(); sc.nextLine();
                            ajouterVehicule(new Moto(id, marque, modele, annee, km, prop, cyl));
                        }
                        case 4 -> { // Vélo
                            System.out.print("Électrique (true/false): "); boolean elect = sc.nextBoolean(); sc.nextLine();
                            ajouterVehicule(new Velo(id, marque, modele, annee, km, prop, elect));
                        }
                        default -> System.out.println("[ERREUR] Type invalide.");
                    }
                }

                case 6 -> {
                    System.out.print("ID véhicule à supprimer: ");
                    int idSupp = sc.nextInt();
                    sc.nextLine();
                    supprimerVehicule(idSupp);
                }

                case 7 -> afficherStatistiques();
                case 0 -> System.out.println("[INFO] Au revoir !");
                default -> System.out.println("[ERREUR] Choix invalide.");
            }
        } while (choix != 0);
    }
}
