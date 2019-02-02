package Airport;

import Aircraft.AircraftID;

public interface IAirportOperationsDatabaseData {
    AircraftID getAircraftID();

    String getDataInformation();
}
