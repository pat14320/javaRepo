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
	
	static class Card {
		SUIT suit;
		int rank;
		
		public Card(SUIT suit, int rank) {
			this.suit = suit;
			this.rank = rank;
		}
	}
	
	public static final int TARGET = 15;
	
	public static int fifthteen(Card[] cards) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		findCombinations(cards, 0, TARGET, new ArrayList<Integer>(), result);
		for (List<Integer> combination : result) {
			System.out.println(combination.toString());
		}
		return result.size();
	}
	
	public static void findCombinations(Card[] cards, int index, int target, List<Integer> current, List<List<Integer>> result) {
		
		// Found an answer here
		if (target == 0) {
			result.add(new ArrayList<Integer>(current));
			return;
		}
		
		// All future numbers will only increase the total sum, return
		if (target < 0) {
			return;
		}
		
		for (int i = index; i < cards.length; i++) {
			// count the current card
			current.add(cards[i].rank);
			
			// Now iterate on the rest of the cards
			findCombinations(cards, index + 1, target - cards[i].rank, current, result);
			
			// Finished recursive call, and remove current card from this path
			current.remove(current.size() - 1);
		}
	}
	
	public static void main(String[] args) {
		Card c1 = new Card(SUIT.HEARTS, 5);
		Card c2 = new Card(SUIT.HEARTS, -10101);
		Card c3 = new Card(SUIT.HEARTS, -11001);
		Card c4 = new Card(SUIT.HEARTS, 5);
		Card c5 = new Card(SUIT.HEARTS, 5);
		
		Card[] cards = new Card[5];
		cards[0] = c1;
		cards[1] = c2;
		cards[2] = c3;
		cards[3] = c4;
		cards[4] = c5;
		
		System.out.println(fifthteen(cards));
	}

}
