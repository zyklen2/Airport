package Aircraft;
import People.Passenger;

public class Seat implements ISeat {
    int id;
    BookingClass theBookingClass;
    Passenger thePassenger;

    public Seat(int id, BookingClass theBookingClass) {
        this.id = id;
        this.theBookingClass=theBookingClass;
    }

    @Override
    public Passenger getThePassenger() {
        return thePassenger;
    }

    @Override
    public void setThePassenger(Passenger thePassenger) {
        this.thePassenger = thePassenger;
    }
}
