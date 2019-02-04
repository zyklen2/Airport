package Airport;

import Aircraft.*;

public interface IGate {
    void addAircraft(IAircraft theAircraft);

    void resetAircraft();

    IAircraft getTheAircraft();

    GateID getGateID();
}
