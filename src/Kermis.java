import java.util.Scanner;
import ride.*;

class Kermis{
    public static final String defaultOptions = "" +
        " [o]\tRevenue (Omzet)\n" +
        " [k]\tNumber of tickets sold (Kaartjes)\n" +
        " [q]\tQuit\n";
    
    private boolean running = true;
    private Register reg = new Register();
    private DisplayMode dispM = DisplayMode.NONE;
    
    String askUserString(String question){
        Scanner inputScanner = new Scanner(System.in);
        System.out.print(question);
        return inputScanner.nextLine().trim();
    }
    
    public boolean isInt(String str){
        boolean isValidInt = false;
        try{
            Integer.parseInt(str);
            isValidInt = true;
        }
        catch(Exception e){}
        
        return isValidInt;
    }
    
    public boolean handleUserInput(){
        int choiceInt;
        boolean isValidInt;
        boolean validInput = false;
        
        
        String choice = askUserString("Choice: ").trim();
        
        // Check if the user wants to run a ride
        if (isInt(choice)){
            choiceInt = Integer.parseInt(choice);
            if (choiceInt >= 0 && choiceInt < this.reg.getNumRides()){
                this.reg.executeRide(choiceInt);
                validInput = true;
            }
        }
        else if (choice.equals("o")){
            this.dispM = DisplayMode.REVENUE;
            validInput = true;
        }
        else if (choice.equals("k")){
            this.dispM = DisplayMode.TICKETSSOLD;
            validInput = true;
        }
        else if (choice.equals("q")){
            this.running = false;
            validInput = true;
        }
        else{
            validInput = false;
        }
        
        if (!validInput)
            System.out.print("Invalid input '" + choice + "', ");
        return validInput;
    }
    
    public void run(){
        boolean validInput = true;
        
        while(this.running){
            if (validInput){
                this.reg.displayRides(this.dispM);
                System.out.println(defaultOptions);
            }
            dispM = DisplayMode.NONE;
            validInput = handleUserInput();
            
        }
    }
    
    public static void main(String[] args){
        Kermis kermis = new Kermis();
        
        kermis.reg.addRide(new Botsautos("Botsautos"));
        kermis.reg.addRide(new Spin("Spin\t"));
        kermis.reg.addRide(new Spiegelpaleis("Spiegelpaleis"));
        kermis.reg.addRide(new Spookhuis("Spookhuis"));
        kermis.reg.addRide(new Hawaii("Hawaii\t"));
        kermis.reg.addRide(new Ladderklimmen("Ladderklimmen"));
        
        kermis.run();
    }
}