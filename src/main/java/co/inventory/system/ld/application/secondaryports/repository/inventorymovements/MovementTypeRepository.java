package co.inventory.system.ld.application.secondaryports.repository.inventorymovements;

import co.inventory.system.ld.application.secondaryports.entity.inventorymovements.MovementTypeEntity;
import co.inventory.system.ld.infrastructure.secondaryadapters.data.sql.repository.inventorymovements.MovementTypeRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface MovementTypeRepository extends JpaRepository<MovementTypeEntity, UUID>, MovementTypeRepositoryCustom {
}
