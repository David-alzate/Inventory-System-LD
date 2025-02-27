package co.inventory.system.ld.domain.users.rules.impl.user;

import org.springframework.stereotype.Service;

import co.inventory.system.ld.domain.users.exceptions.user.UserLastNameLenghIsNotValidException;
import co.inventory.system.ld.domain.users.rules.user.UserLastNameLenghIsValidRule;

@Service
public class UserLastNameLenghIsValidRuleImpl implements UserLastNameLenghIsValidRule {

	private static final int MIN_NAME_LENGTH = 3;
	private static final int MAX_NAME_LENGTH = 50;

	@Override
	public void validate(String data) {
		if (data.length() < MIN_NAME_LENGTH || data.length() > MAX_NAME_LENGTH) {
			throw UserLastNameLenghIsNotValidException.create();
		}
	}

}
