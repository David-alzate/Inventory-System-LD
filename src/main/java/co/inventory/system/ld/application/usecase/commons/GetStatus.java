package co.inventory.system.ld.application.usecase.commons;

import java.util.List;

import co.inventory.system.ld.application.usecase.UseCaseWithReturn;
import co.inventory.system.ld.domain.commons.StatusDomain;

public interface GetStatus extends UseCaseWithReturn<StatusDomain, List<StatusDomain>>{

}
