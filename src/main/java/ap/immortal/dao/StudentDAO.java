package ap.immortal.dao;

import java.util.List;

import ap.immortal.model.Student;

public interface StudentDAO {
	
	public void save(Student student);
	public List<Student> getAll();
	public List<Student> getStudentsByStd(Integer std);
	public List<Student> getStudentByLastNmae(String lastName);
	public String getupdateStudentLastNameOfID(Integer id,String lastNmae);
	public String getdeleteStudentByID(Integer id);
	public String entityDeleteAll();

}
