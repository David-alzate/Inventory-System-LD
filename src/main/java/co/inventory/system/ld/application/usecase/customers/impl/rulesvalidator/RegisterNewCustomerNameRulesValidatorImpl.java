package co.inventory.system.ld.application.usecase.customers.impl.rulesvalidator;

import co.inventory.system.ld.application.usecase.customers.rulesvalidator.RegisterNewCustomerNameRulesValidator;
import co.inventory.system.ld.domain.customers.CustomerDomain;
import co.inventory.system.ld.domain.customers.rules.CustomerNameFormatIsValidRule;
import co.inventory.system.ld.domain.customers.rules.CustomerNameIsNotEmptyRule;
import co.inventory.system.ld.domain.customers.rules.CustomerNameIsNotNullRule;
import co.inventory.system.ld.domain.customers.rules.CustomerNameLenghtIsValidRule;
import org.springframework.stereotype.Service;

@Service
public class RegisterNewCustomerNameRulesValidatorImpl implements RegisterNewCustomerNameRulesValidator {

    private final CustomerNameFormatIsValidRule customerNameFormatIsValidRule;
    private final CustomerNameIsNotEmptyRule customerNameIsNotEmptyRule;
    private final CustomerNameLenghtIsValidRule customerNameLenghtIsValidRule;
    private final CustomerNameIsNotNullRule customerNameIsNotNullRule;

    public RegisterNewCustomerNameRulesValidatorImpl(CustomerNameFormatIsValidRule customerNameFormatIsValidRule, CustomerNameIsNotEmptyRule customerNameIsNotEmptyRule, CustomerNameLenghtIsValidRule customerNameLenghtIsValidRule, CustomerNameIsNotNullRule customerNameIsNotNullRule) {
        this.customerNameFormatIsValidRule = customerNameFormatIsValidRule;
        this.customerNameIsNotEmptyRule = customerNameIsNotEmptyRule;
        this.customerNameLenghtIsValidRule = customerNameLenghtIsValidRule;
        this.customerNameIsNotNullRule = customerNameIsNotNullRule;
    }

    @Override
    public void validate(CustomerDomain data) {
        customerNameFormatIsValidRule.validate(data.getName());
        customerNameIsNotEmptyRule.validate(data.getName());
        customerNameLenghtIsValidRule.validate(data.getName());
        customerNameIsNotNullRule.validate(data.getName());
    }
}
