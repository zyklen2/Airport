package Aircraft;

import java.util.ArrayList;

public class Wing {
    private WingPosition theWingPosition;
    private ArrayList<Fan> theFans = new ArrayList<Fan>();
    private ArrayList<IFlap> theFlaps = new ArrayList<IFlap>();
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
}
