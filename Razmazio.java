import java.awt.*;
import javax.swing.*;
import javax.swing.Timer;
import java.awt.event.*;
import java.util.*;

class GamePanel extends JPanel implements ActionListener {

	// Creating images for single objects
	protected Image rz_background = new ImageIcon("backgrounds\\bkg5.png").getImage(); // Background Image
	protected Image rz_still_right = new ImageIcon("razmazio\\rz_still_right.png").getImage(); // Standing still
	protected Image rz_still_left = new ImageIcon("razmazio\\rz_still_left.png").getImage(); // Walking left
	protected Image rz_walk_left2 = new ImageIcon("razmazio\\rz_walk_left2.png").getImage(); //
	protected Image rz_walk_right2 = new ImageIcon("razmazio\\rz_walk_right2.png").getImage(); // Walking right
	protected Image rz_jump_right = new ImageIcon("razmazio\\rz_right_jump.png").getImage(); // Jumping
	protected Image rz_jump_left = new ImageIcon("razmazio\\rz_left_jump.png").getImage(); //
	protected Image pipe = new ImageIcon("razmazio\\pipe1.png").getImage(); // pipe

	Image obj = rz_still_right; // Temporary Image reference

	final private int BKMIN_X = 1000, BKMAX_X = 10000; // Min and Max of
														// background
	public int bk_x = 695; // background x and y coordinates
	public int bk_y = 535;
	public int rz_x = 600; // character x and y coordinates
	public int rz_y = 615;

	static int direction = 0; // 0=still 1=up , 2=right , 3=left , 4=down

	static boolean moveableRight = true; // variable for collision detection
	static boolean moveableLeft = true;
	static boolean moveableDown = false;
	boolean jumpright = true;

	static boolean jump = false; // For jump
	private Timer time;

	static boolean pause = false;
	int run = 0;

	GamePanel() {
		setLayout(null);
		time = new Timer(30, this); // starting a timer and passing the
									// actionlistener for the running animation
		time.start(); // starting

		addKeyListener(new KeyAdapter() // Movement of razmazio
		{
			public void keyPressed(KeyEvent kp) {

				if (kp.getKeyCode() == KeyEvent.VK_RIGHT
						& moveableRight == true) {
					direction = 2; // right
				}
				if ((kp.getKeyCode() == KeyEvent.VK_LEFT)
						& moveableLeft == true) {
					direction = 3; // left
				}
				if (kp.getKeyCode() == KeyEvent.VK_SPACE) {
					if (jump == false & rz_y == 615) // if character standing of
														// platform
					{
						jump = true;
						moveableDown = true;
						if (direction == 2)
							jumpright = true;
						if (direction == 3)
							jumpright = false;
					}
				}
			} // end keyPressed

			public void keyReleased(KeyEvent kr) {
				if (direction == 2)
					obj = rz_still_right; // if direction is right
				if (direction == 3)
					obj = rz_still_left; // if direction is left

				direction = 0; // set still image
			}
		});// end anonymous class and KeyListener
	}// end constructor

	// ///////////////////////////// TIMED ACTION LISTENER
	// \\\\\\\\\\\\\\\\\\\\\\\
	public void actionPerformed(ActionEvent e) {
		if (direction == 2)
			right();
		if (direction == 3)
			left();

		// repaint(); //repaint after 30ms
	}

	// ////////////////////////////////// PAINT FUNCTION
	// \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
	public void paintComponent(Graphics g) {

		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;

		requestFocus(); // get focus after changing card
		setFocusable(true);

		// setting background points and cash in the game
		setBackground(g2d);
		setPipes(g2d);

		// checking jump collision and enemy death
		Jump();

		if (rz_y == 615 & direction != 3 & direction != 2) // to turn razmazio
															// in normal still
															// state after jump
		{
			if (obj == rz_jump_left)
				obj = rz_still_left;
			if (obj == rz_jump_right)
				obj = rz_still_right;
		}
		g2d.drawImage(obj, rz_x, rz_y, this); // Drawing the character image

		repaint();
	} // end paintComponent

	// /////////////////////////////// DIRECTION CONDITIONS
	// \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
	void Jump() // Jump mechanism
	{

		if (moveableDown == true) {
			if (jump == true & rz_y >= 450) // For upward motion during jump
			{
				if (jumpright == true)
					obj = rz_jump_right;
				else
					obj = rz_jump_left;

				rz_y--;
				if (rz_y <= 450)
					jump = false;
			}
			if (jump == false & rz_y < 615) // For downward motion during jump
			{
				if (jumpright == true)
					obj = rz_jump_right;
				else
					obj = rz_jump_left;
				rz_y++;
			}
		}

	}// end up

	void left() {
		if (moveableLeft == true & bk_x > BKMIN_X) {
			bk_x -= 8; // decrease xcoord while moving left

			if (run % 3 == 0 | run % 5 == 0)
				obj = rz_still_left; // set image
			else
				obj = rz_walk_left2;
			run++;
		}// end if
	}// end left

	void right() {
		if (moveableRight == true & bk_x < BKMAX_X - 800) {
			bk_x += 8; // increasing xcoord while moving right

			if (run % 3 == 0 | run % 5 == 0)
				obj = rz_still_right;
			else
				obj = rz_walk_right2;
			run++;
		}// end if
	}// end right

	// ////////////////////////////////////// SETTER FUNCTIONS
	// \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
	void setBackground(Graphics g2d) {
		g2d.drawImage(rz_background, 700 - bk_x, 0, null); // Drawing background
															// relative to
															// character
	}// end setBackground

	void setPipes(Graphics g2d) {
		g2d.drawImage(pipe, 1692 - bk_x, bk_y + 45, null); // first pipe
		g2d.drawImage(pipe, 7150 - bk_x, bk_y + 45, null); // second pipe
	}// end setPipes

}// end class

public class Razmazio extends JFrame {
	GamePanel gp = new GamePanel();

	Razmazio() {
		add(gp);
		setSize(1024, 750);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

	}

	public static void main(String[] args) {
		Razmazio rz = new Razmazio();
	}// end main
}// end frame class

