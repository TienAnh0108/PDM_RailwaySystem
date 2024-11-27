package P1;

public class Track {
	private int trackId;
    private Station startStation;
    private Station endStation;

    public Track(int trackId, Station startStation, Station endStation) {
        this.trackId = trackId;
        this.startStation = startStation;
        this.endStation = endStation;
    }

    // Getters and setters
    public int getTrackId() {
        return trackId;
    }

    public void setTrackId(int trackId) {
        this.trackId = trackId;
    }

    public Station getStartStation() {
        return startStation;
    }

    public void setStartStation(Station startStation) {
        this.startStation = startStation;
    }

    public Station getEndStation() {
        return endStation;
    }

    public void setEndStation(Station endStation) {
        this.endStation = endStation;
    }
}
