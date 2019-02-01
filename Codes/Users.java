import java.lang.*;

public class Users{
	int users_ID;
	String username;
	String profession;
	public Users(){
	}
	public Users(int u,String user,String prof){
		users_ID=u;
		username=user;
		profession=prof;
	}
	
	// public Student() { }
	// public Student (String s, int r){ rollno = r; name = s; }
	public String getUsersUserName() { return username; }
	public int getUsersUsersId() { return users_ID; }
	public void setUsersId(int id){users_ID=id;}
	public void setUsersUsername(String usr){username=usr;}
	public void setUsersProfession(String prof){profession=prof;}
	public String getUsersProfession() { return profession; }
	// public void setName(String s){ name = s; }
	// public int getRollno() { return rollno; }
	// public void setRollno(int s){ rollno = s; }
	public void print(){System.out.println("users_ID=" + users_ID); System.out.println("username=" + username); System.out.println("profession=" + profession);}
};