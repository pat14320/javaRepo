package squarePractice;

import java.util.Arrays;
import java.util.Comparator;

enum Orientation {
	LEFT,
	RIGHT
}

class Sock {
	String color;
	Orientation orientation;
	
	public Sock(String color, Orientation orientation) {
		this.color = color;
		this.orientation = orientation;
	}
	
	public String toString() {
		return this.color + " " + this.orientation;
	}
}

public class SockProblem {
	
	public static void sortSocks(Sock[] socks) {
		// input validation
		if (socks == null || socks.length == 0) {
			return;
		}
		
		Arrays.sort(socks, new Comparator<Sock>() {
			@Override
			public int compare(Sock s1, Sock s2) {
				// First priority order is lexicographically
				int nameCompare = s1.color.compareTo(s2.color);
				if (nameCompare != 0) {
					return nameCompare;
				}
				
				// Second priority order is by orientation. Defining right sock to be higher ranking than
				// left sock
				if (s1.orientation == s2.orientation) {
					return 0;
				}
				
				if (s1.orientation == Orientation.RIGHT) {
					return 1; // Sock one is "greater" in orientation because it's a right sock
				}
				
				return -1; // Sock two is "greater" in orientation because it's a right sock
				
			}
		});
	}

	public static void main(String[] args) {
		Sock s1= new Sock("red", Orientation.LEFT);
		Sock s2 = new Sock("blue", Orientation.RIGHT);
		Sock s3 = new Sock("red", Orientation.LEFT);
		
		Sock[] socks = {s1, s2, s3};
		sortSocks(socks);
		System.out.println(Arrays.toString(socks));

	}

}
