package co.inventory.system.ld.infrastructure.primaryadapters.controller.rest.sales;

import co.inventory.system.ld.application.primaryports.interactor.sales.RegisterNewSaleInteractor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sales/api/v1/sale")
public class SaleController {

    private final RegisterNewSaleInteractor registerNewSaleInteractor;

    public SaleController(RegisterNewSaleInteractor registerNewSaleInteractor) {
        this.registerNewSaleInteractor = registerNewSaleInteractor;
    }

}
