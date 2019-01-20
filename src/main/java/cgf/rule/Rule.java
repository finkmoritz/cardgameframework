package cgf.rule;

import java.util.ArrayList;
import java.util.Collection;

import cgf.CGFObject;
import cgf.action.Action;
import cgf.game.Game;
import cgf.internal.game.GameChild;
import cgf.internal.validatable.Validatable;

public class Rule extends CGFObject implements GameChild, Validatable {
	
	private Game parentGame = null;
	private Collection<Class<Action>> triggeringActions = new ArrayList<Class<Action>>();
	private Collection<Class<Action>> triggeredActions = new ArrayList<Class<Action>>();
	
	public Collection<Class<Action>> getTriggeredActions(Action triggeringAction) {
		Collection<Class<Action>> actions = new ArrayList<Class<Action>>();
		for(Class<Action> actionClass : triggeringActions) {
			if(triggeringAction.getClass().equals(actionClass)) {
				actions.addAll(triggeredActions);
				break;
			}
		}
		return actions;
	}
	
	public Collection<Class<Action>> getAllTriggeringActions() {
		return triggeringActions;
	}
	
	public boolean addTriggeringAction(Class<Action> actionClass) {
		return triggeringActions.add(actionClass);
	}
	
	public boolean removeTriggeringAction(Class<Action> actionClass) {
		return triggeringActions.remove(actionClass);
	}
	
	public boolean containsTriggeringAction(Class<Action> actionClass) {
		return triggeringActions.contains(actionClass);
	}
	
	public Collection<Class<Action>> getAllTriggeredActions() {
		return triggeredActions;
	}
	
	public boolean addTriggeredAction(Class<Action> actionClass) {
		return triggeredActions.add(actionClass);
	}
	
	public boolean removeTriggeredAction(Class<Action> actionClass) {
		return triggeredActions.remove(actionClass);
	}
	
	public boolean containsTriggeredAction(Class<Action> actionClass) {
		return triggeredActions.contains(actionClass);
	}

	public boolean isValid() {
		return true;
	}

	public void setParentGame(Game parentGame) {
		this.parentGame = parentGame;
	}

	public Game getParentGame() {
		return parentGame;
	}

}
