import Aircraft.*;
import Airport.*;
import People.FlightAttendant;
import People.Pilot;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args){
        IAirport theAirport = new Airport();
        LandAndStartExcampleData theData=new LandAndStartExcampleData(theAirport.getStartingRunway(),theAirport.getLandingRunway());
        ArrayList<String> alLandingRunway=theData.getAlLandingRunway();
        ArrayList<String> alStartRunway=theData.getAlStartRunway();
        ArrayList<String> alLandingRunwayConnector=theData.getAlLandingRunwayConnector();
        ArrayList<String> alStartRunwayConnector=theData.getAlStartRunwayConnector();
        ArrayList<String> alExactStartpoint=theData.getAlExactStartpoint();
        ArrayList<String> alDestinationGateID=theData.getAlDestinationGateID();
        ArrayList<ArrayList<String>> alTheWay=theData.getAlTheWay();
        ArrayList<ArrayList<String>> alTheWay2=theData.getAlTheWay2();
        for(int i=0;i<10;i++) {
            String landingRunway = alLandingRunway.get(i);
            String startRunway = alStartRunway.get(i);
            String landingRunwayConnector = alLandingRunwayConnector.get(i);
            String startRunwayConnector = alStartRunwayConnector.get(i);
            String exactStartpoint = alExactStartpoint.get(i);
            String destinationGateID = alDestinationGateID.get(i);
            ArrayList<String> theWayToRunway = alTheWay.get(i);
            ArrayList<String> theWayToGate = alTheWay2.get(i);
            theAirport.landAndStart(i, landingRunway, landingRunwayConnector, theWayToRunway, theWayToGate, startRunwayConnector, exactStartpoint, startRunway, destinationGateID);
        }
        ArrayList<String> theLogList =theAirport.getAllLoggedData();
        for(int i=0;i<theLogList.size();i++){
            System.out.println(theLogList.get(i));
        }
        String winddirection="";
        if(theAirport.getLandingRunway()[0]=="08L"){
            winddirection="east";
        }
        else{
            winddirection="west";
        }
        System.out.println("Events in total: "+theLogList.size()+", winddirection: "+winddirection);
    }
}
