package abstractClasses;

public class AbstractClasses {

	public static void main(String[] args) {
		Cat cat = new Cat();
		
		cat.makeNoise();
		cat.poop();
		System.out.println("Cat age is: " + cat.getAge());
		System.out.println("Cat name is: " + cat.getName());
		System.out.println();
		
		cat.setAge(100);
		cat.setName("Buster");
		System.out.println("Cat age is: " + cat.getAge());
		System.out.println("Cat name is: " + cat.getName());
		System.out.println();
		
		Elephant elephant = new Elephant();
		
		elephant.makeNoise();
		elephant.poop();
		
		elephant.setAge(700);
		elephant.setName("Dumbo");
		System.out.println("Elephant age is: " + elephant.getAge());
		System.out.println("Elephant name is: " + elephant.getName());
	}

}
