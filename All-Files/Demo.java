//STEP 1. Import required packages
import java.sql.*;

public class Demo {
	public static void main(String[] args) {
		try{
			DAO_Factory daoFactory = new DAO_Factory();

			daoFactory.activateConnection();

			booksDAO sdao = daoFactory.getbooksDAO();
			books b = new books(1008,"potter2","j.k rowling",1,2);
			shelf s = new shelf(2,20);
			sdao.addbook(b,s);
			books bk1 = sdao.getbookByKey(1008);
			bk1.print();
			sdao.removebook(b);
			daoFactory.deactivateConnection();
		}catch(Exception e){
				//Handle errors for Class.forName
				e.printStackTrace();
		}
	}//end main
}//end FirstExample
