package Airport;

import Aircraft.*;

public interface ITower {
    void eventRunwayClearedToLand(IAircraft aircraft, String runway);

    void eventRunwayClearedForTakeOff(IAircraft aircraft, String runway);

    void eventHoldShort(IAircraft aircraft, String runwayEntrance);

    void addAircraft(Subscriber subscriber);
}
