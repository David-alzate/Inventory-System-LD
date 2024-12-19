package co.inventory.system.ld.application.usecase.users.impl.rulesvalidatorimpl;

import org.springframework.stereotype.Service;

import co.inventory.system.ld.application.usecase.users.rulesvalidator.RegisterNewUserStatusRulesValidator;
import co.inventory.system.ld.domain.commons.rules.status.StatusIdDoesExistsRule;
import co.inventory.system.ld.domain.commons.rules.status.StatusIdIsNotDefaultValueRule;
import co.inventory.system.ld.domain.commons.rules.status.StatusIdIsNotNullRule;
import co.inventory.system.ld.domain.users.UserDomain;

@Service
public class RegisterNewUserStatusRulesValidatorImpl implements RegisterNewUserStatusRulesValidator {

	private final StatusIdDoesExistsRule statusIdDoesExistsRule;
	private final StatusIdIsNotDefaultValueRule statusIdIsNotDefaultValueRule;
	private final StatusIdIsNotNullRule statusIdIsNotNullRule;

	public RegisterNewUserStatusRulesValidatorImpl(StatusIdDoesExistsRule statusIdDoesExistsRule,
			StatusIdIsNotDefaultValueRule statusIdIsNotDefaultValueRule, StatusIdIsNotNullRule statusIdIsNotNullRule) {
		this.statusIdDoesExistsRule = statusIdDoesExistsRule;
		this.statusIdIsNotDefaultValueRule = statusIdIsNotDefaultValueRule;
		this.statusIdIsNotNullRule = statusIdIsNotNullRule;
	}

	@Override
	public void validate(UserDomain data) {
		statusIdDoesExistsRule.validate(data.getStatus().getId());
		statusIdIsNotDefaultValueRule.validate(data.getStatus().getId());
		statusIdIsNotNullRule.validate(data.getStatus().getId());
	}

}
