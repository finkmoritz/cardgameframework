package cgf.internal.rule;

import java.util.ArrayList;
import java.util.Collection;

import cgf.rule.Rule;

public class RuleArrayList extends RuleCollection {

	protected ArrayList<Rule> rules = new ArrayList<Rule>();

	@Override
	protected Collection<Rule> getAllRules() {
		return rules;
	}

	@Override
	protected Collection<Rule> getAllValidRules() {
		Collection<Rule> validRules = new ArrayList<Rule>();
		for(Rule rule : rules) {
			if(rule.isValid()) {
				validRules.add(rule);
			}
		}
		return validRules;
	}

	@Override
	protected boolean addRule(Rule rule) {
		return rules.add(rule);
	}

	@Override
	protected boolean removeRule(Rule rule) {
		return rules.remove(rule);
	}

	@Override
	protected boolean containsRule(Rule rule) {
		return rules.contains(rule);
	}
}
