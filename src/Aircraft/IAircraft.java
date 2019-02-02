package Aircraft;

import Airport.EventHoldShort;
import Airport.EventRunwayClearedForTakeOff;
import Airport.EventRunwayClearedToLand;
import Airport.EventTaxi;
import com.google.common.eventbus.Subscribe;

public interface IAircraft {
    @Subscribe
    void receive(EventTaxi event);

    @Subscribe
    void receive(EventHoldShort event);

    @Subscribe
    void receive(EventRunwayClearedForTakeOff event);

    @Subscribe
    void receive(EventRunwayClearedToLand event);

    AircraftID getId();
}
