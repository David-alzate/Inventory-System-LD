package co.inventory.system.ld.crosscutting.enums;

import co.inventory.system.ld.application.secondaryports.entity.commons.StatusEntity;
import co.inventory.system.ld.application.secondaryports.repository.commons.StatusRepository;
import co.inventory.system.ld.crosscutting.exceptions.CroscutingInventorySystemException;

import java.util.List;
import java.util.UUID;

public enum StatusEnum {
    ACTIVE("ACTIVE"),
    INACTIVE("INACTIVE");

    private final String name;
    private UUID id;
    private static StatusRepository statusRepository;

    StatusEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static void setStatusRepository(StatusRepository statusRepository) {
        StatusEnum.statusRepository = statusRepository;
    }

    public UUID getId(){
        synchronized (this){
            if(id == null){
                StatusEntity filter = StatusEntity.create().setName(this.name);

                List<StatusEntity> results = statusRepository.findByFilter(filter);

                if (results.isEmpty()) {
                    throw new CroscutingInventorySystemException("Estado no encontrado: " + this.name,
                            "No existe registro en la base de datos para este estado",
                            (Exception) List.of("Verificar los estados iniciales en la base de datos"));
                }

                if (results.size() > 1) {
                    throw new CroscutingInventorySystemException("Múltiples estados encontrados",
                            "Existen múltiples registros con el nombre: " + this.name,
                            (Exception) List.of("Validar consistencia de datos en la tabla de estados"));
                }

                StatusEntity statusEntity = results.get(0);
                if (statusEntity.getId() == null) {
                    throw new CroscutingInventorySystemException("Estado sin ID asignado",
                            "El estado encontrado no tiene identificador único",
                            (Exception) List.of("Revisar migraciones de base de datos"));
                }

                this.id = statusEntity.getId();
            }
        }
        return id;
    }
}
