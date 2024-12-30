package co.inventory.system.ld.infrastructure.secondaryadapters.data.sql.repository.inventorymovements;

import co.inventory.system.ld.application.secondaryports.entity.inventorymovements.MovementTypeEntity;

import java.util.List;

public interface MovementTypeRepositoryCustom {
    List<MovementTypeEntity> findByFilter(MovementTypeEntity filter);
}
