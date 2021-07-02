package oops;
//its mandatory to override all method in SubClass.
//all method under interface by default public + abstract if youn do not this in declaring the method.
interface motorCycle{
	void run();
	int run1();
	//final method is not valid in interface.
	//final run2();
}
public class Interface implements motorCycle{
	@Override
	public void run() {
		System.out.println("run()");
	}

	@Override
	public int run1() {
		System.out.println("run1()");
		return 0;
	}

	public void main(String[] args) {
		// TODO Auto-generated method stub
		run();
		run1();
	}
}
