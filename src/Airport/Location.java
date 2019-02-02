package Airport;

import Aircraft.Aircraft;

public class Location implements ILocation {
    private String locationID;
    private String[] connectedLocations;
    private Aircraft currentAircraft =null;
    private Gate theGate=null;

    protected Location(){
    }

    public Location(String locationID, String[] connectedLocations) {
        this.locationID = locationID;
        this.connectedLocations = connectedLocations;
    }
    @Override
    public void addAirplane(Aircraft currentAriplane){
        this.currentAircraft = currentAriplane;
    }

    @Override
    public Aircraft getCurrentAriplane() {
        return currentAircraft;
    }

    @Override
    public void resetCurrentAirplane(){
        currentAircraft =null;
    }

    @Override
    public boolean hasAirplane(){
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
