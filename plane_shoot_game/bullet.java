package planeShootGame;

import java.awt.Graphics;

public class Bullet extends FlyObject {
	private static BufferedImage bullet;

	static {
		try {
			bullet = ImageIO.read(HeroPlane.class.geyResource("bullet.png"));
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	Bullet() {
	 super();
	}
	Bullet(int x, int y) {
		super(x, y);
	}

	public void move() {
		this.y--;
	}
	public void paintBullet(Graphics g) {
		g.drawImage(bullet, this.x, this.y, null);
	}
}
