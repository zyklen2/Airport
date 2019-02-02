package Aircraft;

import Airport.EventHoldShort;
import Airport.EventRunwayClearedForTakeOff;
import Airport.EventRunwayClearedToLand;
import Airport.EventTaxi;
import com.google.common.eventbus.Subscribe;

import java.util.ArrayList;

public class Aircraft extends Subscriber implements IAircraft {
    private AircraftID id;
    private String manufacturer;
    private int numberOfSeatFirstClass;
    private int numberOfSeatBusinessClass;
    private int numberOfSeatEconomyClass;
    private ArrayList<ISeat> theSeats = new ArrayList<ISeat>();
    private ArrayList<Wing> theWing = new ArrayList<Wing>();
    private ArrayList<ArrayList<IFlap>> theFlaps = new ArrayList<ArrayList<IFlap>>();
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
            ArrayList<IFlap> tempFlaps = new ArrayList<IFlap>();
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

    @Override
    @Subscribe
    public void receive(EventTaxi event) {
        if(event.getAircraft()==id){
            System.out.println("EventTaxi "+id);
            System.out.println(event.toString());
        }
    }

    @Override
    @Subscribe
    public void receive(EventHoldShort event){
        if(event.getAircraft()==id){
            System.out.println("EventHoldShort "+id);
            System.out.println(event.toString());
        }
    }

    @Override
    @Subscribe
    public void receive(EventRunwayClearedForTakeOff event){
        if(event.getAircraft()==id){
            System.out.println("EventRunwayClearedForTakeOff "+id);
            System.out.println(event.toString());
        }
    }

    @Override
    @Subscribe
    public void receive(EventRunwayClearedToLand event){
        if(event.getAircraft()==id){
            System.out.println("EventRunwayClearedToLand "+id);
            System.out.println(event.toString());
        }
    }

    @Override
    public AircraftID getId() {
        return id;
    }
}
