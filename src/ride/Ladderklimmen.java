package ride;

public class Ladderklimmen extends Ride implements GamblingRide{
    public Ladderklimmen(String name){
        super(name);
        this.setPrice(5.00);
    }
}