import java.util.ArrayList;
import java.util.List;
import java.sql.*;


public class borrowable_booksDAO_JDBC implements borrowable_booksDAO {
																																																																																																																																																																																																																																															Connection dbConnection;

	public borrowable_booksDAO_JDBC(Connection dbconn){
		// JDBC driver name and database URL
 		//  Database credentials
		dbConnection = dbconn;
	}

	@Override
	public int changeBookStatus(boolean a,int book_id) {
		borrowable_books b = new borrowable_books();
		String sql;
		PreparedStatement preparedStatement = null;
		sql= "Update borrowable_books set status=(?) where bbook_ID=(?)";
		try{
			preparedStatement = dbConnection.prepareStatement(sql);
 
			preparedStatement.setBoolean(1, a);
			preparedStatement.setInt(2,book_id);
 
			// execute insert SQL stetement
			preparedStatement.executeUpdate();																																																																																																																																																																																
			//STEP 5: Extract data from result set
				//Retrieve by column name
			System.out.println("book_id:" + book_id + ", status changed in database");

				// Add exception handling here if more than one row is returne
		} catch (SQLException ex) {
		    // handle any errors
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		    return 0;
		}
		// Add exception handling when there is no matching record
		return 1;
	}
}
