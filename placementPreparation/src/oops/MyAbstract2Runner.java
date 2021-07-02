package oops;
//if a class c1 inherited Abstract class C2 and C1 object is created then first C2(Abstract class)
//constructor will call after that C1 contructor will call

public class MyAbstract2Runner extends MyAbstract2{
	
	MyAbstract2Runner(){
		System.out.println("Under runner class");
	}
	
	public static void main(String[] args) {
		MyAbstract2Runner obj = new MyAbstract2Runner();
		System.out.println("under main method");
	}

}
