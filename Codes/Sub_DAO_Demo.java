//STEP 1. Import required packages
import java.sql.*;
import java.io.*;
import java.util.*;
import java.lang.*;


public class Sub_DAO_Demo {
	public static void main(String[] args) {
		int count=11000;
		Random rand = new Random();
		Sub_DAO_Factory daoFactory = new Sub_DAO_Factory();		
		try{
		    daoFactory.activateConnection();
			StudentDAO sdao = daoFactory.getStudentDAO();
			borrowable_booksDAO bbdao = daoFactory.getBbooksDAO();
			BooksDAO bdao= daoFactory.getBooksDAO();
			IssuelogDAO idao= daoFactory.getissuelogDAO();
			LoginDAO ldao = daoFactory.getloginDAO();
			UsersDAO udao = daoFactory.getusersDAO();
			Scanner sc =new Scanner(System.in);
			Login l = new Login();
			while(true)
			{
				System.out.println("Select the option you want to execute");
				System.out.println("1.Issue");
				System.out.println("2.Reissue");
				System.out.println("3.ADD User");
				System.out.println("4.Exit");
				int opt = sc.nextInt();
				if(opt==4)
					{
						System.out.println("Exiting....");
						break;
					}
				System.out.println("Username:");
				String s3 = sc.next();
				System.out.println("Password:");
				String s2 = sc.next();
				Users u;
			l = ldao.getUserIDByCredentials(s3,s2);
			if(l==null)
			{
				System.out.println("Invalid Details");
			}
			else
			{
				u = udao.getUsersByKey(l.getUser_ID()); 
					if(opt==1)
					{
						if(u.getUsersProfession().equals("librarian"))
						{
							System.out.println("Please mention your rollno:");
							String rollno= sc.next();
							Student s1 = sdao.getStudentByRoll(rollno);
							System.out.println("Please mention the book you want to take:");
							String bname = sc.next();
							Books b1 = bdao.getBookByName(bname);
							count++;
							idao.addLog(s1,b1,count);
							bbdao.changeBookStatus(true,b1.getbbook_ID());
							bbdao.changeBookStatus(false,b1.getbbook_ID());
						}
						else
						{
							System.out.println("not allowed");
						}
					}	
					else if(opt==2)
					{
						if(u.getUsersProfession().equals("librarian"))
						{
							System.out.println("Please mention your rollno:");
							String rollno= sc.next();
							System.out.println("Please mention the book you want for extension:");
							String bname = sc.next();
							count++;
							Student sd = sdao.getStudentByRoll(rollno);
							Books bk = bdao.getBookByName(bname);
							Issuelog il = idao.findLog(sd,bk);
							idao.updateLog(il);
							idao.updateNewEntryLog(il,count);
						}
						else
						{
							System.out.println("not allowed");
						}	
					}

					else if(opt==3)
					{
						if(u.getUsersProfession().equals("admin"))
						{
							System.out.println("Enter your name:");
							String usrname =sc.next();
							System.out.println("Enter your profession");
							String profession = sc.next();
							count++;
							if(profession.equals("student"))
							{
							System.out.println("Enter your rollno");
								String rollno=sc.next();
							System.out.println("Enter your program");	
								String program=sc.next();
								Student s=new Student(count,usrname,profession,program,rollno);
								sdao.addStudent(s);
							}
							else if(profession.equals("faculty"))
							{
							System.out.println("Enter your department");
								String depart = sc.next();
								int fac = count;
								faculty f =new faculty(count,usrname,profession,fac,depart);
								sdao.addFaculty(f);
							}
						}
						else
						{
							System.out.println("not allowed");
						}	
					}
					}
			}
		}
		catch(Exception e){
				//Handle errors for Class.forName
				e.printStackTrace();
		}
		}
		//end main
}//end FirstExample
