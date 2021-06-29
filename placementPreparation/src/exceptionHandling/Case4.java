package exceptionHandling;
/**
 * @Contributor Satyam Singh
 * @Exception_Handling
 * @Case_4
 */
//Note : Compiler only check checked Exceptions
public class Case4 {
	
	public void m1() {
		try {
			System.out.println("Hello");
		}
		catch(ArithmeticException e) {
			// ArithmeticException in checked exception that's why it will not give any error.
		}
	}
	
	public void m2() {
		try {
			System.out.println("Hello");
		}
		catch(Exception e) {
			// Exception in checked exception that's why it will not give any error.
		}
	}
	
	public void m3() {
		try {
			System.out.println("Hello");
		}
		catch(IOException e) {
			// Exception in unchecked exception that's why it will give error. 
			//compiler wants to remove the catch clause
		}
	}
	
	public void m4() {
		try {
			System.out.println("Hello");
		}
		catch(InterruptedException e) {
			// InterruptedException in unchecked exception that's why it will give error. 
			// compiler wants to remove the catch clause
		}
	}
	
	public void m5() {
		try {
			System.out.println("Hello");
		}
		catch(Error e) {
			// Error in checked exception that's why it will not give any error.
		}
	}
}
