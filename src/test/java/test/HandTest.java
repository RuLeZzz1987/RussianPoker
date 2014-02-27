package test;

import static org.junit.Assert.*;
import org.junit.Test;

import source.Card;
import source.Hand;
import source.Suit;

public class HandTest {


	@Test
	public void testIsFlush() {
		Hand hand = new Hand();
		hand.add(new Card(Suit.CLUBS, 'A', 14));
		hand.add(new Card(Suit.CLUBS, 'K', 13));
		hand.add(new Card(Suit.CLUBS, '6', 6));
		hand.add(new Card(Suit.CLUBS, '3', 3));
		hand.add(new Card(Suit.CLUBS, '2', 2));
		assertEquals("6 14 13 6 3 2", hand.getCombinationOnFiveCards().getCombCode());
	}
	
	@Test
	public void testKickersList() {
		Hand hand = new Hand();
		hand.add(new Card(Suit.CLUBS, 'A', 14));
		hand.add(new Card(Suit.DIAMOND, 'A', 14));
		hand.add(new Card(Suit.CLUBS, '6', 6));
		hand.add(new Card(Suit.CLUBS, '3', 3));
		hand.add(new Card(Suit.CLUBS, '2', 2));
		hand.getCombinationOnFiveCards();
	}
	

	@Test
	public void testCombinationDNQ() {
		Hand hand = new Hand();
		hand.add(new Card(Suit.CLUBS, 'A'));
		hand.add(new Card(Suit.DIAMOND, 'J'));
		hand.add(new Card(Suit.CLUBS, '6'));
		hand.add(new Card(Suit.CLUBS, '3'));
		hand.add(new Card(Suit.CLUBS, '2'));
		assertEquals("0", hand.getCombinationOnFiveCards().getCombCode());
	}
	
	@Test
	public void testCombinationAK() {
		Hand hand = new Hand();
		hand.add(new Card(Suit.CLUBS, 'A'));
		hand.add(new Card(Suit.DIAMOND, 'K'));
		hand.add(new Card(Suit.CLUBS, '6'));
		hand.add(new Card(Suit.CLUBS, '3'));
		hand.add(new Card(Suit.CLUBS, '2'));
		assertEquals("1 6 3 2", hand.getCombinationOnFiveCards().getCombCode());
	}
	
	@Test
	public void testCombinationPairAABCD() {
		Hand hand = new Hand();
		hand.add(new Card(Suit.CLUBS, 'K'));
		hand.add(new Card(Suit.DIAMOND, 'K'));
		hand.add(new Card(Suit.CLUBS, '7'));
		hand.add(new Card(Suit.CLUBS, '5'));
		hand.add(new Card(Suit.CLUBS, '2'));
		assertEquals("2 13 13 7 5 2", hand.getCombinationOnFiveCards().getCombCode());
	}
	
	@Test
	public void testCombinationPairABBCD() {
		Hand hand = new Hand();
		hand.add(new Card(Suit.CLUBS, 'A'));
		hand.add(new Card(Suit.DIAMOND, 'J'));
		hand.add(new Card(Suit.CLUBS, 'J'));
		hand.add(new Card(Suit.CLUBS, '3'));
		hand.add(new Card(Suit.CLUBS, '2'));
		assertEquals("2 11 11 14 3 2", hand.getCombinationOnFiveCards().getCombCode());
	}
	
	@Test
	public void testCombinationPairABCCD() {
		Hand hand = new Hand();
		hand.add(new Card(Suit.CLUBS, 'A'));
		hand.add(new Card(Suit.DIAMOND, 'J'));
		hand.add(new Card(Suit.CLUBS, '6'));
		hand.add(new Card(Suit.HEART, '6'));
		hand.add(new Card(Suit.CLUBS, '2'));
		assertEquals("2 6 6 14 11 2", hand.getCombinationOnFiveCards().getCombCode());
	}
	
	@Test
	public void testCombinationPairABCDD() {
		Hand hand = new Hand();
		hand.add(new Card(Suit.CLUBS, 'A'));
		hand.add(new Card(Suit.DIAMOND, 'J'));
		hand.add(new Card(Suit.CLUBS, '6'));
		hand.add(new Card(Suit.HEART, '2'));
		hand.add(new Card(Suit.CLUBS, '2'));
		assertEquals("2 2 2 14 11 6", hand.getCombinationOnFiveCards().getCombCode());
	}
	
	@Test
	public void testCombinationTwoPairsAABBC() {
		Hand hand = new Hand();
		hand.add(new Card(Suit.CLUBS, 'A'));
		hand.add(new Card(Suit.DIAMOND, 'A'));
		hand.add(new Card(Suit.CLUBS, '6'));
		hand.add(new Card(Suit.HEART, '6'));
		hand.add(new Card(Suit.CLUBS, '2'));
		assertEquals("3 14 14 6 6 2", hand.getCombinationOnFiveCards().getCombCode());
	}
	
	@Test
	public void testCombinationTwoPairsAABCC() {
		Hand hand = new Hand();
		hand.add(new Card(Suit.CLUBS, 'A'));
		hand.add(new Card(Suit.DIAMOND, 'A'));
		hand.add(new Card(Suit.CLUBS, '7'));
		hand.add(new Card(Suit.HEART, '6'));
		hand.add(new Card(Suit.CLUBS, '6'));
		assertEquals("3 14 14 6 6 7", hand.getCombinationOnFiveCards().getCombCode());
	}
	
	@Test
	public void testCombinationTwoPairsABBCC() {
		Hand hand = new Hand();
		hand.add(new Card(Suit.CLUBS, 'A'));
		hand.add(new Card(Suit.DIAMOND, '7'));
		hand.add(new Card(Suit.CLUBS, '7'));
		hand.add(new Card(Suit.HEART, '6'));
		hand.add(new Card(Suit.CLUBS, '6'));
		assertEquals("3 7 7 6 6 14", hand.getCombinationOnFiveCards().getCombCode());
	}
	
	@Test
	public void testCombinationSetAAABC() {
		Hand hand = new Hand();
		hand.add(new Card(Suit.CLUBS, '7'));
		hand.add(new Card(Suit.DIAMOND, '7'));
		hand.add(new Card(Suit.SPADES, '7'));
		hand.add(new Card(Suit.CLUBS, '5'));
		hand.add(new Card(Suit.CLUBS, '2'));
		assertEquals("4 7 7 7 5 2", hand.getCombinationOnFiveCards().getCombCode());
	}
	
	@Test
	public void testCombinationSetABBBC() {
		Hand hand = new Hand();
		hand.add(new Card(Suit.CLUBS, 'A'));
		hand.add(new Card(Suit.DIAMOND, 'J'));
		hand.add(new Card(Suit.CLUBS, 'J'));
		hand.add(new Card(Suit.SPADES, 'J'));
		hand.add(new Card(Suit.CLUBS, '2'));
		assertEquals("4 11 11 11 14 2", hand.getCombinationOnFiveCards().getCombCode());
	}
	
	@Test
	public void testCombinationSetABCCC() {
		Hand hand = new Hand();
		hand.add(new Card(Suit.CLUBS, 'A'));
		hand.add(new Card(Suit.DIAMOND, 'J'));
		hand.add(new Card(Suit.DIAMOND, '2'));
		hand.add(new Card(Suit.SPADES, '2'));
		hand.add(new Card(Suit.CLUBS, '2'));
		assertEquals("4 2 2 2 14 11", hand.getCombinationOnFiveCards().getCombCode());
	}
	
	@Test
	public void testCombinationFullHouseAAACC() {
		Hand hand = new Hand();
		hand.add(new Card(Suit.CLUBS, 'A'));
		hand.add(new Card(Suit.DIAMOND, 'A'));
		hand.add(new Card(Suit.HEART, 'A'));
		hand.add(new Card(Suit.SPADES, '2'));
		hand.add(new Card(Suit.CLUBS, '2'));
		assertEquals("7 14 2", hand.getCombinationOnFiveCards().getCombCode());
	}
	
	@Test
	public void testCombinationFullHouseAACCC() {
		Hand hand = new Hand();
		hand.add(new Card(Suit.CLUBS, 'A'));
		hand.add(new Card(Suit.DIAMOND, 'A'));
		hand.add(new Card(Suit.SPADES, '2'));
		hand.add(new Card(Suit.HEART, '2'));
		hand.add(new Card(Suit.CLUBS, '2'));
		assertEquals("7 2 14", hand.getCombinationOnFiveCards().getCombCode());
	}
	
	@Test
	public void testCombinationFourOfaKindAAAAB() {
		Hand hand = new Hand();
		hand.add(new Card(Suit.CLUBS, 'A'));
		hand.add(new Card(Suit.DIAMOND, 'A'));
		hand.add(new Card(Suit.HEART, 'A'));
		hand.add(new Card(Suit.SPADES, 'A'));
		hand.add(new Card(Suit.CLUBS, '2'));
		assertEquals("8 14 2", hand.getCombinationOnFiveCards().getCombCode());
	}
	
	@Test
	public void testCombinationFourOfaKindABBBB() {
		Hand hand = new Hand();
		hand.add(new Card(Suit.CLUBS, 'A'));
		hand.add(new Card(Suit.DIAMOND, '2'));
		hand.add(new Card(Suit.HEART, '2'));
		hand.add(new Card(Suit.SPADES, '2'));
		hand.add(new Card(Suit.CLUBS, '2'));
		assertEquals("8 2 14", hand.getCombinationOnFiveCards().getCombCode());
	}
	
	@Test
	public void testCombinationStraight() {
		Hand hand = new Hand();
		hand.add(new Card(Suit.CLUBS, 'K'));
		hand.add(new Card(Suit.DIAMOND, 'Q'));
		hand.add(new Card(Suit.HEART, 'J'));
		hand.add(new Card(Suit.SPADES, 'T'));
		hand.add(new Card(Suit.CLUBS, '9'));
		assertEquals("5 13", hand.getCombinationOnFiveCards().getCombCode());
	}
	
	@Test
	public void testCombinationWheelStraight() {
		Hand hand = new Hand();
		hand.add(new Card(Suit.CLUBS, 'A'));
		hand.add(new Card(Suit.DIAMOND, '5'));
		hand.add(new Card(Suit.HEART, '4'));
		hand.add(new Card(Suit.SPADES, '3'));
		hand.add(new Card(Suit.CLUBS, '2'));
		assertEquals("5 5", hand.getCombinationOnFiveCards().getCombCode());
	}
	
	@Test
	public void testCombinationStraightFlush() {
		Hand hand = new Hand();
		hand.add(new Card(Suit.CLUBS, 'K'));
		hand.add(new Card(Suit.CLUBS, 'Q'));
		hand.add(new Card(Suit.CLUBS, 'J'));
		hand.add(new Card(Suit.CLUBS, 'T'));
		hand.add(new Card(Suit.CLUBS, '9'));
		assertEquals("9 13", hand.getCombinationOnFiveCards().getCombCode());
	}
	
	@Test
	public void testCombinationWheelStraightFlush() {
		Hand hand = new Hand();
		hand.add(new Card(Suit.CLUBS, 'A'));
		hand.add(new Card(Suit.CLUBS, '5'));
		hand.add(new Card(Suit.CLUBS, '4'));
		hand.add(new Card(Suit.CLUBS, '3'));
		hand.add(new Card(Suit.CLUBS, '2'));
		assertEquals("9 5", hand.getCombinationOnFiveCards().getCombCode());
	}
	
	@Test
	public void testCombinationRoyalFlush() {
		Hand hand = new Hand();
		hand.add(new Card(Suit.CLUBS, 'A'));
		hand.add(new Card(Suit.CLUBS, 'K'));
		hand.add(new Card(Suit.CLUBS, 'Q'));
		hand.add(new Card(Suit.CLUBS, 'J'));
		hand.add(new Card(Suit.CLUBS, 'T'));
		assertEquals("10", hand.getCombinationOnFiveCards().getCombCode());
	}
}
