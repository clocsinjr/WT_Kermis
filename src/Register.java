import java.util.ArrayList;
import java.lang.StringBuilder;
import ride.*;
enum DisplayMode { NONE, REVENUE, TICKETSSOLD }

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
    public String displayRides(){
        return this.displayRides(DisplayMode.NONE);
    }
    public String displayRides(DisplayMode mode){
        StringBuilder dispStr = new StringBuilder();
        Ride r;
        
        for(int i = 0; i < this.rides.size(); i++){
            r = this.rides.get(i);
            dispStr.append(" [" + i + "]\t");
            dispStr.append(r.toString() + "\t");
            
            if (mode == DisplayMode.REVENUE){
                dispStr.append("Revenue: ");
                dispStr.append(r.getRevenue());
            }
            else if (mode == DisplayMode.TICKETSSOLD){
                dispStr.append("Tickets sold: ");
                dispStr.append(r.getTicketsSold());
            }
            
            dispStr.append("\n");
        }
        
        System.out.println(dispStr);
        return dispStr.toString();
    }
}