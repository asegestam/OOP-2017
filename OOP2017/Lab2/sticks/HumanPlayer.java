/**
 * Write a description of class ComputerPlayer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HumanPlayer
{
    private Sticks sticks; 
    private UserInterface ui;
    
    public HumanPlayer(Sticks sticks,UserInterface ui) {
        this.sticks = sticks;
        this.ui = ui;
    }
    /*
     * Spelarens input sparas i variablen i
     * Om i är 1 eller 2 så tas 1 eller 2 sticks från högen
     * Annars skrivs ett felmedelande ut
     */
    public int move() {
        ui.howManySticksMsg();
        while(true){
        int i = ui.nextInt();
        if(i == 1   ||  i == 2 && (sticks.sticksLeft() - i >= 0) ){
            sticks.take(i);
            break;
        }
        else{
            ui.illegalMoveMsg();
        }
    }
    return sticks.sticksLeft();
}

}