package oops;
//final method can not override but it can be inherited
abstract class Base{
	final void fun() {
		System.out.println("Abstract class  with final method");
	}
}
class Derived extends Base {
}
public class MyAbstract4 {

	public static void main(String[] args) {
		Derived obj = new Derived();
		obj.fun();
	}

}
