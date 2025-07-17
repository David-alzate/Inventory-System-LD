package co.inventory.system.ld.init;

import co.inventory.system.ld.application.secondaryports.entity.users.UserTypeEntity;
import co.inventory.system.ld.application.secondaryports.repository.users.UserTypeRepository;
import co.inventory.system.ld.crosscutting.helpers.UUIDHelper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@SpringBootApplication
@ComponentScan(basePackages = { "co.inventory.system.ld" })
@EnableJpaRepositories("co.inventory.system.ld")
@EntityScan("co.inventory.system.ld.application.secondaryports.entity")
public class InventorySystemLdApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventorySystemLdApplication.class, args);
	}

	@Bean
	CommandLineRunner init(UserTypeRepository userTypeRepository){
		return _ -> {
			var userTypes = userTypeRepository.findAll();

			if (userTypes.isEmpty()){

				userTypeRepository.saveAll(List.of(UserTypeEntity.create().setId(UUIDHelper.generate()).setName("ADMIN"),
						UserTypeEntity.create().setId(UUIDHelper.generate()).setName("USER")));
			}
		};
	}
	@Bean
	WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins("http://localhost:4200").allowedMethods("*")
						.allowedHeaders("*");
			}
		};
	}

}
