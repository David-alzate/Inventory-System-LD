package co.inventory.system.ld.application.usecase.customers.impl.rulesvalidator;

import co.inventory.system.ld.application.usecase.customers.rulesvalidator.RegisterNewCustomerIdTypeRulesValidator;
import co.inventory.system.ld.domain.commons.rules.idtype.IdTypeIdDoesExistsRule;
import co.inventory.system.ld.domain.customers.CustomerDomain;
import org.springframework.stereotype.Service;

@Service
public class RegisterNewCustomerIdTypeRulesValidatorImpl implements RegisterNewCustomerIdTypeRulesValidator {

    private final IdTypeIdDoesExistsRule idTypeIdDoesExistsRule;

    public RegisterNewCustomerIdTypeRulesValidatorImpl(IdTypeIdDoesExistsRule idTypeIdDoesExistsRule) {
        this.idTypeIdDoesExistsRule = idTypeIdDoesExistsRule;
    }

    @Override
    public void validate(CustomerDomain data) {
        idTypeIdDoesExistsRule.validate(data.getIdType().getId());
    }
}
