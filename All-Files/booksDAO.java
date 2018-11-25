import java.lang.*;
import java.util.List;

public interface booksDAO{
	
	public books getbookByKey(int id);
	public void addbook(books b,shelf s);
	public void removebook(books b);	
	
}

