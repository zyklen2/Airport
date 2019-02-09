package Aircraft;

import Airport.*;
import com.google.common.eventbus.Subscribe;

import java.util.ArrayList;

public class Aircraft extends Subscriber implements IAircraft {
    private AircraftID id;
    private String manufacturer;
    private int numberOfSeatFirstClass;
    private int numberOfSeatBusinessClass;
    private int numberOfSeatEconomyClass;
    private ArrayList<ISeat> theSeats = new ArrayList<ISeat>();
    private ArrayList<IWing> theWing = new ArrayList<>();
    private ArrayList<ArrayList<IFlap>> theFlaps = new ArrayList<ArrayList<IFlap>>();
    private ArrayList<IGear> theGears = new ArrayList<>();
    private Crew theCrew;
    private String theLocation="";
    private String theCurrentStatus="";
    private Flightrecorder theFlightRecoreder;
    private IGate currentGate;

    public Aircraft(AircraftID id, String manufacturer, int numberOfSeatFirstClass, int numberOfSeatBusinessClass, int numberOfSeatEconomyClass,String theLocation,String theCurrentStatus, Crew theCrew){
        this.id = id;
        this.manufacturer = manufacturer;
        this.numberOfSeatFirstClass = numberOfSeatFirstClass;
        this.numberOfSeatBusinessClass = numberOfSeatBusinessClass;
        this.numberOfSeatEconomyClass = numberOfSeatEconomyClass;
        this.theLocation=theLocation;
        this.theCurrentStatus=theCurrentStatus;
        theFlightRecoreder=new Flightrecorder();
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

    @Subscribe
    public void receive(EventTaxi event) {
        if(event.getFrequency()==CommunicationFrequencys.ApronControl) {
            if (event.getAircraft() == id) {
                //System.out.println("EventTaxi " + id);
                //System.out.println(event.toString());
                if (currentGate != null) {
                    theCurrentStatus = "Starting";
                    if(!event.getToGate()) {
                        currentGate = null;
                    }
                } else {
                    theCurrentStatus = "inTaxi";
                }
                for(IGear tempGear:theGears){
                    tempGear.releaseBrake();
                }
                theLocation = event.getDestination();
                theFlightRecoreder.addData(id, event.toString());
            }
        }
    }

    @Subscribe
    public void receive(EventHoldShort event) {
        if ((theCurrentStatus == "Landed"&&event.getFrequency()==CommunicationFrequencys.Tower)||(theCurrentStatus=="Starting"&&event.getFrequency()==CommunicationFrequencys.Tower)){
            if (event.getAircraft() == id) {
                //System.out.println("EventHoldShort " + id);
                //System.out.println(event.toString());
                if(theCurrentStatus=="Starting"){
                    theWing.get(0).start();
                    theWing.get(1).start();
                }
                else{
                    theWing.get(0).landEngineOff();
                    theWing.get(1).landEngineOff();
                }
                for(IGear tempGear:theGears){
                    tempGear.setBrake();
                }
                theCurrentStatus = "HoldShort";
                theLocation = event.getRunwayEntrance();
                theFlightRecoreder.addData(id, event.toString());
            }
        }
    }

    @Subscribe
    public void receive(EventRunwayClearedForTakeOff event){
        if(event.getFrequency()==CommunicationFrequencys.Tower) {
            if (event.getAircraft() == id) {
                //System.out.println("EventRunwayClearedForTakeOff " + id);
                //System.out.println(event.toString());
                theCurrentStatus = "Flying";
                theLocation = "Flying";
                theWing.get(0).inFlight();
                theWing.get(1).inFlight();
                for(IGear tempGear:theGears){
                    tempGear.releaseBrake();
                    tempGear.up();
                }
                theFlightRecoreder.addData(id, event.toString());
            }
        }
    }

    @Subscribe
    public void receive(EventRunwayClearedToLand event){
        if(event.getFrequency()==CommunicationFrequencys.Tower) {
            if (event.getAircraft() == id) {
                //System.out.println("EventRunwayClearedToLand " + id);
                //System.out.println(event.toString());
                theCurrentStatus = "Landed";
                theLocation = event.getRunway();
                theWing.get(0).land();
                theWing.get(0).land();
                for(IGear tempGear:theGears){
                    tempGear.down();
                }
                theFlightRecoreder.addData(id, event.toString());
            }
        }
    }

    @Override
    public void setGate(IGate theGate){
        currentGate=theGate;
        theCurrentStatus="InGate";
        theLocation=theGate.getGateID().toString();
        for(IGear tempGear:theGears){
            tempGear.setBrake();
        }
    }

    @Override
    public AircraftID getId() {
        return id;
    }

    @Override
    public String getLocation() {
        return theLocation;
    }

    @Override
    public void setLocation(String location) {
        theLocation = location;
    }

    @Override
    public String getCurrentStatus() {
        return theCurrentStatus;
    }

    @Override
    public void setCurrentStatus(String currentStatus) {
        theCurrentStatus = currentStatus;
    }

    @Override
    public ArrayList<String> getRecordedData(){
        return theFlightRecoreder.getAllData();
    }

    @Override
    public IGate getCurrentGate(){
        return currentGate;
    }
}
