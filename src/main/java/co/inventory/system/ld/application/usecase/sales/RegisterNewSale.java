package co.inventory.system.ld.application.usecase.sales;

import co.inventory.system.ld.application.usecase.UseCaseWithReturn;
import co.inventory.system.ld.domain.sales.SaleDomain;

import java.util.UUID;

public interface RegisterNewSale extends UseCaseWithReturn<SaleDomain, UUID> {
}
