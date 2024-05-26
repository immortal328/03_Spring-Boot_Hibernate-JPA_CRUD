package ap.immortal.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import ap.immortal.model.Student;

@Component
public class StudentUtil {
	
	public List<Student> createStudents(){
		List<Student> studentList = new ArrayList<Student>();
		studentList.add(new Student("Amar", "Pujari", "amar.pujari@gmail.com"));
		studentList.add(new Student("Omkar", "Sawant", "omkar.sawant@gmail.com\""));
		studentList.add(new Student("Pranit", "Zore", "pranit.zore@gmail.com\""));
		studentList.add(new Student("Rakesh", "Puri", "rakesh.puri@gmail.com\""));
		return studentList;
	}

}
