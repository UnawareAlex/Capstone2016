import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.BorderLayout;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.JPanel;

/**
 * Combines Sketch and ControlPanel Classes into one frame where it is presented to user in a GUI
 * 
 * Alex Arnold 
 * 5/10/16
 */
public class Board extends JFrame
{
    private static final int FRAME_WIDTH = 2560;
    private static final int FRAME_HEIGHT = 1600;
    private Sketch sketch;
    private ControlPanel buttonPanel;
    private JPanel panel;
    
    /**
     * Default constructor for objects of class DrawingEditor
     */
    public Board() 
    {
        this.sketch = new Sketch(sketch);
        this.buttonPanel = new ControlPanel(sketch);
        
        this.panel = new JPanel(new BorderLayout()); //Need a singular panel to add to my frame
        this.panel.add(sketch, BorderLayout.CENTER);
        this.panel.add(buttonPanel, BorderLayout.SOUTH);
      
        this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Etch-a-Sketch");
        this.setLayout(new BorderLayout());
        this.add(panel);
        this.setVisible(true);
        
        this.addKeyListener(new EventListener()); //frame will now listen to keyboard events
        this.requestFocusInWindow();
    }
    
    /**
     * Adds KeyListener to the designated arrow keys and calls sketch.updatePoints when keys are pressed
     * 
     */
    public class EventListener implements KeyListener
    {
        public void keyPressed(KeyEvent e) 
        {
            if (e.getKeyCode() == KeyEvent.VK_LEFT)
            {
                sketch.updatePoints(-4, 0); 
            }
            if (e.getKeyCode() == KeyEvent.VK_RIGHT)
            {
                sketch.updatePoints(4, 0);
            }
            if (e.getKeyCode() == KeyEvent.VK_UP)
            {
                sketch.updatePoints(0, -4);
            }
            if (e.getKeyCode() == KeyEvent.VK_DOWN)
            {
                sketch.updatePoints(0, 4);
            }
        }
        public void keyTyped(KeyEvent e) {}
        public void keyReleased(KeyEvent e) {}
    }
    
    public static void main(String[] args)
    {
        Board board = new Board();
    }
}