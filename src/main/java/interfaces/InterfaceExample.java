package interfaces;

interface WaterBottleInterface {
	String color = "Blue";
	
	void fillUp();
	void pourOut();
}

public class InterfaceExample implements WaterBottleInterface {

	public static void main(String[] args) {
		System.out.println(color);
		// Cannot change value of color since it is final
		// color = "Red";
		
		InterfaceExample ex = new InterfaceExample();
		ex.fillUp();
	}

	@Override
	public void fillUp() {
		System.out.println("It is filled");
	}

	@Override
	public void pourOut() {
		// TODO Auto-generated method stub
		
	}

}
