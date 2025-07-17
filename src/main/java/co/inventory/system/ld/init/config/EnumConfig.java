package co.inventory.system.ld.init.config;

import co.inventory.system.ld.application.secondaryports.repository.commons.StatusRepository;
import co.inventory.system.ld.application.secondaryports.repository.users.UserTypeRepository;
import co.inventory.system.ld.crosscutting.enums.StatusEnum;
import co.inventory.system.ld.crosscutting.enums.UserTypeEnum;
import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EnumConfig {
    private final UserTypeRepository userTypeRepository;
    private final StatusRepository statusRepository;

    public EnumConfig(UserTypeRepository userTypeRepository, StatusRepository statusRepository) {
        this.userTypeRepository = userTypeRepository;
        this.statusRepository = statusRepository;
    }

    @PostConstruct
    public void init(){
        UserTypeEnum.setUserTypeRepository(userTypeRepository);
        StatusEnum.setStatusRepository(statusRepository);
    }
}
