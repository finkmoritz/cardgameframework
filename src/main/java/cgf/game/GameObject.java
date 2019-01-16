package cgf.game;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

import cgf.action.Action;
import cgf.exception.CGFException;
import cgf.internal.actionhandler.ActionHandler;
import cgf.internal.game.GameChild;
import cgf.internal.trigger.TriggerArrayList;
import cgf.trigger.Trigger;

public class GameObject extends TriggerArrayList implements GameChild, ActionHandler {

	private Game parentGame = null;

	public void handleAction(Action action) throws CGFException {
		ArrayList<Class<Action>> alltriggeredActionClasses = getAllTriggeredActionClasses(action);
		ArrayList<Action> triggeredActions = new ArrayList<Action>();
		for(Class<Action> actionClass : alltriggeredActionClasses) {
			Action a = getActionFromClass(actionClass);
			a.initialize(action);
			triggeredActions.add(a);
		}
		//TODO queue triggeredActions
	}
	
	private ArrayList<Class<Action>> getAllTriggeredActionClasses(Action action) {
		ArrayList<Trigger> triggers = (ArrayList<Trigger>) getAllValidTriggers();
		ArrayList<Class<Action>> alltriggeredActionClasses = new ArrayList<Class<Action>>();
		for(Trigger trigger : triggers) {
			alltriggeredActionClasses.addAll(trigger.getTriggeredActions(action));
		}
		return alltriggeredActionClasses;
	}
	
	private Action getActionFromClass(Class<Action> actionClass) throws CGFException {
		Action action = null;
		try {
			Constructor<?> actionConstructor = actionClass.getConstructor();
			action = (Action) actionConstructor.newInstance();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
			throw new CGFException("Unable to find the default constructor for class "+actionClass.getName());
		} catch (SecurityException e) {
			e.printStackTrace();
			throw new CGFException("Security violation while instantiating class "+actionClass.getName());
		} catch (InstantiationException e) {
			e.printStackTrace();
			throw new CGFException("Unable to create instance of class "+actionClass.getName());
		} catch (IllegalAccessException e) {
			e.printStackTrace();
			throw new CGFException("Unable to access constructor of class "+actionClass.getName()+" from class "+getClass().getName());
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			throw new CGFException("Illegal or inappropriate argument for constructor of class "+actionClass.getName());
		} catch (InvocationTargetException e) {
			e.printStackTrace();
			throw new CGFException("Exception thrown while invoking the default constructor of class "+actionClass.getName());
		}
		return action;
	}

	public void setParentGame(Game parentGame) {
		this.parentGame = parentGame;
	}

	public Game getParentGame() {
		return parentGame;
	}
}
