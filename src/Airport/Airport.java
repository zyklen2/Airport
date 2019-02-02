package Airport;
import Aircraft.*;
import People.FlightAttendant;
import People.Pilot;

import java.util.ArrayList;

public class Airport implements IAirport {

    //EVENTID??????????????
    private EventID theEventID=new EventID();
    private ArrayList<IGate> theGates=new ArrayList<>();
    private ArrayList<Pilot[]> thePilots=new ArrayList<>();
    private ArrayList<FlightAttendant[]> theFlightAttendants=new ArrayList<>();
    private ArrayList<IAircraft> theAircrafts =new ArrayList<>();
    private ArrayList<ILocation> theLocations =new ArrayList<ILocation>();
    IAirportOperationsDatabase theAirportOperationsDatabase;
    private ITower theTower;
    private IApronControl theApronControl;
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
            initializeAndSetLocations();
        }


    }

    private void initializeAndSetLocations(){
        String []connectedLocations;


        //PARRALELSPUREN SIND DIREKTER WEG ZUM GATE

        //O-Line
        connectedLocations=new String[]{"O2","A01","N1","N2","X6","X7"};
        theLocations.add(new Location("O1",connectedLocations));
        connectedLocations=new String[]{"O1","O3","A01","A02","N1","N2","N3","X1","X3"};
        theLocations.add(new Location("O2",connectedLocations));
        connectedLocations=new String[]{"O2","O4","A02","A03","N2","N3","N4"};
        theLocations.add(new Location("O3",connectedLocations));
        connectedLocations=new String[]{"O3","O5","A03","A04","N3","N4","N5"};
        theLocations.add(new Location("O4",connectedLocations));
        connectedLocations=new String[]{"O4","O6","A04","A05","N4","N5","N6","X9","X11"};
        theLocations.add(new Location("O5",connectedLocations));
        connectedLocations=new String[]{"O5","A05","N5","N6","X13","X15"};
        theLocations.add(new Location("O6",connectedLocations));
        //N-Line
        connectedLocations=new String[]{"N2","A01","O1","O2","X5","X8"};
        theLocations.add(new Location("N1",connectedLocations));
        connectedLocations=new String[]{"N1","N3","A01","O1","O2","O3","X2","X4"};
        theLocations.add(new Location("N2",connectedLocations));
        connectedLocations=new String[]{"N2","N4","A02","A03","O2","O3","O4"};
        theLocations.add(new Location("N3",connectedLocations));
        connectedLocations=new String[]{"N3","N5","A03","A04","O3","O4","O5"};
        theLocations.add(new Location("N4",connectedLocations));
        connectedLocations=new String[]{"N4","N6","A04","A05","O4","O5","O6","X10","X12"};
        theLocations.add(new Location("N5",connectedLocations));
        connectedLocations=new String[]{"N5","A05","O5","O6","X14","X16"};
        theLocations.add(new Location("N6",connectedLocations));
        //M-Line
        connectedLocations=new String[]{"M2","B01","L1","L2","X1","X2"};
        theLocations.add(new Location("M1",connectedLocations));
        connectedLocations=new String[]{"M1","M3","B01","B02","L1","L2","L3","X7","X8"};
        theLocations.add(new Location("M2",connectedLocations));
        connectedLocations=new String[]{"M2","M4","B02","B03","L2","L3","L4"};
        theLocations.add(new Location("M3",connectedLocations));
        connectedLocations=new String[]{"M3","M5","B03","B04","L3","L4","L5",};
        theLocations.add(new Location("M4",connectedLocations));
        connectedLocations=new String[]{"M4","M6","B04","B05","L4","L5","L6","X15","X16"};
        theLocations.add(new Location("M5",connectedLocations));
        connectedLocations=new String[]{"M5","B05","L5","L6","X9","X10"};
        theLocations.add(new Location("M6",connectedLocations));
        //L-Line
        connectedLocations=new String[]{"L2","B01","M1","M2","X3","X4"};
        theLocations.add(new Location("L1",connectedLocations));
        connectedLocations=new String[]{"L1","L3","B01","B02","M1","M2","M3","X5","X6"};
        theLocations.add(new Location("L2",connectedLocations));
        connectedLocations=new String[]{"L2","L4","B02","B03","M2","M3","M4"};
        theLocations.add(new Location("L3",connectedLocations));
        connectedLocations=new String[]{"L3","L5","B03","B04","M3","M4","M5"};
        theLocations.add(new Location("L4",connectedLocations));
        connectedLocations=new String[]{"L4","L6","B04","B05","M4","M5","M6","X13","X14"};
        theLocations.add(new Location("L5",connectedLocations));
        connectedLocations=new String[]{"L5","B05","M5","M6","X11","X12"};
        theLocations.add(new Location("L6",connectedLocations));
        //Crossroads
        connectedLocations=new String[]{"O2","M1"};
        theLocations.add(new Location("X1",connectedLocations));
        connectedLocations=new String[]{"N2","M1"};
        theLocations.add(new Location("X2",connectedLocations));
        connectedLocations=new String[]{"O2","L1"};
        theLocations.add(new Location("X3",connectedLocations));
        connectedLocations=new String[]{"N2","L1"};
        theLocations.add(new Location("X4",connectedLocations));
        connectedLocations=new String[]{"L2","N1"};
        theLocations.add(new Location("X5",connectedLocations));
        connectedLocations=new String[]{"L2","O1"};
        theLocations.add(new Location("X6",connectedLocations));
        connectedLocations=new String[]{"M2","O1"};
        theLocations.add(new Location("X7",connectedLocations));
        connectedLocations=new String[]{"M2","N1"};
        theLocations.add(new Location("X8",connectedLocations));
        connectedLocations=new String[]{"O2","M6"};
        theLocations.add(new Location("X9",connectedLocations));
        connectedLocations=new String[]{"N5","M6"};
        theLocations.add(new Location("X10",connectedLocations));
        connectedLocations=new String[]{"O5","L6"};
        theLocations.add(new Location("X11",connectedLocations));
        connectedLocations=new String[]{"N5","L6"};
        theLocations.add(new Location("X12",connectedLocations));
        connectedLocations=new String[]{"L5","O6"};
        theLocations.add(new Location("X13",connectedLocations));
        connectedLocations=new String[]{"L5","N6"};
        theLocations.add(new Location("X14",connectedLocations));
        connectedLocations=new String[]{"M5","O6"};
        theLocations.add(new Location("X15",connectedLocations));
        connectedLocations=new String[]{"M5","N6"};
        theLocations.add(new Location("X16",connectedLocations));
        connectedLocations=new String[]{"O1","N1"};
        //Runway Connectors
        connectedLocations=new String[]{"O1","N1"};
        theLocations.add(new Location("S1",connectedLocations));
        connectedLocations=new String[]{"M1","L1"};
        theLocations.add(new Location("S2",connectedLocations));
        connectedLocations=new String[]{"O6","N6"};
        theLocations.add(new Location("S3",connectedLocations));
        connectedLocations=new String[]{"M6","L6"};
        theLocations.add(new Location("S4",connectedLocations));
        //Gates
        connectedLocations=new String[]{"N1","N2","O1","O2"};
        theLocations.add(new Location(GateID.A01.toString(),connectedLocations));
        connectedLocations=new String[]{"N2","N3","O2","O3"};
        theLocations.add(new Location(GateID.A02.toString(),connectedLocations));
        connectedLocations=new String[]{"N3","N4","O3","O4"};
        theLocations.add(new Location(GateID.A03.toString(),connectedLocations));
        connectedLocations=new String[]{"N4","N5","N4","N5"};
        theLocations.add(new Location(GateID.A04.toString(),connectedLocations));
        connectedLocations=new String[]{"N5","N6","N5","N6"};
        theLocations.add(new Location(GateID.A05.toString(),connectedLocations));
        connectedLocations=new String[]{"M1","M2","L1","L2"};
        theLocations.add(new Location(GateID.B01.toString(),connectedLocations));
        connectedLocations=new String[]{"M2","M3","L2","L3"};
        theLocations.add(new Location(GateID.B02.toString(),connectedLocations));
        connectedLocations=new String[]{"M3","M4","L3","L4"};
        theLocations.add(new Location(GateID.B03.toString(),connectedLocations));
        connectedLocations=new String[]{"M4","M5","L4","L5"};
        theLocations.add(new Location(GateID.B04.toString(),connectedLocations));
        connectedLocations=new String[]{"M5","M6","L5","L6"};
        theLocations.add(new Location(GateID.B05.toString(),connectedLocations));
        connectedLocations=new String[]{"M5","M6","L5","L6"};
        //Runways
        connectedLocations=new String[]{"S2"};
        theLocations.add(new Location("08L",connectedLocations));
        connectedLocations=new String[]{"S4"};
        theLocations.add(new Location("08R",connectedLocations));
        connectedLocations=new String[]{"S1"};
        theLocations.add(new Location("26R",connectedLocations));
        connectedLocations=new String[]{"S3"};
        theLocations.add(new Location("26L",connectedLocations));
    }

    @Override
    public void landAndStart(Aircraft aircraftToLand, Aircraft aircraftToStart, String landingRunway, String landingRunwayConnector, ArrayList<String> theWayToRunway, ArrayList<String> theWayToGate, String startRunwayConnector, String exactStartpoint, String startRunway, String destinationGateID){
        theTower.eventRunwayClearedToLand(aircraftToLand,landingRunway);
        theTower.eventHoldShort(aircraftToLand,landingRunwayConnector);
        theApronControl.eventTaxi(aircraftToStart,startRunwayConnector,theWayToRunway,exactStartpoint);
        theApronControl.eventHoldShort(aircraftToStart,startRunway);
        theApronControl.eventTaxi(aircraftToLand,destinationGateID,theWayToGate,destinationGateID);
        theApronControl.eventRunwayClearedForTakeOff(aircraftToStart,startRunway);
    }

    @Override
    public void landAndStartExcample(){
        IAircraft aircraftToLand=theAircrafts.get(0);
        IAircraft aircraftToStart=theAircrafts.get(1);
        String landingRunway="08L";
        String startRunway="08R";
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

    @Override
    public ArrayList<String> getLoggedInformationsToAirplane(AircraftID theID){
        String theAircraftID=theID.toString();
        return theAirportOperationsDatabase.getDataOfAirplane(theAircraftID);
    }

    @Override
    public ArrayList<String> getAllLoggedData(){
        return theAirportOperationsDatabase.getAllData();
    }

}
