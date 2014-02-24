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
	
	public String getCombination() {
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
				if ( hand.get(1).getScore() == 11 && hand.get(0).getScore() - hand.get(4).getScore() != 9 ) {
					return "1"+hand.get(2).getScore() + hand.get(3).getScore() + hand.get(4).getScore();
				} else return "0";
			}
			case 1: { 
				if (consil1 == 0) {
					return "2" + hand.get(combPos).getScore();
				}
				
			
			}
		}
		return null;
	}
}
