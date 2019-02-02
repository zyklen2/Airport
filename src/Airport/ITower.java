package Airport;

import Aircraft.IAircraft;
import Aircraft.Subscriber;

import java.util.ArrayList;

public interface ITower {
    void eventRunwayClearedToLand(IAircraft aircraft, String runway);

    void eventTaxi(IAircraft aircraft, String destinationRunwayConnector, ArrayList<String> wayToDestination, String exactDestination);

    void eventTaxi(IAircraft aircraft, String destinationRunwayConnector, ArrayList<String> wayToDestination);

    void eventRunwayClearedForTakeOff(IAircraft aircraft, String runway);

    void eventHoldShort(IAircraft aircraft, String runwayEntrance);

    void addAirplane(Subscriber subscriber);
}
