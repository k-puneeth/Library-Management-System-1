import java.util.ArrayList;
import java.util.List;
import java.sql.*;


public class LoginDAO_JDBC implements LoginDAO {

Connection dbConnection;
	public LoginDAO_JDBC(Connection dbconn){
		// JDBC driver name and database URL
 		//  Database credentials
		dbConnection = dbconn;
	}
     
	@Override
	public Login getUserIDByCredentials(String username,String password) {
		Login login = new Login();
		String sql;
		Statement stmt = null;
		Boolean b  = false;
		try{
			stmt = dbConnection.createStatement();
			sql = "select user_ID,username,password,login_ID from login where username ='"+  username +"'  and  password = '"+ password+"'";
			ResultSet rs = stmt.executeQuery(sql);

			//STEP 5: Extract data from result set
			while(rs.next()){
				//Retrieve by column name
				int user_ID  = rs.getInt("user_ID");
				login.setUser_ID(user_ID);
				b=true;
				break;
				// Add exception handling here if more than one row is returned
			}
		} catch (SQLException ex) {
		    // handle any errors
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		}
		// Add exception handling when there is no matching record
		if(b)
		return login;
		else
		{
			return null;
		}
	}


}


