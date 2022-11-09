package controller;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import model.Album;
import model.Artist;
import model.DbManager;
import model.Track;

import java.sql.SQLException;
import java.util.Map;

public class Controller {
    private MapManager artists;
    private DbManager dbManager;

    private SpotifyAccessor accessor;


    public Controller(String clientId, String clientSecret){
        this.artists = new MapManager();
        this.dbManager = new DbManager();
        try {this.accessor = new SpotifyAccessor(clientId, clientSecret);} catch (Exception e) {}

    }

    public void storeArtists(String name) throws Exception {
        String artistJson = accessor.get("/artists/" + artists.getAID(name), Map.of());
        JsonObject json = new Gson().fromJson(artistJson, JsonObject.class);
        Artist artist = new Artist();
        artist.setArtistId(artists.getAID(name));
        artist.setArtistName(json.get("name").getAsString());
        artist.setArtistPopularity(json.get("popularity").getAsInt());
        dbManager.insertArtist(artist);
        storeAlbums(name, artists.getAID(name));
    }

    public void storeAlbums(String name, String idArtist) throws Exception {
        String artistJson = accessor.get("/artists/" + artists.getAID(name) + "/albums", Map.of());
        JsonObject json = new Gson().fromJson(artistJson, JsonObject.class);
        JsonArray albums = json.get("items").getAsJsonArray();

        for (JsonElement a : albums) {
            Album album = new Album();
            album.setAlbumId(a.getAsJsonObject().get("id").getAsString());
            album.setAlbumName(a.getAsJsonObject().get("name").getAsString());
            album.setAlbumDate(a.getAsJsonObject().get("release_date").getAsString());
            album.setArtistId(idArtist);
            dbManager.insertAlbum(album);
            storeTracks(album, idArtist,a.getAsJsonObject().get("id").getAsString() );
        }
    }

    public void storeTracks(Album album, String idArtist, String idAlbum) throws Exception {
        String tracksJson = accessor.get("/albums/" + album.getAlbumId() + "/tracks", Map.of());
        JsonObject json = new Gson().fromJson(tracksJson, JsonObject.class);
        JsonArray tracks = json.get("items").getAsJsonArray();

        for (JsonElement t : tracks) {
            Track track = new Track();
            track.setTrackId(t.getAsJsonObject().get("id").getAsString());
            track.setTrackName(t.getAsJsonObject().get("name").getAsString());
            track.setTrackDuration(t.getAsJsonObject().get("duration_ms").getAsInt());
            track.setTrackExplicit(t.getAsJsonObject().get("explicit").getAsBoolean());
            track.setTrackArtistId(idArtist);
            track.setTrackAlbumId(idAlbum);
            dbManager.insertTrack(track);
        }
    }

    public void addArtists(String name, String id){
        artists.addArtists(name, id);
    }

    public String ShowArtists(){
        return artists.ShowArtist();
    }

    public void close() throws SQLException {
        dbManager.closeConnection();
    }

}
