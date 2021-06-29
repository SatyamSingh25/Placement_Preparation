package exceptionHandling;

public class MultipleCatchBlock {

	public static void main(String[] args) {
		try {
			//risky code
		}
		catch(Exception e) {
			//all exceptions are catched here
		}
		catch(ArithmeticException e) {
			//never gonna use
		}
	}

}
