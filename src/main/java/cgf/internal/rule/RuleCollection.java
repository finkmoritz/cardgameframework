package cgf.internal.rule;

import java.util.Collection;

import cgf.CGFObject;
import cgf.rule.Rule;

public abstract class RuleCollection extends CGFObject {

	protected abstract Collection<Rule> getAllRules();
	protected abstract Collection<Rule> getAllValidRules();
	protected abstract boolean addRule(Rule rule);
	protected abstract boolean removeRule(Rule rule);
	protected abstract boolean containsRule(Rule rule);
}
