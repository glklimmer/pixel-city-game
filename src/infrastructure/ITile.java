package infrastructure;

import gameobject.IGameClickable;
import gameobject.IGameObject;

public interface ITile extends IGameObject, IGameClickable {
	
	public void updateTile();
	
}
