package ap.immortal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ap.immortal.model.Student;
import ap.immortal.repository.StudentRepository;
import ap.immortal.util.StudentUtil;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private StudentUtil studentUtil;
	
	List<Student> studentList = studentUtil.createStudents();
	
	public void saveFewStudents() {		
		for(Student student : studentList) {
			studentRepository.save(student);
			System.out.println("Succesfully saved Details od Student : "+student.toString());	
		}
	}

}
