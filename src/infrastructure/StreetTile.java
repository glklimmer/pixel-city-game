package infrastructure;

import java.util.Optional;

import grid.GameGrid;
import logger.GameLogger;

public class StreetTile extends AbstractTile {
	
	public StreetTile(GameGrid<ITile> tileGrid) {
		super(tileGrid);
	}
	
	@Override
	public void updateTile() {
		updateTile(true);
	}
	
	public void updateTile(boolean updateNeighbours) {
		double rotation = 0.0;
		int streetNeighbourCount = (int) tileGrid.getNeighbours(this).filter(tile -> tile instanceof StreetTile)
				.count();
		
		Optional<ITile> leftNeighbour = tileGrid.getLeftNeighbour(this);
		boolean left = leftNeighbour.isPresent() && leftNeighbour.get() instanceof StreetTile;
		Optional<ITile> topNeighbour = tileGrid.getTopNeighbour(this);
		boolean top = topNeighbour.isPresent() && topNeighbour.get() instanceof StreetTile;
		Optional<ITile> rightNeighbour = tileGrid.getRightNeighbour(this);
		boolean right = rightNeighbour.isPresent() && rightNeighbour.get() instanceof StreetTile;
		Optional<ITile> bottomNeighbour = tileGrid.getBottomNeighbour(this);
		boolean bottom = bottomNeighbour.isPresent() && bottomNeighbour.get() instanceof StreetTile;
		StringBuilder path = new StringBuilder();
		
		switch (streetNeighbourCount) {
		case 4:
			path.append("Intersection");
			break;
		case 3:
			path.append("TreewayIntersection");
			if (!top) {
				rotation = 90;
			} else if (!right) {
				rotation = 180;
			} else if (!bottom) {
				rotation = 270;
			}
			break;
		case 2:
			if (top && bottom || left && right) {
				path.append("StraightStreet");
				if (left && right) {
					rotation = 90;
				}
			} else {
				path.append("CornerStreet");
				if (left && bottom) {
					rotation = 90;
				} else if (top && left) {
					rotation = 180;
				} else if (top && right) {
					rotation = 270;
				}
			}
			break;
		case 1:
			if (left || right) {
				rotation = 90;
			}
			path.append("StraightStreet");
			break;
		default:
			path.append("StraightStreet");
		}
		
		setImage(path.append(".png").toString());
		rotate(rotation);
		
		if (updateNeighbours) {
			tileGrid.getNeighbours(this).filter(tile -> tile instanceof StreetTile).map(StreetTile.class::cast)
					.forEach(tile -> tile.updateTile(false));
		}
	}
	
	@Override
	public void clicked() {
		GameLogger.info("Street clicked!");
	}
}
