package Aircraft;

import java.util.ArrayList;

public class Fan {
    int id;
    int rpm;
    ArrayList<Blade> theBlades = new ArrayList<Blade>();

    public Fan(int id) {
        this.id = id;
        int bladeStartID=100*id;
        for(int i=bladeStartID;i<bladeStartID+96;i++){
            theBlades.add(new Blade(i));
        }
    }
    public void start(){
        rpm=10;
    }
    public void increaseRPM(int value){
        if(rpm+value<=100){
            rpm=rpm+value;
        }
    }
    public void decreaseRPM(int value){
        if(rpm+value>=0){
            rpm=rpm-value;
        }
    }
    public void shutdown(){
        rpm=0;
    }


}
