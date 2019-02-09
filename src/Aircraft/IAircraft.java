package Aircraft;

import Airport.*;
import com.google.common.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.concurrent.Flow;

public interface IAircraft{

    AircraftID getId();

    String getLocation();

    void setLocation(String location);

    String getCurrentStatus();

    void setCurrentStatus(String currentStatus);

    ArrayList<String> getRecordedData();

    void setGate(IGate theGate);

    IGate getCurrentGate();
}
