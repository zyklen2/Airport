package Airport;

import Aircraft.Aircraft;

public interface ILocation {
    void addAirplane(Aircraft currentAriplane);

    Aircraft getCurrentAriplane();

    void resetCurrentAirplane();

    boolean hasAirplane();

    String getLocationID();

    String[] getConnectedLocations();
}
