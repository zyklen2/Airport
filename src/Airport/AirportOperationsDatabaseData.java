package Airport;

import Aircraft.AircraftID;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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
        return "(#Aircraft: "+aircraftID+", Time: "+timeStemp.format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"))+", Message: "+eventMessage+")";
    }
}
