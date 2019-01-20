package cgf.game;

import cgf.action.Action;
import cgf.internal.actionhandler.ActionHandlerArrayList;
import cgf.internal.trigger.Trigger;

public class Game extends ActionHandlerArrayList implements Trigger {

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

	public void trigger(Action action) {
		// TODO Auto-generated method stub
		
	}
}
