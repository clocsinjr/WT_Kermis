package ride;

abstract class HighRiskRide extends Ride{
    private int rideLimit;
    HighRiskRide(String name){
        super(name);
    }
}
