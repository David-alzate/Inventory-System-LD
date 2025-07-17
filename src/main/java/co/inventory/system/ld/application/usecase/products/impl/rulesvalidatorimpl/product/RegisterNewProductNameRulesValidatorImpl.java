package co.inventory.system.ld.application.usecase.products.impl.rulesvalidatorimpl.product;

import co.inventory.system.ld.application.usecase.products.rulesvalidator.product.RegisterNewProductNameRulesValidator;
import co.inventory.system.ld.domain.products.ProductDomain;
import co.inventory.system.ld.domain.products.rules.product.ProductNameIsNotEmpyRule;
import co.inventory.system.ld.domain.products.rules.product.ProductNameIsNotNullRule;
import co.inventory.system.ld.domain.products.rules.product.ProductNameLenghIsValidRule;
import org.springframework.stereotype.Service;

@Service
public class RegisterNewProductNameRulesValidatorImpl implements RegisterNewProductNameRulesValidator {

    private final ProductNameIsNotEmpyRule productNameIsNotEmpyRule;
    private final ProductNameIsNotNullRule productNameIsNotNullRule;
    private final ProductNameLenghIsValidRule productNameLenghIsValidRule;

    public RegisterNewProductNameRulesValidatorImpl(ProductNameIsNotEmpyRule productNameIsNotEmpyRule, ProductNameIsNotNullRule productNameIsNotNullRule, ProductNameLenghIsValidRule productNameLenghIsValidRule) {
        this.productNameIsNotEmpyRule = productNameIsNotEmpyRule;
        this.productNameIsNotNullRule = productNameIsNotNullRule;
        this.productNameLenghIsValidRule = productNameLenghIsValidRule;
    }

    @Override
    public void validate(ProductDomain data) {
        productNameIsNotEmpyRule.validate(data.getName());
        productNameIsNotNullRule.validate(data.getName());
        productNameLenghIsValidRule.validate(data.getName());
    }
}
