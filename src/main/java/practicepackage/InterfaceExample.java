package practicepackage;

/**
 * Shape interface is used when you don't want to share any common behavior between the
 * different classes that will implement the shape interface
 * @author patrick.zhang
 *
 */

interface Shape {
	// Abstract methods
	abstract void draw();
	abstract double area();
}

class Rectangle implements Shape {
	int length;
	int width;
	
	Rectangle(int length, int width) {
		this.length = length;
		this.width = width;
	}
	
	public void draw() {
		System.out.println("Drawing a rectangle");
	}
	
	public double area() {
		return (double) this.length * this.width;
	}
}

class Circle implements Shape {
	int radius;
	double pi = 3.14;
	
	Circle(int radius) {
		this.radius = radius;
	}
	
	public void draw() {
		System.out.println("Drawing a circle");
	}
	
	public double area() {
		return (double) (pi * this.radius * this.radius);
	}
}

public class InterfaceExample {
	
	public static void main(String[] args) {
		Rectangle r = new Rectangle(10, 3);
		r.draw();
		System.out.println(r.area());
		
		Circle c = new Circle(10);
		c.draw();
		System.out.println(c.area());
	}
	
}
