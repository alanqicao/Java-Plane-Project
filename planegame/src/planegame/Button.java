package planegame;

import java.awt.Graphics;
import java.awt.Image;

public class Button extends GameObject{
	
	private boolean play;
	
	/**
	 * @return the play
	 */
	public boolean isPlay() {
		return play;
	}

	/**
	 * @param play the play to set
	 */
	public void setPlay(boolean play) {
		this.play = play;
	}

	public Button(Image img, double x, double y) {
		this.img = img;
		this.x=x;
		this.y=y;
		this.width = img.getWidth(null);
		this.height = img.getHeight(null);
		
	}
	
	public void drawSelf(Graphics g) {
		
			g.drawImage(img, (int) x, (int) y, null);
	}

}