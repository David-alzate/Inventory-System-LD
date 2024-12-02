package co.inventory.system.ld.application.secondaryports.repository.commons;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.inventory.system.ld.application.secondaryports.entity.commons.StatusEntity;

@Repository
public interface StatusRepository extends JpaRepository<StatusEntity, UUID>, StatusRepositoryCustom {

}
