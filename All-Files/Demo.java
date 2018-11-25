//STEP 1. Import required packages
import java.sql.*;

public class Demo {
	public static void main(String[] args) {
		try{
			DAO_Factory daoFactory = new DAO_Factory();

			daoFactory.activateConnection();

			
			booksDAO sdao = daoFactory.getbooksDAO();

			// search by key
			//add book
			books b1 = new books(1008,"potter1","j.k rowling",1,1);
			shelf s1 = new shelf(1,10);
			sdao.addbook(b1,s1);

			books bk1 = sdao.getbookByKey(1008);
			bk1.print();
			

			// search by name
			//add book
			books b2 = new books(1009,"potter2","j.k rowling",1,2);
			shelf s2 = new shelf(2,20);
			sdao.addbook(b2,s2);

			books bk2 = sdao.getbookByName("potter2");
			bk2.print();


			// search by author
			//add book
			books b3 = new books(1007,"potter3","j.k rowling",1,1);
			sdao.addbook(b3,s1);

			books bk3 = sdao.getbookByAuthor("j.k rowling");
			bk3.print();

			//remove book
			sdao.removebook(bk1);
			sdao.removebook(bk2);
			sdao.removebook(bk3);


			daoFactory.deactivateConnection();
		}catch(Exception e){
				//Handle errors for Class.forName
				e.printStackTrace();
		}
	}//end main
}//end FirstExample
