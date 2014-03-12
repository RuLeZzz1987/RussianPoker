package test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import source.Card;
import source.Deck;
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
	public void testIsSameCard() {
		Card card1 = new Card(Suit.CLUBS, 'A');
		Card card2 = new Card(Suit.CLUBS, 'A');
		assertEquals(true, card1.isSame(card2));
		card2 = new Card(Suit.DIAMOND, 'A');
		assertEquals(false, card1.isSame(card2));
		card2 = new Card(Suit.CLUBS, 'K');
		assertEquals(false, card1.isSame(card2));
		
	}
	
	@Test
	public void testCreateCard() {
		Card card1 = new Card(Suit.CLUBS, 'A');
		assertEquals(14, card1.getScore());
		card1 = new Card(Suit.CLUBS, 'K');
		assertEquals(13, card1.getScore());
		card1 = new Card(Suit.CLUBS, 'Q'); 
		assertEquals(12, card1.getScore());
		card1 = new Card(Suit.CLUBS, 'J');
		assertEquals(11, card1.getScore());
		card1 = new Card(Suit.CLUBS, 'T');
		assertEquals(10, card1.getScore());
		for (int i=2; i<=9; i++) {
			card1 = new Card(Suit.CLUBS, (char)(i+48));
			assertEquals(i, card1.getScore()); 
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
	


}
