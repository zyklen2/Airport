package Airport;

import Aircraft.AircraftID;

import java.time.LocalDateTime;

public class AirportOperationsDatabaseData {
    private AircraftID aircraftID;
    private LocalDateTime timeStemp;
    private String eventMessage;
    public AirportOperationsDatabaseData(AircraftID aircraftID, String eventMessage){
        this.aircraftID=aircraftID;
        timeStemp=LocalDateTime.now();
        this.eventMessage=eventMessage;
    }

    public AircraftID getAircraftID(){
        return aircraftID;
    }

    public String getDataInformation(){
        return "#"+aircraftID+","+timeStemp+","+eventMessage;
    }
}
