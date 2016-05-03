import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Point;
import javax.swing.JComponent;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Sketch extends JComponent 
{
    private int initX;
    private int initY;
    private int newX;
    private int newY;
    
    public Sketch()
    {
        initX = 200;
        initY = 200;
        newY = 220;
        newX = 220;
    }
    
    public void updateCords(boolean compass, int direction)
    {
        //true if LEFT or RIGHT
        //flase if UP or DOWN
        if (compass == true)
        {
            initX = newX;
            initY = newY;
            newX += direction;
            System.out.println("Updated point (Left or Right)");
        }
        else
        {
            initX = newX;
            initY = newY;
            newY += direction;
            System.out.println("Update point (Up or Down)");
        }
    }
    
    public void paintComponent(Graphics g)
    {
        Graphics2D g2 = (Graphics2D)g;
        System.out.println("Called paintComponent");
        g2.draw(new Line2D.Double(initX, initY, newX, newY));
    }
}