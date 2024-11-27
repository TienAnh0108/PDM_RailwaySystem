package P1;

public class Train {
	private int trainId;
    private String trainName;
    private Schedule schedule;

    public Train(int trainId, String trainName, Schedule schedule) {
        this.trainId = trainId;
        this.trainName = trainName;
        this.schedule = schedule;
    }

    // Getters and setters
    public int getTrainId() {
        return trainId;
    }

    public void setTrainId(int trainId) {
        this.trainId = trainId;
    }

    public String getTrainName() {
        return trainName;
    }

    public void setTrainName(String trainName) {
        this.trainName = trainName;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }
}
