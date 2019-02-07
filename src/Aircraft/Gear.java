package Aircraft;

import java.util.ArrayList;

public class Gear implements IGear {
    private GearType theGearType;
    private boolean isDown;
    private boolean isBrakeSet;
    private ArrayList<Wheel> theWheels=new ArrayList<Wheel>();

    public Gear(GearType theGearType,int wheelCount,int id) {
        this.theGearType = theGearType;
        isDown=false;
        isBrakeSet=false;
        for(int i=0;i<wheelCount;i++){
            theWheels.add(new Wheel(((id*10)+i),60));
        }
    }

    @Override
    public void up(){
        isDown=false;
    }

    @Override
    public void down(){
        isDown=true;
    }

    @Override
    public void setBrake(){
        isBrakeSet=true;
    }

    @Override
    public void releaseBrake(){
        isBrakeSet=false;
    }
}
