package Airport;

import Aircraft.Aircraft;

public class Location implements ILocation {
    private String locationID;
    private String[] connectedLocations;
    private Aircraft currentAircraft =null;
    private Gate theGate=null;

    public Location(String locationID, String[] connectedLocations) {
        this.locationID = locationID;
        this.connectedLocations = connectedLocations;
    }
    @Override
    public void addAircraft(Aircraft currentAircraft){
        this.currentAircraft = currentAircraft;
    }

    @Override
    public Aircraft getCurrentAircraft() {
        return currentAircraft;
    }

    @Override
    public void resetCurrentAircraft(){
        currentAircraft =null;
    }

    @Override
    public boolean hasAircraft(){
        if(currentAircraft !=null) {
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public String getLocationID() {
        return locationID;
    }

    @Override
    public String[] getConnectedLocations(){
        return connectedLocations;
    }
}
