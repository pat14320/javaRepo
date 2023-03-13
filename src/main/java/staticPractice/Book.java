package staticPractice;

public class Book {
	// Class variable/static field
	private static String publisher = "Addison-Weasley";
	// Instance variable, non-static field
	private String title = "The Mythical Man-Month";
	
	// Static methods access static fields (however, can make this non-static as well)
	public static String getPublisher() {
		return publisher;
	}
	
	// Have to use non-static method to access it since static method cannot access non-static fields
	// Has to be non-static
	public String getTitle() {
		return this.title;
	}

}
