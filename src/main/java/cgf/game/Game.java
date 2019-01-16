package cgf.game;

import cgf.internal.actionhandler.ActionHandlerArrayList;

public class Game extends ActionHandlerArrayList {

	public boolean bind(GameObject gameObject) {
		gameObject.setParentGame(this);
		return addActionHandler(gameObject);
	}
	
	public boolean unbind(GameObject gameObject) {
		if(gameObject.getParentGame() == this) {
			gameObject.setParentGame(null);
		}
		return removeActionHandler(gameObject);
	}
	
	public boolean binds(GameObject gameObject) {
		return containsActionHandler(gameObject);
	}
}
