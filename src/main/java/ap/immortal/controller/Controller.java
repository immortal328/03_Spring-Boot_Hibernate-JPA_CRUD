package ap.immortal.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import ap.immortal.service.StudentService;
import ap.immortal.util.StudentUtil;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class Controller {
	private final StudentService studentService;
	private final StudentUtil studentUtil;
	
	
	@GetMapping("/")
	public String greetingMsg() {
		return "<h1>"+"WellCome to Hibernate Spring Practice project"+"</h1>";
	}
	
	@GetMapping("/insert")
	public String inserSomeStudentInDatabase() {
		studentService.insertStudentDetails(studentUtil.createStudents());
		return "Inseted data...";
	}	

}
