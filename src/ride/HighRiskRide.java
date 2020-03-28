package ride;

abstract class HighRiskRide extends Ride{
    private int rideLimit;
    private boolean isAvailable;
    
    HighRiskRide(String name){
        super(name);
    }
}
