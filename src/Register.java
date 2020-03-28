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
    
    public boolean maintainRides(){
        StringBuilder dispStr = new StringBuilder();
        ArrayList<HighRiskRide> maintained = new ArrayList<>();
        boolean maintenanceSuccess = false;
        
        for (Ride r : this.rides){
            if (r instanceof HighRiskRide){
                HighRiskRide hrr = (HighRiskRide)r;
                if (!hrr.getAvailability()){
                    hrr.doMaintenance();
                    maintained.add(hrr);
                    maintenanceSuccess = true;
                }
                
            }
        }
        dispStr.append("Carried out maintenance for rides: ");
        for (HighRiskRide mr : maintained){
            dispStr.append(mr.toString() + ", ");
        }
        System.out.println(dispStr);
        
        return maintenanceSuccess;
    }
    
    public String displayTotalRevenue(){
        StringBuilder dispStr = new StringBuilder();
        dispStr.append(" Total  Revenue: ");
        
        double total = 0.0;
        for (Ride r : this.rides){
            total += r.getRevenue();
        }
        dispStr.append(getRounded(total));
        System.out.println(dispStr);
        
        return dispStr.toString();
    }
    
    public String getRounded(double amount){
        return "" + Math.round(amount * 100.0) / 100.0;
    }
    public String displayRides(DisplayMode mode){
        StringBuilder dispStr = new StringBuilder();
        Ride r;
        
        for(int i = 0; i < this.rides.size(); i++){
            r = this.rides.get(i);
            
            dispStr.append(" [" + i + "]\t");
            
            if (mode == DisplayMode.REVENUE){
                dispStr.append("Revenue: ");
                dispStr.append(this.getRounded(r.getRevenue()) + "\t\t");
            }
            else if (mode == DisplayMode.TICKETSSOLD){
                dispStr.append("Tickets sold: ");
                dispStr.append(r.getTicketsSold() + " \t");
            }
            
            dispStr.append(r.toString() + "\t");
            
            dispStr.append("\n");
        }
        
        System.out.println(dispStr);
        return dispStr.toString();
    }
}