package co.inventory.system.ld.crosscutting.enums;

import co.inventory.system.ld.application.secondaryports.entity.users.UserTypeEntity;
import co.inventory.system.ld.application.secondaryports.repository.users.UserTypeRepository;
import co.inventory.system.ld.crosscutting.exceptions.CroscutingInventorySystemException;

import java.util.List;
import java.util.UUID;

public enum UserTypeEnum {
    ADMIN("ADMIN"),
    USER("USER");

    private final String name;
    private UUID id;
    private static UserTypeRepository userTypeRepository;

    UserTypeEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static void setUserTypeRepository(UserTypeRepository userTypeRepository) {
        UserTypeEnum.userTypeRepository = userTypeRepository;
    }

    public UUID getId() {
        synchronized (this){
            if(id ==null){
                UserTypeEntity filter = UserTypeEntity.create().setName(this.name);

                List<UserTypeEntity> results = userTypeRepository.findByFilter(filter);

                if (results.isEmpty()) {
                    throw new CroscutingInventorySystemException("Role no encontrado" + this.name,
                            "No existe registro en la base de datos para este rol",
                            (Exception) List.of("Verificar los roles iniciales en la base de datos"));
                }

                if (results.size()>1){
                    throw new CroscutingInventorySystemException("Múltiples roles encontrados",
                            "Existen múltiples registros con el nombre: " + this.name,
                            (Exception) List.of("Validar consistencia de datos en la tabla de roles"));
                }

                UserTypeEntity userTypeEntity = results.get(0);
                if (userTypeEntity.getId() == null){
                    throw new CroscutingInventorySystemException("Rol sin ID asignado",
                            "El rol encontrado no tiene identificador único",
                            (Exception) List.of("Revisar migraciones de base de datos"));
                }

                this.id = userTypeEntity.getId();
            }
        }
        return id;
    }
}

