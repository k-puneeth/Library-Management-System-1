import java.lang.*;
import java.util.List;

public interface booksDAO{
	
	public books getbookByKey(int id);
	public books getbookByName(String name);
	public books getbookByAuthor(String author);
	public void addbook(books b,shelf s);
	public void removebook(books b);

}

