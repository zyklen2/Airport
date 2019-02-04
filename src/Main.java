import Aircraft.*;
import Airport.*;
import People.FlightAttendant;
import People.Pilot;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args){
        IAirport theAirport = new Airport();
        //theAirport.landAndStart();
        /*Aircraft aircraftToLand=theAircrafts.get(0);
        Aircraft aircraftToStart=theAircrafts.get(1);
        String landingRunway="08L";
        String startRunway="08R";
        String landingRunwayConnector="S1";
        String startRunwayConnector="S4";
        String exactStartpoint="M6";
        String destinationGateID="A01";
        theTower.eventRunwayClearedToLand(aircraftToLand,landingRunway);
        theTower.eventHoldShort(aircraftToLand,landingRunwayConnector);
        ArrayList<String>theWayToRunway=new ArrayList<>();
        theWayToRunway.add("O2");
        theWayToRunway.add("O3");
        theWayToRunway.add("O4");
        theWayToRunway.add("O5");
        theWayToRunway.add("X9");
        theApronControl.eventTaxi(aircraftToStart,startRunwayConnector,theWayToRunway,exactStartpoint);
        theApronControl.eventHoldShort(aircraftToStart,startRunway);
        ArrayList<String>theWayToGate=new ArrayList<>();
        theWayToGate.add("O1");
        theAirport.landAndStart(aircraftToLand,aircraftToStart,landingRunway,landingRunwayConnector,theWayToRunway,theWayToGate,startRunwayConnector,exactStartpoint,startRunway,destinationGateID);
        ArrayList<String> theLogList =theAirport.getAllLoggedData();
        for(int i=0;i<theLogList.size();i++){
            System.out.println(theLogList.get(i));
        }*/
        theAirport.landAndStartExcample();
    }
}
