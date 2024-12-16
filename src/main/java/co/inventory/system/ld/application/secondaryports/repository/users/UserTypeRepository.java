package co.inventory.system.ld.application.secondaryports.repository.users;

import co.inventory.system.ld.application.secondaryports.entity.users.UserTypeEntity;
import co.inventory.system.ld.infrastructure.secondaryadapters.data.sql.repository.users.UserTypeRepositoryCustom;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserTypeRepository extends JpaRepository<UserTypeEntity, UUID>, UserTypeRepositoryCustom {
}
