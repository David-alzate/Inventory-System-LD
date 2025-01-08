package co.inventory.system.ld.infrastructure.primaryadapters.controller.rest.inventorymovements;

import co.inventory.system.ld.application.primaryports.dto.inventorymovements.MovementTypeDTO;
import co.inventory.system.ld.application.primaryports.interactor.inventorymovements.movementtype.GetMovementTypeInteractor;
import co.inventory.system.ld.crosscutting.exceptions.InventorySystemException;
import co.inventory.system.ld.crosscutting.messagecatalog.MessageCatalogStrategy;
import co.inventory.system.ld.crosscutting.messagecatalog.data.MessageCode;
import co.inventory.system.ld.infrastructure.primaryadapters.controller.response.inventorymovements.MovementTypeResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("inventoryMovements/api/v1/movementType")
public class MovementTypeControler {

    private GetMovementTypeInteractor getMovementTypeInteractor;

    public MovementTypeControler(GetMovementTypeInteractor getMovementTypeInteractor) {
        this.getMovementTypeInteractor = getMovementTypeInteractor;
    }

    @GetMapping
    public ResponseEntity<MovementTypeResponse> getMovementType(){

        var httpStatusCode = HttpStatus.ACCEPTED;
        var movementTypeRespose = new MovementTypeResponse();

        try {
            var movementTypeDTO = MovementTypeDTO.create();
            movementTypeRespose.setDatos(getMovementTypeInteractor.execute(movementTypeDTO));
            movementTypeRespose.getMensajes().add(MessageCatalogStrategy.getContenidoMensaje(MessageCode.M00073));

        } catch (final InventorySystemException excepcion) {
            httpStatusCode = HttpStatus.BAD_REQUEST;
            movementTypeRespose.getMensajes().add(excepcion.getMessage());
        } catch (final Exception excepcion) {
            httpStatusCode = HttpStatus.INTERNAL_SERVER_ERROR;

            var userMessage = MessageCatalogStrategy.getContenidoMensaje(MessageCode.M00071);
            movementTypeRespose.getMensajes().add(userMessage);
        }

        return new ResponseEntity<>(movementTypeRespose, httpStatusCode);
    }
}
