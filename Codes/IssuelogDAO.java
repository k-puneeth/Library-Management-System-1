import java.lang.*;
import java.util.List;
import java.util.Date;

public interface IssuelogDAO 
{
	public void addLog(Student s,Books b,int count);
	public void updateLog(Issuelog ilog);
	public void updateNewEntryLog(Issuelog ilog,int count);
	public Issuelog findLog(Student sd, Books bk);
}