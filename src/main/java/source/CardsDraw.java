package source;

import java.util.ArrayList;
import java.util.Collections;

public class CardsDraw{
	
	private ArrayList<Card> knownCards;
	private Hand hand;
	private ArrayList<Card> cardsForChange;
	
	public CardsDraw(Hand hand, ArrayList<Card> knownCards, Card... cardsForChange) {
		this.knownCards = knownCards;
		this.hand = hand;
		for (int i=0; i<cardsForChange.length; i++) {
			this.cardsForChange.add(cardsForChange[i]);
		}
	}
	
	public ArrayList<Card> getDrawList(){
		return cardsForChange;
	}
	
	public void sort() {
		Collections.sort(this.cardsForChange);
	}

	public Boolean isSameSet(CardsDraw draw){
		draw.sort();
		sort();
		for (int i=0; i<cardsForChange.size(); i++) {
			if ( draw.getDrawList().get(i) != this.cardsForChange.get(i)) {
				return false;
			}
		}
		return true;
	}
}
