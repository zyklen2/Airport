package Airport;

import Aircraft.*;

import java.util.ArrayList;

public interface IAirport {
    void landAndStart(int aircraftPairNumber, String landingRunway, String landingRunwayConnector, ArrayList<String> theWayToRunway, ArrayList<String> theWayToGate, String startRunwayConnector, String exactStartpoint, String startRunway, String destinationGateID);

    ArrayList<String> getLoggedInformationsToAircraft(AircraftID theID);

    ArrayList<IAircraft> getTheAircrafts();

    ArrayList<String> getAllLoggedData();

    ArrayList<IDatabaseData> getAllLoggedDataInDatatype();

    String[] getStartingRunway();

    String[] getLandingRunway();
}
