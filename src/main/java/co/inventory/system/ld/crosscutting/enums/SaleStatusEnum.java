package co.inventory.system.ld.crosscutting.enums;

import co.inventory.system.ld.application.secondaryports.entity.sales.SaleStatusEntity;
import co.inventory.system.ld.application.secondaryports.repository.sales.SaleStatusRepository;
import co.inventory.system.ld.crosscutting.exceptions.CroscutingInventorySystemException;

import java.util.List;
import java.util.UUID;

public enum SaleStatusEnum {
    PENDING("Pending"),
    COMPLETED("Completed"),
    CANCELED("Canceled");

    private final String name;
    private UUID id;
    private static SaleStatusRepository saleStatusRepository;

    SaleStatusEnum(String name) {
        this.name = name;
    }

    public static void setSaleStatusRepository(SaleStatusRepository saleStatusRepository) {
        SaleStatusEnum.saleStatusRepository = saleStatusRepository;
    }

    public UUID getId(){
        synchronized (this){
            if (id==null){
                SaleStatusEntity filter = SaleStatusEntity.create().setName(this.name);

                List<SaleStatusEntity> results = saleStatusRepository.findByName(filter.getName()) != null ?
                        List.of(saleStatusRepository.findByName(filter.getName())) : List.of();

                if (results.isEmpty()){
                    throw new CroscutingInventorySystemException("Estado de venta no encontrado: " + this.name,
                            "No existe registro en la base de datos para este estado",
                            (Exception) List.of("Verificar los estados iniciales en la base de datos"));
                }

                if (results.size()>1){
                    throw new CroscutingInventorySystemException("Múltiples estados de venta encontrados",
                            "Existen múltiples registros con el nombre: " + this.name,
                            (Exception) List.of("Validar consistencia de datos en la tabla de estados de venta"));
                }

                SaleStatusEntity saleStatusEntity = results.get(0);
                if (saleStatusEntity.getId() == null){
                    throw new CroscutingInventorySystemException("Estado de venta sin ID asignado",
                            "El estado de venta encontrado no tiene identificador único",
                            (Exception) List.of("Revisar migraciones de base de datos"));
                }

                this.id = saleStatusEntity.getId();

            }
        }
        return id;
    }
}
