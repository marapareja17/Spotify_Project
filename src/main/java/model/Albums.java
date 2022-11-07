package model;

public class Albums {
    private String albumId;
    private String albumName;
    private String albumDate;
    private int albumPopularity;

    public Albums(String albumId, String albumName, String albumDate, int albumPopularity) {
        this.albumId = albumId;
        this.albumName = albumName;
        this.albumDate = albumDate;
        this.albumPopularity = albumPopularity;
    }

    public String getAlbumId() {
        return albumId;
    }

    public String getAlbumName() {
        return albumName;
    }

    public String getAlbumDate() {
        return albumDate;
    }

    public int getAlbumPopularity() {
        return albumPopularity;
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

    public void setAlbumPopularity(int albumPopularity) {
        this.albumPopularity = albumPopularity;
    }
}
