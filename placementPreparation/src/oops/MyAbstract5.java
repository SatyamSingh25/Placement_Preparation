package oops;
//abstract method can have static method method
//this static method can be called without creating the object of that class
abstract class Party {
    static void doParty()
    {
        System.out.println("Lets have some fun!!");
    }
}

public class MyAbstract5 {

	public static void main(String[] args) {
		Party.doParty(); //without creating the object of that class we calling function doParty()
	}

}
