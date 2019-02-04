package Aircraft;

import Airport.DatabaseData;
import Airport.IDatabaseData;

import java.util.ArrayList;

public class Flightrecorder implements IFlightrecorder {
    private ArrayList<IDatabaseData> theDatabase;
    public Flightrecorder(){
        theDatabase=new ArrayList<IDatabaseData>();
    }

    @Override
    public void addData(AircraftID aircraftID, String eventMessage){
        theDatabase.add(new DatabaseData(aircraftID,eventMessage));
    }

    @Override
    public ArrayList<String> getAllData(){
        ArrayList<String> theData=new ArrayList<String>();
        for(int i=0;i<theDatabase.size();i++){
            theData.add(theDatabase.get(i).getDataInformation());
        }
        return theData;
    }
}
