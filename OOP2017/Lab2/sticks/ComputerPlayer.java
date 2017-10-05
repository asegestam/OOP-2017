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
     * F�rs�k p� AI
     * Om sticksLeft - 2 �r delbart med 3 eller �r lika med 0 s� tar den 1
     * Annars tar den slumpvist mellan 1 och 2 f�r att inte g�ra det allt f�r f�ruts�gbart
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
