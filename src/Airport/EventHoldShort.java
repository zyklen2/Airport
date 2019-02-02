package Airport;
import Aircraft.*;

public class EventHoldShort {
    private int eventID;
    private IAircraft aircraft;
    private String runwayEntrance;
    private CommunicationFrequencys frequency;

    public EventHoldShort(IAircraft aircraft, String runwayEntrance, CommunicationFrequencys frequency, int eventID){
        this.eventID=eventID;
        this.aircraft = aircraft;
        this.runwayEntrance=runwayEntrance;
        this.frequency=frequency;
    }

    public AircraftID getAircraft() {
        return aircraft.getId();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{EventRunwayClearedToLand : ");
        stringBuilder.append(" eventID = ").append(eventID);
        stringBuilder.append(" frequency = ").append(frequency);
        stringBuilder.append(" aircraft = ").append(aircraft.getId());
        stringBuilder.append(" runwayEntrance = ").append(runwayEntrance).append("} ");
        return stringBuilder.toString();
    }
}
