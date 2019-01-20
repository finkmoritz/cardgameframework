package cgf.internal.trigger;

import java.util.ArrayList;
import java.util.Collection;

import cgf.trigger.Trigger;

public class TriggerArrayList extends TriggerCollection {

	protected ArrayList<Trigger> triggers = new ArrayList<Trigger>();

	@Override
	protected Collection<Trigger> getAllTriggers() {
		return triggers;
	}

	@Override
	protected Collection<Trigger> getAllValidTriggers() {
		Collection<Trigger> validTriggers = new ArrayList<Trigger>();
		for(Trigger trigger : triggers) {
			if(trigger.isValid()) {
				validTriggers.add(trigger);
			}
		}
		return validTriggers;
	}

	@Override
	protected boolean addTrigger(Trigger trigger) {
		return triggers.add(trigger);
	}

	@Override
	protected boolean removeTrigger(Trigger trigger) {
		return triggers.remove(trigger);
	}

	@Override
	protected boolean containsTrigger(Trigger trigger) {
		return triggers.contains(trigger);
	}
}
