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
			throw new RuntimeException("Cards count in hand != 5");
		}
		int combPos = 0;
		int consil = 0;
		int combPos1 = 0;
		int consil1 = 0;
		Boolean fl = true;
		for (int i=1; i<5; i++) {
			if ( hand.get(combPos).getScore() == hand.get(i).getScore() ) {
				if ( fl ) { 
					consil++;
				} else {
					combPos1 = combPos;
					consil1 = consil;
					consil = 0;
					combPos = i;
				}				
			} else { 
				if ( consil == 0 ) {
					combPos = i;
				} else {
					fl = false;
				}
			}
		}
		switch ( consil ) {
			case 0: {
				if ( !isFlushOnFiveCards() ) {
					if ( hand.get(1).getScore() == 13 && hand.get(0).getScore() - hand.get(4).getScore() != 4 ) {
						return new Combination("1"+hand.get(2).getScore() + hand.get(3).getScore() + hand.get(4).getScore());
					}
					if ( hand.get(0).getScore() - hand.get(4).getScore() == 4 ) {
						return new Combination("5" + hand.get(0).getScore());
					}
					if ( hand.get(0).getScore() - hand.get(1).getScore() == 9 ) {
						return new Combination("5" + hand.get(1).getScore());
					}
					return new Combination("0");
				} else {
					if ( hand.get(0).getScore() - hand.get(4).getScore() != 4 || hand.get(0).getScore() - hand.get(1).getScore() != 9 ) {
						return new Combination("6" + hand.get(0).getScore() + hand.get(1).getScore() + hand.get(2).getScore() + hand.get(3).getScore() + hand.get(4).getScore());
					}
					if ( hand.get(0).getScore() - hand.get(4).getScore() == 4 ) {
						return new Combination("9" + hand.get(0).getScore());
					}
					if ( hand.get(0).getScore() - hand.get(1).getScore() == 9 ) {
						return new Combination("9" + hand.get(1).getScore());
					}
					if ( hand.get(1).getScore() == 13 && hand.get(0).getScore() - hand.get(4).getScore() == 4) {
						return new Combination("10");
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
					return new Combination(result);
				}
				if ( consil1 == 1 ) {
					String result = "3" + hand.get(combPos1).getScore() + hand.get(combPos).getScore();
					for (int i=0; i<5; i++) {
						if ( hand.get(combPos).getScore() != hand.get(i).getScore() || hand.get(combPos1).getScore() != hand.get(i).getScore() ) {
							result = result + hand.get(i).getScore();
						}
					}
					return new Combination(result);
				}
				if ( consil1 == 2 ) {
					return new Combination("7" + hand.get(combPos1).getScore() + hand.get(combPos).getScore());
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
					return new Combination(result);
				} else {
					return new Combination("7" + hand.get(combPos1).getScore() + hand.get(combPos).getScore());
				}
			}
			case 3: {
				String result = "8" + hand.get(combPos).getScore();
				for (int i=0; i<5; i++) {
					if ( hand.get(combPos).getScore() != hand.get(i).getScore() ) {
						result = result + hand.get(i).getScore();
					}
				}
				return new Combination(result);
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
