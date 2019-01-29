package Airport;

import Aircraft.Aircraft;

public class EventRunwayClearedForTakeOff {
    Aircraft aircraft;
    String runway;
    int EventID;

    public EventRunwayClearedForTakeOff(Aircraft aircraft, String runway, int eventID) {
        this.aircraft = aircraft;
        this.runway = runway;
        EventID = eventID;
    }
}
