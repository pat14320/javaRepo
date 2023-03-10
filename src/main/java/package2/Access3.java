package package2;

import package1.Access1;

public class Access3 extends Access1 {

	public static void main(String[] args) {
		Access3 a3 = new Access3();
		System.out.println(a3.hours);
		System.out.println(a3.minutes);
		
		System.out.println(a3.getHours());
	}

}
