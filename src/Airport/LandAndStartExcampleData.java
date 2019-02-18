package Airport;
import java.util.ArrayList;
import java.util.Arrays;

public class LandAndStartExcampleData {
    //Hierfür kein Inteface, da es nur eine Hilfestellung ist um nicht in "Main" alle werte setzen zu müssen und es somit aufgeräumter zu haben.
    ArrayList<String> alLandingRunway=new ArrayList<>();
    ArrayList<String> alStartRunway=new ArrayList<>();
    ArrayList<String> alLandingRunwayConnector=new ArrayList<>();
    ArrayList<String> alStartRunwayConnector=new ArrayList<>();
    ArrayList<String> alExactStartpoint=new ArrayList<>();
    ArrayList<String> alDestinationGateID=new ArrayList<>();
    ArrayList<ArrayList<String>> alTheWay=new ArrayList<>();
    ArrayList<ArrayList<String>> alTheWay2=new ArrayList<>();
    public LandAndStartExcampleData(String[] airportStartRunway,String[] airportLandRunway){
        String eventMsg="";
        String landingRunway = "";
        String startRunway = "";
        String landingRunwayConnector = "";
        String startRunwayConnector = "";
        String exactStartpoint = "";
        String destinationGateID = "";
        ArrayList<String> theWayToRunway = new ArrayList<>();
        ArrayList<String> theWayToGate = new ArrayList<>();
        if(airportLandRunway[0]=="08L") {
            for(int i=0;i<10;i++) {
                switch(i) {
                    case 0:
                        landingRunway = airportLandRunway[0];
                        startRunway = airportStartRunway[0];
                        landingRunwayConnector = "S1";
                        startRunwayConnector = "S4";
                        exactStartpoint = "M6";
                        destinationGateID = "A01";
                        theWayToRunway = new ArrayList<>(Arrays.asList("O2", "O3", "O4", "O5", "X9"));
                        theWayToGate = new ArrayList<>(Arrays.asList("O1"));
                        break;
                    case 1:
                        landingRunway = airportLandRunway[0];
                        startRunway = airportStartRunway[0];
                        landingRunwayConnector = "S1";
                        startRunwayConnector = "S4";
                        exactStartpoint = "M6";
                        destinationGateID = "A02";
                        theWayToRunway = new ArrayList<>(Arrays.asList("O3", "O4", "O5", "X9"));
                        theWayToGate = new ArrayList<>(Arrays.asList("O1","O2"));
                        break;
                    case 2:
                        landingRunway = airportLandRunway[0];
                        startRunway = airportStartRunway[0];
                        landingRunwayConnector = "S1";
                        startRunwayConnector = "S4";
                        exactStartpoint = "M6";
                        destinationGateID = "A03";
                        theWayToRunway = new ArrayList<>(Arrays.asList("O4", "O5", "X9"));
                        theWayToGate = new ArrayList<>(Arrays.asList("O1","O2", "O3"));
                        break;
                    case 3:
                        landingRunway = airportLandRunway[0];
                        startRunway = airportStartRunway[0];
                        landingRunwayConnector = "S1";
                        startRunwayConnector = "S4";
                        exactStartpoint = "M6";
                        destinationGateID = "A04";
                        theWayToRunway = new ArrayList<>(Arrays.asList("O5", "X9"));
                        theWayToGate = new ArrayList<>(Arrays.asList("O1","O2", "O3","O4"));
                        break;
                    case 4:
                        landingRunway = airportLandRunway[0];
                        startRunway = airportStartRunway[0];
                        landingRunwayConnector = "S1";
                        startRunwayConnector = "S4";
                        exactStartpoint = "M6";
                        destinationGateID = "A05";
                        theWayToRunway = new ArrayList<>(Arrays.asList("X9"));
                        theWayToGate = new ArrayList<>(Arrays.asList("O1","O2", "O3","O4", "O5"));
                        break;
                    case 5:
                        landingRunway = airportLandRunway[0];
                        startRunway = airportStartRunway[0];
                        landingRunwayConnector = "S1";
                        startRunwayConnector = "S4";
                        exactStartpoint = "M6";
                        destinationGateID = "B01";
                        theWayToRunway = new ArrayList<>(Arrays.asList("M2","M3","M4","M5"));
                        theWayToGate = new ArrayList<>(Arrays.asList("O1", "X7","M2"));
                        break;
                    case 6:
                        landingRunway = airportLandRunway[0];
                        startRunway = airportStartRunway[0];
                        landingRunwayConnector = "S1";
                        startRunwayConnector = "S4";
                        exactStartpoint = "M6";
                        destinationGateID = "B02";
                        theWayToRunway = new ArrayList<>(Arrays.asList("M3","M4","M5"));
                        theWayToGate = new ArrayList<>(Arrays.asList("O1", "X7","M2"));
                        break;
                    case 7:
                        landingRunway = airportLandRunway[0];
                        startRunway = airportStartRunway[0];
                        landingRunwayConnector = "S1";
                        startRunwayConnector = "S4";
                        exactStartpoint = "M6";
                        destinationGateID = "B03";
                        theWayToRunway = new ArrayList<>(Arrays.asList("M4","M5"));
                        theWayToGate = new ArrayList<>(Arrays.asList("O1", "X7","M2","M3"));
                        break;
                    case 8:
                        landingRunway = airportLandRunway[0];
                        startRunway = airportStartRunway[0];
                        landingRunwayConnector = "S1";
                        startRunwayConnector = "S4";
                        exactStartpoint = "M6";
                        destinationGateID = "B04";
                        theWayToRunway = new ArrayList<>(Arrays.asList("M5"));
                        theWayToGate = new ArrayList<>(Arrays.asList("O1", "X7","M2","M3","M4"));
                        break;
                    case 9:
                        landingRunway = airportLandRunway[0];
                        startRunway = airportStartRunway[0];
                        landingRunwayConnector = "S1";
                        startRunwayConnector = "S4";
                        exactStartpoint = "M6";
                        destinationGateID = "B05";
                        theWayToRunway = new ArrayList<>(Arrays.asList("M6"));
                        theWayToGate = new ArrayList<>(Arrays.asList("O1", "X7","M2","M3","M4","M5"));
                        break;
                }
                alLandingRunway.add(landingRunway);
                alStartRunway.add(startRunway);
                alLandingRunwayConnector.add(landingRunwayConnector);
                alStartRunwayConnector.add(startRunwayConnector);
                alExactStartpoint.add(exactStartpoint);
                alDestinationGateID.add(destinationGateID);
                alTheWay.add(theWayToRunway);
                alTheWay2.add(theWayToGate);

            }
        }
        else{
            for(int i=0;i<10;i++) {
                switch(i) {
                    case 0:
                        landingRunway = airportLandRunway[0];
                        startRunway = airportStartRunway[0];
                        landingRunwayConnector = "S2";
                        startRunwayConnector = "S3";
                        exactStartpoint = "N6";
                        destinationGateID = "A01";
                        theWayToRunway = new ArrayList<>(Arrays.asList("N2", "N3", "N4", "N5"));
                        theWayToGate = new ArrayList<>(Arrays.asList("M1", "X2","N2"));
                        break;
                    case 1:
                        landingRunway = airportLandRunway[0];
                        startRunway = airportStartRunway[0];
                        landingRunwayConnector = "S2";
                        startRunwayConnector = "S3";
                        exactStartpoint = "N6";
                        destinationGateID = "A02";
                        theWayToRunway = new ArrayList<>(Arrays.asList("N3", "N4", "N5"));
                        theWayToGate = new ArrayList<>(Arrays.asList("M1", "X2", "N2"));
                        break;
                    case 2:
                        landingRunway = airportLandRunway[0];
                        startRunway = airportStartRunway[0];
                        landingRunwayConnector = "S2";
                        startRunwayConnector = "S3";
                        exactStartpoint = "N6";
                        destinationGateID = "A03";
                        theWayToRunway = new ArrayList<>(Arrays.asList("N4", "N5"));
                        theWayToGate = new ArrayList<>(Arrays.asList("M1", "X2", "N2","N3"));
                        break;
                    case 3:
                        landingRunway = airportLandRunway[0];
                        startRunway = airportStartRunway[0];
                        landingRunwayConnector = "S2";
                        startRunwayConnector = "S3";
                        exactStartpoint = "N6";
                        destinationGateID = "A04";
                        theWayToRunway = new ArrayList<>(Arrays.asList("N5"));
                        theWayToGate = new ArrayList<>(Arrays.asList("M1", "X2", "N2","N3","N4"));
                        break;
                    case 4:
                        landingRunway = airportLandRunway[0];
                        startRunway = airportStartRunway[0];
                        landingRunwayConnector = "S2";
                        startRunwayConnector = "S3";
                        exactStartpoint = "N6";
                        destinationGateID = "A05";
                        theWayToRunway = new ArrayList<>(Arrays.asList("N6"));
                        theWayToGate = new ArrayList<>(Arrays.asList("M1", "X2", "N2","N3","N4","N5"));
                        break;
                    case 5:
                        landingRunway = airportLandRunway[0];
                        startRunway = airportStartRunway[0];
                        landingRunwayConnector = "S2";
                        startRunwayConnector = "S3";
                        exactStartpoint = "N6";
                        destinationGateID = "B01";
                        theWayToRunway = new ArrayList<>(Arrays.asList("M2", "M3","M4","M5","X16"));
                        theWayToGate = new ArrayList<>(Arrays.asList("M1"));
                        break;
                    case 6:
                        landingRunway = airportLandRunway[0];
                        startRunway = airportStartRunway[0];
                        landingRunwayConnector = "S2";
                        startRunwayConnector = "S3";
                        exactStartpoint = "N6";
                        destinationGateID = "B02";
                        theWayToRunway = new ArrayList<>(Arrays.asList("M3","M4","M5","X16"));
                        theWayToGate = new ArrayList<>(Arrays.asList("M1","M2"));
                        break;
                    case 7:
                        landingRunway = airportLandRunway[0];
                        startRunway = airportStartRunway[0];
                        landingRunwayConnector = "S2";
                        startRunwayConnector = "S3";
                        exactStartpoint = "N6";
                        destinationGateID = "B03";
                        theWayToRunway = new ArrayList<>(Arrays.asList("M4","M5","X16"));
                        theWayToGate = new ArrayList<>(Arrays.asList("M1","M2","M3"));
                        break;
                    case 8:
                        landingRunway = airportLandRunway[0];
                        startRunway = airportStartRunway[0];
                        landingRunwayConnector = "S2";
                        startRunwayConnector = "S3";
                        exactStartpoint = "N6";
                        destinationGateID = "B04";
                        theWayToRunway = new ArrayList<>(Arrays.asList("M5","X16"));
                        theWayToGate = new ArrayList<>(Arrays.asList("M1","M2","M3","M4"));
                        break;
                    case 9:
                        landingRunway = airportLandRunway[0];
                        startRunway = airportStartRunway[0];
                        landingRunwayConnector = "S2";
                        startRunwayConnector = "S3";
                        exactStartpoint = "N6";
                        destinationGateID = "B05";
                        theWayToRunway = new ArrayList<>(Arrays.asList("M5","X16"));
                        theWayToGate = new ArrayList<>(Arrays.asList("M1","M2","M3","M4","M5"));
                        break;
                }
                alLandingRunway.add(landingRunway);
                alStartRunway.add(startRunway);
                alLandingRunwayConnector.add(landingRunwayConnector);
                alStartRunwayConnector.add(startRunwayConnector);
                alExactStartpoint.add(exactStartpoint);
                alDestinationGateID.add(destinationGateID);
                alTheWay.add(theWayToRunway);
                alTheWay2.add(theWayToGate);
            }
        }
    }

    public ArrayList<String> getAlLandingRunway() {
        return alLandingRunway;
    }

    public ArrayList<String> getAlStartRunway() {
        return alStartRunway;
    }

    public ArrayList<String> getAlLandingRunwayConnector() {
        return alLandingRunwayConnector;
    }

    public ArrayList<String> getAlStartRunwayConnector() {
        return alStartRunwayConnector;
    }

    public ArrayList<String> getAlExactStartpoint() {
        return alExactStartpoint;
    }

    public ArrayList<String> getAlDestinationGateID() {
        return alDestinationGateID;
    }

    public ArrayList<ArrayList<String>> getAlTheWay() {
        return alTheWay;
    }

    public ArrayList<ArrayList<String>> getAlTheWay2() {
        return alTheWay2;
    }
}
