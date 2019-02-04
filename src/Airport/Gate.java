package Airport;

import Aircraft.*;

public class Gate implements IGate {
    private boolean isOpen;
    private GateID gateID;
    private IAircraft theAircraft;
    public Gate(boolean isOpen, GateID gateID) {
        this.isOpen = isOpen;
        this.gateID = gateID;
        theAircraft = null;
    }

    @Override
    public void addAircraft(IAircraft theAircraft){
        this.theAircraft = theAircraft;
        theAircraft.setGate(this);
    }

    @Override
    public void resetAircraft(){
        theAircraft =null;
    }

    @Override
    public IAircraft getTheAircraft(){
        return theAircraft;
    }

    @Override
    public GateID getGateID() {
        return gateID;
    }
}
