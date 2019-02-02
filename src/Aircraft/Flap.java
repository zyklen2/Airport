package Aircraft;

public class Flap implements IFlap {
    int id;
    int degree;

    public Flap(int id) {
        this.id = id;
    }

    @Override
    public void neutral(){
        degree=0;
    }

    @Override
    public void levelOne(){
        degree = 10;
    }

    @Override
    public void levelTwo(){
        degree = 20;
    }

    @Override
    public void levelThree(){
        degree = 30;
    }
}
