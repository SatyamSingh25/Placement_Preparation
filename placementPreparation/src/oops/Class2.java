package oops;

public class Class2 {
	//Constructor
	public Class2(int a) {
		System.out.println(a);
	}

	public static void main(String[] args) {
		Class1 x = new Class1();
		int y = x.current;
		System.out.println(y);
		System.out.println(x.getCone());
	}

}
