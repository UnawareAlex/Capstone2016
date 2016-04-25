import java.awt.Graphics2D;
import java.awt.Rectangle;

public class SoccerBall {
	private static final int DIAMETER = 30;
	int x = 0;
	int y = 0;
	int xa = 1;
	int ya = 1;
	private Soccer soccer;

	public SoccerBall(Soccer soccer) {
		this.soccer = soccer;
	}

	void move() {
		if (x + xa < 0)
			xa = 1;
		if (x + xa > soccer.getWidth() - DIAMETER)
			xa = -1;
		if (y + ya < 0)
			ya = 1;
		if (y + ya > soccer.getHeight() - DIAMETER)
			soccer.gameOver();
		if (collision()){
			ya = -1;
			y = soccer.racquet.getTopY() - DIAMETER;
		}
		x = x + xa;
		y = y + ya;
	}

	private boolean collision() {
		return soccer.racquet.getBounds().intersects(getBounds());
	}

	public void paint(Graphics2D g) {
		g.fillOval(x, y, DIAMETER, DIAMETER);
	}
	
	public Rectangle getBounds() {
		return new Rectangle(x, y, DIAMETER, DIAMETER);
	}
}