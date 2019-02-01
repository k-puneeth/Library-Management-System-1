import java.lang.*;
import java.util.List;

public interface StudentDAO {
	// public Student getStudentByKey(int rollNo);
	// public void addStudent(Student student);
	// public void updateStudent(Student student);
	// public void deleteStudent(Student student);
	public Student getStudentByRoll(String rollno1);
	public void addStudent(Student s);
	public void addFaculty(faculty f);
	
}