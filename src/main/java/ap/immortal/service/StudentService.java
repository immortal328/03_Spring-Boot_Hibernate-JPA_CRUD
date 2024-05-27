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
	 
	public void insertStudentDetails(List<Student> list) {
		for(Student student : list) {
			repository.save(student);
			System.out.println("Inserted succesfully...");
		}
	}
	
	public Student getStudentByID(Integer id) {
		return studentDAOImple.getStudentByID(id);		
	}
	
	public Student fetchStudentByID(Integer id) {
		return repository.findStudentById(id);		
	}
	
	public List<Student> getStudentsByStd(Integer std) {
		return studentDAOImple.getStudentsByStd(std);		
	}
	
	public List<Student> fetchStudentsByStd(Integer std) {
		return repository.findByStd(std);		
	}
	
	

}
