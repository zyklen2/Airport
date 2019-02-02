package Airport;

import Aircraft.Aircraft;

public interface IGate {
    void addAircraft(Aircraft theAircraft);

    void resetAircraft();

    Aircraft getTheAircraft();

    GateID getGateID();
}
