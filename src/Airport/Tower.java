package Airport;
import Aircraft.Subscriber;
import Aircraft.*;
import com.google.common.eventbus.EventBus;

import java.util.ArrayList;

public class Tower {
    private EventBus eventBus;
    private int eventID;
    private AirportOperationsDatabase theDatabase;
    public Tower(AirportOperationsDatabase theDatabase) {
        this.eventBus = new EventBus();
        eventID=0;
        this.theDatabase=theDatabase;
    }

    public void eventRunwayClearedToLand(Aircraft aircraft, String runway) {
        eventBus.post(new EventRunwayClearedToLand(aircraft,runway,eventID++));
        theDatabase.addData(aircraft.getId(),"eventRunwayClearedToLand");
    }

    public void eventTaxi(Aircraft aircraft, String destinationRunwayConnector, ArrayList<String> wayToDestination, String exactDestination) {
        eventBus.post(new EventTaxi(aircraft,destinationRunwayConnector,wayToDestination,exactDestination,eventID++));
        theDatabase.addData(aircraft.getId(),"eventTaxi");
    }

    public void eventRunwayClearedForTakeOff(Aircraft aircraft, String runway){
        eventBus.post(new EventRunwayClearedToLand(aircraft,runway,eventID++));
        theDatabase.addData(aircraft.getId(),"eventRunwayClearedForTakeOff");
    }

    public void eventHoldShort(Aircraft aircraft, String runwayEntrance){
        CommunicationFrequencys frequency = CommunicationFrequencys.Tower;
        eventBus.post(new EventHoldShort(aircraft,runwayEntrance,frequency,eventID++));
        theDatabase.addData(aircraft.getId(),"eventHoldShort");
    }

    public void addAirplane(Subscriber subscriber) {
        eventBus.register(subscriber);
    }

}