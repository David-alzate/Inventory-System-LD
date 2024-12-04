package co.inventory.system.ld.application.primaryports.interactor.commons;

import java.util.List;

import co.inventory.system.ld.application.primaryports.dto.commons.StatusDTO;
import co.inventory.system.ld.application.primaryports.interactor.InteractorWithReturn;

public interface GetStatusInteractor extends InteractorWithReturn<StatusDTO, List<StatusDTO>> {

}
