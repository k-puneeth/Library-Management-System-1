import java.lang.*;

public class reference_books{

	int CR_ID;
	String CRname;

	public reference_books(){ 
	}

	public reference_books (int s, String sn){
		CR_ID=s;
		CRname=sn;
	}

	public int getCR_ID() { 
		return CR_ID; 
	}

	public String getName() {
	 	return CRname;
	}

	public void print(){
		 System.out.println("reference_books ID=" + CR_ID); 
		 System.out.println("reference_books name=" + CRname);
	}
};

