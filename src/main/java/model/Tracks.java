package model;

public class Tracks {
    private String trackId;
    private String trackName;
    private String trackDate;
    private int trackPopularity;
    private int trackDuration;
    private boolean trackExplicit;

    public Tracks(String trackId, String trackName, String trackDate, int trackPopularity, int trackDuration, boolean trackExplicit) {
        this.trackId = trackId;
        this.trackName = trackName;
        this.trackDate = trackDate;
        this.trackPopularity = trackPopularity;
        this.trackDuration = trackDuration;
        this.trackExplicit = trackExplicit;
    }

    public String getTrackId() {
        return trackId;
    }

    public String getTrackName() {
        return trackName;
    }

    public String getTrackDate() {
        return trackDate;
    }

    public int getTrackPopularity() {
        return trackPopularity;
    }

    public int getTrackDuration() {
        return trackDuration;
    }

    public boolean isTrackExplicit() {
        return trackExplicit;
    }


    public void setTrackId(String trackId) {
        this.trackId = trackId;
    }

    public void setTrackName(String trackName) {
        this.trackName = trackName;
    }

    public void setTrackDate(String trackDate) {
        this.trackDate = trackDate;
    }

    public void setTrackPopularity(int trackPopularity) {
        this.trackPopularity = trackPopularity;
    }

    public void setTrackDuration(int trackDuration) {
        this.trackDuration = trackDuration;
    }

    public void setTrackExplicit(boolean trackExplicit) {
        this.trackExplicit = trackExplicit;
    }
}
