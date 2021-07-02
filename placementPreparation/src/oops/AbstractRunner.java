package oops;

public class AbstractRunner {

	public static void main(String[] args) {
		// we cannot create Abstract class object
		MyAbstract ab = new MyAbstract ;   //error
		
		//but we can create Abstract class reference variable
		MyAbstract ab2;   //correct
			
		System.out.println(ab);
	}

}
