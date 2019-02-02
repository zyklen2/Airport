package Airport;

import Aircraft.Aircraft;

public class Gate implements IGate {
    private boolean isOpen;
    private GateID gateID;
    private Aircraft theAircraft;
    public Gate(boolean isOpen, GateID gateID) {
        this.isOpen = isOpen;
        this.gateID = gateID;
        theAircraft = null;
    }

    @Override
    public void addAircraft(Aircraft theAircraft){
        this.theAircraft = theAircraft;
    }

    @Override
    public void resetAircraft(){
        theAircraft =null;
    }

    @Override
    public Aircraft getTheAircraft(){
        return theAircraft;
    }

    @Override
    public GateID getGateID() {
        return gateID;
    }
}
