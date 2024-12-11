package co.inventory.system.ld.infrastructure.primaryadapters.controller.rest.suppliers;

import co.inventory.system.ld.application.primaryports.dto.suppliers.RegisterNewSupplierDTO;
import co.inventory.system.ld.application.primaryports.interactor.suppliers.RegisterNewSupplierInteractor;
import co.inventory.system.ld.crosscutting.exceptions.InventorySystemException;
import co.inventory.system.ld.infrastructure.primaryadapters.controller.response.suppliers.RegisterNewSupplierResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/suppliers/api/v1/supplier")
public class SupplierController {

    private final RegisterNewSupplierInteractor registerNewSupplierInteractor;

    public SupplierController(RegisterNewSupplierInteractor registerNewSupplierInteractor) {
        this.registerNewSupplierInteractor = registerNewSupplierInteractor;
    }

    @PostMapping("/registerNewSupplier")
    public ResponseEntity<RegisterNewSupplierResponse> registerNewSupplier(@RequestBody RegisterNewSupplierDTO registerNewSupplierDTO) {
        var httpStatusCode= HttpStatus.CREATED;
        var registerNewSupplierResponse=new RegisterNewSupplierResponse();

        try {
            registerNewSupplierInteractor.execute(registerNewSupplierDTO);
            registerNewSupplierResponse.getMensajes().add("Proveedor registrado exitosamente");

        } catch (final InventorySystemException excepcion) {
            httpStatusCode = HttpStatus.BAD_REQUEST;
            registerNewSupplierResponse.getMensajes().add(excepcion.getUserMessage());


        } catch (final Exception excepcion) {
            httpStatusCode = HttpStatus.INTERNAL_SERVER_ERROR;
            var mensajeUsuario ="Hubo un problema tratando de registrar el proveedor";
            registerNewSupplierResponse.getMensajes().add(mensajeUsuario);
        }

        return new ResponseEntity<>(registerNewSupplierResponse, httpStatusCode);
    }
}
