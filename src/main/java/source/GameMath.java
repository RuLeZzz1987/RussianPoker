package source;

import java.util.ArrayList;

public class GameMath{
	

	private ArrayList<CardsDraw> possibleChanges;
	
	public void addPossibleChanges(Hand hand, ArrayList<Card> knownCards, Card... cards) {
			possibleChanges.add(new CardsDraw(hand, knownCards, cards));
		
	}
	



	
}
