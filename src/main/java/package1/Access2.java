package package1;

import package2.Access3;

public class Access2 {

	public static void main(String[] args) {
		Access1 a1 = new Access1();
		System.out.println(a1.hours);
		System.out.println(a1.minutes);
		
		Access3 a3 = new Access3();
		System.out.println(a3.hours);
		System.out.println(a3.minutes);
		
		System.out.println(a1.getHours());
	}

}
