package squarePractice;

import java.util.ArrayList;
import java.util.List;

public class GameQuestion {
	enum SUIT {
		DIAMONDS,
		HEARTS,
		SPADES,
		CLUBS
	}
	
	class Card {
		SUIT suit;
		int rank;
		
		public Card(SUIT suit, int rank) {
			this.suit = suit;
			this.rank = rank;
		}
	}
	
	
	public static int fifthteen(Card[] cards) {
		List<Integer> sums = new ArrayList<Integer>();
		
		int currSum = 0;
		int groups = 0;
		
		for (Card card : cards) {
			// This card is less than 15, so can just keep adding to the sum
			if (currSum + card.rank < 15) {
				sums.add(currSum + card.rank);
			}
			
			// This card will make a complete group
			if (currSum + card.rank == 15) {
				groups++;
			}
		}
		
		return groups;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
