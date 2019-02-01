import java.lang.*;

public class faculty extends Users{
    int faculty_id;
    String department;
    public faculty(){
    }
	public faculty(int u,String user,String profession,int fac,String dep) { 
        super(u,user,profession);
        faculty_id = fac;
        department = dep;
    }
        
    public int get_faculty_id() { return faculty_id; }
    public void setfaculty_id(int s){ faculty_id=s; }
    
	public String get_dep() { return department; }
    public void set_dep(String s){ department = s; }
    
    public void print()
    { 
        System.out.println("faculty_id=" + faculty_id); 
        System.out.println("department=" + department); 
    }
};
