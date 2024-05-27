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
public class JPARepositoryController {
	private final StudentService studentService;	

	@PostMapping("/insertByJPA")
	public String inserStudentDetailsByJPARepository() {
		//studentService.insertStudentDetails(studentUtil.createStudents());
		return "Inserted Data Using JPARepository ...";
	}
	
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
	
	@GetMapping("/v1/JPA/update/lastName/{lastName}/id/{id}")
	public String fetchUpdateByID(@PathVariable Integer id, @PathVariable String lastName) {
		return "<h1>"+studentService.fetchUpdateStudentLastNameOfId(id, lastName)+"</h1>";		
	}
	
	@GetMapping("/v1/JPA/delete/id/{id}")
	public String fetchDeleteByID(@PathVariable Integer id) {
		return "<h1>"+studentService.fetchDeleteStudentById(id)+"</h1>";		
	}
	
	@GetMapping("/v1/JPA/deleteAll")
	public String fetchDeleteByID() {
		return "<h1>"+ studentService.fetchDeleteAll()+"</h1>";		
	}
	
	

}
