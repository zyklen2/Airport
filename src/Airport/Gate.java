package Airport;

import Aircraft.Aircraft;

public class Gate {
    private boolean isOpen;
    private GateID gateID;
    private Aircraft theAircraft;
    private Location connectedLocation;
    public Gate(boolean isOpen, GateID gateID) {
        this.isOpen = isOpen;
        this.gateID = gateID;
        theAircraft = null;
    }

    public void addAirplane(Aircraft theAircraft){
        this.theAircraft = theAircraft;
    }

    public void resetAirplane(){
        theAircraft =null;
    }

    public Aircraft getTheAircraft(){
        return theAircraft;
    }

    public void setConnectedLocation(Location connectedLocation){
        this.connectedLocation=connectedLocation;
        connectedLocation.addGate(this);
    }

}
