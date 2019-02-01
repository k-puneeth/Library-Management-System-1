import java.lang.*;

public class Student extends Users{
	int student_ID;
	String program;
	String rollno;
	public Student(){
	}
	public Student(int u,String user,String profession,String p,String roll){
		super(u,user,profession);
		student_ID = u;
		program  = p;
		rollno = roll;
	}
	// public Student() { }
	// public Student (String s, int r){ rollno = r; name = s; }
	public int getStudentId() { return student_ID ;}
	public void setStudId(int s){ student_ID = s; }
	public String getRollno() { return rollno; }
	public void setRollno(String s){ rollno = s; }
	public String getProgram(){return program;}
	public void print(){ System.out.println("rollno=" + rollno);System.out.println("Program=" + program);System.out.println("student_ID=" + student_ID);}
};

