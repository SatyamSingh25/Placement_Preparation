package oops;
class Writer{
	public static void write() {
		System.out.println("write write");
	}
}
class Author extends Writer{
	public static void write() {
		System.out.println("write author");
	}
}

public class StaticOverride extends Author {
	public static void write() {
		System.out.println("write StaticOverride");
	}
	public static void main(String[] args) {
		Author a = new StaticOverride();
		a.write();
	}

}
