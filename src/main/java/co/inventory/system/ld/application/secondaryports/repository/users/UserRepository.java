package co.inventory.system.ld.application.secondaryports.repository.users;

import co.inventory.system.ld.application.secondaryports.entity.users.UserEntity;
import co.inventory.system.ld.infrastructure.secondaryadapters.data.sql.repository.users.UserRepositoryCustom;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, UUID>, UserRepositoryCustom {
    List<UserEntity> findAllByIdNumberAndUserTypeId(Long idNumber, UUID userTypeId);

}
