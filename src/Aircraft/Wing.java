package Aircraft;

import java.util.ArrayList;

public class Wing {
    private WingPosition theWingPosition;
    private ArrayList<Fan> theFans = new ArrayList<Fan>();
    private ArrayList<Flap> theFlaps = new ArrayList<Flap>();
    public Wing(WingPosition theWingPosition,ArrayList<Flap> theFlaps){
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
