package ap.immortal.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ap.immortal.model.Student;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
public class StudentDAOImple implements StudentDAO {
	
	private EntityManager entitymanager;
	
	@Autowired
	public StudentDAOImple(EntityManager entitymanager) {
		this.entitymanager = entitymanager;		
	}
	
	@Override
	//@Transactional
	public void save(Student student) {
		entitymanager.persist(student);	
		System.out.println("Saved Student using EntityManager : "+student.toString());
	}
	
	@Transactional
	public void insertStudentDetails(List<Student> list) {
		for(Student student : list) {
			save(student);
			System.out.println("Inserted succesfully...");
		}
	}

	public Student getStudentByID(Integer id) {
		return entitymanager.find(Student.class, id);		
	}

	public List<Student> getStudentsByStd(Integer std) {
		return null;
	}
}
