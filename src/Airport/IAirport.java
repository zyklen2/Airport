package Airport;

import Aircraft.*;

import java.util.ArrayList;

public interface IAirport {
    void landAndStart(Aircraft aircraftToLand, Aircraft aircraftToStart, String landingRunway, String landingRunwayConnector, ArrayList<String> theWayToRunway, ArrayList<String> theWayToGate, String startRunwayConnector, String exactStartpoint, String startRunway, String destinationGateID);

    void landAndStartExcample();

    ArrayList<String> getLoggedInformationsToAirplane(AircraftID theID);

    ArrayList<String> getAllLoggedData();
}
