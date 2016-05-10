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
//     private Point oldPoint;
//     private Point newPoint;
//     private Line2D.Double line;
//     private ArrayList<Line2D.Double> lines;
//     
    private Rectangle bit;
    private Rectangle newBit;
    private ArrayList<Rectangle> squares;
    private int width;
    private int height;
    
    private Ellipse2D.Double circle;
    
    public Sketch()
    {
//         this.oldPoint = new Point(200, 200);
//         this.newPoint = new Point(200, 200);
//         this.lines = new ArrayList();
//         this.setFocusable(true);
//    
//         
        width = 4;
        height = 4;
        
        this.bit = new Rectangle(198, 198, width, height);
        this.newBit = new Rectangle(198, 198, width, height);
        this.squares = new ArrayList();
        
        this.circle = new Ellipse2D.Double(198, 198, width, height);
    }
    
    public void updatePoints(int dx, int dy)
    {
//         oldPoint.setLocation(newPoint.getX(), newPoint.getY());
//         newPoint.translate(dx, dy);
//         line = new Line2D.Double(oldPoint, newPoint);
//         lines.add(line);
//         
        this.bit.setRect((int)newBit.getX(), (int)newBit.getY(), width, height);
        this.newBit.setRect(this.bit.getX() + dx, this.bit.getY() + dy, width, height);
        Rectangle drawBit = new Rectangle(newBit.getLocation(), newBit.getSize());
        this.squares.add(drawBit);
        
        this.circle.setFrame(newBit.getX(), newBit.getY(), width, height);
        
        repaint();
    }
    
    public void updateThickness(int dt)
    {
        width += dt;
        height += dt;
    }
   
    public int getDim()
    {
        return width;
    }
    
    public void paintComponent(Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g;
        for (int i = 0; i < squares.size() - 1; i++) 
        {
            g2.setColor(Color.BLACK);
            g2.draw(squares.get(i)); 
            g2.fill(squares.get(i));
            g2.setColor(Color.RED);
            g2.draw(circle);
            g2.fill(circle);
        }
    }
    
    
}