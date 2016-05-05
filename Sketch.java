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
import java.awt.RenderingHints;
public class Sketch extends JComponent 
{
    private Point oldPoint;
    private Point newPoint;
    private Line2D.Double line;
    private ArrayList<Line2D.Double> lines;
    
    //private Rectangle bit;
    //private ArrayList<Rectngle> squares;
    
    private Ellipse2D.Double bit;
    private ArrayList<Ellipse2D.Double> circles;
    
    public Sketch()
    {
        this.oldPoint = new Point(200, 200);
        this.newPoint = new Point(200, 200);
        this.lines = new ArrayList();
        this.setFocusable(true);
        this.addKeyListener(new EventListener());
        
        //this.bit = new Rectangle(200, 200, 4, 4);
        //this.squares = new ArrayList();
        
        this.bit = new Ellipse2D.Double(198, 198, 4, 4);
        this.circles = new ArrayList();
        circles.add(bit);
    }
    
    public void updatePoints(int dx, int dy)
    {
        oldPoint.setLocation(newPoint.getX(), newPoint.getY());
        newPoint.translate(dx, dy);
        line = new Line2D.Double(oldPoint, newPoint);
        lines.add(line);
        
        //bit.translate(dx, dy);
        bit.setFrame(bit.getX() + dx, bit.getY() + dy, 4, 4);
        circles.add(bit);
        
        repaint();
    }
    
    public void paintComponent(Graphics g)
    {
        Graphics2D g2 = (Graphics2D)g;
        //g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        for (int i = 0; i < lines.size(); i++) 
        {
            Line2D.Double newLine = lines.get(i);
            g2.draw(newLine);
        }
        
        for (int i = 0; i < circles.size(); i++) 
        {
            g2.draw(circles.get(i));
        }
    }
    
    public class EventListener implements KeyListener
    {
        public void keyPressed(KeyEvent e) 
        {
            if (e.getKeyCode() == KeyEvent.VK_LEFT)
            {
                updatePoints(-4, 0);
            }
            if (e.getKeyCode() == KeyEvent.VK_RIGHT)
            {
                updatePoints(4, 0);
            }
            if (e.getKeyCode() == KeyEvent.VK_UP)
            {
                updatePoints(0, -4);
            }
            if (e.getKeyCode() == KeyEvent.VK_DOWN)
            {
                updatePoints(0, 4);
            }
        }
        public void keyTyped(KeyEvent e) {}
        public void keyReleased(KeyEvent e) {}
    }
}