package test;

import static org.junit.Assert.*;

import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

import source.Card;
import source.Deck;
import source.Hand;
import source.PlayerBox;
import source.Suit;
import source.Table;

public class CardTest {

	@Test
	public void testShowDeck() {
		List<Card> deck = new Deck().getDeck();
		for(Card i : deck)
		{
			System.out.print(i.toString()+" ");
		}
	}
	
	@Test
	public void testShowDeal() {
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
	
	@Test
	public void testIsFlush() {
		Hand hand = new Hand();
		hand.add(new Card(Suit.CLUBS, 'A', 14));
		hand.add(new Card(Suit.CLUBS, 'K', 13));
		hand.add(new Card(Suit.CLUBS, '6', 6));
		hand.add(new Card(Suit.CLUBS, '3', 3));
		hand.add(new Card(Suit.CLUBS, '2', 2));
		Assert.assertEquals("61413632", hand.getCombinationOnFiveCards().getCombCode());
	}

}
