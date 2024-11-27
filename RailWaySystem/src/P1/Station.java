package P1;

public class Station {
	private int stationId;
    private String stationName;
    private Track track;

    public Station(int stationId, String stationName, Track track) {
        this.stationId = stationId;
        this.stationName = stationName;
        this.track = track;
    }

    // Getters and setters
    public int getStationId() {
        return stationId;
    }

    public void setStationId(int stationId) {
        this.stationId = stationId;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public Track getTrack() {
        return track;
    }

    public void setTrack(Track track) {
        this.track = track;
    }

}
