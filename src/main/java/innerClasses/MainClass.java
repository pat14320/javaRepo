package innerClasses;

public class MainClass {

	public static void main(String[] args) {
		OuterClass outer = new OuterClass();
		outer.heyThere();
		
		// Doesn't work like this for non-static inner classes
		// InnerClass inner = new InnerClass();
		
		// Use instance of outer class in order to call constructor or inner class
		OuterClass.InnerClass inner = outer.new InnerClass();
		inner.whatsUp();
	}

}
