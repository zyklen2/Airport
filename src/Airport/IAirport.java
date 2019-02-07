package Airport;

import Aircraft.*;

import java.util.ArrayList;

public interface IAirport {
    void landAndStart(int aircraftPairNumber, String landingRunway, String landingRunwayConnector, ArrayList<String> theWayToRunway, ArrayList<String> theWayToGate, String startRunwayConnector, String exactStartpoint, String startRunway, String destinationGateID);

    void landAircraft(IAircraft aircraftToLand, String landingRunway);

    void holdShortAircraftApronControl(IAircraft aircraft, String runwayConnector);

    void holdShortAircraftTower(IAircraft aircraft, String runwayConnector);

    void taxiAircraft(IAircraft aircraft, String runwayConnector, ArrayList<String> theWayToRunway, String exactDestination);

    void startAircraft(IAircraft aircraft, String runway);

    void landAndStartExcample();

    ArrayList<String> getLoggedInformationsToAirplane(AircraftID theID);

    ArrayList<IAircraft> getTheAircrafts();

    ArrayList<String> getAllLoggedData();
}
