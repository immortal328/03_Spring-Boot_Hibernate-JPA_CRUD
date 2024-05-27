package ap.immortal.controller;

import java.util.List;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import ap.immortal.model.Student;
import ap.immortal.service.StudentService;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class Controller {
	private final StudentService studentService;	
	
	@GetMapping("/")
	public String greetingMsg() {
		return "<h1>"+"WellCome to Hibernate Spring Practice project"+"</h1>";
	}
	
	@PostMapping("/insertByJPA")
	public String inserStudentDetailsByJPARepository() {
		//studentService.insertStudentDetails(studentUtil.createStudents());
		return "Inserted Data Using JPARepository ...";
	}
	
	@PostMapping("/insertByEM")
	public String inserStudentDetailsByEntityManager() {
		//studentDAOImple.insertStudentDetails(studentUtil.createStudents());
		return "Inserted Data Using EntityManager ...";
	}
	
	@GetMapping("/studentEm/{id}")
	public ResponseEntity<Student> getStudentByID(@PathVariable Integer id){
		Student student = studentService.getStudentByID(id);	
		return new ResponseEntity<Student>(student, HttpStatusCode.valueOf(200));
	}
	
	@GetMapping("/studentJpa/{std}")
	public ResponseEntity<List<Student>> fetchStudentsByStd(@PathVariable Integer std){
		List<Student> students = studentService.fetchStudentsByStd(std);	
		return new ResponseEntity<List<Student>>(students, HttpStatusCode.valueOf(200));
	}

}
