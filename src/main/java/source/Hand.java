package source;

import java.util.ArrayList;
import java.util.Collections;

public class Hand {
	
	private ArrayList<Card> hand = new ArrayList<Card>();
	
	public void add(Card card) {
		hand.add(card);
	}
	
	public void sort() {
		Collections.sort(hand);
	}
	
	protected Boolean flushCheckOnFiveCards(){
		for (int i=1; i<5; i++) {
			if ( hand.get(0).getSuit() != hand.get(i).getSuit() ) {
				return false;
			}
		}
		return true;
	}
	
	public String getCombinationOnFiveCards() {
		int combPos = 0;
		int consil = 0;
		int combPos1 = 0;
		int consil1 = 0;
		for (int i=1; i<5; i++) {
			if ( hand.get(combPos) == hand.get(i) ) {
				consil++;
			} else { 
				if ( consil == 0 ) {
					combPos = i;
				} else {
					combPos1 = combPos;
					consil1 = consil;
					consil = 0;
					combPos = i;
				}
			}
		}
		switch ( consil ) {
			case 0: {
				if ( !flushCheckOnFiveCards() ) {
					if ( hand.get(1).getScore() == 13 && hand.get(0).getScore() - hand.get(4).getScore() != 4 ) {
						return "1"+hand.get(2).getScore() + hand.get(3).getScore() + hand.get(4).getScore();
					}
					if ( hand.get(0).getScore() - hand.get(4).getScore() == 4 ) {
						return "5" + hand.get(0).getScore();
					}
					if ( hand.get(0).getScore() - hand.get(1).getScore() == 9 ) {
						return "5" + hand.get(1).getScore();
					}
				} else {
					if ( hand.get(0).getScore() - hand.get(4).getScore() != 4 || hand.get(0).getScore() - hand.get(1).getScore() != 9 ) {
						return "6" + hand.get(0).getScore() + hand.get(1).getScore() + hand.get(2).getScore() + hand.get(3).getScore() + hand.get(4).getScore();
					}
					if ( hand.get(0).getScore() - hand.get(4).getScore() == 4 ) {
						return "9" + hand.get(0).getScore();
					}
					if ( hand.get(0).getScore() - hand.get(1).getScore() == 9 ) {
						return "9" + hand.get(1).getScore();
					}
					if ( hand.get(1).getScore() == 13 && hand.get(0).getScore() - hand.get(4).getScore() == 4) {
						return "10";
					}
				}
			}
			case 1: { 
				if ( consil1 == 0 ) {
					String result = "2" + hand.get(combPos).getScore();
					for (int i=0; i<5; i++) {
						if ( hand.get(combPos).getScore() != hand.get(i).getScore() ) {
							result = result + hand.get(i).getScore();
						}
					}
					return result;
				}
				if ( consil1 == 1 ) {
					String result = "3" + hand.get(combPos1).getScore() + hand.get(combPos).getScore();
					for (int i=0; i<5; i++) {
						if ( hand.get(combPos).getScore() != hand.get(i).getScore() || hand.get(combPos1).getScore() != hand.get(i).getScore() ) {
							result = result + hand.get(i).getScore();
						}
					}
					return result;
				}
				if ( consil1 == 2 ) {
					return "7" + hand.get(combPos1).getScore() + hand.get(combPos).getScore();
				}
			}
			case 2: {
				if ( consil1 == 0 ) {
					String result = "4" + hand.get(combPos).getScore();
					for (int i=0; i<5; i++) {
						if ( hand.get(combPos).getScore() != hand.get(i).getScore() ) {
							result = result + hand.get(i).getScore();
						}
					}
					return result;
				} else {
					return "7" + hand.get(combPos1).getScore() + hand.get(combPos).getScore();
				}
			}
			case 3: {
				String result = "8" + hand.get(combPos).getScore();
				for (int i=0; i<5; i++) {
					if ( hand.get(combPos).getScore() != hand.get(i).getScore() ) {
						result = result + hand.get(i).getScore();
					}
				}
				return result;
			}
			default : {
				return null;
			}
		}
	}
	
	@Override
	public String toString() {
		return hand.toString();
	}
}
