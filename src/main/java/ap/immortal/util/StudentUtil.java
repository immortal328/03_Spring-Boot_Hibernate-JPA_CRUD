package ap.immortal.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import ap.immortal.model.Student;

@Component
public class StudentUtil {
	
	public StudentUtil() {
		System.out.println("created bean of "+ getClass().getSimpleName());
	}
	
	public List<Student> createStudents(){
		List<Student> studentList = new ArrayList<Student>();
		studentList.add(new Student("acb", "xyz", "fsf.fgd@gmail.com"));
		studentList.add(new Student("zxy", "sdg", "sss.ff@gmail.com\""));
		studentList.add(new Student("zfhg", "sfh", "fff.zogggre@gmail.com\""));
		studentList.add(new Student("sgh", "ggd", "xfghb.gsdtsf@gmail.com\""));
		return studentList;
	}

}
