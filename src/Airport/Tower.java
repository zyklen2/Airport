package Airport;
import Aircraft.Subscriber;
import Aircraft.*;
import com.google.common.eventbus.EventBus;

import java.util.ArrayList;

public class Tower implements ITower {
    private EventBus eventBus;
    private EventID eventID;
    private IAirportOperationsDatabase theDatabase;
    private CommunicationFrequencys theFrequency= CommunicationFrequencys.Tower;
    public Tower(IAirportOperationsDatabase theDatabase,EventID theEventID) {
        this.eventBus = new EventBus();
        eventID=theEventID;
        this.theDatabase=theDatabase;
    }

    @Override
    public void eventRunwayClearedToLand(IAircraft aircraft, String runway) {
        EventRunwayClearedToLand event=new EventRunwayClearedToLand(aircraft,runway,theFrequency,eventID.getEventID());
        eventBus.post(event);
        theDatabase.addData(aircraft.getId(),event.toString());
    }

    @Override
    public void eventTaxi(IAircraft aircraft, String destinationRunwayConnector, ArrayList<String> wayToDestination, String exactDestination,boolean toGate) {
        EventTaxi event=new EventTaxi(aircraft,destinationRunwayConnector,wayToDestination,exactDestination,theFrequency,eventID.getEventID(),toGate);
        eventBus.post(event);
        theDatabase.addData(aircraft.getId(),event.toString());
    }

    @Override
    public void eventRunwayClearedForTakeOff(IAircraft aircraft, String runway){
        EventRunwayClearedForTakeOff event=new EventRunwayClearedForTakeOff(aircraft,runway,theFrequency,eventID.getEventID());
        eventBus.post(event);
        theDatabase.addData(aircraft.getId(),event.toString());
    }

    @Override
    public void eventHoldShort(IAircraft aircraft, String runwayEntrance){
        EventHoldShort event=new EventHoldShort(aircraft,runwayEntrance,theFrequency,eventID.getEventID());
        eventBus.post(event);
        theDatabase.addData(aircraft.getId(),event.toString());
    }

    @Override
    public void addAirplane(Subscriber subscriber) {
        eventBus.register(subscriber);
    }

}