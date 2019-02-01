import java.lang.*;

public class Login{
	int login_ID;
	String username;
	String password;
	int user_ID;
	
	public Login(int login_ID, String username, String password, int user_ID) {
		super();
		this.login_ID = login_ID;
		this.username = username;
		this.password = password;
		this.user_ID = user_ID;
	}
	public Login()
	{
		
	}

	public int getLogin_ID() {
		return login_ID;
	}

	public void setLogin_ID(int login_ID) {
		this.login_ID = login_ID;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getUser_ID() {
		return user_ID;
	}

	public void setUser_ID(int user_ID) {
		this.user_ID = user_ID;
	}

	public void print(){System.out.println("user_ID=" + user_ID); System.out.println("login_ID=" + login_ID); System.out.println("username=" + username);}
};