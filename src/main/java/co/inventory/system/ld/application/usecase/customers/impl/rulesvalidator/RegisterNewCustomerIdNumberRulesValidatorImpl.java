package co.inventory.system.ld.application.usecase.customers.impl.rulesvalidator;

import co.inventory.system.ld.application.usecase.customers.rulesvalidator.RegisterNewCustomerIdNumberRulesValidator;
import co.inventory.system.ld.domain.customers.CustomerDomain;
import co.inventory.system.ld.domain.customers.rules.CustomerIdNumberLenghtIsValidRule;
import org.springframework.stereotype.Service;

@Service
public class RegisterNewCustomerIdNumberRulesValidatorImpl implements RegisterNewCustomerIdNumberRulesValidator {

    private final CustomerIdNumberLenghtIsValidRule customerIdNumberLenghtIsValidRule;

    public RegisterNewCustomerIdNumberRulesValidatorImpl( CustomerIdNumberLenghtIsValidRule customerIdNumberLenghtIsValidRule ) {
        this.customerIdNumberLenghtIsValidRule=customerIdNumberLenghtIsValidRule;
    }

    @Override
    public void validate(CustomerDomain data) {
        customerIdNumberLenghtIsValidRule.validate(data);
    }
}
