package ap.immortal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ap.immortal.model.Student;


@Repository
public interface StudentRepository  extends JpaRepository<Student, Integer>{
	Student findStudentById(Integer id);
	List<Student> findByStd(Integer std);
	List<Student> findByFirstName(String firstName);
	List<Student> findByLastName(String lastName);
}
