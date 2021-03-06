package cgf.action;

import cgf.CGFObject;
import cgf.game.Game;
import cgf.internal.game.GameChild;
import cgf.internal.trigger.Trigger;

public class Action extends CGFObject implements GameChild, Trigger {
	
	private Game parentGame = null;
	
	public void initialize(Action triggeringAction) {
		return;
	}
	
	public void execute() {
		return;
	}

	public void setParentGame(Game parentGame) {
		this.parentGame = parentGame;
		
	}

	public Game getParentGame() {
		return parentGame;
	}

	public void trigger(Action action) {
		getParentGame().trigger(action);
	}
}
