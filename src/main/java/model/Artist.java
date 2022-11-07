package model;

import java.util.HashMap;
import java.util.Map;

public class Artist {

    public HashMap<String, String> artistas;

    public Artist(){
        artistas = new HashMap<>(Map.of(
                "Rihana", "5pKCCKE2ajJHZ9KAiaK11H",
                "Melendi", "1EXjXQpDx2pROygh8zvHs4",
                "Imagine dragons", "53XhwfbYqKCa1cC15pYq2q",
                "Taylor Swift", "06HL4z0CvFAxyc27GXpf02",
                "Bizarrap", "716NhGYqD1jl2wI1Qkgq36"
        ));
    }

    public void addArtists(String name, String id){
        System.out.println("Hemos añadido tu artista correctamente");
        artistas.put(name, id);
    }

    public String getAID(String name){
        return artistas.get(name);
    }

    public String ShowArtist(){
        return artistas.keySet().toString();
    }
}
