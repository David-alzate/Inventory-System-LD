package co.inventory.system.ld.domain.users.rules.impl.user;

import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

import co.inventory.system.ld.domain.users.exceptions.user.UserEmailFormatIsNotValidException;
import co.inventory.system.ld.domain.users.rules.user.UserEmailFormatIsValidRule;

@Service
public class UserEmailFormatIsValidRuleImpl implements UserEmailFormatIsValidRule {

	private static final Pattern EMAIL_PATTERN = Pattern.compile("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$");

	@Override
	public void validate(String data) {
		if (!EMAIL_PATTERN.matcher(data).matches()) {
			throw UserEmailFormatIsNotValidException.create();
		}

	}

}
