package abstractClasses;

public class Cat extends Animal implements AnimalStuff {

	@Override
	public void makeNoise() {
		System.out.println("Meow");
	}

	@Override
	public void poop() {
		System.out.println("Cat is pooping");
	}

}
