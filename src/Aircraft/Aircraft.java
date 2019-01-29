package Aircraft;

import Airport.EventTaxi;
import com.google.common.eventbus.Subscribe;

import java.util.ArrayList;

public class Aircraft extends Subscriber{
    private AircraftID id;
    private String manufacturer;
    private int numberOfSeatFirstClass;
    private int numberOfSeatBusinessClass;
    private int numberOfSeatEconomyClass;
    private ArrayList<Seat> theSeats = new ArrayList<Seat>();
    private ArrayList<Wing> theWing = new ArrayList<Wing>();
    private ArrayList<ArrayList<Flap>> theFlaps = new ArrayList<ArrayList<Flap>>();
    private ArrayList<Gear> theGears = new ArrayList<Gear>();
    private Crew theCrew;

    public Aircraft(AircraftID id, String manufacturer, int numberOfSeatFirstClass, int numberOfSeatBusinessClass, int numberOfSeatEconomyClass, Crew theCrew){
        this.id = id;
        this.manufacturer = manufacturer;
        this.numberOfSeatFirstClass = numberOfSeatFirstClass;
        this.numberOfSeatBusinessClass = numberOfSeatBusinessClass;
        this.numberOfSeatEconomyClass = numberOfSeatEconomyClass;
        int seatID=0;
        for(int i=0;i<numberOfSeatFirstClass;i++){
            theSeats.add(new Seat(seatID,BookingClass.First));
            seatID++;
        }
        for(int i=0;i<numberOfSeatBusinessClass;i++){
            theSeats.add(new Seat(seatID,BookingClass.Business));
            seatID++;
        }
        for(int i=0;i<numberOfSeatEconomyClass;i++){
            theSeats.add(new Seat(seatID,BookingClass.Economy));
            seatID++;
        }
        for(int i=1;i<3;i++){
            ArrayList<Flap> tempFlaps = new ArrayList<Flap>();
            for(int j=0;j<2;j++){
                tempFlaps.add(new Flap(i*j));
            }
            theFlaps.add(tempFlaps);
        }
        theWing.add(new Wing(WingPosition.Left,theFlaps.get(0)));
        theWing.add(new Wing(WingPosition.Right,theFlaps.get(1)));
        for(int i=1;i<6;i++){
            if(i<4){
                theGears.add(new Gear(GearType.Front,6,i));
            }
            else{
                theGears.add(new Gear(GearType.Rear,6,i));
            }
        }
        this.theCrew=theCrew;
    }

    @Subscribe
    public void receive(EventTaxi taxi) {

    }

    public void holdShort(){

    }

    public void takeOff(){

    }

    public void land(){

    }

    public AircraftID getId() {
        return id;
    }
}
