import java.util.Random;
/**
 * Write a description of class ComputerPlayer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ComputerPlayer
{
    private Sticks sticks;
    
    public ComputerPlayer(Sticks sticks) {
        this.sticks = sticks;
    }
    /*
     * Försök på AI
     * Om sticksLeft - 2 är delbart med 3 eller är lika med 0 så tar den 1
     * Annars tar den slumpvist mellan 1 och 2 för att inte göra det allt för förutsägbart
     */
    public int move() {
        Random rand = new Random();
        int takeNumber;
        if((this.sticks.sticksLeft() - 2) % 3 == 0 || (this.sticks.sticksLeft() - 2 == 0) ){
            takeNumber = 1;
            sticks.take(takeNumber);
        }
        else{
            takeNumber = rand.nextInt(2) + 1;
            sticks.take(takeNumber);
        }
        return sticks.sticksLeft();
    }

}
