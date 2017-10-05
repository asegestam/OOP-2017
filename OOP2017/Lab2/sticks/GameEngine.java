
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
     * Startar om spelet på 21 sticks då du kör runGame
     * Om det finns mer än 0 sticks så är spelet igång
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

