package co.inventory.system.ld.infrastructure.secondaryadapters.data.sql.repository.commons;

import co.inventory.system.ld.application.secondaryports.entity.commons.IdTypeEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface IdTypeRepositoryCustom {
    List<IdTypeEntity> findByFilter(IdTypeEntity filter);

}
