package co.inventory.system.ld.application.primaryports.interactor.users.impl;

import co.inventory.system.ld.application.primaryports.dto.users.RegisterNewUserDTO;
import co.inventory.system.ld.application.primaryports.interactor.users.RegisterNewUserInteractor;
import co.inventory.system.ld.application.primaryports.mapper.users.RegisterNewUserDTOMapper;
import co.inventory.system.ld.application.usecase.users.RegisterNewUser;
import co.inventory.system.ld.crosscutting.exceptions.InteractorInventorySystemException;
import co.inventory.system.ld.crosscutting.exceptions.InventorySystemException;
import co.inventory.system.ld.crosscutting.messagecatalog.MessageCatalogStrategy;
import co.inventory.system.ld.crosscutting.messagecatalog.data.MessageCode;
import co.inventory.system.ld.infrastructure.primaryadapters.controller.response.users.AuthResponse;
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
    public AuthResponse execute(RegisterNewUserDTO data) {

        try {
            var userDomain = RegisterNewUserDTOMapper.INSTANCE.toDomain(data);
            return registerNewUser.execute(userDomain);
        } catch (InventorySystemException exception) {
            throw exception;
        } catch (Exception exception) {
            var userMessage = MessageCatalogStrategy.getContenidoMensaje(MessageCode.M00019);
            var technicalMessage = MessageCatalogStrategy.getContenidoMensaje(MessageCode.M00020);

            throw new InteractorInventorySystemException(userMessage, technicalMessage, exception);

        }

    }
}
