package co.inventory.system.ld.infrastructure.primaryadapters.controller.rest.inventorymovements;

import co.inventory.system.ld.application.primaryports.dto.inventorymovements.InventoryMovementDTO;
import co.inventory.system.ld.application.primaryports.dto.inventorymovements.RegisterNewInventoryMovementDTO;
import co.inventory.system.ld.application.primaryports.dto.products.ProductDTO;
import co.inventory.system.ld.application.primaryports.interactor.inventorymovements.inventorymovement.GetInventoryMovementInteractor;
import co.inventory.system.ld.application.primaryports.interactor.inventorymovements.inventorymovement.RegisterNewInventoryMovementInteractor;
import co.inventory.system.ld.crosscutting.exceptions.InventorySystemException;
import co.inventory.system.ld.crosscutting.messagecatalog.MessageCatalogStrategy;
import co.inventory.system.ld.crosscutting.messagecatalog.data.MessageCode;
import co.inventory.system.ld.infrastructure.primaryadapters.controller.response.inventorymovements.InventoryMovementResponse;
import co.inventory.system.ld.infrastructure.primaryadapters.controller.response.inventorymovements.RegisterNewInventoryMovementResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/inventorymovements/api/v1/inventorymovement")
public class InventoryMovementController {

    private final RegisterNewInventoryMovementInteractor  registerNewInventoryMovementInteractor;
    private final GetInventoryMovementInteractor getInventoryMovementInteractor;

    public InventoryMovementController(RegisterNewInventoryMovementInteractor registerNewInventoryMovementInteractor, GetInventoryMovementInteractor getInventoryMovementInteractor) {
        this.registerNewInventoryMovementInteractor = registerNewInventoryMovementInteractor;
        this.getInventoryMovementInteractor = getInventoryMovementInteractor;
    }

    @PostMapping
    public ResponseEntity<RegisterNewInventoryMovementResponse> create(@RequestBody RegisterNewInventoryMovementDTO inventoryMovementDTO) {

        var httpStatusCode = HttpStatus.ACCEPTED;
        var inventoryMovementResponse = new RegisterNewInventoryMovementResponse();

        try {
            registerNewInventoryMovementInteractor.execute(inventoryMovementDTO);
            inventoryMovementResponse.getMensajes().add("Movimiento de inventario registrado exitosamente");

        } catch (final InventorySystemException excepcion) {
            httpStatusCode = HttpStatus.BAD_REQUEST;
            inventoryMovementResponse.getMensajes().add(excepcion.getUserMessage());
        } catch (final Exception excepcion) {
            httpStatusCode = HttpStatus.INTERNAL_SERVER_ERROR;
            var userMessage = "Se ha presentado un error registrando el movimiento de inventario";
            inventoryMovementResponse.getMensajes().add(userMessage);
        }

        return new ResponseEntity<>(inventoryMovementResponse, httpStatusCode);
    }

    @GetMapping
    public ResponseEntity<InventoryMovementResponse> getInventoryMovement() {

        var httpStatusCode = HttpStatus.ACCEPTED;
        var inventoryMovementResponse = new InventoryMovementResponse();
        try {
            var inventoryMovementDTO = InventoryMovementDTO.create();
            inventoryMovementResponse.setDatos(getInventoryMovementInteractor.execute(inventoryMovementDTO));
            inventoryMovementResponse.getMensajes().add("Movimientos de inventario obtenidos exitosamente");

        } catch (final InventorySystemException excepcion) {
            httpStatusCode = HttpStatus.BAD_REQUEST;
            inventoryMovementResponse.getMensajes().add(excepcion.getMessage());
        } catch (final Exception excepcion) {
            httpStatusCode = HttpStatus.INTERNAL_SERVER_ERROR;

            var userMessage = "Se ha presentado un problema tratando de obtener los movimientos de inventario";
            inventoryMovementResponse.getMensajes().add(userMessage);
        }

        return new ResponseEntity<>(inventoryMovementResponse, httpStatusCode);
    }

}
