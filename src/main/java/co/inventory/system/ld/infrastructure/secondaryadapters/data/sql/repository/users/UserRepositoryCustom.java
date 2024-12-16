package co.inventory.system.ld.infrastructure.secondaryadapters.data.sql.repository.users;

import co.inventory.system.ld.application.secondaryports.entity.users.UserEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepositoryCustom {

    List<UserEntity> findByFilter(UserEntity filter);
}
