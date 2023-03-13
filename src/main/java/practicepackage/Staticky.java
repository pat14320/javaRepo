package practicepackage;

public class Staticky {
	static int a = 3;
	// Here is a common use case of having shared variables
	static int months = 12;

	public static void main(String[] args) {
		int b = 4;
		
		// This is the previous way to access this "global" variable
		Staticky s = new Staticky();
		System.out.println(s.a);
		
		// The work around is simply to put static beforehand
		System.out.println(a + b);
	}

}
