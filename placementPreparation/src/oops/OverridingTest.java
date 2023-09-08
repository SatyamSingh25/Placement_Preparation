package oops;

class Parent{
	public void test() {
		System.out.println("parent");
	}
}

public class OverridingTest extends Parent{
	
//	@Override
//	public void test(){
//		System.out.println("child");
//	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Parent obj = new OverridingTest();
		obj.test();
		
		OverridingTest obj2 = new OverridingTest();
		obj2.test();
	}

}
