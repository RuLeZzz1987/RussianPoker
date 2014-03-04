package source;

import java.util.ArrayList;
import java.util.Collections;

public class Hand {
	
	private ArrayList<Card> hand = new ArrayList<Card>();
	
	public void add(Card card) {
		hand.add(card);
	}
	
	public ArrayList<Card> getHand() {
		return hand;
	}
	
	public void sort() {
		Collections.sort(hand);
	}
	
	protected Boolean isFlushOnFiveCards(){
		for (int i=1; i<5; i++) {
			if ( hand.get(0).getSuit() != hand.get(i).getSuit() ) {
				return false;
			}
		}
		return true;
	}
	
	public Combination getCombinationOnFiveCards() {
		if ( hand.size() != 5 ) {
			throw new IllegalStateException("Cards count in hand != 5");
		}
		int pairPosition = 0;
		int consilience = 0;
		int firstPairPosition = 0;
		int consilience1 = 0;
		int flagFirstPairFound = 0;
		for (int i=1; i<5; i++) {
			if ( hand.get(pairPosition).getScore() == hand.get(i).getScore() ) {
				if ( flagFirstPairFound <= 1) {
					consilience++;
				}
			} else {
				if ( consilience == 0 ) {
					pairPosition = i;
				} else {
					if ( flagFirstPairFound == 0 ) {
						firstPairPosition = pairPosition;
						pairPosition = i;
						consilience1 = consilience;
						consilience = 0;
						flagFirstPairFound = 1;
					}
				}
			}
		}
		if ( consilience == 0 && consilience1 != 0) {
			consilience = consilience1;
			consilience1 = 0;
			pairPosition = firstPairPosition;
			firstPairPosition = 0;
		}
		switch ( consilience ) {
			case 0: {
				if ( !isFlushOnFiveCards() ) {
					if ( hand.get(1).getScore() == 13 && hand.get(0).getScore() - hand.get(4).getScore() != 4 ) {
						return new Combination("1" + " " + hand.get(2).getScore() + " " + hand.get(3).getScore() + " " + hand.get(4).getScore());
					}
					if ( hand.get(0).getScore() - hand.get(4).getScore() == 4 ) {
						return new Combination("5" + " " + hand.get(0).getScore());
					}
					if ( hand.get(0).getScore() - hand.get(1).getScore() == 9 ) {
						return new Combination("5" + " " + hand.get(1).getScore());
					}
					return new Combination("0");
				} else {
					if ( hand.get(0).getScore() - hand.get(4).getScore() != 4 && hand.get(0).getScore() - hand.get(1).getScore() != 9 ) {
						return new Combination("6" + " " + hand.get(0).getScore() + " " + hand.get(1).getScore() + " " + hand.get(2).getScore() + " " + hand.get(3).getScore() + " " + hand.get(4).getScore());
					}
					if ( hand.get(0).getScore() - hand.get(4).getScore() == 4 && hand.get(0).getScore() != 14) {
						return new Combination("9" + " " + hand.get(0).getScore());
					}
					if ( hand.get(0).getScore() - hand.get(1).getScore() == 9 ) {
						return new Combination("9" + " " + hand.get(1).getScore());
					}
					if ( hand.get(1).getScore() == 13 && hand.get(0).getScore() - hand.get(4).getScore() == 4) {
						return new Combination("10");
					}					
				}
			}
			case 1: { 
				if ( consilience1 == 0 ) {
					String result = "2" + " " + hand.get(pairPosition).getScore() + " " + hand.get(pairPosition).getScore();
					for (int i=0; i<5; i++) {
						if ( hand.get(pairPosition).getScore() != hand.get(i).getScore() ) {
							result = result + " " + hand.get(i).getScore();
						}
					}
					return new Combination(result);
				}
				if ( consilience1 == 1 ) {
					String result = "3" + " " + hand.get(firstPairPosition).getScore() + " " + hand.get(firstPairPosition).getScore() + " " + hand.get(pairPosition).getScore() + " " + hand.get(pairPosition).getScore();
					for (int i=0; i<5; i++) {
						if ( hand.get(pairPosition).getScore() != hand.get(i).getScore() && hand.get(firstPairPosition).getScore() != hand.get(i).getScore() ) {
							result = result + " " + hand.get(i).getScore();
						}
					}
					return new Combination(result);
				}
				if ( consilience1 == 2 ) {
					return new Combination("7" + " " + hand.get(firstPairPosition).getScore() + " " + hand.get(pairPosition).getScore()) ;
				}
			}
			case 2: {
				if ( consilience1 == 0 ) {
					String result = "4" + " " + hand.get(pairPosition).getScore() + " " + hand.get(pairPosition).getScore() + " " + hand.get(pairPosition).getScore();
					for (int i=0; i<5; i++) {
						if ( hand.get(pairPosition).getScore() != hand.get(i).getScore() ) {
							result = result + " " + hand.get(i).getScore();
						}
					}
					return new Combination(result);
				} else {
					return new Combination("7" + " " + hand.get(pairPosition).getScore() + " " + hand.get(firstPairPosition).getScore() );
				}
			}
			case 3: {
				String result = "8" + " " + hand.get(pairPosition).getScore();
				for (int i=0; i<5; i++) {
					if ( hand.get(pairPosition).getScore() != hand.get(i).getScore() ) {
						result = result + " " + hand.get(i).getScore();
					}
				}
				return new Combination(result);
			}
			default : {
				 throw new IllegalStateException("Unknown combination");
			}
		}
	}
	
	@Override
	public String toString() {
		return hand.toString();
	}
}
