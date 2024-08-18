package online.nutritabapi.api_nutricional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class NutriTabApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(NutriTabApiApplication.class, args);
	}

}
