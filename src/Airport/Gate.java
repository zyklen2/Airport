package Airport;

import Aircraft.Aircraft;

public class Gate {
    private boolean isOpen;
    private GateID gateID;
    private Aircraft theAircraft;
    public Gate(boolean isOpen, GateID gateID) {
        this.isOpen = isOpen;
        this.gateID = gateID;
        theAircraft = null;
    }

    public void addAircraft(Aircraft theAircraft){
        this.theAircraft = theAircraft;
    }

    public void resetAircraft(){
        theAircraft =null;
    }

    public Aircraft getTheAircraft(){
        return theAircraft;
    }

    public GateID getGateID() {
        return gateID;
    }
}
