
/**
 * Write a description of class GameEngine here.
 * 
 * @author 
 * @version 
 */
public class GameEngine
{

    private Sticks sticks;

    private ComputerPlayer computerPlayer;

    private HumanPlayer humanPlayer;

    private UserInterface ui;
    
    public GameEngine(){
        //Kopplar ComputerPlayer med sticks och HumanPlayer med sticks och ui
        this.sticks = new Sticks();
        this.ui = new UserInterface();
        this.computerPlayer = new ComputerPlayer(this.sticks);
        this.humanPlayer = new HumanPlayer(this.sticks, this.ui);
        
    }
    /*
     * Startar om spelet p� 21 sticks d� du k�r runGame
     * Om det finns mer �n 0 sticks s� �r spelet ig�ng
     */
    public void runGame(){
        sticks.newGame();
        while(this.sticks.sticksLeft() > 0){
        ui.sticksLeftMsg(sticks.sticksLeft());
        if(humanPlayer.move() == 0){
                ui.computerWinMsg();   
        }
        else if(computerPlayer.move() == 0){
                ui.playerWinMsg();   
        }
    }
}
}

