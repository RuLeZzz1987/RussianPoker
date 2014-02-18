package source;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Box {
	
	private List<Card> hand = new ArrayList<Card>();
	private int power;
	private int combinationHash;
	
	public List<Card> getHand() {
		return hand;
	}
	
	public void sort() {
		Collections.sort(hand);
	}
	
	public int getHandPower() {
		Collections.sort(hand);
		return 0;
	}
	
	public void setHand(Card card) {
		this.hand.add(card);
	}
	
	@Override
	public String toString() {
		return hand.toString();
	}
}
