package controller;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import model.*;

import java.util.Map;

public class Controller {
    private Artist artist;
    private DbManager dbManager;

    private SpotifyAccessor accessor;


    public Controller(){
        this.artist = new Artist();
        this.dbManager = new DbManager();
        try {this.accessor = new SpotifyAccessor();} catch (Exception e) {}

    }

    public void StoreArtists(String name) throws Exception {
        String artistJson = accessor.get("/artists/" +artist.getAID(name), Map.of());
        JsonObject json = new Gson().fromJson(artistJson, JsonObject.class);
        dbManager.insert(json);
    }
    public void addArtists(String name, String id){
        artist.addArtists(name, id);
    }

    public String ShowArtists(){
        return artist.ShowArtist();
    }

}
