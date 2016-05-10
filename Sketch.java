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
import java.awt.Color;
import javax.swing.JPanel;

public class Sketch extends JPanel 
{
    private Point oldPoint;
    private Point newPoint;
    private Line2D.Double line;
    private ArrayList<Line2D.Double> lines;
    
    private Rectangle bit;
    private Rectangle newBit;
    private ArrayList<Rectangle> squares;
    private int width;
    private int height;
//     private static final int IFW = JComponent.WHEN_IN_FOCUSED_WINDOW;
//     private static final String MOVE_UP = "move up";
//     private static final String MOVE_DOWN = "move down";
//     private static final String MOVE_LEFT = "move left";
//     private static final String RIGHT = "move right";
    
    private Ellipse2D.Double circle;
    //private Ellipse2D.Double newBit;
    //private ArrayList<Ellipse2D.Double> circles;
    
    public Sketch()
    {
        this.oldPoint = new Point(200, 200);
        this.newPoint = new Point(200, 200);
        this.lines = new ArrayList();
        this.setFocusable(true);
   
        
        width = 8;
        height = 8;
        
        this.bit = new Rectangle(198, 198, width, height);
        this.newBit = new Rectangle(198, 198, width, height);
        this.squares = new ArrayList();
        
        this.circle = new Ellipse2D.Double(198, 198, width, height);
//         this.newBit = new Ellipse2D.Double(198, 198, 4, 4);
//         this.circles = new ArrayList();
//         circles.add(bit);
    }
    
    public void updatePoints(int dx, int dy)
    {
        oldPoint.setLocation(newPoint.getX(), newPoint.getY());
        newPoint.translate(dx, dy);
        line = new Line2D.Double(oldPoint, newPoint);
        lines.add(line);
        
        bit.setLocation((int)newBit.getX(), (int)newBit.getY());
        newBit.translate(dx, dy);
        Rectangle drawBit = new Rectangle(newBit.getLocation(), newBit.getSize());
        squares.add(drawBit);
        
         circle.setFrame(newBit.getX(), newBit.getY(), 8, 8);
//         newBit.setFrame(bit.getX() + dx, bit.getY() + dy, 4, 4);
//         Ellipse2D.Double drawBit = new Ellipse2D.Double(newBit.getX(), newBit.getY(), 4, 4);
//         circles.add(drawBit);
        
        repaint();
    }
    
    public void paintComponent(Graphics g)
    {
        Graphics2D g2 = (Graphics2D)g;
        //g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
//         for (int i = 0; i < lines.size(); i++) 
//         {
//             Line2D.Double newLine = lines.get(i);
//             g2.draw(newLine);
//         }
        
        for (int i = 0; i < squares.size() - 1; i++) 
        {
            g2.setColor(Color.BLACK);
            g2.draw(squares.get(i)); 
            g2.fill(squares.get(i));
            g2.setColor(Color.RED);
            g2.draw(circle);
            g2.fill(circle);
        }
        
//         for (int i = 0; i < circles.size(); i++) 
//         {
//             g2.draw(circles.get(i));
//         }
    }
    
    
}