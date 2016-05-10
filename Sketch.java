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
import javax.swing.JColorChooser;

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
    
    public Sketch(Sketch sketch)
    {
        width = 4;
        height = 4;
        
        this.currentColor = Color.BLACK;
        this.canvas = sketch; 
        this.bit = new Rectangle(198, 198, width, height);
        this.newBit = new Rectangle(198, 198, width, height);
        this.squares = new ArrayList();
        
        this.circle = new Ellipse2D.Double(198, 198, width, height);
    }
    
    public void updatePoints(int dx, int dy)
    {
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
    
    public void clearList()
    {
        squares.clear();
        repaint();
    }
   
    public int getDim()
    {
        return width;
    }
    
    public void pickColor() 
    {
        currentColor = JColorChooser.showDialog(canvas, "Pick a Color", currentColor);
    }
    
    public void paintComponent(Graphics g)
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