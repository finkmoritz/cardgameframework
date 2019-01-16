package cgf.internal.actionhandler;

import cgf.action.Action;
import cgf.exception.CGFException;

public interface ActionHandler {

	public void handleAction(Action action) throws CGFException;
}
