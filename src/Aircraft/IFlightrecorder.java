package Aircraft;

import java.util.ArrayList;

public interface IFlightrecorder {
    void addData(AircraftID aircraftID, String eventMessage);

    ArrayList<String> getAllData();
}
