package co.inventory.system.ld.domain.users.rules.impl;

import org.springframework.stereotype.Service;

import co.inventory.system.ld.domain.users.exceptions.UserLastNameFormatIsNotValidException;
import co.inventory.system.ld.domain.users.rules.UserLastNameFormatIsValidRule;

@Service
public class UserLastNameFormatIsValidRuleImpl implements UserLastNameFormatIsValidRule {

	@Override
	public void validate(String data) {
		if (!data.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+$")) {
			throw UserLastNameFormatIsNotValidException.create();
		}

	}

}
