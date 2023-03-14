package innerClasses;

public class AnonymousInnerClasses {

	public static void main(String[] args) {
		Animal myAnimal = new Animal();
		myAnimal.makeNoise();
		
		// Creating an anonymous subclass of the animal class
		// Overriding the make noise method
		Animal bigfoot = new Animal() {
			// Creating a subclass of an Animal. Doesn't even have a name
			// One time use- do the same thing when Comparator is overridden for when we
			// create a PriorityQueue
			@Override
			public void makeNoise() {
				System.out.println("Bigfoot sounds!!");
			}
		};
		bigfoot.makeNoise();
		
		// Here is an example with an interface
		Runnable myAnomymousRunnable = new Runnable() {
			public void run() {
				System.out.println("I'm an anonymous runnable");
			}
		};
		
		myAnomymousRunnable.run();
	}

}
