package co.inventory.system.ld.application.primaryports.interactor.users;

import java.util.List;

import co.inventory.system.ld.application.primaryports.dto.users.UserDTO;
import co.inventory.system.ld.application.primaryports.interactor.InteractorWithReturn;

public interface GetUserInteractor extends InteractorWithReturn<UserDTO, List<UserDTO>>{

}
