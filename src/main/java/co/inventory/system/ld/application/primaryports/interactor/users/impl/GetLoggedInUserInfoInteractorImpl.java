package co.inventory.system.ld.application.primaryports.interactor.users.impl;

import co.inventory.system.ld.application.primaryports.dto.users.UserDTO;
import co.inventory.system.ld.application.primaryports.interactor.users.GetLoggedInUserInfoInteractor;
import co.inventory.system.ld.application.primaryports.mapper.users.UserDTOMapper;
import co.inventory.system.ld.application.usecase.users.GetLoggedInUserInfo;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class GetLoggedInUserInfoInteractorImpl implements GetLoggedInUserInfoInteractor {

    private final GetLoggedInUserInfo getLoggedInUserInfo;

    public GetLoggedInUserInfoInteractorImpl(GetLoggedInUserInfo getLoggedInUserInfo) {
        this.getLoggedInUserInfo = getLoggedInUserInfo;
    }

    @Override
    public UserDTO execute() {
        var user = getLoggedInUserInfo.execute();
        return UserDTOMapper.INSTANCE.toDTO(user);
    }
}
