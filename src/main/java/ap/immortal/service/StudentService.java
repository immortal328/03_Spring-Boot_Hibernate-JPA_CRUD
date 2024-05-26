package ap.immortal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ap.immortal.model.Student;
import ap.immortal.repository.StudentRepository;


@Service
public class StudentService {
	@Autowired
	private StudentRepository repository;
	 
	public void insertStudentDetails(List<Student> list) {
		for(Student student : list) {
			repository.save(student);
			System.out.println("Inserted succesfully...");
		}
	}

}
