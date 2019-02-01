import java.util.ArrayList;
import java.util.List;
import java.sql.*;


public class UsersDAO_JDBC implements UsersDAO {
																																																																																																																																																																																																																																															Connection dbConnection;

	public UsersDAO_JDBC(Connection dbconn){
		// JDBC driver name and database URL
 		//  Database credentials
		dbConnection = dbconn;
	}

	@Override
	public Users getUsersByKey(int id) {
		Users s = new Users();
		String sql;
		Statement stmt = null;
		
		try
		{
			stmt = dbConnection.createStatement();
			sql = "select users_id,username,profession from users where users_id=" + id;
			ResultSet rs = stmt.executeQuery(sql);
																																																																																																																																																																																			
			//STEP 5: Extract data from result set
			while(rs.next()){
				//Retrieve by column name
				int users_id = rs.getInt("users_id");
				String username  = rs.getString("username");
				String profession = rs.getString("profession");

				s.setUsersId(users_id);
				s.setUsersUsername(username);
				s.setUsersProfession(profession);
				// Add exception handling here if more than one row is returned
			}
		} catch (SQLException ex) {
		    // handle any errors
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		}
		// Add exception handling when there is no matching record
		return s;
	}



}
