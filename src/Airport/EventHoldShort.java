package Airport;
import Aircraft.Aircraft;

public class EventHoldShort {
    private int eventID;
    private Aircraft aircraft;
    private String runwayEntrance;
    private CommunicationFrequencys frequency;
    public EventHoldShort(Aircraft aircraft, String runwayEntrance, CommunicationFrequencys frequency, int eventID){
        this.eventID=eventID;
        this.aircraft = aircraft;
        this.runwayEntrance=runwayEntrance;
        this.frequency=frequency;
    }
}
