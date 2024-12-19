package co.inventory.system.ld.application.usecase.users.impl.rulesvalidatorimpl;

import org.springframework.stereotype.Service;

import co.inventory.system.ld.application.usecase.users.rulesvalidator.RegisterNewUserIdTypeRulesValidator;
import co.inventory.system.ld.domain.commons.rules.idtype.IdTypeIdDoesExistsRule;
import co.inventory.system.ld.domain.commons.rules.idtype.IdTypeIdIsNotDefaultValueRule;
import co.inventory.system.ld.domain.commons.rules.idtype.IdTypeIdIsNotNullRule;
import co.inventory.system.ld.domain.users.UserDomain;

@Service
public class RegisterNewUserIdTypeRulesValidatorImpl implements RegisterNewUserIdTypeRulesValidator {

	private final IdTypeIdDoesExistsRule idTypeIdDoesExistsRule;
	private final IdTypeIdIsNotDefaultValueRule idTypeIdIsNotDefaultValueRule;
	private final IdTypeIdIsNotNullRule idTypeIdIsNotNullRule;

	public RegisterNewUserIdTypeRulesValidatorImpl(IdTypeIdDoesExistsRule idTypeIdDoesExistsRule,
			IdTypeIdIsNotDefaultValueRule idTypeIdIsNotDefaultValueRule, IdTypeIdIsNotNullRule idTypeIdIsNotNullRule) {
		this.idTypeIdDoesExistsRule = idTypeIdDoesExistsRule;
		this.idTypeIdIsNotDefaultValueRule = idTypeIdIsNotDefaultValueRule;
		this.idTypeIdIsNotNullRule = idTypeIdIsNotNullRule;
	}

	@Override
	public void validate(UserDomain data) {
		idTypeIdDoesExistsRule.validate(data.getIdType().getId());
		idTypeIdIsNotDefaultValueRule.validate(data.getIdType().getId());
		idTypeIdIsNotNullRule.validate(data.getIdType().getId());

	}

}
