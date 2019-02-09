package Airport;

import Aircraft.AircraftID;

import java.util.ArrayList;

public interface IAirportOperationsDatabase {
    void addData(AircraftID aircraftID, String eventMessage);

    ArrayList<String> getDataOfAirplane(String aircraftID);

    ArrayList<String> getAllData();

    ArrayList<IDatabaseData> getAllDataInDatatype();
}
