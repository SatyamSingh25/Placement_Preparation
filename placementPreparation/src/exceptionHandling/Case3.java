package exceptionHandling;
/**
 * @Contributor Satyam Singh
 * @Exception_Handling
 * @Case_3
 */
public class Case3 {
	//give compile time error if it doesn't throws a Exception in method name
	public static void main(String[] args) throws Exception {
		throw new Exception();
	}
	
	//compile fine but give runtime error
	public static void main2(String[] arg) {
		throw new Error();
	}

}
