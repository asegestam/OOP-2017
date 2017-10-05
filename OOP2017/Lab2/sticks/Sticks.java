/**
 * Write a description of class Sticks here.
 * 
 * @author 
 * @version 
 */
public class Sticks
{
    private int maxNoOfSticks;
    private int sticksLeft;

public Sticks(int n){
    this.maxNoOfSticks = this.sticksLeft = n;
}

public Sticks(){
    this(21);
}
/*
 * Sätter sticks till 21 dvs, startar om spelet
 */
public void newGame(){
   this.sticksLeft = 21;
}
/*
 * Returnerar antalet sticks som är kvar
 */
public int sticksLeft(){
    return this.sticksLeft;
}
/*
 * Om parameter n är mellan 1 och 2 och det finns mer sticks än n
 * så tas 1 eller 2 sticks ifrån högen
 * annars returneras -1
 */
public int take(int n){
    if( 1 <= n && n <=2 && (this.sticksLeft - n) >= 0){
        this.sticksLeft -= n;
        return sticksLeft();
    }
    else{
        return -1;
    }
}

}