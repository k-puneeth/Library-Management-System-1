import java.lang.*;

public class borrowable_books{

	int bbook_ID;
	String bbookname;
	boolean status;

	public borrowable_books(){ 
	}

	public borrowable_books (int s, String sn,boolean b){
		bbook_ID=s;
		bbookname=sn;
		status=b;
	}

	public int getbbook_ID() { 
		return bbook_ID; 
	}

	public String getName() {
	 	return bbookname;
	}

	public boolean getstatus() {
	 	return status;
	}

	public void print(){
		 System.out.println("borrowable_books ID=" + bbook_ID); 
		 System.out.println("borrowable_books name=" + bbookname);
		 System.out.println("borrowable_books status=" + status);
	}
};

