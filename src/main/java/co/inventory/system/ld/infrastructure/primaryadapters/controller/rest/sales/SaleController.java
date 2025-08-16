package co.inventory.system.ld.infrastructure.primaryadapters.controller.rest.sales;

import co.inventory.system.ld.application.primaryports.dto.sales.SaleDTO;
import co.inventory.system.ld.application.primaryports.interactor.sales.RegisterNewSaleInteractor;
import co.inventory.system.ld.crosscutting.exceptions.InventorySystemException;
import co.inventory.system.ld.infrastructure.primaryadapters.controller.response.sales.RegisterNewSaleResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sales/api/v1/sale")
public class SaleController {

    private final RegisterNewSaleInteractor registerNewSaleInteractor;

    public SaleController(RegisterNewSaleInteractor registerNewSaleInteractor) {
        this.registerNewSaleInteractor = registerNewSaleInteractor;
    }

    @PostMapping
    public ResponseEntity<RegisterNewSaleResponse> createSale(@RequestBody SaleDTO saleDTO){

        var httpStatusCode = HttpStatus.ACCEPTED;
        var saleResponse = new RegisterNewSaleResponse();

        try {
            registerNewSaleInteractor.execute(saleDTO);
            saleResponse.getMensajes().add("Sale created successfully");

        } catch (final InventorySystemException excepcion) {
            httpStatusCode = HttpStatus.BAD_REQUEST;
            saleResponse.getMensajes().add(excepcion.getUserMessage());
        }catch (final Exception excepcion) {
            httpStatusCode = HttpStatus.INTERNAL_SERVER_ERROR;
            saleResponse.getMensajes().add("Se ha producido un error inesperado en el sistema");
        }
        return new ResponseEntity<>(saleResponse, httpStatusCode);
    }
}
