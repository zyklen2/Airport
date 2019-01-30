package Airport;
import Aircraft.Aircraft;
import java.util.ArrayList;

public class Airport {
    private ArrayList<Gate> theGates=new ArrayList<Gate>();
    private ArrayList<Aircraft> theAircrafts =new ArrayList<Aircraft>();
    private ArrayList<Location> theCheckpoints=new ArrayList<Location>();
    private ArrayList<Location> theCrossroads=new ArrayList<Location>();
    private ArrayList<Location> theRunwayConnectors=new ArrayList<Location>();
    private ArrayList<Location> theGateLocations=new ArrayList<Location>();
    AirportOperationsDatabase theAirportOperationsDatabase =new AirportOperationsDatabase();
    private Tower theTower=new Tower(theAirportOperationsDatabase);
    private ApronControl theApronControl=new ApronControl(theAirportOperationsDatabase);
    public Airport(){
        for(int i=0;i<10;i++){
            Gate tempGate = new Gate(true,GateID.values()[i]);
            theGates.add(tempGate);
        }

    }

    private void initializeAndSetLocations(){
        String []connectedLocations;
        //O-Line
        connectedLocations=new String[]{"O2","N1","N2","X6","X7"};
        theCheckpoints.add(new Location("O1",connectedLocations));
        connectedLocations=new String[]{"O1","O3","N1","N2","N3","X1","X3"};
        theCheckpoints.add(new Location("O2",connectedLocations));
        connectedLocations=new String[]{"O2","O4"};
        theCheckpoints.add(new Location("O3",connectedLocations));
        connectedLocations=new String[]{"O3","O5"};
        theCheckpoints.add(new Location("O4",connectedLocations));
        connectedLocations=new String[]{"O4","O6","X9","X11"};
        theCheckpoints.add(new Location("O5",connectedLocations));
        connectedLocations=new String[]{"O5","X13","X15"};
        theCheckpoints.add(new Location("O6",connectedLocations));
        //N-Line
        connectedLocations=new String[]{"N2","X5","X8"};
        theCheckpoints.add(new Location("N1",connectedLocations));
        connectedLocations=new String[]{"N1","N3","X2","X4"};
        theCheckpoints.add(new Location("N2",connectedLocations));
        theGates.get(0).setConnectedLocation(theCheckpoints.get(8));
        connectedLocations=new String[]{"N2","N4"};
        theCheckpoints.add(new Location("N3",connectedLocations));
        connectedLocations=new String[]{"N3","N5"};
        theCheckpoints.add(new Location("N4",connectedLocations));
        connectedLocations=new String[]{"N4","N6","X10","X12"};
        theCheckpoints.add(new Location("N5",connectedLocations));
        connectedLocations=new String[]{"N5","X14","X16"};
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
        theRunwayConnectors.add(new Location("S1",connectedLocations));
        connectedLocations=new String[]{"M1","L1"};
        theRunwayConnectors.add(new Location("S2",connectedLocations));
        connectedLocations=new String[]{"O6","N6"};
        theRunwayConnectors.add(new Location("S3",connectedLocations));
        connectedLocations=new String[]{"M6","L6"};
        theRunwayConnectors.add(new Location("S4",connectedLocations));
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


    //GATES ALS LOCATIONS, S1-S4 ALS LOCATIONS

}
