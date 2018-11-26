import java.lang.*;
import java.util.List;

public interface borrowable_booksDAO{
	
	public borrowable_books getbookByKey(int id);
	public borrowable_books getbookByName(String name);
	public borrowable_books getbookByAuthor(String author);
	public void addbook(borrowable_books b,shelf s);
	public void removebook(borrowable_books b);	
	
	
}

