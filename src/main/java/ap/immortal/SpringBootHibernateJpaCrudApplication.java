package ap.immortal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ap.immortal.service.StudentService;

@SpringBootApplication
public class SpringBootHibernateJpaCrudApplication {
	
	@Autowired
	private static StudentService studentservice;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootHibernateJpaCrudApplication.class, args);
		studentservice.saveFewStudents();
	}

}
