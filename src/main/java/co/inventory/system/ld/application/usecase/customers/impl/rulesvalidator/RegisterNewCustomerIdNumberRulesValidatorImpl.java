package co.inventory.system.ld.application.usecase.customers.impl.rulesvalidator;

import co.inventory.system.ld.application.usecase.customers.rulesvalidator.RegisterNewCustomerIdNumberRulesValidator;
import co.inventory.system.ld.domain.customers.CustomerDomain;
import co.inventory.system.ld.domain.customers.rules.CustomerIdNumberDoesNotExistsRule;
import co.inventory.system.ld.domain.customers.rules.CustomerIdNumberLenghtIsValidRule;
import org.springframework.stereotype.Service;

@Service
public class RegisterNewCustomerIdNumberRulesValidatorImpl implements RegisterNewCustomerIdNumberRulesValidator {

    private final CustomerIdNumberLenghtIsValidRule customerIdNumberLenghtIsValidRule;
    private final CustomerIdNumberDoesNotExistsRule customerIdNumberDoesNotExistsRule;

    public RegisterNewCustomerIdNumberRulesValidatorImpl( CustomerIdNumberLenghtIsValidRule customerIdNumberLenghtIsValidRule, CustomerIdNumberDoesNotExistsRule customerIdNumberDoesNotExistsRule ) {
        this.customerIdNumberLenghtIsValidRule=customerIdNumberLenghtIsValidRule;
        this.customerIdNumberDoesNotExistsRule=customerIdNumberDoesNotExistsRule;
    }

    @Override
    public void validate(CustomerDomain data) {
        customerIdNumberLenghtIsValidRule.validate(data);
        customerIdNumberDoesNotExistsRule.validate(data);
    }
}
