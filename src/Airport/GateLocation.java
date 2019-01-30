package Airport;

public class GateLocation extends Location {
    private GateID locationID;
    String[] connectedLocations;
    public GateLocation(GateID locationID, String[] connectedLocations) {
        this.locationID = locationID;
        this.connectedLocations = connectedLocations;
    }
    public GateID getLocationID(){
        return locationID;
    }
}