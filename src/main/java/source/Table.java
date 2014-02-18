package source;

import java.util.ArrayList;
import java.util.List;

public class Table extends Box{
		
	private List<PlayerBox> playerBoxes = new ArrayList<PlayerBox>();
	private Deck deck = new Deck();
	private List<Card> cardList = deck.getDeck();
	
	public void deal(int boxCount)
	{	
		for (int j=0; j<boxCount; j++)
			playerBoxes.add(new PlayerBox());
		for (int i=0; i<5; i++)
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
	}
	
	public List<PlayerBox> getBoxes() {
		return this.playerBoxes;
	}
}
