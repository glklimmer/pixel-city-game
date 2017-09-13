package main;

import canvas.GameCanvas;
import gameobject.BlueCar;
import grid.GameGrid;
import infrastructure.GrassTile;
import infrastructure.ITile;

public class PixelGame extends GameCanvas {
	private static final long serialVersionUID = 1L;
	
	@Override
	public void start() {
		GameGrid<ITile> tileGrid = new GameGrid<>(30, 10);
		tileGrid.fillWithGameObjectTemplate(() -> new GrassTile(tileGrid));
		
		new BlueCar(200, 200);
	}
	
	@Override
	public void stop() {
		// Nothing to do for now
	}
	
	public static void main(String[] args) {
		new PixelGame();
	}
}
