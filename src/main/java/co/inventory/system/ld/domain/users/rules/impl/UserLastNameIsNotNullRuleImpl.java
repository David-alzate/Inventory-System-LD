package co.inventory.system.ld.domain.users.rules.impl;

import org.springframework.stereotype.Service;

import co.inventory.system.ld.crosscutting.helpers.TextHelper;
import co.inventory.system.ld.domain.users.exceptions.UserLastNameIsNullException;
import co.inventory.system.ld.domain.users.rules.UserLastNameIsNotNullRule;

@Service
public class UserLastNameIsNotNullRuleImpl implements UserLastNameIsNotNullRule {

	@Override
	public void validate(String data) {
		if (TextHelper.isNull(data)) {
			throw UserLastNameIsNullException.create();
		}
	}

}