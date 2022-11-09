package controller;

import java.util.HashMap;
import java.util.Map;

public class MapManager {

    public HashMap<String, String> artistas;

    public MapManager(){
        artistas = new HashMap<>(Map.of(
                "Morat", "5C4PDR4LnhZTbVnKWXuDKD",
                "Melendi", "1EXjXQpDx2pROygh8zvHs4",
                "C.Tangana", "5TYxZTjIPqKM8K8NuP9woO",
                "Nicki Nicole", "2UZIAOlrnyZmyzt1nuXr9y",
                "Nathy Peluso", "3VHAySZQPlfGlNLslzXYpN"
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
