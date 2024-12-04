package co.inventory.system.ld.application.secondaryports.repository.commons;

import co.inventory.system.ld.application.secondaryports.entity.commons.IdTypeEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface IdTypeRepository extends JpaRepository<IdTypeEntity, UUID>, IdTypeRepositoryCustom {
    //dependency injection
}
