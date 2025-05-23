package dukes.spring;

import dukes.ai.AwesomeJakartaGPTModel;
import dukes.ai.JakartaGPT;
import jakarta.enterprise.inject.se.SeContainer;
import jakarta.enterprise.inject.se.SeContainerInitializer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

	private static SeContainer weldContainer;

	public static void main(String[] args) {

		weldContainer = SeContainerInitializer.newInstance()
				.addBeanClasses(JakartaGPT.class)
				.addBeanClasses(AwesomeJakartaGPTModel.class)
				.initialize();

		SpringApplication.run(Application.class, args);
	}

	@Bean
	public JakartaGPT jakartaGPT() {
		return weldContainer.select(JakartaGPT.class).get();
	}

	@Bean
	public AwesomeJakartaGPTModel awesomeModel() {
		return weldContainer.select(AwesomeJakartaGPTModel.class).get();
	}
}
