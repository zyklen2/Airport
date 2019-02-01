import Aircraft.*;
import Airport.*;
import People.FlightAttendant;
import People.Pilot;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args){
        EventID theEventID=new EventID();
        ArrayList<Pilot[]> thePilots=new ArrayList<>();
        ArrayList<FlightAttendant[]> theFlightAttendants=new ArrayList<>();
        ArrayList<Aircraft> theAircrafts =new ArrayList<Aircraft>();
        Airport theAirport = new Airport();
        AirportOperationsDatabase theDatabase=new AirportOperationsDatabase();
        Tower theTower=new Tower(theDatabase,theEventID);
        ApronControl theApronControl=new ApronControl(theDatabase,theEventID);
        for(int i=0;i<10;i++){
            Pilot[] pilots=new Pilot[2];
            FlightAttendant[] flightAttendants=new FlightAttendant[3];
            for(int j=0;j<2;j++){
                Pilot tempPilot=new Pilot();
                pilots[j]=tempPilot;
            }
            for(int j=0;j<3;j++){
                FlightAttendant flightAttendant=new FlightAttendant();
                flightAttendants[j]=flightAttendant;
            }
            Crew theCrew = new Crew(pilots,flightAttendants);
            AircraftID theAircraftID=AircraftID.F01;
            switch (i+1){
                case 1:
                    theAircraftID=AircraftID.F01;
                    break;
                case 2:
                    theAircraftID=AircraftID.F02;
                    break;
                case 3:
                    theAircraftID=AircraftID.F03;
                    break;
                case 4:
                    theAircraftID=AircraftID.F04;
                    break;
                case 5:
                    theAircraftID=AircraftID.F05;
                    break;
                case 6:
                    theAircraftID=AircraftID.F06;
                    break;
                case 7:
                    theAircraftID=AircraftID.F07;
                    break;
                case 8:
                    theAircraftID=AircraftID.F08;
                    break;
                case 9:
                    theAircraftID=AircraftID.F09;
                    break;
                case 10:
                    theAircraftID=AircraftID.F10;
                    break;
                case 11:
                    theAircraftID=AircraftID.F11;
                    break;
                case 12:
                    theAircraftID=AircraftID.F12;
                    break;
                case 13:
                    theAircraftID=AircraftID.F13;
                    break;
                case 14:
                    theAircraftID=AircraftID.F14;
                    break;
                case 15:
                    theAircraftID=AircraftID.F15;
                    break;
                case 16:
                    theAircraftID=AircraftID.F16;
                    break;
                case 17:
                    theAircraftID=AircraftID.F17;
                    break;
                case 18:
                    theAircraftID=AircraftID.F18;
                    break;
                case 19:
                    theAircraftID=AircraftID.F19;
                    break;
                case 20:
                    theAircraftID=AircraftID.F20;
                    break;
            }

            Aircraft tempAircraft = new Aircraft(theAircraftID,"Airbus",100,150,318,theCrew);
            theAircrafts.add(tempAircraft);
            thePilots.add(pilots);
            theFlightAttendants.add(flightAttendants);
            theTower.addAirplane(tempAircraft);
            theApronControl.addAirplane(tempAircraft);
        }

        /*theTower.eventHoldShort(theAircrafts.get(0),"S1");
        ArrayList<String> theWayToDestination=new ArrayList<>();
        theWayToDestination.add("O1");
        theApronControl.eventTaxi(theAircrafts.get(3),"A01",theWayToDestination);*/
        theAirport.landAndStart();
        ArrayList<String> theLogList =theAirport.getAllLoggedData();
        for(int i=0;i<theLogList.size();i++){
            System.out.println(theLogList.get(i));
        }
    }
}