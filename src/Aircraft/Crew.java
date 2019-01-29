package Aircraft;
import People.*;
public class Crew {
    Pilot[] thePilots = new Pilot[2];
    FlightAttendant[] theFlightAttendants = new FlightAttendant[3];

    public Crew(Pilot[] thePilots,FlightAttendant[] theFlightAttendants){
        this.thePilots=thePilots;
        this.theFlightAttendants=theFlightAttendants;
    }
}
