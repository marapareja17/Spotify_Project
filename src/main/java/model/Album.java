package model;

public class Album {
    private String albumId;
    private String albumName;
    private String albumDate;

    private String artistId;



    public String getAlbumId() {
        return albumId;
    }

    public String getAlbumName() {
        return albumName;
    }

    public String getAlbumDate() {
        return albumDate;
    }

    public String getArtistId() {
        return artistId;
    }

    public void setAlbumId(String albumId) {
        this.albumId = albumId;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public void setAlbumDate(String albumDate) {
        this.albumDate = albumDate;
    }

    public void setArtistId(String artistId){
        this.artistId = artistId;
    }
}
