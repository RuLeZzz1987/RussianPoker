package source;

import java.util.ArrayList;


public abstract class Box {
	
	private Hand hand = new Hand();
	private int power;
	private int combinationHash;
	private ArrayList<Hand> handList = new ArrayList<Hand>();
	
	public Hand getHand() {
		return hand;
	}
	
	public void sort() {
		hand.sort();
	}
	

	
	public void setHand(Card card) {
		this.hand.add(card);
	}
	
	@Override
	public String toString() {
		return hand.toString();
	}
}
