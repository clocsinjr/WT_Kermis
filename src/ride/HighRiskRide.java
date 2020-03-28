package ride;

public abstract class HighRiskRide extends Ride{
    private int rideLimit;
    private int timesRan = 0;
    private boolean isAvailable = true;
    
    HighRiskRide(String name, int rideLimit){
        super(name);
        this.rideLimit = rideLimit;
    }
    
    public boolean getAvailability(){
            return this.isAvailable;
    }
    
    public void doMaintenance(){
        this.timesRan = 0;
        this.isAvailable = true;
    }
    
    @Override
    public void executeRide(){
        if (this.isAvailable){
            super.executeRide();
            this.timesRan++;
            
            if(this.timesRan >= rideLimit){
                this.isAvailable = false;
            }
        }
        else{
            System.out.println("Ride needs maintenance! Can't run ride");
        }
    }
    
    @Override
    public String toString(){
        if (!this.isAvailable)
            return "[!] " + super.toString();
        return super.toString();
    }
}
