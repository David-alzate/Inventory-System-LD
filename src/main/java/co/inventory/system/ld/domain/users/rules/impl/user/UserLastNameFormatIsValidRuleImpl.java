package co.inventory.system.ld.domain.users.rules.impl.user;

import org.springframework.stereotype.Service;
import co.inventory.system.ld.domain.users.exceptions.user.UserLastNameFormatIsNotValidException;
import co.inventory.system.ld.domain.users.rules.user.UserLastNameFormatIsValidRule;

@Service
public class UserLastNameFormatIsValidRuleImpl implements UserLastNameFormatIsValidRule {

	@Override
	public void validate(String data) {
		if (!data.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+$")) {
			throw UserLastNameFormatIsNotValidException.create();
		}

	}

}
