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
        newY = 201;
        newX = 201;
    }
    
    public void paintComponent(Graphics g)
    {
        Graphics2D g2 = (Graphics2D)g;
        g2.draw(new Line2D.Double(initX, initY, newX, newY));
    }
   
    public class EventListener implements KeyListener
    {
        public void keyTyped(KeyEvent e) {}
        public void keyPressed(KeyEvent e) 
        {
            if (e.getKeyCode() == KeyEvent.VK_LEFT)
            {
                initX = newX;
                initY = newY;
                newX -= 1;
            }
            if (e.getKeyCode() == KeyEvent.VK_RIGHT)
            {
                initX = newX;
                initY = newY;
                newX += 1;
            }
            if (e.getKeyCode() == KeyEvent.VK_DOWN)
            {
                initX = newX;
                initY = newY;
                newY -= 1;
            }
            if (e.getKeyCode() == KeyEvent.VK_UP)
            {
                initX = newX;
                initY = newY;
                newY += 1;
            }
            repaint();
        }
        public void keyReleased(KeyEvent e) {}
    }
}