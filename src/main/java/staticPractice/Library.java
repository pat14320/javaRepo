package staticPractice;

public class Library {

	public static void main(String[] args) {
		// Create an instance of Book class
		Book mythicalManMonth = new Book();
		
		// Legal to call the method directly from the name of the class itself.
		// Very similar to accessing the variable as well
		Book.getPublisher();
		
		// Also legal to call the static method from the instance. Don't have to do it
		// from the class itself. But see the warning
		mythicalManMonth.getPublisher();
		
		// Illegal to call non-static method from name of class itself
		// Book.getTitle();
		
		// Is legal to call the non-static method from the instance of the class
		mythicalManMonth.getTitle();
		
		// NOT LEGAL to call a non-static method from a static method. Have seen this before
		// sayHelloWorld();
		
		// But look here, we can call this non-static method from an instance of the class
		Library alexandria = new Library();
		alexandria.sayHelloWorld();
	}
	
	public void sayHelloWorld() {
		System.out.println("Hello World");
	}

}
