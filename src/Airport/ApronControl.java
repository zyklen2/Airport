package Airport;
import Aircraft.*;
import com.google.common.eventbus.EventBus;

import java.util.ArrayList;

public class ApronControl implements IApronControl {
    private EventBus eventBus;
    private EventID eventID;
    private IAirportOperationsDatabase theDatabase;
    public ApronControl(IAirportOperationsDatabase theDatabase,EventID theEventID) {
        this.eventBus = new EventBus();
        eventID=theEventID;
        this.theDatabase=theDatabase;
    }

    @Override
    public void eventRunwayClearedToLand(IAircraft aircraft, String runway) {
        EventRunwayClearedToLand event=new EventRunwayClearedToLand(aircraft,runway,eventID.getEventID());
        eventBus.post(event);
        theDatabase.addData(aircraft.getId(),event.toString());
    }

    @Override
    public void eventTaxi(IAircraft aircraft, String destinationRunwayConnector, ArrayList<String> wayToDestination, String exactDestination) {
        EventTaxi event=new EventTaxi(aircraft,destinationRunwayConnector,wayToDestination,exactDestination,eventID.getEventID());
        eventBus.post(event);
        theDatabase.addData(aircraft.getId(),event.toString());
    }

    @Override
    public void eventTaxi(IAircraft aircraft, String destinationRunwayConnector, ArrayList<String> wayToDestination) {
        EventTaxi event = new EventTaxi(aircraft,destinationRunwayConnector,wayToDestination,eventID.getEventID());
        eventBus.post(event);
        theDatabase.addData(aircraft.getId(),event.toString());
    }

    @Override
    public void eventRunwayClearedForTakeOff(IAircraft aircraft, String runway){
        EventRunwayClearedForTakeOff event=new EventRunwayClearedForTakeOff(aircraft,runway,eventID.getEventID());
        eventBus.post(event);
        theDatabase.addData(aircraft.getId(),event.toString());
    }

    @Override
    public void eventHoldShort(IAircraft aircraft, String runwayEntrance){
        CommunicationFrequencys frequency = CommunicationFrequencys.Tower;
        EventHoldShort event=new EventHoldShort(aircraft,runwayEntrance,frequency,eventID.getEventID());
        eventBus.post(event);
        theDatabase.addData(aircraft.getId(),event.toString());
    }

    @Override
    public void addAirplane(Subscriber subscriber) {
        eventBus.register(subscriber);
    }

}
