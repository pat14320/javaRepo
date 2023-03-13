package practicepackage;

class Employee {
	int employeeId;
	int salary;
	// Everyone has the same CEO
	static String CEO;
	
	// Static block (will execute only once)
	// Use static block to initialize static variables
	// Happens when you load a class (class loads only once)
	static {
		CEO = "Larry";
	}
	
	// Use constructor to initialize non-static variables
	// Called every time an object is created
	public Employee() {
		// Default values
		employeeId = 1;
		salary = 3000;
		CEO = "Larry";
	}
	
	public void show() {
		System.out.println(this.employeeId + " : " + this.salary + " : " + this.CEO);
	}
}

public class StaticDemo {

	int i = 0;
	public static void main(String[] args) {
		// Need to actually create instances of objects here because accessing non static member variables
//		Employee navin = new Employee();
//		navin.employeeId = 8;
//		navin.salary = 4000;
//		
//		Employee rahul = new Employee();
//		rahul.employeeId = 9;
//		rahul.salary = 5000;
	
		// Here, you don't need to create an instance of the object
//		Employee.CEO = "Jeff Bezos";
//		
//		navin.show();
//		rahul.show();
		
		// Below code is not allowed because can't access non-static variable inside a static method
		// i = 9;
		
		Employee navin = new Employee();
		Employee rahul = new Employee();
		
		navin.show();
		rahul.show();

	}

}
