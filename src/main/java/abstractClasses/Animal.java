package abstractClasses;

// Doesn't make sense for the class to be non-abstract since never would want
// to create an instance of it
public abstract class Animal {
	
	// So now subclasses can share these fields
	// But each animal will set these values specific to themselves
	private int age;
	private String name;
	
	// Wouldn't make sense to implement makeNoise here since every animal will make a different noise
	public abstract void makeNoise();
	
	// Creating concrete/shared method
	public void printName() {
		System.out.println("My name is " + name);
	}
	
	public int getAge() {
		return age;
	}
	
	public String getName() {
		return name;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public void setName(String name) {
		this.name = name;
	}
}
