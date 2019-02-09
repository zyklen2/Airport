package Airport;
import Aircraft.*;
import com.google.common.eventbus.EventBus;

import java.util.ArrayList;

public class ApronControl implements IApronControl {
    private EventBus eventBus;
    private IEventID eventID;
    private IAirportOperationsDatabase theDatabase;
    private CommunicationFrequencys theFrequency = CommunicationFrequencys.ApronControl;

    public ApronControl(IAirportOperationsDatabase theDatabase,IEventID theEventID) {
        this.eventBus = new EventBus();
        eventID=theEventID;
        this.theDatabase=theDatabase;
    }

    @Override
    public void eventTaxi(IAircraft aircraft, String destinationRunwayConnector, ArrayList<String> wayToDestination, String exactDestination,boolean toGate) {
        EventTaxi event=new EventTaxi(aircraft,destinationRunwayConnector,wayToDestination,exactDestination,theFrequency,eventID.getEventID(),toGate);
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
    public void addAircraft(Subscriber subscriber) {
        eventBus.register(subscriber);
    }

}
