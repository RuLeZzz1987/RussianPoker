package source;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Table extends Box{
	
	private int bankroll = 1000;
	private List<PlayerBox> playerBoxes = new ArrayList<PlayerBox>();
	private Deck deck = new Deck();
	private List<Card> cardList = deck.getDeck();
	private GameType gameType;
	private GameStatus gameStatus;
	
	public Table(GameType gameType) {
		this.gameType = gameType;
		gameStatus = GameStatus.BETS;
	}

	public void deal() throws IOException {
		if (gameStatus != GameStatus.DEAL) {
			throw new IOException("No money, no Cards!");
		} else {
			deal(playerBoxes.size());
		}
	}
	
	public void deal(int boxCount)
	{	
		if (playerBoxes.size() != 0) {
			boxCount = playerBoxes.size();
		}
		int k = 5;
		switch (gameType) {
			case FIVECARD : {
				k = 5;
				break;
			}
			case OMAHA : {
				k = 4;
				break;
			}
			case TEXAS : {
				k = 2;
				break;
			}
			default :
				throw new IllegalStateException("Unknown game type");
		}
		for (int i=0; i<k; i++)
		{	
			for (PlayerBox b: playerBoxes) 
			{	
				b.setHand(cardList.get(0));
				deck.setUsed(cardList.get(0));
				cardList.remove(0);
			}
			setHand(cardList.get(0));
			deck.setUsed(cardList.get(0));
			cardList.remove(0);
		}
		gameStatus = GameStatus.DRAWS;
	}
	
	public List<PlayerBox> getBoxes() {
		return this.playerBoxes;
	}
	
	public PlayerBox getBox(int i) {
		return this.playerBoxes.get(i);
	}
	
	public void calculateDealResult() {
		if ( getHand().getCombinationOnFiveCards().getHighness() != 0 && gameStatus == GameStatus.DETERMINATION) {
			for (int i=0; i < playerBoxes.size(); i++ ) {
				if ( playerBoxes.get(i).getStatus().equals(BoxStatus.BET) )	
					switch ( playerBoxes.get(i).getHand().getCombinationOnFiveCards().compareTo(getHand().getCombinationOnFiveCards()) ) {
						case 1 : {
							
							break;
						}
						case 0 : {
							
							break;
						}
						case -1: {
							
							break;
						}
					}
				}
		}	else {
			gameStatus = GameStatus.ANTE;
		}
	}
	
	public void makeBets(int... bets) {		
		for(int i=0; i<bets.length; i++) {
			playerBoxes.add(new PlayerBox(bets[i]));
		}
		gameStatus = GameStatus.DEAL;
	}
	
	@Override 
	public String toString() {
		String result = "";
		for(int i=0; i<playerBoxes.size(); i++) {
			result = result + " " + playerBoxes.get(i).toString();
		}
		return result + " | " + getHand().toString();
	}
}
