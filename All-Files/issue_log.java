import java.lang.*;
import java.sql.*;
public class issue_log{
    int issue_id;
    int book_id;
    int student_ID;
    Date date_issued;
    Date expected_return;
    Date return_date;
	public issue_log() { }
	public issue_log (int a,int b,int c,Date d,Date e,Date f){ issue_id=a; book_id=b; student_ID=c; date_issued=d; expected_return=e; return_date=f; }
    
    public int getissue_id() { return issue_id; }
    public void setissue_id(int s){ issue_id=s; }
    
	public int getbook_id() { return book_id; }
    public void setbook_id(int s){ book_id = s; }

    public int getstudent_ID() { return student_ID; }
    public void setstudent_ID(int s){ student_ID = s; }
    
    public Date getdate_issued() { return date_issued; }
    public void setdate_issued(Date s){ date_issued = s; }
    
    public Date getexpected_return() { return expected_return; }
    public void setexpected_return(Date s){ expected_return = s; }
    
    public Date getreturn_date() { return return_date; }
    public void setreturn_date(Date s){ return_date = s; }
    
    
    public void print()
    { 
        System.out.println("issue_id=" + issue_id); 
        System.out.println("book_id=" + book_id);
        System.out.println("student_ID=" + student_ID); 
        System.out.println("date_issued=" + date_issued); 
        System.out.println("expected_return=" + expected_return); 
        System.out.println("return_date=" + return_date); 
    }
};

