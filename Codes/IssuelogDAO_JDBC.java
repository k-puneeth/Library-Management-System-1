import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import java.util.Calendar;
import java.util.Date;

public class IssuelogDAO_JDBC implements IssuelogDAO {
																																																																																																																																																																																																																																															Connection dbConnection;

	public IssuelogDAO_JDBC (Connection dbconn){
		// JDBC driver name and database URL
 		//  Database credentials
		dbConnection = dbconn;
	}

	// private static java.sql.Date getCurrentDate() {
 //    java.util.Date today = new java.util.Date();
 //    return new java.sql.Date(today.getTime());
	// }
	@Override
	public void addLog(Student s,Books b,int count) {
		Issuelog ilog= new Issuelog();
		String sql;
		PreparedStatement preparedStatement = null;
		sql = "insert into issue_log(issue_ID,book_ID,student_id,date_issued,expected_return,return_date,status) values (?,?,?,?,?,?,?)";
		try{
			preparedStatement = dbConnection.prepareStatement(sql);
 			
			preparedStatement.setInt(1,count);
			preparedStatement.setInt(2,b.getbbook_ID());
 			preparedStatement.setInt(3,s.getStudentId());
 			preparedStatement.setDate(4,java.sql.Date.valueOf(java.time.LocalDate.now()));
 			preparedStatement.setDate(5,java.sql.Date.valueOf(java.time.LocalDate.now().plusDays(7)));
 			preparedStatement.setDate(6,null);
 			preparedStatement.setInt(7,0);
			// execute insert SQL stetement
			preparedStatement.executeUpdate();																																																																																																																																																																																
			//STEP 5: Extract data from result set
				//Retrieve by column name
			System.out.println("ilog:"+ count + ",added changed in database");

				// Add exception handling here if more than one row is returne
		} catch (SQLException ex) {
		    // handle any errors
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		}
		// Add exception handling when there is no matching recor
	}

	@Override
	public void updateNewEntryLog(Issuelog ilog,int count){
		Issuelog ilog1= new Issuelog();
		String sql;
		PreparedStatement preparedStatement = null;
		sql = "insert into issue_log(issue_ID,book_ID,student_id,date_issued,expected_return,return_date,status) values (?,?,?,?,?,?,?)";

		try{
			preparedStatement = dbConnection.prepareStatement(sql);
 
			preparedStatement.setInt(1,count);
			preparedStatement.setInt(2,ilog.getbook_id());
 			preparedStatement.setInt(3,ilog.getstudent_id());
 			preparedStatement.setDate(4,java.sql.Date.valueOf(java.time.LocalDate.now().plusDays(7)));
 			preparedStatement.setDate(5,java.sql.Date.valueOf(java.time.LocalDate.now().plusDays(14)));
 			preparedStatement.setDate(6,null);
 			preparedStatement.setInt(7,0);
			// execute insert SQL stetement
			preparedStatement.executeUpdate();																																																																																																																																																																																
			//STEP 5: Extract data from result set
				//Retrieve by column name
			System.out.println("ilog:"+ count + ", status changed in database");

				// Add exception handling here if more than one row is returne
		} catch (SQLException ex) {
		    // handle any errors
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		}
	}

	@Override
	public void updateLog(Issuelog ilog){
		Issuelog ilog1= new Issuelog();
		String sql;
		PreparedStatement preparedStatement = null;
		sql = "update issue_log set return_date=(?),status=(?) where issue_ID=(?)";

		try{
			preparedStatement = dbConnection.prepareStatement(sql);
 
			preparedStatement.setDate(1,java.sql.Date.valueOf(java.time.LocalDate.now().plusDays(7)));
			preparedStatement.setInt(2,1);
			int x = ilog.getissue_id();
			preparedStatement.setInt(3,x);
			// execute insert SQL stetement
			preparedStatement.executeUpdate();																																																																																																																																																																																
			//STEP 5: Extract data from result set
				//Retrieve by column name
			System.out.println("New Entry for book has been created");

				// Add exception handling here if more than one row is returne
		} catch (SQLException ex) {
		    // handle any errors
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		}
	}

	@Override
	public Issuelog findLog(Student sd,Books bk){
		Issuelog ilog1= new Issuelog();
		String sql;
		Statement stmt = null;
		try{
			sql = "select * from issue_log";
			int student_id = sd.getStudentId();
			int book_id = bk.getbbook_ID();
			stmt = dbConnection.createStatement();
			// execute insert SQL stetement
			ResultSet rs =stmt.executeQuery(sql);
			while(rs.next())
			{
				if(rs==null)
				{
					break;
				}
				else
				{
					int iss_id=rs.getInt("issue_ID");
					int bk_id=rs.getInt("book_ID");
					int std_id =rs.getInt("student_id");
					Date date_issued = rs.getDate("date_issued");
					Date expec_return = rs.getDate("expected_return");
					Date return_date = rs.getDate("return_date");
					boolean status= rs.getBoolean("status");
					if(student_id==std_id && bk_id==book_id)
					{
						ilog1.setissue_id(iss_id);
						ilog1.setbook_id(bk_id);
						ilog1.setstudent_id(std_id); 
						ilog1.setdate_issued(date_issued);																																																																																																																																																																																
						ilog1.setexpec_return(expec_return);
						ilog1.setreturn_date(return_date);
						System.out.println("Books location has been found");
						break;
					}	
				}
			}
			//STEP 5: Extract data from result set
				//Retrieve by column name
				// Add exception handling here if more than one row is returne
		} catch (SQLException ex) {
		    // handle any errors
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		}
			return ilog1;
	}
}
