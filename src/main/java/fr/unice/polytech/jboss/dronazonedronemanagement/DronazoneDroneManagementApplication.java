package fr.unice.polytech.jboss.dronazonedronemanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Import;
import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableFeignClients
public class DronazoneDroneManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(DronazoneDroneManagementApplication.class, args);
	}

}
