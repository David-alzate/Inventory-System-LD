package co.inventory.system.ld.domain.users.rules.impl.user;

import org.springframework.stereotype.Service;

import co.inventory.system.ld.crosscutting.helpers.TextHelper;
import co.inventory.system.ld.domain.users.exceptions.user.UserLastNameIsEmpyException;
import co.inventory.system.ld.domain.users.rules.user.UserLastNameIsNotEmpyRule;

@Service
public class UserLastNameIsNotEmpyRuleImpl implements UserLastNameIsNotEmpyRule {

	@Override
	public void validate(String data) {
		if (TextHelper.isEmpty(data)) {
			UserLastNameIsEmpyException.create();
		}
		
	}

}
