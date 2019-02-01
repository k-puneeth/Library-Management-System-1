import java.util.ArrayList;
import java.util.List;
import java.sql.*;


public class StudentDAO_JDBC implements StudentDAO {
																																																																																																																																																																																																																																															Connection dbConnection;

	public StudentDAO_JDBC(Connection dbconn){
		// JDBC driver name and database URL
 		//  Database credentials
		dbConnection = dbconn;
	}

	@Override
	public Student getStudentByRoll(String rollno1) {
		Student s = new Student();
		String sql;
		Statement stmt= null;
		
		try{
			stmt = dbConnection.createStatement();
			sql = "select rollno,student_ID from student";
			ResultSet rs = stmt.executeQuery(sql);
																																																																																																																																																																																			
			//STEP 5: Extract data from result set
			while(rs.next()){
				//Retrieve by column name
				if(rs==null)
				{
					break;
				}
				else
				{
					String rollno  = rs.getString("rollno");
					if(rollno.equals(rollno1))
					{
						int stud_id = rs.getInt("student_ID");
						s.setRollno(rollno);
						s.setStudId(stud_id);
						break;
					}
				}
				// Add exception handling here if more than one row is returned
			}

				// Add exception handling here if more than one row is returne
		} catch (SQLException ex) {
		    // handle any errors
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		}
		// Add exception handling when there is no matching record
		return s;
	}

	@Override
	public void addStudent(Student s)
	{
		String sql,sql1;
		PreparedStatement preparedStatement= null;
		sql = "insert into users(Users_ID,username,profession) values (?,?,?)";
		try{
			preparedStatement = dbConnection.prepareStatement(sql);																																																																																																																																																																																			
			//STEP 5: Extract data from result set
			preparedStatement.setInt(1,s.getUsersUsersId());
			preparedStatement.setString(2,s.getUsersUserName());
			preparedStatement.setString(3,s.getUsersProfession());
			preparedStatement.executeUpdate();
			if(preparedStatement!=null)
			{
				preparedStatement.close();
			}
				// Add exception handling here if more than one row is returne
		} catch (SQLException ex) {
		    // handle any errors
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		}
		// Add exception handling when there is no matching record
		PreparedStatement preparedStatement1= null;
		sql1 = "insert into student(student_ID,program,rollno) values (?,?,?)";
		try{
			preparedStatement1 = dbConnection.prepareStatement(sql1);																																																																																																																																																																																			
			//STEP 5: Extract data from result set
			preparedStatement1.setInt(1,s.getStudentId());
			preparedStatement1.setString(2,s.getProgram());
			preparedStatement1.setString(3,s.getRollno());
			preparedStatement1.executeUpdate();
				// Add exception handling here if more than one row is returne
		} catch (SQLException ex) {
		    // handle any errors
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		}
	}

	@Override
	public void addFaculty(faculty f)
	{
		String sql,sql1;
		PreparedStatement preparedStatement= null;
		sql = "insert into users(Users_ID,username,profession) values (?,?,?)";
		try{
			preparedStatement = dbConnection.prepareStatement(sql);																																																																																																																																																																																			
			//STEP 5: Extract data from result set
			preparedStatement.setInt(1,f.getUsersUsersId());
			preparedStatement.setString(2,f.getUsersUserName());
			preparedStatement.setString(3,f.getUsersProfession());
			preparedStatement.executeUpdate();
			if(preparedStatement!=null)
			{
				preparedStatement.close();
			}
				// Add exception handling here if more than one row is returne
		} catch (SQLException ex) {
		    // handle any errors
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		}
		// Add exception handling when there is no matching record
		PreparedStatement preparedStatement1= null;
		sql1 = "insert into faculty(faculty_id,department) values (?,?)";
		try{
			preparedStatement1 = dbConnection.prepareStatement(sql1);																																																																																																																																																																																			
			//STEP 5: Extract data from result set
			preparedStatement1.setInt(1,f.get_faculty_id());
			preparedStatement1.setString(2,f.get_dep());
			preparedStatement1.executeUpdate();
				// Add exception handling here if more than one row is returne
		} catch (SQLException ex) {
		    // handle any errors
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		}
	}

	
}
