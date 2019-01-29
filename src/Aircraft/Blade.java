package Aircraft;

public class Blade {
    int id;
    BladeMaterial theBladeMaterial;
    public Blade(int id){
        this.id=id;
        if(id%2==0){
            theBladeMaterial=BladeMaterial.Carbon;
        }
        else{
            theBladeMaterial=BladeMaterial.Titan;
        }
    }
}
