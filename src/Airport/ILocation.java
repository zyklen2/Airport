package Airport;

import Aircraft.Aircraft;

public interface ILocation {
    void addAircraft(Aircraft currentAircraft);

    Aircraft getCurrentAircraft();

    void resetCurrentAircraft();

    boolean hasAircraft();

    String getLocationID();

    String[] getConnectedLocations();
}
