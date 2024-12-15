package co.inventory.system.ld.domain.users.rules.impl.usertype;

import java.util.UUID;

import org.springframework.stereotype.Service;

import co.inventory.system.ld.crosscutting.helpers.ObjectHelper;
import co.inventory.system.ld.domain.users.exceptions.usertype.UserTypeIdIsNullException;
import co.inventory.system.ld.domain.users.rules.usertype.UserTypeIdIsNotNullRule;

@Service
public class UserTypeIdIsNotNullRuleImpl implements UserTypeIdIsNotNullRule {

	@Override
	public void validate(UUID data) {
		if (ObjectHelper.isNull(data)) {
			throw UserTypeIdIsNullException.create();
		}
	}

}
