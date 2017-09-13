package infrastructure;

import grid.GameGrid;

public class TestTile extends AbstractTile {
	
	public TestTile(GameGrid<ITile> tileGrid) {
		super(tileGrid);
	}
	
	@Override
	public void updateTile() {}
	
	@Override
	public void clicked() {}
}
