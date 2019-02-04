package IAirport;

import Aircraft.*;

import java.util.ArrayList;

public interface Airport {
    void landAndStart(IAircraft aircraftToLand, IAircraft aircraftToStart, String landingRunway, String landingRunwayConnector, ArrayList<String> theWayToRunway, ArrayList<String> theWayToGate, String startRunwayConnector, String exactStartpoint, String startRunway, String destinationGateID);

    void landAircraft(IAircraft aircraftToLand, String landingRunway);

    void holdShortAircraft(IAircraft aircraft, String runwayConnector);

    void taxtAircraft(IAircraft aircraft, String runwayConnector, ArrayList<String> theWayToRunway, String exactDestination);

    void startAircraft(IAircraft aircraft, String runway);

    void landAndStartExcample();

    ArrayList<String> getLoggedInformationsToAirplane(AircraftID theID);

    ArrayList<IAircraft> getTheAircrafts();

    ArrayList<String> getAllLoggedData();
}
