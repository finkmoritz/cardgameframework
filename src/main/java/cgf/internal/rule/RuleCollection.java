package cgf.internal.trigger;

import java.util.Collection;

import cgf.CGFObject;
import cgf.trigger.Trigger;

public abstract class TriggerCollection extends CGFObject {

	protected abstract Collection<Trigger> getAllTriggers();
	protected abstract Collection<Trigger> getAllValidTriggers();
	protected abstract boolean addTrigger(Trigger trigger);
	protected abstract boolean removeTrigger(Trigger trigger);
	protected abstract boolean containsTrigger(Trigger trigger);
}
