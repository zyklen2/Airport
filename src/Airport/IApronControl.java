package Airport;

import Aircraft.*;

import java.util.ArrayList;

public interface IApronControl {
    void eventRunwayClearedToLand(IAircraft aircraft, String runway);

    void eventTaxi(IAircraft aircraft, String destinationRunwayConnector, ArrayList<String> wayToDestination, String exactDestination,boolean toGate);

    void eventRunwayClearedForTakeOff(IAircraft aircraft, String runway);

    void eventHoldShort(IAircraft aircraft, String runwayEntrance);

    void addAirplane(Subscriber subscriber);
}
