import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class DronePilot extends JPanel implements ActionListener, KeyListener {

	protected int baseX = 0; // starting x point for rocket
	protected int baseY = 200;// starting y point for rocket
	protected int angle = 0;
	protected Timer timer;
	protected BufferedImage rocket; // rocket image
	protected BufferedImage rocks;

	protected JLabel winning; // lets user know they own
	protected JLabel lives; // number of lives left
	protected JLabel score; // score
	protected JLabel fuelElapsed; // how much fuel has elapsed
	protected JLabel gameOver;
	protected int fuel = 50; // starting fuel
	protected int userScore = 0; // starting score
	protected int livesRemaining = 3; // starting number of lives

	protected int topA; // level 1
	protected int topB;
	protected int topC;
	protected int topD;
	protected int topE;

	protected int bottomA; // level 1
	protected int bottomB;
	protected int bottomC;
	protected int bottomD;
	protected int bottomE;

	protected int topA2; // level 2
	protected int topB2;
	protected int topC2;
	protected int topD2;
	protected int topE2;

	protected int bottomA2; // level2
	protected int bottomB2;
	protected int bottomC2;
	protected int bottomD2;
	protected int bottomE2;

	protected int speed = 2;
	protected int gravity = 1;

	protected int level = 0; // starting level

	Random random = new Random();

	public DronePilot() {

		topA2 = random.nextInt(51) + 150; // randomly generated numbers for top
											// barrier
		topB2 = random.nextInt(51) + 150; // level 2
		topC2 = random.nextInt(51) + 150;
		topD2 = random.nextInt(51) + 150;
		topE2 = random.nextInt(51) + 150;

		bottomA2 = random.nextInt(51) + 150; // randomly generated numbers for
												// bottom barrier
		bottomB2 = random.nextInt(51) + 150; // level 2
		bottomC2 = random.nextInt(51) + 150;
		bottomD2 = random.nextInt(51) + 150;
		bottomE2 = random.nextInt(51) + 150;

		topA = random.nextInt(100) + 70; // randomly generated numbers for top
											// barrier
		topB = random.nextInt(100) + 70; // level 1
		topC = random.nextInt(100) + 70;
		topD = random.nextInt(100) + 70;
		topE = random.nextInt(100) + 70;

		bottomA = random.nextInt(100) + 60;// randomly generated numbers for
											// bottom barrier
		bottomB = random.nextInt(100) + 70;// level 1
		bottomC = random.nextInt(100) + 70;
		bottomD = random.nextInt(100) + 70;
		bottomE = random.nextInt(100) + 70;

		this.addKeyListener(this);
		this.setFocusable(true);
		this.requestFocusInWindow();
		timer = new Timer(50, new TimerCallback()); // how fast it goes
		timer.start(); // starting the animation

		try {
			rocket = ImageIO.read(new File("rocket.gif"));
		} catch (IOException ex) {
			System.out.println("IO Exception.");
		}

		try {
			rocks = ImageIO.read(new File("rock.gif"));
		} catch (IOException ex) {
			System.out.println("IO Exception.");
		}

		winning = new JLabel("");
		add(winning);

		lives = new JLabel("");
		add(lives);

		score = new JLabel("");
		add(score);

		fuelElapsed = new JLabel("");
		add(fuelElapsed);

		gameOver = new JLabel("");
		add(gameOver);

	}

	public void restartGame() { // restarts the game if user runs out of fuel or
								// lives
		System.out.println("dead");
		topA = random.nextInt(100) + 60;
		topB = random.nextInt(100) + 60;
		topC = random.nextInt(100) + 60;
		topD = random.nextInt(100) + 60;
		topE = random.nextInt(100) + 60;

		bottomA = random.nextInt(100) + 60;
		bottomB = random.nextInt(100) + 60;
		bottomC = random.nextInt(100) + 60;
		bottomD = random.nextInt(100) + 60;
		bottomE = random.nextInt(100) + 60;

		baseX = 0;
		baseY = 0;
		userScore = 0;
		livesRemaining = 4;
		fuel = 100;
		score.setText("score: " + String.valueOf(userScore));
		fuelElapsed.setText("fuel remaining: " + String.valueOf(fuel));
		lives.setText("lives remaining: " + String.valueOf(livesRemaining));

	}

	public void fuel() {
		if (fuel <= 0) {
			restartGame();
		}
	}

	public void lives() {
		if (livesRemaining <= 0) {
			restartGame();
		}
	}

	public void topWall1() { // level 2
		if (level == 1) {
			if (baseX <= 100 && baseY <= topA2 && baseY >= 0) {
				baseX = 0;
				baseY = 250;
				userScore -= 15;
				livesRemaining -= 1;
				System.out.println(userScore);
				System.out.println("t hit rectangle1");
				lives.setText("lives remaining: " + String.valueOf(livesRemaining));
			} else if (baseX <= 200 && baseX >= 100 && baseY <= topB2 && baseY >= 0) {
				baseX = 0;
				baseY = 250;
				userScore -= 15;
				livesRemaining -= 1;
				System.out.println(userScore);
				System.out.println("t hit rectangle2");
				lives.setText("lives remaining: " + String.valueOf(livesRemaining));
			} else if (baseX <= 300 && baseX <= 200 && baseY <= topC2 && baseY >= 0) {
				baseX = 0;
				baseY = 250;
				userScore -= 15;
				livesRemaining -= 1;
				System.out.println(userScore);
				System.out.println("t hit rectangle3");
				lives.setText("lives remaining: " + String.valueOf(livesRemaining));
			} else if (baseX <= 400 && baseX >= 300 && baseY <= topD2 && baseY >= 0) {
				baseX = 0;
				baseY = 250;
				userScore -= 15;
				livesRemaining -= 1;
				System.out.println(userScore);
				System.out.println("t hit rectangle4");
				lives.setText("lives remaining: " + String.valueOf(livesRemaining));
			} else if (baseX <= 500 && baseX >= 400 && baseY <= topE2 && baseY >= 0) {
				baseX = 0;
				baseY = 250;
				userScore -= 15;
				livesRemaining -= 1;
				System.out.println(userScore);
				System.out.println("t hit rectangle5");
				lives.setText("lives remaining: " + String.valueOf(livesRemaining));
			}
		}
	}

	public void bottomWall1() { // level 2
		if (level == 1) {
			if (baseX <= 100 && baseX >= 100 && baseY >= 500 - bottomA2) {
				baseX = 0;
				baseY = 250;
				userScore -= 15;
				livesRemaining -= 1;
				System.out.println(userScore);
				System.out.println(" b hit rectangle1");
				lives.setText("lives remaining: " + String.valueOf(livesRemaining));
			} else if (baseX <= 200 && baseX >= 100 && baseY >= 500 - bottomB2) {
				baseX = 0;
				baseY = 250;
				userScore -= 15;
				livesRemaining -= 1;
				System.out.println(userScore);
				System.out.println("b hit rectangle2");
				lives.setText("lives remaining: " + String.valueOf(livesRemaining));
			} else if (baseX <= 300 && baseX <= 200 && baseY >= 500 - bottomC2) {
				baseX = 0;
				baseY = 250;
				userScore -= 15;
				livesRemaining -= 1;
				System.out.println(userScore);
				System.out.println("b hit rectangle3");
				lives.setText("lives remaining: " + String.valueOf(livesRemaining));
			} else if (baseX <= 400 && baseX >= 300 && baseY >= 500 - bottomD2) {
				baseX = 0;
				baseY = 250;
				userScore -= 15;
				livesRemaining -= 1;
				System.out.println(userScore);
				System.out.println("b hit rectangle4");
				lives.setText("lives remaining: " + String.valueOf(livesRemaining));
			}
		}
	}

	public void bottomWall0() { // level 1
		if (level == 0) {
			if (baseX <= 100 && baseX >= 100 && baseY >= 500 - bottomA) {
				baseX = 0;
				baseY = 250;
				userScore -= 15;
				livesRemaining -= 1;
				System.out.println(userScore);
				System.out.println(" b hit rectangle1");
				lives.setText("lives remaining: " + String.valueOf(livesRemaining));
			} else if (baseX <= 200 && baseX >= 100 && baseY >= 500 - bottomB) {
				baseX = 0;
				baseY = 250;
				userScore -= 15;
				livesRemaining -= 1;
				System.out.println(userScore);
				System.out.println("b hit rectangle2");
				lives.setText("lives remaining: " + String.valueOf(livesRemaining));
			} else if (baseX <= 300 && baseX <= 200 && baseY >= 500 - bottomC) {
				baseX = 0;
				baseY = 250;
				userScore -= 15;
				livesRemaining -= 1;
				System.out.println(userScore);
				System.out.println("b hit rectangle3");
				lives.setText("lives remaining: " + String.valueOf(livesRemaining));
			} else if (baseX <= 400 && baseX >= 300 && baseY >= 500 - bottomD) {
				baseX = 0;
				baseY = 250;
				userScore -= 15;
				livesRemaining -= 1;
				System.out.println(userScore);
				System.out.println("b hit rectangle4");
				lives.setText("lives remaining: " + String.valueOf(livesRemaining));
			}
		}
	}

	public void topWall0() { // level1
		if (level == 0) {
			if (baseX <= 100 && baseY <= topA && baseY >= 0) {
				baseX = 0;
				baseY = 250;
				userScore -= 15;
				livesRemaining -= 1;
				System.out.println(userScore);
				System.out.println("t hit rectangle1");
				lives.setText("lives remaining: " + String.valueOf(livesRemaining));
			} else if (baseX <= 200 && baseX >= 100 && baseY <= topB && baseY >= 0) {
				baseX = 0;
				baseY = 250;
				userScore -= 15;
				livesRemaining -= 1;
				System.out.println(userScore);
				System.out.println("t hit rectangle2");
				lives.setText("lives remaining: " + String.valueOf(livesRemaining));
			} else if (baseX <= 300 && baseX <= 200 && baseY <= topC && baseY >= 0) {
				baseX = 0;
				baseY = 250;
				userScore -= 15;
				livesRemaining -= 1;
				System.out.println(userScore);
				System.out.println("t hit rectangle3");
				lives.setText("lives remaining: " + String.valueOf(livesRemaining));
			} else if (baseX <= 400 && baseX >= 300 && baseY <= topD && baseY >= 0) {
				baseX = 0;
				baseY = 250;
				userScore -= 15;
				livesRemaining -= 1;
				System.out.println(userScore);
				System.out.println("t hit rectangle4");
				lives.setText("lives remaining: " + String.valueOf(livesRemaining));
			} else if (baseX <= 500 && baseX >= 400 && baseY <= topE && baseY >= 0) {
				baseX = 0;
				baseY = 250;
				userScore -= 15;
				livesRemaining -= 1;
				System.out.println(userScore);
				System.out.println("t hit rectangle5");
				lives.setText("lives remaining: " + String.valueOf(livesRemaining));
			}
		}
	}

	public void winner1() {
		if (level == 0) {
			if (baseX <= 500 && baseX >= 400 && baseY >= 500 - bottomE + 10) {
				System.out.println("winner! 1");
				level = 1;
				baseX = 0;
				baseY = 200;
				fuel = 50;
				userScore += 100;
			}
		} else if (level == 1) {
			if (baseX <= 500 && baseX >= 400 && baseY >= 500 - bottomE2 + 10) {

				System.out.println("winner! 2");
				winning.setText("YOU WON");

			}
		}
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.drawImage(rocks, 0, 0, null);

		Graphics2D g2 = (Graphics2D) g;
		AffineTransform af = g2.getTransform();
		g2.rotate(Math.toRadians(angle), baseX + 15, baseY + 15);
		g2.drawImage(rocket, baseX, baseY, null);
		g2.setTransform(af);

		if (level == 0) {
			g.setColor(Color.RED);
			g.drawString("LEVEL 1", 50, 300);

			g.setColor(Color.gray);
			// top border
			g.fillRect(0, 0, 100, topA);
			g.fillRect(100, 0, 100, topB);
			g.fillRect(200, 0, 100, topC);
			g.fillRect(300, 0, 100, topD);
			g.fillRect(400, 0, 100, topE);

			// bottom border
			g.fillRect(0, 500 - bottomA, 100, bottomA);
			g.fillRect(100, 500 - bottomB, 100, bottomB);
			g.fillRect(200, 500 - bottomC, 100, bottomC);
			g.fillRect(300, 500 - bottomD, 100, bottomD);
			g.fillRect(400, 500 - bottomE, 100, bottomE);

			g.setColor(Color.RED);
			g.fillRect(400, 500 - bottomE, 100, 10);
			g.drawImage(rocks, 0, 0, null);
			g.drawImage(rocks, 100, 0, null);
			g.drawImage(rocks, 200, 0, null);
			g.drawImage(rocks, 300, 0, null);
			g.drawImage(rocks, 400, 0, null);

			g.drawImage(rocks, 0, 420, null);
			g.drawImage(rocks, 100, 420, null);
			g.drawImage(rocks, 200, 420, null);
			g.drawImage(rocks, 300, 420, null);
			g.drawImage(rocks, 400, 420, null);

		}
		if (level == 1) {
			g.setColor(Color.RED);
			g.drawString("LEVEL 2", 50, 300);
			g.setColor(Color.gray);
			// top border
			g.fillRect(0, 0, 100, topA2);
			g.fillRect(100, 0, 100, topB2);
			g.fillRect(200, 0, 100, topC2);
			g.fillRect(300, 0, 100, topD2);
			g.fillRect(400, 0, 100, topE2);

			// bottom border
			g.fillRect(0, 500 - bottomA2, 100, bottomA2);
			g.fillRect(100, 500 - bottomB2, 100, bottomB2);
			g.fillRect(200, 500 - bottomC2, 100, bottomC2);
			g.fillRect(300, 500 - bottomD2, 100, bottomD2);
			g.fillRect(400, 500 - bottomE2, 100, bottomE2);

			g.drawImage(rocks, 0, 0, null);
			g.drawImage(rocks, 100, 0, null);
			g.drawImage(rocks, 200, 0, null);
			g.drawImage(rocks, 300, 0, null);
			g.drawImage(rocks, 400, 0, null);

			g.drawImage(rocks, 0, 420, null);
			g.drawImage(rocks, 100, 420, null);
			g.drawImage(rocks, 200, 420, null);
			g.drawImage(rocks, 300, 420, null);
			g.drawImage(rocks, 400, 420, null);

			g.setColor(Color.RED);
			g.fillRect(400, 500 - bottomE2, 100, 10);
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {

		if (e.getKeyCode() == KeyEvent.VK_UP) {
			baseY -= 15;
			System.out.println("up");

			userScore += 5;
			System.out.println(userScore);
			score.setText("score: " + String.valueOf(userScore));

			fuel -= 1;
			System.out.println(fuel);
			fuelElapsed.setText("fuel remaining: " + String.valueOf(fuel));

			repaint();

		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			angle -= 7;
			baseX -= 15;
			System.out.println("left");

			userScore += 5;
			System.out.println(userScore);
			score.setText("score: " + String.valueOf(userScore));

			fuel -= 1;
			System.out.println(fuel);
			fuelElapsed.setText("fuel remaining: " + String.valueOf(fuel));

			repaint();
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			angle += 7;
			baseX += 15;
			System.out.println("right");

			userScore += 5;
			System.out.println(userScore);
			score.setText("score: " + String.valueOf(userScore));

			fuel -= 1;
			System.out.println(fuel);
			fuelElapsed.setText("fuel remaining: " + String.valueOf(fuel));

			repaint();
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		speed = 2;
		baseY = baseY + speed;

		repaint();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		repaint();

	}

	protected class TimerCallback implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			topWall1();
			bottomWall1();
			topWall0();
			bottomWall0();
			lives();
			fuel();
			repaint();
			winner1();

			baseY = baseY + gravity;

		}

	}
}
