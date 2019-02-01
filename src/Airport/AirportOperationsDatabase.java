package Airport;

import Aircraft.AircraftID;

import java.util.ArrayList;

public class AirportOperationsDatabase {
    private ArrayList<AirportOperationsDatabaseData> theDatabase;
    public AirportOperationsDatabase(){
        theDatabase=new ArrayList<AirportOperationsDatabaseData>();
    }
    public void addData(AircraftID aircraftID, String eventMessage){
        theDatabase.add(new AirportOperationsDatabaseData(aircraftID,eventMessage));
    }

    public ArrayList<String> getDataOfAirplane(String aircraftID){
        ArrayList<String> theData=new ArrayList<String>();
        for(int i=0;i<theDatabase.size();i++){
            if(theDatabase.get(i).getAircraftID().toString()==aircraftID){
                theData.add(theDatabase.get(i).getDataInformation());
            }
        }
        return theData;
    }

    public ArrayList<String> getAllData(){
        ArrayList<String> theData=new ArrayList<String>();
        for(int i=0;i<theDatabase.size();i++){
            theData.add(theDatabase.get(i).getDataInformation());
        }
        return theData;
    }
}
