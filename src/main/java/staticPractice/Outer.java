package staticPractice;

public class Outer {
	private static int a = 10;
	private int b = 15;
	private static int c = 20;
	
	static class InnerStatic {
		void display() {
			System.out.println("static inner class");
			System.out.println("a is : " + a);
			System.out.println("c is : " + c);
			// Cannot access the variable b from here since it is non-static
			// System.out.println("c is : " + b);
		}
	}
	
	class Inner {
		void display() {
			System.out.println("normal inner class");
			// Can access all variables here since it's just regular inner class
			System.out.println("a is : " + a);
			System.out.println("b is : " + b);
			System.out.println("c is : " + c);
		}
	}

	public static void main(String[] args) {
		Outer.InnerStatic innerStatic = new Outer.InnerStatic();
		innerStatic.display();
		
		// Below code isn't allowed because need enclosing instance if inner class is non-static
		// Outer.Inner obj2 = new Outer.Inner();
		
		// This is how you create a regular inner class
		Outer outer = new Outer();
		Outer.Inner inner = outer.new Inner();
		inner.display();
	}

}
