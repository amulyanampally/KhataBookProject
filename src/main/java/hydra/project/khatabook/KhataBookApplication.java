package hydra.project.khatabook;

import java.sql.Date;
import java.time.LocalDate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;

@SpringBootApplication
public class KhataBookApplication {

	public static void main(String[] args) {
		SpringApplication.run(KhataBookApplication.class, args);
	      LocalDate localDate = LocalDate.now();
	      System.out.print(localDate);
 
	}

}
