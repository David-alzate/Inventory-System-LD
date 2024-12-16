package co.inventory.system.ld.infrastructure.secondaryadapters.data.sql.repository.commons;

import java.util.List;

import org.springframework.stereotype.Repository;

import co.inventory.system.ld.application.secondaryports.entity.commons.StatusEntity;

@Repository
public interface StatusRepositoryCustom {
	List<StatusEntity> findByFilter(StatusEntity filter);
}
