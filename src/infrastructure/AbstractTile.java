package infrastructure;

import gameobject.GameClickableObject;
import grid.GameGrid;

public abstract class AbstractTile extends GameClickableObject implements ITile {
	
	protected GameGrid<ITile> tileGrid;
	
	public AbstractTile(GameGrid<ITile> tileGrid) {
		super();
		this.tileGrid = tileGrid;
	}
	
	@Override
	public void update() {
		// Nothing to do now
	}
}
