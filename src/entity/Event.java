package entity;

public class Event {

    private String eventCode;
    private String eventName;
    private long startTime;
    private long finishTime;
    private int eventType;
    private int status;

    public Event() {
    }

    public Event(String eventCode, String eventName, long startTime, long finishTime, int eventType, int status) {
        this.eventCode = eventCode;
        this.eventName = eventName;
        this.startTime = startTime;
        this.finishTime = finishTime;
        this.eventType = eventType;
        this.status = status;
    }

    public String getEventCode() {
        return eventCode;
    }

    public void setEventCode(String eventCode) {
        this.eventCode = eventCode;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public long getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(long finishTime) {
        this.finishTime = finishTime;
    }

    public int getEventType() {
        return eventType;
    }

    public void setEventType(int eventType) {
        this.eventType = eventType;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
