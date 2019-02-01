package Airport;
import Aircraft.*;
import com.google.common.eventbus.EventBus;

import java.util.ArrayList;

public class ApronControl {
    private EventBus eventBus;
    private EventID eventID;
    private AirportOperationsDatabase theDatabase;
    public ApronControl(AirportOperationsDatabase theDatabase,EventID theEventID) {
        this.eventBus = new EventBus();
        eventID=theEventID;
        this.theDatabase=theDatabase;
    }

    public void eventRunwayClearedToLand(Aircraft aircraft, String runway) {
        EventRunwayClearedToLand event=new EventRunwayClearedToLand(aircraft,runway,eventID.getEventID());
        eventBus.post(event);
        theDatabase.addData(aircraft.getId(),event.toString());
    }

    public void eventTaxi(Aircraft aircraft, String destinationRunwayConnector, ArrayList<String> wayToDestination, String exactDestination) {
        EventTaxi event=new EventTaxi(aircraft,destinationRunwayConnector,wayToDestination,exactDestination,eventID.getEventID());
        eventBus.post(event);
        theDatabase.addData(aircraft.getId(),event.toString());
    }

    public void eventTaxi(Aircraft aircraft, String destinationRunwayConnector, ArrayList<String> wayToDestination) {
        EventTaxi event = new EventTaxi(aircraft,destinationRunwayConnector,wayToDestination,eventID.getEventID());
        eventBus.post(event);
        theDatabase.addData(aircraft.getId(),event.toString());
    }

    public void eventRunwayClearedForTakeOff(Aircraft aircraft, String runway){
        EventRunwayClearedForTakeOff event=new EventRunwayClearedForTakeOff(aircraft,runway,eventID.getEventID());
        eventBus.post(event);
        theDatabase.addData(aircraft.getId(),event.toString());
    }

    public void eventHoldShort(Aircraft aircraft, String runwayEntrance){
        CommunicationFrequencys frequency = CommunicationFrequencys.Tower;
        EventHoldShort event=new EventHoldShort(aircraft,runwayEntrance,frequency,eventID.getEventID());
        eventBus.post(event);
        theDatabase.addData(aircraft.getId(),event.toString());
    }

    public void addAirplane(Subscriber subscriber) {
        eventBus.register(subscriber);
    }

}
