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
	
	//EntityManager
	@GetMapping("/v1/entityManager/student/{id}")
	public ResponseEntity<Student> getStudentByID(@PathVariable Integer id){
		return new ResponseEntity<Student>(studentService.getStudentByID(id), HttpStatusCode.valueOf(200));
	}
	
	@GetMapping("/v1/entityManager/students/std/{std}")
	public ResponseEntity<List<Student>> getStudentsByStd(@PathVariable Integer std){
		return new ResponseEntity<List<Student>>(studentService.getStudentsByStd(std), HttpStatusCode.valueOf(200));
	}
	
	@GetMapping("/v1/entityManager/allStudent")
	public ResponseEntity<List<Student>> getAllStudents(){
		return new ResponseEntity<List<Student>>(studentService.getAllStudent(), HttpStatusCode.valueOf(200));
	}
	
	@GetMapping("/v1/entityManager/student/lastName/{lastName}")
	public ResponseEntity<List<Student>> getStudentByLastName(@PathVariable String lastName){
		return new ResponseEntity<List<Student>>(studentService.getStudentBylastName(lastName), HttpStatusCode.valueOf(200));
	}
	
	
	
	//JPARepository
	@GetMapping("/v1/JPA/student/{id}")
	public ResponseEntity<Student> fetchStudentByID(@PathVariable Integer id) {
		return new ResponseEntity<Student>(studentService.fetchStudentByID(id), HttpStatusCode.valueOf(200));
	}
	
	@GetMapping("/v1/JPA/students/std/{std}")
	public ResponseEntity<List<Student>> fetchStudentsByStd(@PathVariable Integer std){
		return new ResponseEntity<List<Student>>(studentService.fetchStudentsByStd(std), HttpStatusCode.valueOf(200));
	}
	
	@GetMapping("/v1/JPA/allStudent")
	public ResponseEntity<List<Student>> fetchAllStudents(){
		return new ResponseEntity<List<Student>>(studentService.fetchAllStudent(), HttpStatusCode.valueOf(200));
	}
	
	@GetMapping("/v1/JPA/student/lastName/{lastName}")
	public ResponseEntity<List<Student>> fetchStudentByLastName(@PathVariable String lastName){
		return new ResponseEntity<List<Student>>(studentService.fetchStudentBylastName(lastName), HttpStatusCode.valueOf(200));
	}

}
