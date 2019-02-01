import java.lang.*;
import java.sql.*;

public class Sub_DAO_Factory{
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";

	static final String DB_URL = "jdbc:mysql://localhost/librarydb";
	static final String USER = "root";
	static final String PASS = "Tonystark01@";

	Connection dbconnection = null;
	boolean activeConnection = false;
	borrowable_booksDAO bbooksDAO = null;
	BooksDAO booksDAO = null;
	IssuelogDAO issuelogDAO = null;
	StudentDAO studentDAO=null;
	LoginDAO loginDAO=null;
	UsersDAO usersDAO = null;

	public Sub_DAO_Factory()
	{
		dbconnection = null;
		activeConnection = false;
	}

	public void activateConnection() throws Exception
	{
		if( activeConnection == true )
			throw new Exception("Connection already active");

		System.out.println("Connecting to database...");
		try{
			Class.forName("com.mysql.jdbc.Driver");
			dbconnection = DriverManager.getConnection(DB_URL,USER,PASS);
			activeConnection = true;
		} catch(ClassNotFoundException ex) {
			System.out.println("Error: unable to load driver class!");
			System.exit(1);
		} catch (SQLException ex) {
		    // handle any errors
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		}
	}

	public LoginDAO getloginDAO() throws Exception
	{
		if( activeConnection == false )
			throw new Exception("Connection not activated...");

		if( loginDAO == null )
			loginDAO = new LoginDAO_JDBC( dbconnection );

		return loginDAO;
	}
	public UsersDAO getusersDAO() throws Exception
	{
		if( activeConnection == false )
			throw new Exception("Connection not activated...");

		if( usersDAO == null )
			usersDAO = new UsersDAO_JDBC( dbconnection );

		return usersDAO;
	}

	public IssuelogDAO getissuelogDAO() throws Exception
	{
		if( activeConnection == false )
			throw new Exception("Connection not activated...");

		if( issuelogDAO == null )
			issuelogDAO = new IssuelogDAO_JDBC( dbconnection );

		return issuelogDAO;
	}

	public BooksDAO getBooksDAO() throws Exception
	{
		if( activeConnection == false )
			throw new Exception("Connection not activated...");

		if( booksDAO == null )
			booksDAO = new BooksDAO_JDBC( dbconnection );

		return booksDAO;
	}

	public borrowable_booksDAO getBbooksDAO() throws Exception
	{
		if( activeConnection == false )
			throw new Exception("Connection not activated...");

		if( bbooksDAO == null )
			bbooksDAO = new borrowable_booksDAO_JDBC( dbconnection );

		return bbooksDAO;
	}

	public StudentDAO getStudentDAO() throws Exception
	{
		if( activeConnection == false )
			throw new Exception("Connection not activated...");

		if( studentDAO == null )
			studentDAO = new StudentDAO_JDBC( dbconnection);

		return studentDAO;
	}


	public void deactivateConnection()
	{
		// Okay to keep deactivating an already deactivated connection
		activeConnection = false;
		if( dbconnection != null ){
			try{
				dbconnection.close();
				dbconnection = null;
				booksDAO = null;
				bbooksDAO = null;
				studentDAO = null;
				issuelogDAO = null;
			}
			catch (SQLException ex) {
			    // handle any errors
			    System.out.println("SQLException: " + ex.getMessage());
			    System.out.println("SQLState: " + ex.getSQLState());
			    System.out.println("VendorError: " + ex.getErrorCode());
			}
		}
	}
};

