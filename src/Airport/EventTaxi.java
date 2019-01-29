package Airport;

import Aircraft.Aircraft;

import java.util.ArrayList;

public class EventTaxi {
    private int eventID;
    private Aircraft aircraft;
    private String destinationSide;
    private ArrayList<String> wayToDestination;
    private String exactDestination;

    public EventTaxi(Aircraft aircraft, String destinationSide, ArrayList<String> wayToDestination, String exactDestination, int eventID) {
        this.eventID = eventID;
        this.aircraft = aircraft;
        this.destinationSide = destinationSide;
        this.wayToDestination = wayToDestination;
        this.exactDestination = exactDestination;
    }
}
