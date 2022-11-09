package model;

public class Track {
    private String trackId;
    private String trackName;
    private int trackDuration;
    private boolean trackExplicit;

    private String artistId;

    private String albumId;

    public Track() {
    }

    public String getTrackId() {
        return trackId;
    }

    public String getTrackName() {
        return trackName;
    }

    public int getTrackDuration() {
        return trackDuration;
    }

    public boolean isTrackExplicit() {
        return trackExplicit;
    }

    public String getTrackArtistId() { return artistId; }
    public String getTrackAlbumId() { return albumId; }


    public void setTrackId(String trackId) {
        this.trackId = trackId;
    }

    public void setTrackName(String trackName) {
        this.trackName = trackName;
    }

    public void setTrackDuration(int trackDuration) {
        this.trackDuration = trackDuration;
    }

    public void setTrackExplicit(boolean trackExplicit) {
        this.trackExplicit = trackExplicit;
    }

    public void setTrackArtistId(String trackArtistId) { this.artistId = trackArtistId;}
    public void setTrackAlbumId(String trackAlbumId) { this.albumId = trackAlbumId;}
}
