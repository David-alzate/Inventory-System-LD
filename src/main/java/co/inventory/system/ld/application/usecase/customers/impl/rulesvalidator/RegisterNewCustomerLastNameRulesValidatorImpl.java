package co.inventory.system.ld.application.usecase.customers.impl.rulesvalidator;

import co.inventory.system.ld.application.usecase.customers.rulesvalidator.RegisterNewCustomerLastNameRulesValidator;
import co.inventory.system.ld.domain.customers.CustomerDomain;
import co.inventory.system.ld.domain.customers.rules.CustomerLastNameFormatIsValidRule;
import co.inventory.system.ld.domain.customers.rules.CustomerLastNameIsNotEmptyRule;
import co.inventory.system.ld.domain.customers.rules.CustomerLastNameIsNotNullRule;
import co.inventory.system.ld.domain.customers.rules.CustomerLastNameLenghtIsValidRule;
import org.springframework.stereotype.Service;

@Service
public class RegisterNewCustomerLastNameRulesValidatorImpl implements RegisterNewCustomerLastNameRulesValidator {

    private final CustomerLastNameFormatIsValidRule customerLastNameFormatIsValidRule;
    private final CustomerLastNameIsNotNullRule customerLastNameIsNotNullRule;
    private final CustomerLastNameIsNotEmptyRule customerLastNameIsNotEmptyRule;
    private final CustomerLastNameLenghtIsValidRule customerLastNameLenghtIsValidRule;

    public RegisterNewCustomerLastNameRulesValidatorImpl(CustomerLastNameFormatIsValidRule customerLastNameFormatIsValidRule, CustomerLastNameIsNotNullRule customerLastNameIsNotNullRule, CustomerLastNameIsNotEmptyRule customerLastNameIsNotEmptyRule, CustomerLastNameLenghtIsValidRule customerLastNameLenghtIsValidRule) {
        this.customerLastNameFormatIsValidRule = customerLastNameFormatIsValidRule;
        this.customerLastNameIsNotNullRule = customerLastNameIsNotNullRule;
        this.customerLastNameIsNotEmptyRule = customerLastNameIsNotEmptyRule;
        this.customerLastNameLenghtIsValidRule = customerLastNameLenghtIsValidRule;
    }

    @Override
    public void validate(CustomerDomain data) {
        customerLastNameFormatIsValidRule.validate(data.getLastName());
        customerLastNameIsNotNullRule.validate(data.getLastName());
        customerLastNameIsNotEmptyRule.validate(data.getLastName());
        customerLastNameLenghtIsValidRule.validate(data.getLastName());
    }
}
