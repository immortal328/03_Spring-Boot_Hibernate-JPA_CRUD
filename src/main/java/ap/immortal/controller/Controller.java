package ap.immortal.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import ap.immortal.dao.StudentDAOImple;
import ap.immortal.service.StudentService;
import ap.immortal.util.StudentUtil;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class Controller {
	private final StudentService studentService;
	private final StudentDAOImple studentDAOImple;
	private final StudentUtil studentUtil;
	
	
	@GetMapping("/")
	public String greetingMsg() {
		return "<h1>"+"WellCome to Hibernate Spring Practice project"+"</h1>";
	}
	
	@GetMapping("/insertByJPA")
	public String inserStudentDetailsByJPARepository() {
		studentService.insertStudentDetails(studentUtil.createStudents());
		return "Inserted Data Using JPARepository ...";
	}
	
	@GetMapping("/insertByEM")
	public String inserStudentDetailsByEntityManager() {
		studentDAOImple.insertStudentDetails(studentUtil.createStudents());
		return "Inserted Data Using EntityManager ...";
	}	

}
