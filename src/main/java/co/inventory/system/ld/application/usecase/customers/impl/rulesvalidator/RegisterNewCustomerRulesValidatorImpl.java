package co.inventory.system.ld.application.usecase.customers.impl.rulesvalidator;

import co.inventory.system.ld.application.usecase.customers.rulesvalidator.*;
import co.inventory.system.ld.domain.customers.CustomerDomain;
import org.springframework.stereotype.Service;

@Service
public class RegisterNewCustomerRulesValidatorImpl implements RegisterNewCustomerRulesValidator {
    private final RegisterNewCustomerEmailRulesValidator emailRulesValidator;
    private final RegisterNewCustomerIdNumberRulesValidator idNumberRulesValidator;
    private final RegisterNewCustomerNameRulesValidator nameRulesValidator;
    private final RegisterNewCustomerIdRulesValidator idRulesValidator;
    private final RegisterNewCustomerLastNameRulesValidator lastNameRulesValidator;

    public RegisterNewCustomerRulesValidatorImpl(RegisterNewCustomerEmailRulesValidator emailRulesValidator, RegisterNewCustomerIdNumberRulesValidator idNumberRulesValidator, RegisterNewCustomerNameRulesValidator nameRulesValidator, RegisterNewCustomerIdRulesValidator idRulesValidator, RegisterNewCustomerLastNameRulesValidator lastNameRulesValidator) {
        this.emailRulesValidator = emailRulesValidator;
        this.idNumberRulesValidator = idNumberRulesValidator;
        this.nameRulesValidator = nameRulesValidator;
        this.idRulesValidator = idRulesValidator;
        this.lastNameRulesValidator = lastNameRulesValidator;
    }

    @Override
    public void validate(CustomerDomain data) {
        emailRulesValidator.validate(data);
        idNumberRulesValidator.validate(data);
        nameRulesValidator.validate(data);
        idRulesValidator.validate(data);
        lastNameRulesValidator.validate(data);
    }
}
