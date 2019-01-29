package Aircraft;
import People.Passenger;

public class Seat {
    int id;
    BookingClass theBookingClass;
    Passenger thePassenger;

    public Seat(int id, BookingClass theBookingClass) {
        this.id = id;
        this.theBookingClass=theBookingClass;
    }

    public Passenger getThePassenger() {
        return thePassenger;
    }

    public void setThePassenger(Passenger thePassenger) {
        this.thePassenger = thePassenger;
    }
}
