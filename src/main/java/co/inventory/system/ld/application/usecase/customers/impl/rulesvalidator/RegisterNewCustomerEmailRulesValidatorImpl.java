package co.inventory.system.ld.application.usecase.customers.impl.rulesvalidator;

import co.inventory.system.ld.application.usecase.customers.rulesvalidator.RegisterNewCustomerEmailRulesValidator;
import co.inventory.system.ld.domain.customers.CustomerDomain;
import co.inventory.system.ld.domain.customers.rules.CustomerEmailFormatIsValidRule;
import org.springframework.stereotype.Service;

@Service
public class RegisterNewCustomerEmailRulesValidatorImpl implements RegisterNewCustomerEmailRulesValidator {

    private final CustomerEmailFormatIsValidRule customerEmailFormatIsValidRule;

    public RegisterNewCustomerEmailRulesValidatorImpl(CustomerEmailFormatIsValidRule customerEmailFormatIsValidRule) {
        this.customerEmailFormatIsValidRule = customerEmailFormatIsValidRule;
    }

    @Override
    public void validate(CustomerDomain data) {
        customerEmailFormatIsValidRule.validate(data.getEmail());
    }
}
