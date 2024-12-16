package co.inventory.system.ld.application.secondaryports.repository.users;

import co.inventory.system.ld.application.secondaryports.entity.users.UserTypeEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserTypeRepositoryCustom {

    List<UserTypeEntity> findByFilter(UserTypeEntity filter);
}
