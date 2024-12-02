package co.inventory.system.ld.application.secondaryports.repository.commons;

import java.util.List;

import org.springframework.stereotype.Repository;

import co.inventory.system.ld.application.secondaryports.entity.commons.IdTypeEntity;

@Repository
public interface IdTypeRepositoryCustom {
    List<IdTypeEntity> findByFilter(IdTypeEntity filter);

}
