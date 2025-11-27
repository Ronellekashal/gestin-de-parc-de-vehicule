import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class FileManager {

    private static final String TXT_FILE = "vehicules.txt";
    private static final String JSON_FILE = "vehicules.json";

    public static void saveTxt(ArrayList<Vehicule> list) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(TXT_FILE))) {
            for (Vehicule v : list) {
                String type = v.getClass().getSimpleName();
                pw.println(type + ";" + v.getMatricule() + ";" + v.getMarque() + ";" + v.getModele() +
                        ";" + v.getAnnee() + ";" + v.getKilometrage() + ";" + v.getProprietaire());
            }
            System.out.println("Fichier TXT sauvegardé !");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Vehicule> loadTxt() {
        ArrayList<Vehicule> list = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(TXT_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(";");
                String type = parts[0];
                String matricule = parts[1];
                String marque = parts[2];
                String modele = parts[3];
                int annee = Integer.parseInt(parts[4]);
                double km = Double.parseDouble(parts[5]);
                String proprio = parts[6];

                switch (type) {
                    case "Voiture" -> list.add(new Voiture(matricule, marque, modele, annee, km, proprio, 4, "Essence"));
                    case "Camion" -> list.add(new Camion(matricule, marque, modele, annee, km, proprio, 5.0, 2));
                    case "Moto" -> list.add(new Moto(matricule, marque, modele, annee, km, proprio, 150));
                    case "Velo" -> list.add(new Velo(matricule, marque, modele, annee, km, proprio, false));
                }
            }
            System.out.println("Fichier TXT chargé !");
        } catch (IOException e) {
            System.out.println("Aucun fichier TXT trouvé.");
        }
        return list;
    }

    public static void saveJson(ArrayList<Vehicule> list) {
        try (Writer writer = new FileWriter(JSON_FILE)) {
            Gson gson = new GsonBuilder()
                    .registerTypeAdapter(Vehicule.class, new InterfaceAdapter<>())
                    .setPrettyPrinting()
                    .create();
            gson.toJson(list, writer);
            System.out.println("Fichier JSON sauvegardé !");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Vehicule> loadJson() {
        ArrayList<Vehicule> list = new ArrayList<>();
        try (Reader reader = new FileReader(JSON_FILE)) {
            Gson gson = new GsonBuilder()
                    .registerTypeAdapter(Vehicule.class, new InterfaceAdapter<>())
                    .create();
            Type listType = new TypeToken<ArrayList<Vehicule>>() {}.getType();
            list = gson.fromJson(reader, listType);
            System.out.println("Fichier JSON chargé !");
        } catch (IOException e) {
            System.out.println("Aucun fichier JSON trouvé.");
        }
        return list;
    }

    public static class InterfaceAdapter<T> implements JsonSerializer<T>, JsonDeserializer<T> {
        @Override
        public JsonElement serialize(T src, Type typeOfSrc, JsonSerializationContext context) {
            JsonObject obj = context.serialize(src).getAsJsonObject();
            obj.addProperty("type", src.getClass().getSimpleName());
            return obj;
        }

        @Override
        public T deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
            JsonObject obj = json.getAsJsonObject();
            String type = obj.get("type").getAsString();
            return switch (type) {
                case "Voiture" -> context.deserialize(json, Voiture.class);
                case "Camion" -> context.deserialize(json, Camion.class);
                case "Moto" -> context.deserialize(json, Moto.class);
                case "Velo" -> context.deserialize(json, Velo.class);
                default -> throw new JsonParseException("Type inconnu : " + type);
            };
        }
    }
}
