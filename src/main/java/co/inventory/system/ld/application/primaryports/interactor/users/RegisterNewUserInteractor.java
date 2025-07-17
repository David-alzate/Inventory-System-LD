package co.inventory.system.ld.application.primaryports.interactor.users;

import co.inventory.system.ld.application.primaryports.dto.users.RegisterNewUserDTO;
import co.inventory.system.ld.application.primaryports.interactor.InteractorWithOutReturn;
import co.inventory.system.ld.application.primaryports.interactor.InteractorWithReturn;
import co.inventory.system.ld.infrastructure.primaryadapters.controller.response.users.AuthResponse;

public interface RegisterNewUserInteractor extends InteractorWithReturn<RegisterNewUserDTO, AuthResponse> {
}
