package br.com.api.states;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

@SpringBootApplication
@EnableSpringDataWebSupport
public class StatesApplication {

	public static void main(String[] args) {
		SpringApplication.run(StatesApplication.class, args);
	}

}
