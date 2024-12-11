package co.inventory.system.ld.domain.users.rules.impl;

import org.springframework.stereotype.Service;

import co.inventory.system.ld.crosscutting.helpers.TextHelper;
import co.inventory.system.ld.domain.users.exceptions.UserLastNameIsEmpyException;
import co.inventory.system.ld.domain.users.rules.UserLastNameIsNotEmpyRule;

@Service
public class UserLastNameIsNotEmpyRuleImpl implements UserLastNameIsNotEmpyRule {

	@Override
	public void validate(String data) {
		if (TextHelper.isEmpty(data)) {
			UserLastNameIsEmpyException.create();
		}
		
	}

}
