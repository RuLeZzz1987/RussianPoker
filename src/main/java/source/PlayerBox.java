package source;

import java.util.ArrayList;

public class PlayerBox extends Box{
	
	private int bet;
	private GameMath handMath = new GameMath();
	private ArrayList<Hand> handList = new ArrayList<Hand>();
	
	public PlayerBox(Hand hand, int bet) {
		this.handList.add(hand);
		this.bet = bet;
	}
	
	public PlayerBox() {
		// TODO Auto-generated constructor stub
	}

	public PlayerBox(int bet) {
		this.bet = bet;
	}
	
	public int getBet() {
		return bet;
	}
	
	 

	public GameMath getMath(){
		return handMath;
	}
	
}
