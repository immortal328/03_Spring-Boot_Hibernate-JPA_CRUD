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
public class EntityManagerController {
	private final StudentService studentService;	
	
	@PostMapping("/insertByEM")
	public String inserStudentDetailsByEntityManager() {
		//studentDAOImple.insertStudentDetails(studentUtil.createStudents());
		return "Inserted Data Using EntityManager ...";
	}
	
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
	
	@GetMapping("/v1/entityManager/update/lastName/{lastName}/id/{id}")
	public String getUpdateByID(@PathVariable Integer id, @PathVariable String lastName) {
		return "<h1>"+ studentService.getUpdateStudentLastNameOfId(id, lastName)+"</h1>";
	}
	
	@GetMapping("/v1/entityManager/delete/id/{id}")
	public String getDeleteByID(@PathVariable Integer id) {
		return "<h1>"+ studentService.getDeleteStudentById(id)+"</h1>";		
	}
	
	@GetMapping("/v1/entityManager/deleteAll")
	public String getDeleteAll() {
		return "<h1>"+ studentService.getDeleteAll()+"</h1>";		
	}
}
