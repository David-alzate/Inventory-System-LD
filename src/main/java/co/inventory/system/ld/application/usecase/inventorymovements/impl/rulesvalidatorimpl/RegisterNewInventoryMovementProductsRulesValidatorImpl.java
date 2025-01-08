package co.inventory.system.ld.application.usecase.inventorymovements.impl.rulesvalidatorimpl;

import co.inventory.system.ld.application.usecase.inventorymovements.rulesvalidator.RegisterNewInventoryMovementProductsRulesValidator;
import co.inventory.system.ld.domain.inventorymovements.InventoryMovementDomain;
import co.inventory.system.ld.domain.products.rules.product.ProductIdDoesExitsRule;
import org.springframework.stereotype.Service;

@Service
public class RegisterNewInventoryMovementProductsRulesValidatorImpl implements RegisterNewInventoryMovementProductsRulesValidator {

    ProductIdDoesExitsRule productIdDoesExitsRule;

    public RegisterNewInventoryMovementProductsRulesValidatorImpl(ProductIdDoesExitsRule productIdDoesExitsRule) {
        this.productIdDoesExitsRule = productIdDoesExitsRule;
    }

    @Override
    public void validate(InventoryMovementDomain data) {
        productIdDoesExitsRule.validate(data.getProduct().getId());
    }
}
