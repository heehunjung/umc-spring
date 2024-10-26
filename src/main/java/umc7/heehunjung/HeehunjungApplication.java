package umc7.heehunjung;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class HeehunjungApplication {

	public static void main(String[] args) {
		SpringApplication.run(HeehunjungApplication.class, args);
	}

}
