package innerClasses;

public class OuterClass {
	int number = 6;
	
	public void heyThere() {
		System.out.println("Hey there!");
		
		// Method inner class. Only accessible in the method in which it's declared
		class LocalInnerClass {
			String localInnerClassVariable = "Here's Johnny";
			
			public void printLocalInnerClassVariable() {
				System.out.println(localInnerClassVariable);
			}
		}
		
		LocalInnerClass lic = new LocalInnerClass();
		lic.printLocalInnerClassVariable();
	}
	
	// InnerClass is now a member of OuterClass
	public class InnerClass {
		// member variables
		int innerNumber = 8;
		
		public void whatsUp() {
			System.out.println("Hey, what's up from the inner class!");
		}
	}
}
