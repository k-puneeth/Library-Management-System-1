import java.lang.*;

public class shelf{
	
	int shelf_ID;
	int snumber;
	int book_ID;

	public shelf(){ 
	}

	public shelf (int s, int sn,int b){
		shelf_ID=s;
		snumber=sn;
		book_ID=b;
	}

	public int getshelfID() { 
		return shelf_ID; 
	}

	public void setshelf(int sn){ 
		snumber=sn ;
	}

	public int getshelfN() {
	 	return snumber;
	}

	public void print(){
		 System.out.println("shelf ID=" + shelf_ID); 
		 System.out.println("shelf number=" + snumber);
		 System.out.println("book ID=" + book_ID);
	}
};

