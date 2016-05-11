import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import javax.swing.JComponent;
import java.awt.geom.Line2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.KeyStroke;
import java.util.ArrayList;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JColorChooser;

/**
 * Combines DrawingPanel and ControlPanel Classes into one frame where it is presented to user in a GUI
 * 
 * Alex Arnold 
 * 5/10/16
 */
public class Sketch extends JPanel 
{
    private Rectangle bit;
    private Rectangle newBit;
    private ArrayList<Rectangle> squares;
    private int width;
    private int height;
    private Color currentColor;
    private Sketch canvas;
    private Ellipse2D.Double circle;
    
    /**
     * 
     * Basic constructor for the Sketch class
     */
    public Sketch(Sketch sketch)
    {
        width = 4; //starting values
        height = 4;
        
        this.currentColor = Color.BLACK;
        this.canvas = sketch; 
        this.bit = new Rectangle(198, 198, width, height);
        this.newBit = new Rectangle(198, 198, width, height);
        this.squares = new ArrayList();
        
        this.circle = new Ellipse2D.Double(198, 198, width, height); //will always be at front of the line so that the user can tell where the beginning of their line is
    }
    
    /**
     * Updates the cords and dimensions of the initial rectangle and sets the cords and dimensions of the new
     *      rectangle based on the passed in parameter. Then, a new rectangle is constructed with the same 
     *      size and dimensions as the updated rectangle and added to the ArrayList squares. The circle is also
     *      updated to stay at the front of the line.
     * 
     * @param dx    change in x-cord
     * @param dy    change in y-cord
     */
    public void updatePoints(int dx, int dy)
    {
        this.bit.setRect((int)newBit.getX(), (int)newBit.getY(), width, height); //set initial square to last new square
        this.newBit.setRect(this.bit.getX() + dx, this.bit.getY() + dy, width, height); //set new square to the updated point based on keyboard input
        Rectangle drawBit = new Rectangle(newBit.getLocation(), newBit.getSize()); //construct a new square identical to newBit and add it to the ArrayList to be drawn later
        this.squares.add(drawBit);
        
        this.circle.setFrame(newBit.getX(), newBit.getY(), width, height); //updating the position/size of the circle in front
        
        repaint();
    }
    
    /**
     * Updates the thickness of the line by changing the instance variables width and height of the rectangles
     *
     * @param  dt   change in the width/height of the rectangles
     */
    public void updateThickness(int dt)
    {
        width += dt; //updating thickness of line
        height += dt;
    }
    
    /**
     * 
     * Clears the ArrayList squares and calls repaint() in order to clear the board
     * 
     */
    public void clearList()
    {
        squares.clear();
        repaint(); //So that the user doesn't have to press the keyboard to wait for the GUI to repaint. This way, the panel clears instantly when 'Clear' is pressed
    }
   
    /**
     * 
     * Returns the instance variable width a.k.a. the dimensions of the squares used to draw the line
     * 
     * @return      the instance variable width (which will always be the same as height)
     *
     */public int getDim()
    {
        return width;
    }
    
    /**
     * 
     * Sets the instance variable currentColor to a new color as designated by JColorChooser
     * 
     */
    public void pickColor() 
    {
        currentColor = JColorChooser.showDialog(canvas, "Pick a Color", currentColor); //lets the user pick a new color for the line
    }
    
    /**
     * 
     * Paints the ArrayList squares and fills them with a pre-determined color as well as the leading circle 
     * 
     */public void paintComponent(Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g;
        for (int i = 0; i < squares.size() - 1; i++) 
        {
            g2.setColor(currentColor);
            g2.draw(squares.get(i)); 
            g2.fill(squares.get(i));
            g2.setColor(Color.RED);
            g2.draw(circle);
            g2.fill(circle);
        }
    }
}