package co.inventory.system.ld.application.usecase.users.impl.rulesvalidatorimpl;

import org.springframework.stereotype.Service;

import co.inventory.system.ld.application.usecase.users.rulesvalidator.RegisterNewUserUserTypeRulesValidator;
import co.inventory.system.ld.domain.users.UserDomain;
import co.inventory.system.ld.domain.users.rules.usertype.UserTypeDoesExistRule;
import co.inventory.system.ld.domain.users.rules.usertype.UserTypeIdIsNotDefaultValueRule;
import co.inventory.system.ld.domain.users.rules.usertype.UserTypeIdIsNotNullRule;

@Service
public class RegisterNewUserUserTypeRulesValidatorImpl implements RegisterNewUserUserTypeRulesValidator {

	private final UserTypeDoesExistRule userTypeDoesExistRule;
	private final UserTypeIdIsNotDefaultValueRule userTypeIdIsNotDefaultValueRule;
	private final UserTypeIdIsNotNullRule userTypeIdIsNotNullRule;

	public RegisterNewUserUserTypeRulesValidatorImpl(UserTypeDoesExistRule userTypeDoesExistRule,
			UserTypeIdIsNotDefaultValueRule userTypeIdIsNotDefaultValueRule,
			UserTypeIdIsNotNullRule userTypeIdIsNotNullRule) {
		this.userTypeDoesExistRule = userTypeDoesExistRule;
		this.userTypeIdIsNotDefaultValueRule = userTypeIdIsNotDefaultValueRule;
		this.userTypeIdIsNotNullRule = userTypeIdIsNotNullRule;
	}

	@Override
	public void validate(UserDomain data) {
		userTypeDoesExistRule.validate(data.getUserType().getId());
		userTypeIdIsNotDefaultValueRule.validate(data.getUserType().getId());
		userTypeIdIsNotNullRule.validate(data.getUserType().getId());
	}

}
