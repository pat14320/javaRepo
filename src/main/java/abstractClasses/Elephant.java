package abstractClasses;

public class Elephant extends Animal implements AnimalStuff {

	@Override
	public void poop() {
		System.out.println("Elephant is pooping");
	}

	@Override
	public void makeNoise() {
		System.out.println("Elephant trumpet sound with nose!!!");
	}

}
