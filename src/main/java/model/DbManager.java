package model;

import java.sql.*;

public class DbManager {

    private String dbPath;
    private Statement statement;

    Connection connection;

    Artist artist = new Artist();

    public DbManager(){
        dbPath =  "C:\\Users\\usuarioç\\IdeaProjects\\ingenieriasoftware\\Spotify\\database\\spotifydb.db";
        try {
            connection = connect(dbPath);
            statement = connection.createStatement();
            System.out.println("Conexión establecida");
            //System.out.println("El rojo es mi color favorito"); --> debug

            statement.execute("DROP TABLE IF EXISTS Artists");
            statement.execute("DROP TABLE IF EXISTS Albums");
            statement.execute("DROP TABLE IF EXISTS Tracks");


            statement.execute("CREATE TABLE IF NOT EXISTS Artists (" +
                    "artistId TEXT PRIMARY KEY, " +
                    "artistName TEXT NOT NULL," +
                    "artistPopularity NUMBER" +
                    ")");

            statement.execute("CREATE TABLE IF NOT EXISTS Albums (" +
                    "albumId TEXT PRIMARY KEY, " +
                    "albumName TEXT NOT NULL," +
                    "albumDate TEXT NOT NULL," +
                    "artistId TEXT," +
                    "FOREIGN KEY (artistId) REFERENCES Artists(artistId)" +
                    ")");

            statement.execute("CREATE TABLE IF NOT EXISTS Tracks (" +
                    "trackId TEXT PRIMARY KEY, " +
                    "trackName TEXT NOT NULL," +
                    "trackDuration NUMBER," +
                    "trackExplicit BOOLEAN," +
                    "artistId TEXT," +
                    "albumId TEXT,"+
                    "FOREIGN KEY (artistId) REFERENCES Artists(artistId)," +
                    "FOREIGN KEY (albumId) REFERENCES Albums(albumId)" +
                    ")");
        }
        catch (SQLException e) {
            System.out.println("No se pudo conectar");
        }
    }

    public void insertArtist(Artist artist){
        String sql = "INSERT INTO Artists(artistId, artistName, artistPopularity) VALUES(?,?,?)";
        String artistName = (artist.getArtistName()).replaceAll("'","");
        artistName = artistName.replaceAll("\"","");
        try (PreparedStatement pstm = connection.prepareStatement(sql)){
            pstm.setString(1, artist.getArtistId());
            pstm.setString(2, artistName);
            pstm.setInt(3, artist.getArtistPopularity());
            pstm.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void insertAlbum(Album album){
        String sql = "INSERT INTO Albums(albumId, albumName, albumDate, artistId) VALUES(?,?,?,?)";
        String albumName = (artist.getArtistName()).replaceAll("'","");
        albumName = albumName.replaceAll("\"","");
        try (PreparedStatement pstm = connection.prepareStatement(sql)){
            pstm.setString(1, album.getAlbumId());
            pstm.setString(2, albumName);
            pstm.setString(3, album.getAlbumDate());
            pstm.setString(4, album.getArtistId());
            pstm.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void insertTrack(Track track){
        String sql = "INSERT INTO Tracks(trackId, trackName, trackDuration, trackExplicit, artistId, albumId) VALUES(?,?,?,?,?,?)";
        String trackName = (artist.getArtistName()).replaceAll("'","");
        trackName = trackName.replaceAll("\"","");
        try (PreparedStatement pstm = connection.prepareStatement(sql)){
            pstm.setString(1, track.getTrackId());
            pstm.setString(2, trackName);
            pstm.setInt(3, track.getTrackDuration());
            pstm.setBoolean(4, track.isTrackExplicit());
            pstm.setString(5, track.getTrackArtistId());
            pstm.setString(6, track.getTrackAlbumId());
            pstm.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public Connection connect(String dbPath) {
        Connection conn = null;
        try {
            String url = "jdbc:sqlite:" + dbPath;
            conn = DriverManager.getConnection(url);
            System.out.println("Conexión con SQLite establecida.");
        } catch (SQLException e) {
            System.out.println("No se pudo establecer la conexión");
        }
        return conn;
    }
    public void closeConnection() throws SQLException {
        connection.close();
    }

}
