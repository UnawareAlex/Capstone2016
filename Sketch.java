import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import javax.swing.JComponent;
import java.awt.geom.Line2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.KeyStroke;

public class Sketch extends JComponent 
{
    private Point oldPoint;
    private Point newPoint;
    
    public Sketch()
    {
        this.oldPoint = new Point(200, 200);
        this.newPoint = new Point(200, 200);
        
        this.setFocusable(true);
        this.addKeyListener(new EventListener());
    }
    
    public void updatePoints(int dx, int dy)
    {
        oldPoint.setLocation(newPoint.getX(), newPoint.getY());
        newPoint.translate(dx, dy);
            System.out.println("Updated point");
        repaint();
    }
    
    public void paintComponent(Graphics g)
    {
        Graphics2D g2 = (Graphics2D)g;
            System.out.println("Called paintComponent");
        
        g2.draw(new Line2D.Double(oldPoint, newPoint));
    }
    
    public class EventListener implements KeyListener
    {
        public void keyPressed(KeyEvent e) 
        {
            if (e.getKeyCode() == KeyEvent.VK_LEFT)
            {
                updatePoints(-1, 0);
                System.out.println("keyPressed="+KeyEvent.getKeyText(e.getKeyCode()));
            }
            if (e.getKeyCode() == KeyEvent.VK_RIGHT)
            {
                updatePoints(1, 0);
                System.out.println("keyPressed="+KeyEvent.getKeyText(e.getKeyCode()));
            }
            if (e.getKeyCode() == KeyEvent.VK_UP)
            {
                updatePoints(0, -1);
                System.out.println("keyPressed="+KeyEvent.getKeyText(e.getKeyCode()));
            }
            if (e.getKeyCode() == KeyEvent.VK_DOWN)
            {
                updatePoints(0, 1);
                System.out.println("keyPressed="+KeyEvent.getKeyText(e.getKeyCode()));
            }
        }
        public void keyTyped(KeyEvent e) {}
        public void keyReleased(KeyEvent e) {}
    }
}