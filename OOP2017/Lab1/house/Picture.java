/**
 * This class represents a simple picture. You can draw the picture using
 * the draw method. But wait, there's more: being an electronic picture, it
 * can be changed. You can set it to black-and-white display and back to
 * colors (only after it's been drawn, of course).
 *
 * This class was written as an early example for teaching Java with BlueJ.
 * 
 * @author  Michael Kölling and David J. Barnes
 * @version 2011.07.31
 */
public class Picture
{
    private Square wall;
    private Square window;
    private Triangle roof;
    private Circle sun;
    private Circle sun2;
    private Person jeff;

    /**
     * Constructor for objects of class Picture
     */
    public Picture()
    {
    }

    /**
     * Draw this picture.
     */
    public void draw()
    {
        wall = new Square();
        wall.moveHorizontal(-140);
        wall.moveVertical(20);
        wall.changeSize(120);
        wall.makeVisible();
        
        window = new Square();
        window.changeColor("black");
        window.moveHorizontal(-120);
        window.moveVertical(40);
        window.changeSize(40);
        window.makeVisible();

        roof = new Triangle();  
        roof.changeSize(60, 180);
        roof.moveHorizontal(20);
        roof.moveVertical(-60);
        roof.makeVisible();

        sun = new Circle();
        sun.changeColor("blue");
        sun.moveHorizontal(100);
        sun.moveVertical(-40);
        sun.changeSize(80);
        sun.makeVisible();
        /*Excercuse 1.18
        sun.slowMoveVertical(260);
        /* Excercise 1.17
        sun2 = new Circle();
        sun2.changeColor("blue");
        sun2.moveHorizontal(-200);
        sun2.moveVertical(-40);
        sun2.changeSize(80);
        sun2.makeVisible();
        */
    }
    
    
    public void sunset()
    {
        if (wall != null)   // only if it's painted already...
        {
            /*
             * Övning 1.19
             */
            sun.slowMoveVertical(260);
            
            /* Övning 1.20 
             * Personen flyttas till huset efter solnedgången
             */
            jeff = new Person();
            jeff.makeVisible();
            jeff.slowMoveHorizontal(250);
            
        }
    }

    /**
     * Change this picture to black/white display
     */
    public void setBlackAndWhite()
    {
        if (wall != null)   // only if it's painted already...
        {
            wall.changeColor("black");
            window.changeColor("white");
            roof.changeColor("black");
            sun.changeColor("black");
            //sun2.changeColor("black");
        }
    }

    /**
     * Change this picture to use color display
     */
    public void setColor()
    {
        if (wall != null)   // only if it's painted already...
        {
            wall.changeColor("red");
            window.changeColor("black");
            roof.changeColor("green");
            sun.changeColor("blue");
            //sun2.changeColor("blue");
        }
    }
}
