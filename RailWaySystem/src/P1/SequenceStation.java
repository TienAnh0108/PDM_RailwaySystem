package P1;

import java.sql.Date;

public class SequenceStation {
	private int routeId;
    private Schedule schedule;
    private Date arrivalTime;
    private Date departureTime;
    private Station station;
    private int sequenceNum;

    public SequenceStation(int routeId, Schedule schedule, Date arrivalTime, Date departureTime, Station station, int sequenceNum) {
        this.routeId = routeId;
        this.schedule = schedule;
        this.arrivalTime = arrivalTime;
        this.departureTime = departureTime;
        this.station = station;
        this.sequenceNum = sequenceNum;
    }

    // Getters and setters
    public int getRouteId() {
        return routeId;
    }

    public void setRouteId(int routeId) {
        this.routeId = routeId;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    public Date getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(Date arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }

    public Station getStation() {
        return station;
    }

    public void setStation(Station station) {
        this.station = station;
    }

    public int getSequenceNum() {
        return sequenceNum;
    }

    public void setSequenceNum(int sequenceNum) {
        this.sequenceNum = sequenceNum;
    }
}
