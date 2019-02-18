package Tests;
import Aircraft.*;
import Airport.*;
import People.FlightAttendant;
import People.Pilot;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class TestsAirport {
    @Test
    public void testAirport(){
        Airport theAirport=new Airport();
        String eventMsg="";
        String landingRunway = "";
        String startRunway = "";
        String landingRunwayConnector = "";
        String startRunwayConnector = "";
        String exactStartpoint = "";
        String destinationGateID = "";
        ArrayList<String> theWayToRunway = new ArrayList<>();
        ArrayList<String> theWayToGate = new ArrayList<>();
        if(theAirport.getLandingRunway()[0]=="08L") {
            landingRunway  = theAirport.getLandingRunway()[0];
            startRunway = theAirport.getStartingRunway()[0];
            landingRunwayConnector = "S1";
            startRunwayConnector = "S4";
            exactStartpoint = "M6";
            destinationGateID = "A01";
            theWayToRunway = new ArrayList<>();
            theWayToRunway.add("O2");
            theWayToRunway.add("O3");
            theWayToRunway.add("O4");
            theWayToRunway.add("O5");
            theWayToRunway.add("X9");
            theWayToGate = new ArrayList<>();
            theWayToGate.add("O1");
            eventMsg="{EventRunwayClearedToLand :  eventID = 0 frequency = 128.5 aircraft = F11 runway = 08L}";
        }
        else{
            landingRunway  = theAirport.getLandingRunway()[0];
            startRunway = theAirport.getStartingRunway()[0];
            landingRunwayConnector = "S2";
            startRunwayConnector = "S3";
            exactStartpoint = "N6";
            destinationGateID = "A01";
            theWayToRunway = new ArrayList<>();
            theWayToRunway.add("N2");
            theWayToRunway.add("N3");
            theWayToRunway.add("N4");
            theWayToRunway.add("N5");
            theWayToGate = new ArrayList<>();
            theWayToGate.add("M1");
            theWayToGate.add("X2");
            theWayToGate.add("N2");
            eventMsg="{EventRunwayClearedToLand :  eventID = 0 frequency = 128.5 aircraft = F11 runway = 26R}";

        }
        theAirport.landAndStart(0,landingRunway,landingRunwayConnector,theWayToRunway,theWayToGate,startRunwayConnector,exactStartpoint,startRunway,destinationGateID);
        //Hängt vom zufallsfaktor Wind ab, kann also je nach wind wahr oder falsch sein
        assertEquals(eventMsg,theAirport.getAllLoggedDataInDatatype().get(0).getEventMessage());
        assertEquals("Flying",theAirport.getTheAircrafts().get(0).getCurrentStatus());
        //getLoggedInformationsToAircraft und getAllLoggedData kann nicht getestet werden, da durch den Zeitstempel ein abgleich nicht möglich ist
        //getStartingRunway und getLandingRunway wurden weiter oben indirekt mitgetestet da ohne ihr volle Funktionalität der Ablauf nicht funktionieren würde
    }

    @Test
    public void testOperationsDatabase(){
        IAirportOperationsDatabase theDatabase=new AirportOperationsDatabase();
        String eventMsg="{EventRunwayClearedToLand :  eventID = 0 frequency = 128.5 aircraft = F11 runway = 26R}";
        AircraftID theID=AircraftID.F11;
        theDatabase.addData(theID,eventMsg);//Indirekt über die nachfolgenden abfragen geprüft
        assertEquals("{EventRunwayClearedToLand :  eventID = 0 frequency = 128.5 aircraft = F11 runway = 26R}",theDatabase.getAllDataInDatatype().get(0).getEventMessage());
        assertEquals("{EventRunwayClearedToLand :  eventID = 0 frequency = 128.5 aircraft = F11 runway = 26R}",theDatabase.getDataOfAirplane(theID.toString()));
        //getAllData kann nicht geprüft werden, da der rückgabewert einen Zeitstempel enthält, der nicht beeinflusst werden kann.
    }

    @Test
    public void testApronControl(){
        IAirportOperationsDatabase theDatabase=new AirportOperationsDatabase();
        IEventID theEventID = new EventID();
        IApronControl theApronControl = new ApronControl(theDatabase,theEventID);
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
        Aircraft theAircraft = new Aircraft(AircraftID.F01,"Boing",100,200,268,"Flying","Flying",theCrew);
        theApronControl.addAircraft(theAircraft);
        assertEquals("Flying",theAircraft.getLocation());
        theApronControl.eventHoldShort(theAircraft,"S1");
        assertEquals("S1",theAircraft.getLocation());
        String runwayConnector="S4";
        ArrayList<String> theWay=new ArrayList<>();
        theWay.add("O2");
        theWay.add("O3");
        theWay.add("O4");
        theWay.add("O5");
        theWay.add("X9");
        String exactStartpoint="M6";
        theApronControl.eventTaxi(theAircraft,runwayConnector,theWay,exactStartpoint,false);
        assertEquals("S4",theAircraft.getLocation());
    }

    @Test
    public void testDatabaseData(){
        AircraftID theID = AircraftID.F01;
        String eventMsg = "{EventRunwayClearedToLand :  eventID = 0 frequency = 128.5 aircraft = F11 runway = 26R}";
        IDatabaseData theData = new DatabaseData(theID,eventMsg);
        assertEquals(theID,theData.getAircraftID());
        assertEquals(eventMsg,theData.getEventMessage());
        //getDataInformation kann nicht getestet werden, da es einen Zeitstempel enthält der nicht beeinflusst werden kann
    }

    @Test
    public void testEventID(){
        IEventID eventID = new EventID();
        assertEquals(eventID.getEventID()+1,eventID.getEventID());
    }

    @Test
    public void testIGate(){
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
        Aircraft theAircraft = new Aircraft(AircraftID.F01,"Boing",100,200,268,"Flying","Flying",theCrew);
        IGate theGate = new Gate(true,GateID.A01);
        theGate.addAircraft(theAircraft);
        assertEquals(theAircraft,theGate.getTheAircraft());
        Aircraft theAircraft2 = new Aircraft(AircraftID.F02,"Boing",100,200,268,"Flying","Flying",theCrew);
        theGate.addAircraft(theAircraft2);
        assertEquals(theAircraft2,theGate.getTheAircraft());
        theGate.resetAircraft();
        assertEquals(null,theGate.getTheAircraft());
        assertEquals(GateID.A01,theGate.getGateID());
    }

    @Test
    public void testLocation(){
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
        Aircraft theAircraft = new Aircraft(AircraftID.F01,"Boing",100,200,268,"Flying","Flying",theCrew);

        String[] connectedLocations=new String[]{"O2","A01","N1","N2","X6","X7"};
        ILocation theLocation = new Location("O1",connectedLocations);
        assertEquals("O1",theLocation.getLocationID());
        theLocation.addAircraft(theAircraft);
        assertEquals(theAircraft,theLocation.getCurrentAircraft());
        assertEquals(connectedLocations,theLocation.getConnectedLocations());
        assertEquals(true,theLocation.hasAircraft());
        theLocation.resetCurrentAircraft();
        assertEquals(null,theLocation.getCurrentAircraft());
    }

    @Test
    public void testTower(){
        IAirportOperationsDatabase theDatabase=new AirportOperationsDatabase();
        IEventID theEventID = new EventID();
        ITower theTower = new Tower(theDatabase,theEventID);
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
        Aircraft theAircraft = new Aircraft(AircraftID.F01,"Boing",100,200,268,"Flying","Flying",theCrew);
        theTower.addAircraft(theAircraft);
        assertEquals("Flying",theAircraft.getLocation());
        theTower.eventHoldShort(theAircraft,"S1");
        assertEquals("S1",theAircraft.getLocation());
        String landingRunway="08L";
        theTower.eventRunwayClearedToLand(theAircraft,landingRunway);
        assertEquals(landingRunway,theAircraft.getLocation());
        String startingRunway="08R";
        theTower.eventRunwayClearedForTakeOff(theAircraft,startingRunway);
        assertEquals("Flying",theAircraft.getLocation());
    }
}
