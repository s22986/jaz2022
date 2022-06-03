package pl.pjwtk.domkru;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@ImportResource("classpath:Beans.xml")
@SpringBootApplication
public class DomkruApplication {
	public static void main(String[] args) {
		SpringApplication.run(DomkruApplication.class, args);
	}

}
