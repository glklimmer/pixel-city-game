/**
 * 
 */
package gameobject;

import java.awt.event.KeyEvent;

public class BlueCar extends GameObject {
	
	public BlueCar() {
		super();
		setImage("BlueCar01.png");
	}
	
	public BlueCar(int x, int y) {
		this();
		this.x = x;
		this.y = y;
	}
	
	@Override
	public void update() {
		if (input.isKeyDown(KeyEvent.VK_W)) {
			y--;
		}
		if (input.isKeyDown(KeyEvent.VK_D)) {
			x++;
		}
		if (input.isKeyDown(KeyEvent.VK_S)) {
			y++;
		}
		if (input.isKeyDown(KeyEvent.VK_A)) {
			x--;
		}
	}
}
