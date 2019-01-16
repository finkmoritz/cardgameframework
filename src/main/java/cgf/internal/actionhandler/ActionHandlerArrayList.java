package cgf.internal.actionhandler;

import java.util.ArrayList;
import java.util.Collection;

public class ActionHandlerArrayList extends ActionHandlerCollection {

	protected ArrayList<ActionHandler> actionHandlers = new ArrayList<ActionHandler>();

	@Override
	protected Collection<ActionHandler> getAllActionHandlers() {
		return actionHandlers;
	}

	@Override
	protected boolean addActionHandler(ActionHandler actionHandler) {
		return actionHandlers.add(actionHandler);
	}

	@Override
	protected boolean removeActionHandler(ActionHandler actionHandler) {
		return actionHandlers.remove(actionHandler);
	}

	@Override
	protected boolean containsActionHandler(ActionHandler actionHandler) {
		return actionHandlers.contains(actionHandler);
	}
}
