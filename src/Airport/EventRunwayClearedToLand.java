package Airport;

import Aircraft.*;

public class EventRunwayClearedToLand {
    private IAircraft aircraft;
    private String runway;
    private int eventID;

    public EventRunwayClearedToLand(IAircraft aircraft, String runway, int eventID) {
        this.aircraft = aircraft;
        this.runway = runway;
        this.eventID = eventID;
    }

    public AircraftID getAircraft() {
        return aircraft.getId();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{EventRunwayClearedToLand : ");
        stringBuilder.append(" eventID = ").append(eventID);
        stringBuilder.append(" aircraft = ").append(aircraft.getId());
        stringBuilder.append(" runway = ").append(runway).append("} ");
        return stringBuilder.toString();
    }
}
