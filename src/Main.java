import Aircraft.*;
import Airport.*;
import People.FlightAttendant;
import People.Pilot;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args){
        IAirport theAirport = new Airport();

        String landingRunway="R1";
        String startRunway="R2";
        String landingRunwayConnector="S1";
        String startRunwayConnector="S4";
        String exactStartpoint="M6";
        String destinationGateID="A01";
        ArrayList<String>theWayToRunway=new ArrayList<>();
        theWayToRunway.add("O2");
        theWayToRunway.add("O3");
        theWayToRunway.add("O4");
        theWayToRunway.add("O5");
        theWayToRunway.add("X9");
        ArrayList<String>theWayToGate=new ArrayList<>();
        theWayToGate.add("O1");

        theAirport.landAndStart(0,landingRunway,landingRunwayConnector,theWayToRunway,theWayToGate,startRunwayConnector,exactStartpoint,startRunway,destinationGateID);
        ArrayList<String> theLogList =theAirport.getAllLoggedData();
        for(int i=0;i<theLogList.size();i++){
            System.out.println(theLogList.get(i));
        }

    }
}
