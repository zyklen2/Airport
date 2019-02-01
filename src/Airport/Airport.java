package Airport;
import Aircraft.*;
import People.FlightAttendant;
import People.Pilot;

import java.util.ArrayList;

public class Airport {

    //EVENTID??????????????
    private EventID theEventID=new EventID();
    private ArrayList<Gate> theGates=new ArrayList<Gate>();
    private ArrayList<Pilot[]> thePilots=new ArrayList<>();
    private ArrayList<FlightAttendant[]> theFlightAttendants=new ArrayList<>();
    private ArrayList<Aircraft> theAircrafts =new ArrayList<Aircraft>();
    private ArrayList<Location> theCheckpoints=new ArrayList<Location>();
    private ArrayList<Location> theCrossroads=new ArrayList<Location>();
    private ArrayList<Location> theRunwayConnectors=new ArrayList<Location>();
    private ArrayList<Location> theGateLocations=new ArrayList<Location>();
    AirportOperationsDatabase theAirportOperationsDatabase;
    private Tower theTower;
    private ApronControl theApronControl;
    public Airport(){
        //Tower and ApronControl
        theAirportOperationsDatabase =new AirportOperationsDatabase();
        theTower=new Tower(theAirportOperationsDatabase,theEventID);
        theApronControl=new ApronControl(theAirportOperationsDatabase,theEventID);
        //The Gates
        for(int i=0;i<10;i++){
            Gate tempGate = new Gate(true,GateID.values()[i]);
            theGates.add(tempGate);
        }
        //The Aircrafts
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
            //Add the Airplane as Subscriber to the Tower and ApronControl
            theTower.addAirplane(tempAircraft);
            theApronControl.addAirplane(tempAircraft);
        }


    }

    private void initializeAndSetLocations(){
        String []connectedLocations;


        //PARRALELSPUREN SIND DIREKTER WEG ZUM GATE

        //O-Line
        connectedLocations=new String[]{"O2","N1","N2","X6","X7"};
        theCheckpoints.add(new Location("O1",connectedLocations));
        connectedLocations=new String[]{"O1","O3","N1","N2","N3","X1","X3"};
        theCheckpoints.add(new Location("O2",connectedLocations));
        connectedLocations=new String[]{"O2","O4","N2","N3","N4"};
        theCheckpoints.add(new Location("O3",connectedLocations));
        connectedLocations=new String[]{"O3","O5","N3","N4","N5"};
        theCheckpoints.add(new Location("O4",connectedLocations));
        connectedLocations=new String[]{"O4","O6","N4","N5","N6","X9","X11"};
        theCheckpoints.add(new Location("O5",connectedLocations));
        connectedLocations=new String[]{"O5","N5","N6","X13","X15"};
        theCheckpoints.add(new Location("O6",connectedLocations));
        //N-Line
        connectedLocations=new String[]{"N2","O1","O2","X5","X8"};
        theCheckpoints.add(new Location("N1",connectedLocations));
        connectedLocations=new String[]{"N1","N3","O1","O2","O3","X2","X4"};
        theCheckpoints.add(new Location("N2",connectedLocations));
        connectedLocations=new String[]{"N2","N4","O2","O3","O4"};
        theCheckpoints.add(new Location("N3",connectedLocations));
        connectedLocations=new String[]{"N3","N5","O3","O4","O5"};
        theCheckpoints.add(new Location("N4",connectedLocations));
        connectedLocations=new String[]{"N4","N6","O4","O5","O6","X10","X12"};
        theCheckpoints.add(new Location("N5",connectedLocations));
        connectedLocations=new String[]{"N5","O5","O6","X14","X16"};
        theCheckpoints.add(new Location("N6",connectedLocations));
        //M-Line
        connectedLocations=new String[]{"M2","X1","X2"};
        theCheckpoints.add(new Location("M1",connectedLocations));
        connectedLocations=new String[]{"M1","M3","X7","X8"};
        theCheckpoints.add(new Location("M2",connectedLocations));
        connectedLocations=new String[]{"M2","M4"};
        theCheckpoints.add(new Location("M3",connectedLocations));
        connectedLocations=new String[]{"M3","M5"};
        theCheckpoints.add(new Location("M4",connectedLocations));
        connectedLocations=new String[]{"M4","M6","X15","X16"};
        theCheckpoints.add(new Location("M5",connectedLocations));
        connectedLocations=new String[]{"M5","X9","X10"};
        theCheckpoints.add(new Location("M6",connectedLocations));
        //L-Line
        connectedLocations=new String[]{"L2","X3","X4"};
        theCheckpoints.add(new Location("L1",connectedLocations));
        connectedLocations=new String[]{"L1","L3","X5","X6"};
        theCheckpoints.add(new Location("L2",connectedLocations));
        connectedLocations=new String[]{"L2","L4"};
        theCheckpoints.add(new Location("L3",connectedLocations));
        connectedLocations=new String[]{"L3","L5"};
        theCheckpoints.add(new Location("L4",connectedLocations));
        connectedLocations=new String[]{"L4","L6","X13","X14"};
        theCheckpoints.add(new Location("L5",connectedLocations));
        connectedLocations=new String[]{"L5","X11","X12"};
        theCheckpoints.add(new Location("L6",connectedLocations));
        //Crossroads
        connectedLocations=new String[]{"O2","M1"};
        theCrossroads.add(new Location("X1",connectedLocations));
        connectedLocations=new String[]{"N2","M1"};
        theCrossroads.add(new Location("X2",connectedLocations));
        connectedLocations=new String[]{"O2","L1"};
        theCrossroads.add(new Location("X3",connectedLocations));
        connectedLocations=new String[]{"N2","L1"};
        theCrossroads.add(new Location("X4",connectedLocations));
        connectedLocations=new String[]{"L2","N1"};
        theCrossroads.add(new Location("X5",connectedLocations));
        connectedLocations=new String[]{"L2","O1"};
        theCrossroads.add(new Location("X6",connectedLocations));
        connectedLocations=new String[]{"M2","O1"};
        theCrossroads.add(new Location("X7",connectedLocations));
        connectedLocations=new String[]{"M2","N1"};
        theCrossroads.add(new Location("X8",connectedLocations));
        connectedLocations=new String[]{"O2","M6"};
        theCrossroads.add(new Location("X9",connectedLocations));
        connectedLocations=new String[]{"N5","M6"};
        theCrossroads.add(new Location("X10",connectedLocations));
        connectedLocations=new String[]{"O5","L6"};
        theCrossroads.add(new Location("X11",connectedLocations));
        connectedLocations=new String[]{"N5","L6"};
        theCrossroads.add(new Location("X12",connectedLocations));
        connectedLocations=new String[]{"L5","O6"};
        theCrossroads.add(new Location("X13",connectedLocations));
        connectedLocations=new String[]{"L5","N6"};
        theCrossroads.add(new Location("X14",connectedLocations));
        connectedLocations=new String[]{"M5","O6"};
        theCrossroads.add(new Location("X15",connectedLocations));
        connectedLocations=new String[]{"M5","N6"};
        theCrossroads.add(new Location("X16",connectedLocations));
        connectedLocations=new String[]{"O1","N1"};
        //Runway Connectors
        theRunwayConnectors.add(new Location("S1",connectedLocations));
        connectedLocations=new String[]{"M1","L1"};
        theRunwayConnectors.add(new Location("S2",connectedLocations));
        connectedLocations=new String[]{"O6","N6"};
        theRunwayConnectors.add(new Location("S3",connectedLocations));
        connectedLocations=new String[]{"M6","L6"};
        theRunwayConnectors.add(new Location("S4",connectedLocations));
        //Gates
        connectedLocations=new String[]{"N1","N2"};
        theGateLocations.add(new GateLocation(GateID.A01,connectedLocations));
        connectedLocations=new String[]{"N2","N3"};
        theGateLocations.add(new GateLocation(GateID.A02,connectedLocations));
        connectedLocations=new String[]{"N3","N4"};
        theGateLocations.add(new GateLocation(GateID.A03,connectedLocations));
        connectedLocations=new String[]{"N4","N5"};
        theGateLocations.add(new GateLocation(GateID.A04,connectedLocations));
        connectedLocations=new String[]{"N5","N6"};
        theGateLocations.add(new GateLocation(GateID.A05,connectedLocations));
        connectedLocations=new String[]{"M1","M2"};
        theGateLocations.add(new GateLocation(GateID.B01,connectedLocations));
        connectedLocations=new String[]{"M2","M3"};
        theGateLocations.add(new GateLocation(GateID.B02,connectedLocations));
        connectedLocations=new String[]{"M3","M4"};
        theGateLocations.add(new GateLocation(GateID.B03,connectedLocations));
        connectedLocations=new String[]{"M4","M5"};
        theGateLocations.add(new GateLocation(GateID.B04,connectedLocations));
        connectedLocations=new String[]{"M5","M6"};
        theGateLocations.add(new GateLocation(GateID.B05,connectedLocations));
    }

    public void landAndStart(Aircraft aircraftToLand,Aircraft aircraftToStart,String landingRunway,String startRunway,String landingRunwayConnector,String startRunwayConnector,String exactLandPoint,String exactStartpoint,String destinationGateID){
        theTower.eventRunwayClearedToLand(aircraftToLand,landingRunway);
        theTower.eventHoldShort(aircraftToLand,landingRunwayConnector);
        ArrayList<String>theWay=new ArrayList<>();
        theApronControl.eventTaxi(aircraftToStart,startRunwayConnector,theWay,exactStartpoint);
        theApronControl.eventHoldShort(aircraftToStart,startRunway);
        theApronControl.eventTaxi(aircraftToLand,destinationGateID,theWay,destinationGateID);
        theApronControl.eventRunwayClearedForTakeOff(aircraftToStart,startRunway);
    }

    public void landAndStart(){
        Aircraft aircraftToLand=theAircrafts.get(0);
        Aircraft aircraftToStart=theAircrafts.get(1);
        String landingRunway="O8L";
        String startRunway="O8R";
        String landingRunwayConnector="S1";
        String startRunwayConnector="S4";
        String exactStartpoint="M6";
        String destinationGateID="A01";
        theTower.eventRunwayClearedToLand(aircraftToLand,landingRunway);
        theTower.eventHoldShort(aircraftToLand,landingRunwayConnector);
        ArrayList<String>theWay=new ArrayList<>();
        theWay.add("O2");
        theWay.add("O3");
        theWay.add("O4");
        theWay.add("O5");
        theWay.add("X9");
        theApronControl.eventTaxi(aircraftToStart,startRunwayConnector,theWay,exactStartpoint);
        theApronControl.eventHoldShort(aircraftToStart,startRunway);
        ArrayList<String>theWay2=new ArrayList<>();
        theWay2.add("O1");
        theApronControl.eventTaxi(aircraftToLand,destinationGateID,theWay2);
        theApronControl.eventRunwayClearedForTakeOff(aircraftToStart,startRunway);
    }

    public ArrayList<String> getLoggedInformationsToAirplane(AircraftID theID){
        String theAircraftID=theID.toString();
        return theAirportOperationsDatabase.getDataOfAirplane(theAircraftID);
    }

    public ArrayList<String> getAllLoggedData(){
        return theAirportOperationsDatabase.getAllData();
    }

}
