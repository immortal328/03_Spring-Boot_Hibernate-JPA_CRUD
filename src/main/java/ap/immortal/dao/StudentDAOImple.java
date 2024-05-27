package ap.immortal.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ap.immortal.model.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
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
		TypedQuery<Student> query = entitymanager.createQuery("FROM Student WHERE std=:theStd", Student.class);
		query.setParameter("theStd", std);
		return query.getResultList();
	}

	@Override
	public List<Student> getAll() {
		TypedQuery<Student> query = entitymanager.createQuery("FROM Student", Student.class);
		return query.getResultList();
	}

	public List<Student> getStudentByLastNmae(String lastName) {
		TypedQuery<Student> query = entitymanager.createQuery("FROM Student WHERE lastNmae=:theLastName", Student.class);
		query.setParameter("theLastName", lastName);
		return query.getResultList();
	}
	
	@Override
	@Transactional
	public String getupdateStudentLastNameOfID(Integer id, String lastNmae) {
		Student student  = getStudentByID(id);
		student.setLastName(lastNmae);
		entitymanager.merge(student);
		return String.format("Updated Student lastName to %s of id %d by EntityManager", lastNmae,id);
		
	}

	@Override
	@Transactional
	public String getdeleteStudentByID(Integer id) {
		Student student = getStudentByID(id);
		entitymanager.remove(student);
		return String.format("Deleted Row of ID : %d", id);
	}

}
