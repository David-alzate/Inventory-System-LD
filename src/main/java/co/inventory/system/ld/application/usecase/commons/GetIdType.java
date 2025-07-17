package co.inventory.system.ld.application.usecase.commons;

import co.inventory.system.ld.application.usecase.UseCaseWithReturn;
import co.inventory.system.ld.domain.commons.IdTypeDomain;

import java.util.List;

public interface  GetIdType extends UseCaseWithReturn <IdTypeDomain, List<IdTypeDomain>>{
}
