package Airport;

import Aircraft.Aircraft;

public class Location {
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
    public void addAirplane(Aircraft currentAriplane){
        this.currentAircraft = currentAriplane;
    }

    public Aircraft getCurrentAriplane() {
        return currentAircraft;
    }

    public void resetCurrentAirplane(){
        currentAircraft =null;
    }

    public boolean hasAirplane(){
        if(currentAircraft !=null) {
            return true;
        }
        else{
            return false;
        }
    }

    public String getLocationID() {
        return locationID;
    }

    public String[] getConnectedLocations(){
        return connectedLocations;
    }
}
