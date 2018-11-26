import java.lang.*;

public class borrowable_books extends books{

	int bbook_ID;
	boolean status;

	public borrowable_books(){ 
	}

	public borrowable_books (int s, String sn, String a,int e, int si,boolean b){
		super(s,sn,a,e,si);
		bbook_ID=super.ISBN;
		status=b;
	}

	public int getbbook_ID() { 
		return bbook_ID; 
	}

	public void setbbook_ID(int b) { 
		bbook_ID=b; 
	}


	public boolean getstatus() {
	 	return status;
	}

	public void setstatus(boolean b) {
	 	status=b;
	}

	public void print(){
		 System.out.println("borrowable_books ID= " + bbook_ID); 
		 System.out.println("borrowable_books status= " + status);
		 System.out.println("books ID=" + super.ISBN); 
		 System.out.println("books name=" + super.bookname);
		 System.out.println("books author=" + super.author);
		 System.out.println("books edition=" + super.edition_b);
		 System.out.println("books shelf_ID=" + super.shelf_ID);
	}
};

