import java.util.ArrayList;

public class GestionParc {
    private ArrayList<Vehicule> parc = new ArrayList<>();

    public void ajouter(Vehicule v) {
        parc.add(v);
        System.out.println("Véhicule ajouté : " + v.getMatricule());
    }

    public void supprimer(String matricule) {
        parc.removeIf(v -> v.getMatricule().equalsIgnoreCase(matricule));
        System.out.println("Véhicule supprimé : " + matricule);
    }

    public Vehicule chercher(String matricule) {
        for (Vehicule v : parc) {
            if (v.getMatricule().equalsIgnoreCase(matricule)) return v;
        }
        return null;
    }

    public void afficher() {
        if (parc.isEmpty()) System.out.println("Parc vide !");
        else for (Vehicule v : parc) v.afficherInfos();
    }

    // Persistance
    public void sauvegarder() {
        FileManager.saveTxt(parc);
        FileManager.saveJson(parc);
    }

    public void charger() {
        parc = FileManager.loadTxt();
        if (parc.isEmpty()) parc = FileManager.loadJson();

        if (parc.isEmpty()) {
            System.out.println("Aucun véhicule trouvé. Initialisation du parc par défaut...");
            parc.add(new Voiture("V001", "Toyota", "Corolla", 2019, 45000, "Alice", 4, "Essence"));
            parc.add(new Camion("C001", "Volvo", "FH", 2020, 120000, "Bob", 5.0, 2));
            parc.add(new Moto("M001", "Yamaha", "MT07", 2021, 8000, "Charlie", 689));
            sauvegarder();
        }
    }
}
