package co.inventory.system.ld.application.primaryports.interactor.users.impl;

import co.inventory.system.ld.application.primaryports.dto.users.RegisterNewUserDTO;
import co.inventory.system.ld.application.primaryports.interactor.users.RegisterNewUserInteractor;
import co.inventory.system.ld.application.primaryports.mapper.users.RegisterNewUserDTOMapper;
import co.inventory.system.ld.application.usecase.users.RegisterNewUser;
import co.inventory.system.ld.crosscutting.exceptions.InteractorInventorySystemException;
import co.inventory.system.ld.crosscutting.exceptions.InventorySystemException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class RegisterNewUserInteractorImpl implements RegisterNewUserInteractor {

    private final RegisterNewUser registerNewUser;

    public RegisterNewUserInteractorImpl(RegisterNewUser registerNewUser) {
        this.registerNewUser = registerNewUser;
    }

    @Override
    public void execute(RegisterNewUserDTO data) {

        try {
            var userDomain = RegisterNewUserDTOMapper.INSTANCE.toDomain(data);
            registerNewUser.execute(userDomain);
        } catch (InventorySystemException exception) {
            throw exception;
        } catch (Exception exception) {
            var userMessage = "Se ha presentado un problema registrando el usuario";
            var technicalMessage = "Se ha presentado un problema INESPERADO registrando el usuario";

            throw new InteractorInventorySystemException(userMessage, technicalMessage, exception);

        }

    }
}
