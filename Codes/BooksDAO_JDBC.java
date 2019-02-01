import java.util.ArrayList;
import java.util.List;
import java.sql.*;


public class BooksDAO_JDBC implements BooksDAO {
																																																																																																																																																																																																																																															Connection dbConnection;

	public BooksDAO_JDBC(Connection dbconn){
		// JDBC driver name and database URL
 		//  Database credentials
		dbConnection = dbconn;
	}

	@Override
	public Books getBookByName(String name) {
		Books b = new Books();
		String sql;
		Statement stmt = null;
		
		try{
			stmt = dbConnection.createStatement();
			sql = "select * from books";
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
					int isbn = rs.getInt("ISBN");
					String bname = rs.getString("bookname");
					String auth = rs.getString("author");
					int ed  = rs.getInt("edition_b");
					int shelf_id = rs.getInt("shelf_ID");
					if(bname.equals(name))
					{
						b.setbbook_ID(isbn);
						b.setName(bname);
						b.setauthor(auth);
						b.setedition(ed);
						b.setShelf_ID(shelf_id);
						break;
					}
				}
				// Add exception handling here if more than one row is returned
			}
		} catch (SQLException ex) {
		    // handle any errors
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		}
		// Add exception handling when there is no matching record
		return b;
	}

}
