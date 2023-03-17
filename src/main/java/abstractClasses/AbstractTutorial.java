package abstractClasses;

interface DogInterface {
	// Don't have to put abstract here, will default to abstract
	// Not allowed to put any code inside
	void bark();
	void poop();
}

abstract class Dog {
	String breed;
	
	// This is already implemented, so anything that extends Dog doesn't
	// have to implement it
	public void bark() {
		System.out.println("Bark!");
	}
	
	// Abstract method is where you don't put code inside
	// the curly braces. This function is not implemented!!!
	// The method is abstract, meaning that there's nothing implementing it
	public abstract void poop();
}

class Chihuahua extends Dog {
	public void poop() {
		System.out.println("Dog pooped");
	}
	
	@Override
	public void bark() {
		System.out.println("Override bark method; Chihuahua is barking!");
	}
}

public class AbstractTutorial {

	public static void main(String[] args) {
		// Cannot instantiate an abstract class
		// Dog d = new Dog();
		
		// Chihuahua is an extension of Dog- meaning it has all that it
		// extends and possibly more
		Chihuahua c = new Chihuahua();
		
		c.bark();
		c.poop();
	}

}
