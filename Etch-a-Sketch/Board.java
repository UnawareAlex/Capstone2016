import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Board
{
    private static final int FRAME_WIDTH = 1200;
    private static final int FRAME_HEIGHT = 800;
    private Sketch sketch;
    
    public Board()
    {
        JFrame frame = new JFrame("Etch-a-Sketch");
        sketch = new Sketch();
        frame.add(sketch);
        
        //EventListener listener = new EventListener();
        //sketch.addKeyListener(listener);
        
        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public static void main(String[] args)
    {
        Board board = new Board();
    }
}