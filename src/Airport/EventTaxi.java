package Airport;

import Aircraft.*;

import java.util.ArrayList;

public class EventTaxi {
    private int eventID;
    private IAircraft aircraft;
    private String destination;
    private ArrayList<String> wayToDestination;
    private String exactDestination;

    //Wenn wenn das Ziel ein Runway ist, muss der RunwayConnector und der genaue Punkt angegeben werden
    public EventTaxi(IAircraft aircraft, String destination, ArrayList<String> wayToDestination, String exactDestination, int eventID) {
        this.eventID = eventID;
        this.aircraft = aircraft;
        this.destination = destination;
        this.wayToDestination = wayToDestination;
        this.exactDestination = exactDestination;
    }

    //Wenn das Ziel ein Gate ist, muss nur das Gate selbst angegeben werden
    public EventTaxi(IAircraft aircraft, String destination, ArrayList<String> wayToDestination,int eventID) {
        this.eventID = eventID;
        this.aircraft = aircraft;
        this.destination = destination;
        this.wayToDestination = wayToDestination;
    }

    public AircraftID getAircraft() {
        return aircraft.getId();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{EventTaxi : ");
        stringBuilder.append(" eventID = ").append(eventID);
        stringBuilder.append(" aircraft = ").append(aircraft.getId());
        stringBuilder.append(" destinationSide = ").append(destination);
        stringBuilder.append(" wayToDestination = ");
        for(int i=0;i<wayToDestination.size();i++){
            stringBuilder.append(wayToDestination.get(i));
            if(i!=0&&i<=(wayToDestination.size()-1)){
                stringBuilder.append(",");
            }
        }
        if(exactDestination!=null) {
            stringBuilder.append(" exactDestination = ").append(exactDestination).append("} ");
        }
        else{
            stringBuilder.append("} ");
        }
        return stringBuilder.toString();
    }
}
