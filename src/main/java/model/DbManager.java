package model;

import com.google.gson.JsonObject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DbManager {

    private String dbPath;
    private Statement statement;

    public DbManager(){
        dbPath =  "C:\\Users\\usuarioç\\IdeaProjects\\ingenieriasoftware\\Spotify\\database\\spotifydb.db";
        try {
            Connection conn = connect(dbPath);
            statement = conn.createStatement();
            System.out.println("Conexión establecida");

            statement.execute("CREATE TABLE IF NOT EXISTS Artists (" +
                    "artistId TEXT PRIMARY KEY, " +
                    "artistName TEXT NOT NULL," +
                    "artistPopularity NUMBER" +
                    ")");

            statement.execute("CREATE TABLE IF NOT EXISTS Albums (" +
                    "albumId TEXT PRIMARY KEY, " +
                    "albumName TEXT NOT NULL," +
                    "albumDate TEXT NOT NULL," +
                    "albumPopularity NUMBER" +
                    ")");

            statement.execute("CREATE TABLE IF NOT EXISTS Tracks (" +
                    "trackId TEXT PRIMARY KEY, " +
                    "trackName TEXT NOT NULL," +
                    "trackDate TEXT NOT NULL," +
                    "trackPopularity NUMBER," +
                    "trackDuration NUMBER," +
                    "trackExplicit BOOLEAN" +
                    ")");

            conn.close();
        }
        catch (SQLException e) {
            System.out.println("No se pudo conectar");
        }
    }

    public void insertArtist(MapManager artist, Connection connection){
        String sql = "INSERT INTO MapManager(id, name, popularity) VALUES(?, ?, ?)";
    }
    public void insert(JsonObject json) throws SQLException {
        try {
            Connection conn = connect(dbPath);
            Statement statement2 = conn.createStatement();
            System.out.println("Conexión establecida");

            statement2.execute("INSERT INTO Artists (artistId, artistName, artistPopularity)\n" +
                    "VALUES(json.get(\"id\").getAsString()" +
                    ", (json.get(\"name\").getAsString()" +
                    ", (json.get(\"popularity\").getAsInt()" +
                    ");");


            statement2.execute("INSERT INTO Albums(albumId, albumName, albumDate, albumPopularity)\n" +
                    "VALUES(json.get(\"id\").getAsString())" +
                    "VALUES(json.get(\"name\").getAsString())" +
                    "VALUES(json.get(\"date\").getAsString())" +
                    "VALUES(json.get(\"popularity\").getAsInt())" +
                    ")");

;
            statement.execute("INSERT INTO Tracks(trackId, trackName, trackDate, trackPopularity, trackDuration, trackExplicit)\n" +
                    "VALUES(json.get(\"id\").getAsString())" +
                    "VALUES(json.get(\"name\").getAsString())" +
                    "VALUES(json.get(\"date\").getAsString())" +
                    "VALUES(json.get(\"popularity\").getAsInt())" +
                    "VALUES(json.get(\"popularity\").getAsInt())" +
                    "VALUES(json.get(\"popularity\").getAsBoolean())" +
                    ")");

            conn.close();
        }
        catch (SQLException e) {
            System.out.println("No se pudo conectar");
        }
    }

    public void ChangePath(String newPath){
        dbPath = newPath;
    }

    public static Connection connect(String dbPath) {
        Connection conn = null;
        try {
            String url = "jdbc:sqlite:" + dbPath;
            conn = DriverManager.getConnection(url);
            System.out.println("Connection to SQLite has been established.");
        } catch (SQLException e) {
            System.out.println("No se pudo establecer la conexión");
        }
        return conn;
    }

}
