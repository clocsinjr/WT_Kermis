package ride;

public abstract class Ride{
    private String name;
    private double price;
    private int surfaceArea;
    
    private double revenue;
    private int ticketsSold;
    
    Ride(String name){
        this.name = name;
    }
    
    public void setPrice(double newPrice){
        this.price = newPrice;
    }
    
    public double getRevenue(){
        return this.revenue;
    }
    public int getTicketsSold(){
        return this.ticketsSold;
    }
    public void executeRide(){
        System.out.println("Ride '" + this.name + "' is running");
        this.ticketsSold++;
        this.revenue += this.price;
    }
    
    public String toString(){
        String disp = this.name;
        return disp;
    }
}
