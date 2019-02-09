package Airport;

import Aircraft.*;

public class EventRunwayClearedToLand {
    private IAircraft aircraft;
    private String runway;
    private int eventID;
    private CommunicationFrequencys frequency;

    public EventRunwayClearedToLand(IAircraft aircraft, String runway,CommunicationFrequencys frequency, int eventID) {
        this.aircraft = aircraft;
        this.runway = runway;
        this.eventID = eventID;
        this.frequency=frequency;
    }

    public AircraftID getAircraft() {
        return aircraft.getId();
    }

    public String getRunway() {
        return runway;
    }

    public CommunicationFrequencys getFrequency() {
        return frequency;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{EventRunwayClearedToLand : ");
        stringBuilder.append(" eventID = ").append(eventID);
        stringBuilder.append(" frequency = ").append(frequency.getFrequency());
        stringBuilder.append(" aircraft = ").append(aircraft.getId());
        stringBuilder.append(" runway = ").append(runway).append("}");
        return stringBuilder.toString();
    }
}
