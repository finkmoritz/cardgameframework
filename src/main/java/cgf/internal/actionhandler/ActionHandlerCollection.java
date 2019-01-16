package cgf.internal.actionhandler;

import java.util.Collection;

import cgf.CGFObject;

public abstract class ActionHandlerCollection extends CGFObject {

	protected abstract Collection<ActionHandler> getAllActionHandlers();
	protected abstract boolean addActionHandler(ActionHandler actionHandler);
	protected abstract boolean removeActionHandler(ActionHandler actionHandler);
	protected abstract boolean containsActionHandler(ActionHandler actionHandler);
}
