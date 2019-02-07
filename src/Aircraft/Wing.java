package Aircraft;

import java.util.ArrayList;

public class Wing implements IWing {
    private WingPosition theWingPosition;
    private ArrayList<IFan> theFans = new ArrayList<>();
    private ArrayList<IFlap> theFlaps = new ArrayList<>();
    public Wing(WingPosition theWingPosition,ArrayList<IFlap> theFlaps){
        this.theFlaps=theFlaps;
        this.theWingPosition=theWingPosition;
        if(theWingPosition==WingPosition.Left) {
            theFans.add(new Fan(0));
            theFans.add(new Fan(1));
        }
        else{
            theFans.add(new Fan(2));
            theFans.add(new Fan(3));
        }
    }

    @Override
    public void start(){
        theFans.get(0).start();
        theFans.get(1).start();
        theFlaps.get(0).levelThree();
        theFlaps.get(1).levelThree();
    }

    @Override
    public void land(){
        theFans.get(0).decreaseRPM(50);
        theFans.get(1).decreaseRPM(50);
        theFlaps.get(0).neutral();
        theFlaps.get(1).neutral();
    }

    @Override
    public void inFlight(){
        theFans.get(0).increaseRPM(90);
        theFans.get(0).increaseRPM(90);
        theFlaps.get(0).neutral();
        theFlaps.get(1).neutral();
    }

    @Override
    public  void landEngineOff(){
        theFans.get(0).shutdown();
        theFans.get(1).shutdown();
    }
}
