package infrastructure;

import grid.GameGrid;

public class GrassTile extends AbstractTile {
	
	public GrassTile(GameGrid<ITile> tileGrid) {
		super(tileGrid);
		setImages("Gras01.png", "Gras02.png");
	}
	
	@Override
	public void updateTile() {
		// Nothing to do
	}
	
	@Override
	public void clicked() {
		StreetTile streetTile = new StreetTile(tileGrid);
		tileGrid.replace(this, streetTile);
		streetTile.updateTile();
	}
}
