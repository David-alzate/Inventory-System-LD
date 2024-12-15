package co.inventory.system.ld.domain.users.rules.impl.user;

import org.springframework.stereotype.Service;

import co.inventory.system.ld.crosscutting.helpers.NumericHelper;
import co.inventory.system.ld.domain.users.UserDomain;
import co.inventory.system.ld.domain.users.exceptions.user.UserIdNumberLenghIsNotValidException;
import co.inventory.system.ld.domain.users.rules.user.UserIdNumberLenghIsValidRule;

@Service
public class UserIdNumberLenghIsValidRuleImpl implements UserIdNumberLenghIsValidRule {

	private static final int MIN_LENGTH = 5;
	private static final int MAX_LENGTH = 15;

	@Override
	public void validate(UserDomain data) {
		int length = data.getIdNumber().toString().length();

		if (!NumericHelper.isBetween(length, MIN_LENGTH, MAX_LENGTH, true, true)) {
			throw UserIdNumberLenghIsNotValidException.create();
		}

	}

}
