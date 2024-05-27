package ap.immortal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ap.immortal.dao.StudentDAOImple;
import ap.immortal.model.Student;
import ap.immortal.repository.StudentRepository;


@Service
public class StudentService {
	@Autowired
	private StudentRepository repository;
	
	@Autowired
	private StudentDAOImple studentDAOImple;	
	
	//Using EntityManager
	public Student getStudentByID(Integer id) {return studentDAOImple.getStudentByID(id);}	
	public List<Student> getStudentsByStd(Integer std) {return studentDAOImple.getStudentsByStd(std);}
	public List<Student> getAllStudent() {return studentDAOImple.getAll();}
	
	public void insertStudentDetailsWithEntityManager(List<Student> list) {
		for(Student student : list) {
			studentDAOImple.save(student);
			System.out.println("Inserted succesfully...");
		}
	}
	
	public List<Student> getStudentBylastName(String lastName) {
		return studentDAOImple.getStudentByLastNmae(lastName);
	}
	
	public String getUpdateStudentLastNameOfId(Integer id, String lastName) {
		return studentDAOImple.getupdateStudentLastNameOfID(id, lastName);
	}
	
	public String  getDeleteStudentById(Integer id) {
		return studentDAOImple.getdeleteStudentByID(id);		
	}
	
	public String getDeleteAll() {
		return studentDAOImple.entityDeleteAll();		
	}
	
	//Using JPARepository
	public Student fetchStudentByID(Integer id) {return repository.findStudentById(id);}	
	public List<Student> fetchStudentsByStd(Integer std) {return repository.findByStd(std);}
	
	public void insertStudentDetailsWithJPA(List<Student> list) {
		for(Student student : list) {
			repository.save(student);
			System.out.println("Inserted succesfully...");
		}
	}
	
	public List<Student> fetchAllStudent() {
		return repository.findAll();
	}
	
	public List<Student> fetchStudentBylastName(String lastName) {
		return repository.findByLastName(lastName);
	}
	
	public String fetchUpdateStudentLastNameOfId(Integer id, String lastName) {
		Student student = fetchStudentByID(id);
		student.setLastName(lastName);
		repository.save(student);
		return String.format("Updated Student lastName to %s of id %d by JPA", lastName,id);
	}
	
	public String fetchDeleteStudentById(Integer id) {
		repository.deleteById(id);
		return String.format("Deleted Row of ID : %d", id);
	}
	
	public String fetchDeleteAll() {
		repository.deleteAll();
		return "Deleted All Rows";
	}
	
	

}
