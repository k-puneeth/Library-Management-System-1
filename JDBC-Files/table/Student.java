import java.lang.*;

public class Student{
	String student_ID;
	String program;
	String rollno;

	// public Student() { }
	// public Student (String s, int r){ rollno = r; name = s; }
	public String getStudentId() { return student_ID ;}
	// public void setName(String s){ name = s; }
	public String getRollno() { return rollno; }
	// public void setRollno(int s){ rollno = s; }
	public String print(){ System.out.println("rollno=" + rollno); System.out.println("Name=" + sname);System.out.println("Program=" + program);System.out.println("student_ID=" + student_ID);}
};

