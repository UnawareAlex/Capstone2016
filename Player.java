import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

public class Player 
{
    private static final int X = 70;
    private static final int WIDTH = 10;
    private static final int HEIGHT = 60;
    int y = 0;
    int ya = 0;
    private Soccer soccer;
    
    public Player(Soccer soccer)
    {
        this.soccer = soccer;
    }
    
    public void move() 
    {
        if (y + ya > 0 && y + ya < soccer.getHeight() - HEIGHT)
            y = y + ya;
    }
    
    public void paint(Graphics2D g)
    {
        g.fillRect(X, y, WIDTH, HEIGHT);
    }
    
    public void keyReleased(KeyEvent e) 
    {
        ya = 0;
    }
    
    public void keyPressed(KeyEvent e)
    {
        if (e.getKeyCode() == KeyEvent.VK_LEFT)
        
            ya = -soccer.speed;
        if (e.getKeyCode() == KeyEvent.VK_RIGHT)
            ya = soccer.speed;
    }
    
    public Rectangle getBounds()
    {
        return new Rectangle(X, y, WIDTH, HEIGHT);
    }
    
    public int getTopY()
    {
        return y - HEIGHT;
    }
}