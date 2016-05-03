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
    private static final int FRAME_WIDTH = 400;
    private static final int FRAME_HEIGHT = 400;
    private Sketch sketch;
    
    public Board()
    {
        JFrame frame = new JFrame("Etch-a-Sketch");
        sketch = new Sketch();
        frame.add(sketch);
        
        EventListener listener = new EventListener();
        sketch.addKeyListener(listener);
        
        KeyboardExample2 keyboardExample = new KeyboardExample2();
		frame.add(keyboardExample);
        
        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
	
    public class EventListener implements KeyListener
    {
        public void keyTyped(KeyEvent e) {}
        public void keyPressed(KeyEvent e) 
        {
            if (e.getKeyCode() == KeyEvent.VK_LEFT)
            {
                sketch.updateCords(true, -1);
                System.out.println("keyPressed="+KeyEvent.getKeyText(e.getKeyCode()));
            }
            if (e.getKeyCode() == KeyEvent.VK_RIGHT)
            {
                sketch.updateCords(true, 1);
                System.out.println("keyPressed="+KeyEvent.getKeyText(e.getKeyCode()));
            }
            if (e.getKeyCode() == KeyEvent.VK_UP)
            {
                sketch.updateCords(false, -1);
                System.out.println("keyPressed="+KeyEvent.getKeyText(e.getKeyCode()));
            }
            if (e.getKeyCode() == KeyEvent.VK_DOWN)
            {
                sketch.updateCords(false, 1);
                System.out.println("keyPressed="+KeyEvent.getKeyText(e.getKeyCode()));
            }
            sketch.repaint();
        }
        public void keyReleased(KeyEvent e) {}
    }
    
    public static void main(String[] args)
    {
        Board board = new Board();
    }
}