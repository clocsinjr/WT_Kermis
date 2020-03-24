import java.util.Scanner;
import ride.*;

class Kermis{
    private boolean running = true;
    private Register reg = new Register();
    
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
            validInput = true;
        }
        else if (choice.equals("k")){
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
            System.out.println("Invalid input '" + choice + "'");
        return validInput;
    }
    
    public void run(){
        while(this.running){
            this.reg.displayRidesInfo();
            handleUserInput();
        }
    }
    
    public static void main(String[] args){
        Kermis kermis = new Kermis();
        
        kermis.reg.addRide(new Botsautos());
        kermis.reg.addRide(new Spin());
        kermis.reg.addRide(new Spiegelpaleis());
        kermis.reg.addRide(new Spookhuis());
        kermis.reg.addRide(new Hawaii());
        kermis.reg.addRide(new Ladderklimmen());
        
        kermis.run();
    }
}