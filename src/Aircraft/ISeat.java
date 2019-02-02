package Aircraft;

import People.Passenger;

public interface ISeat {
    Passenger getThePassenger();

    void setThePassenger(Passenger thePassenger);
}
