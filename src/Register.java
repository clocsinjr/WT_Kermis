import java.util.ArrayList;

import ride.*;

public class Register{
    private ArrayList<Ride> rides = new ArrayList<>();
    
    public void addRide(Ride ride){
        this.rides.add(ride);
    }
    
    public int getNumRides(){
        return this.rides.size();
    }
    
    public Ride executeRide(int rideIndex){
        Ride chosenRide = this.rides.get(rideIndex);
        chosenRide.executeRide();
        return chosenRide;
    }
    public void displayRidesInfo(){
        for(int i = 0; i < this.rides.size(); i++){
            System.out.print(" [" + i + "]\t");
            this.rides.get(i).displayInfo();
        }
    }
}