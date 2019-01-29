package Aircraft;

public class Flap {
    int id;
    int degree;

    public Flap(int id) {
        this.id = id;
    }

    public void neutral(){
        degree=0;
    }

    public void levelOne(){
        degree = 10;
    }

    public void levelTwo(){
        degree = 20;
    }

    public void levelThree(){
        degree = 30;
    }
}
