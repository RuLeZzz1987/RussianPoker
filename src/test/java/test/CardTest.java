package test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import source.Card;
import source.Deck;
import source.PlayerBox;
import source.Table;

public class CardTest {

	@Test
	public void ShowDeck() {
		List<Card> deck = new Deck().getDeck();
		for(Card i : deck)
		{
			System.out.print(i.toString()+" ");
		}
	}
	
	@Test
	public void ShowDeal() {
		Table table = new Table();
		table.deal(2);
		List<PlayerBox> boxList = table.getBoxes();
		for (PlayerBox b: boxList) {
			b.sort();
			b.getHand().getCombinationOnFiveCards();
			System.out.println(b.toString() +" "+b.getHand().getCombinationOnFiveCards());
		}
		table.sort();
		System.out.println(table.getHand().toString() + " " + table.getHand().getCombinationOnFiveCards());
	}

}
