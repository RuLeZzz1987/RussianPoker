package source;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Table extends Box{
		
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
			case FiveCard : {
				k = 5;
				break;
			}
			case Omaha : {
				k = 4;
				break;
			}
			case Texas : {
				k = 2;
				break;
			}
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
