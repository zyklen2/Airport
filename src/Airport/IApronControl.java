package Airport;

import Aircraft.*;

import java.util.ArrayList;

public interface IApronControl {

    void eventTaxi(IAircraft aircraft, String destinationRunwayConnector, ArrayList<String> wayToDestination, String exactDestination,boolean toGate);

    void eventHoldShort(IAircraft aircraft, String runwayEntrance);

    void addAircraft(Subscriber subscriber);
}
