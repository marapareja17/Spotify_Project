package model;

public class Artists {
    private String artistId;
    private String artistName;
    private int artistPopularity;

    public Artists(String artistId, String artistName, int artistPopularity) {
        this.artistId = artistId;
        this.artistName = artistName;
        this.artistPopularity = artistPopularity;
    }

    public String getArtistId() {
        return artistId;
    }

    public String getArtistName() {
        return artistName;
    }

    public int getArtistPopularity() {
        return artistPopularity;
    }

    public void setArtistId(String artistId) {
        this.artistId = artistId;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public void setArtistPopularity(int artistPopularity) {
        this.artistPopularity = artistPopularity;
    }
}
