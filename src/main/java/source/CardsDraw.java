package source;

import java.util.ArrayList;

public class CardsDraw {
	
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
}
