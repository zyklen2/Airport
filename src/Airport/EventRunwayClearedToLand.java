package Airport;

import Aircraft.Aircraft;

public class EventRunwayClearedToLand {
    Aircraft aircraft;
    String runway;
    int eventID;

    public EventRunwayClearedToLand(Aircraft aircraft, String runway, int eventID) {
        this.aircraft = aircraft;
        this.runway = runway;
        this.eventID = eventID;
    }
}
