package co.inventory.system.ld.application.usecase.customers.impl.rulesvalidator;

import co.inventory.system.ld.application.usecase.customers.rulesvalidator.RegisterNewCustomerIdRulesValidator;
import co.inventory.system.ld.domain.customers.CustomerDomain;
import co.inventory.system.ld.domain.customers.exceptions.CustomerIdDoesExistsException;
import co.inventory.system.ld.domain.customers.rules.CustomerIdDoesNotExistsRule;
import org.springframework.stereotype.Service;

@Service
public class RegisterNewCustomerIdRulesValidatorImpl implements RegisterNewCustomerIdRulesValidator {

    private final CustomerIdDoesNotExistsRule customerIdDoesNotExistsRule;

    public RegisterNewCustomerIdRulesValidatorImpl(CustomerIdDoesNotExistsRule customerIdDoesNotExistsRule) {
        this.customerIdDoesNotExistsRule = customerIdDoesNotExistsRule;
    }

    @Override
    public void validate(CustomerDomain data) {
        data.generateId();
        try {
            customerIdDoesNotExistsRule.validate(data.getId());
        }catch (final CustomerIdDoesExistsException exception){
            validate(data);
        }
    }
}
