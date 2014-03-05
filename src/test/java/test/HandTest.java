package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import source.Card;
import source.CardsDraw;
import source.GameMath;
import source.Hand;
import source.Suit;

public class HandTest {
	
	private Hand hand;
	private GameMath gameMath, testGameMath;
	
	@Before
	public void setUp() {
		hand = new Hand();
		gameMath = new GameMath();
		testGameMath = new GameMath();
	}
	
	@Test
	public void testPermutation() {
		hand.add(new Card(Suit.CLUBS, 'A', 14));
		hand.add(new Card(Suit.HEART, 'K', 13));
		hand.add(new Card(Suit.SPADES, '6', 6));
		hand.add(new Card(Suit.DIAMOND, '3', 3));
		hand.add(new Card(Suit.CLUBS, '2', 2));
		
		testGameMath.generatePossibleChanges(hand.getHand(), 3);
		/*for (int i=0; i< testGameMath.getPossibleChanges().size(); i++) {
			assertEquals(true, testGameMath.getPossibleChanges().get(i).isSameSet(gameMath.getPossibleChanges().get(i)));
		} */
		
	}
	
	@Test
	public void testIsFlush() {
		hand.add(new Card(Suit.CLUBS, 'A', 14));
		hand.add(new Card(Suit.CLUBS, 'K', 13));
		hand.add(new Card(Suit.CLUBS, '6', 6));
		hand.add(new Card(Suit.CLUBS, '3', 3));
		hand.add(new Card(Suit.CLUBS, '2', 2));
		assertEquals("6 14 13 6 3 2", hand.getCombinationOnFiveCards().getCombCode());
	}
	
	@Test
	public void testKickersList() {
		hand.add(new Card(Suit.CLUBS, 'A', 14));
		hand.add(new Card(Suit.DIAMOND, 'A', 14));
		hand.add(new Card(Suit.CLUBS, '6', 6));
		hand.add(new Card(Suit.CLUBS, '3', 3));
		hand.add(new Card(Suit.CLUBS, '2', 2));
		int[] check = { 2, 14, 14, 6, 3, 2 };
		for ( int i=0; i < hand.getCombinationOnFiveCards().getKickers().length; i++) {
			assertEquals(check[i], hand.getCombinationOnFiveCards().getKickers()[i]);
		}
	}
	

	@Test
	public void testCombinationDNQ() {
		hand.add(new Card(Suit.CLUBS, 'A'));
		hand.add(new Card(Suit.DIAMOND, 'J'));
		hand.add(new Card(Suit.CLUBS, '6'));
		hand.add(new Card(Suit.CLUBS, '3'));
		hand.add(new Card(Suit.CLUBS, '2'));
		assertEquals("0", hand.getCombinationOnFiveCards().getCombCode());
	}
	
	@Test
	public void testCombinationAK() {
		hand.add(new Card(Suit.CLUBS, 'A'));
		hand.add(new Card(Suit.DIAMOND, 'K'));
		hand.add(new Card(Suit.CLUBS, '6'));
		hand.add(new Card(Suit.CLUBS, '3'));
		hand.add(new Card(Suit.CLUBS, '2'));
		assertEquals("1 6 3 2", hand.getCombinationOnFiveCards().getCombCode());
	}
	
	@Test
	public void testCombinationPairAABCD() {
		hand.add(new Card(Suit.CLUBS, 'K'));
		hand.add(new Card(Suit.DIAMOND, 'K'));
		hand.add(new Card(Suit.CLUBS, '7'));
		hand.add(new Card(Suit.CLUBS, '5'));
		hand.add(new Card(Suit.CLUBS, '2'));
		assertEquals("2 13 13 7 5 2", hand.getCombinationOnFiveCards().getCombCode());
	}
	
	@Test
	public void testCombinationPairABBCD() {
		hand.add(new Card(Suit.CLUBS, 'A'));
		hand.add(new Card(Suit.DIAMOND, 'J'));
		hand.add(new Card(Suit.CLUBS, 'J'));
		hand.add(new Card(Suit.CLUBS, '3'));
		hand.add(new Card(Suit.CLUBS, '2'));
		assertEquals("2 11 11 14 3 2", hand.getCombinationOnFiveCards().getCombCode());
	}
	
	@Test
	public void testCombinationPairABCCD() {
		hand.add(new Card(Suit.CLUBS, 'A'));
		hand.add(new Card(Suit.DIAMOND, 'J'));
		hand.add(new Card(Suit.CLUBS, '6'));
		hand.add(new Card(Suit.HEART, '6'));
		hand.add(new Card(Suit.CLUBS, '2'));
		assertEquals("2 6 6 14 11 2", hand.getCombinationOnFiveCards().getCombCode());
	}
	
	@Test
	public void testCombinationPairABCDD() {
		hand.add(new Card(Suit.CLUBS, 'A'));
		hand.add(new Card(Suit.DIAMOND, 'J'));
		hand.add(new Card(Suit.CLUBS, '6'));
		hand.add(new Card(Suit.HEART, '2'));
		hand.add(new Card(Suit.CLUBS, '2'));
		assertEquals("2 2 2 14 11 6", hand.getCombinationOnFiveCards().getCombCode());
	}
	
	@Test
	public void testCombinationTwoPairsAABBC() {
		hand.add(new Card(Suit.CLUBS, 'A'));
		hand.add(new Card(Suit.DIAMOND, 'A'));
		hand.add(new Card(Suit.CLUBS, '6'));
		hand.add(new Card(Suit.HEART, '6'));
		hand.add(new Card(Suit.CLUBS, '2'));
		assertEquals("3 14 14 6 6 2", hand.getCombinationOnFiveCards().getCombCode());
	}
	
	@Test
	public void testCombinationTwoPairsAABCC() {
		hand.add(new Card(Suit.CLUBS, 'A'));
		hand.add(new Card(Suit.DIAMOND, 'A'));
		hand.add(new Card(Suit.CLUBS, '7'));
		hand.add(new Card(Suit.HEART, '6'));
		hand.add(new Card(Suit.CLUBS, '6'));
		assertEquals("3 14 14 6 6 7", hand.getCombinationOnFiveCards().getCombCode());
	}
	
	@Test
	public void testCombinationTwoPairsABBCC() {
		hand.add(new Card(Suit.CLUBS, 'A'));
		hand.add(new Card(Suit.DIAMOND, '7'));
		hand.add(new Card(Suit.CLUBS, '7'));
		hand.add(new Card(Suit.HEART, '6'));
		hand.add(new Card(Suit.CLUBS, '6'));
		assertEquals("3 7 7 6 6 14", hand.getCombinationOnFiveCards().getCombCode());
	}
	
	@Test
	public void testCombinationSetAAABC() {
		hand.add(new Card(Suit.CLUBS, '7'));
		hand.add(new Card(Suit.DIAMOND, '7'));
		hand.add(new Card(Suit.SPADES, '7'));
		hand.add(new Card(Suit.CLUBS, '5'));
		hand.add(new Card(Suit.CLUBS, '2'));
		assertEquals("4 7 7 7 5 2", hand.getCombinationOnFiveCards().getCombCode());
	}
	
	@Test
	public void testCombinationSetABBBC() {
		hand.add(new Card(Suit.CLUBS, 'A'));
		hand.add(new Card(Suit.DIAMOND, 'J'));
		hand.add(new Card(Suit.CLUBS, 'J'));
		hand.add(new Card(Suit.SPADES, 'J'));
		hand.add(new Card(Suit.CLUBS, '2'));
		assertEquals("4 11 11 11 14 2", hand.getCombinationOnFiveCards().getCombCode());
	}
	
	@Test
	public void testCombinationSetABCCC() {
		hand.add(new Card(Suit.CLUBS, 'A'));
		hand.add(new Card(Suit.DIAMOND, 'J'));
		hand.add(new Card(Suit.DIAMOND, '2'));
		hand.add(new Card(Suit.SPADES, '2'));
		hand.add(new Card(Suit.CLUBS, '2'));
		assertEquals("4 2 2 2 14 11", hand.getCombinationOnFiveCards().getCombCode());
	}
	
	@Test
	public void testCombinationFullHouseAAACC() {
		hand.add(new Card(Suit.CLUBS, 'A'));
		hand.add(new Card(Suit.DIAMOND, 'A'));
		hand.add(new Card(Suit.HEART, 'A'));
		hand.add(new Card(Suit.SPADES, '2'));
		hand.add(new Card(Suit.CLUBS, '2'));
		assertEquals("7 14 2", hand.getCombinationOnFiveCards().getCombCode());
	}
	
	@Test
	public void testCombinationFullHouseAACCC() {
		hand.add(new Card(Suit.CLUBS, 'A'));
		hand.add(new Card(Suit.DIAMOND, 'A'));
		hand.add(new Card(Suit.SPADES, '2'));
		hand.add(new Card(Suit.HEART, '2'));
		hand.add(new Card(Suit.CLUBS, '2'));
		assertEquals("7 2 14", hand.getCombinationOnFiveCards().getCombCode());
	}
	
	@Test
	public void testCombinationFourOfaKindAAAAB() {
		hand.add(new Card(Suit.CLUBS, 'A'));
		hand.add(new Card(Suit.DIAMOND, 'A'));
		hand.add(new Card(Suit.HEART, 'A'));
		hand.add(new Card(Suit.SPADES, 'A'));
		hand.add(new Card(Suit.CLUBS, '2'));
		assertEquals("8 14 2", hand.getCombinationOnFiveCards().getCombCode());
	}
	
	@Test
	public void testCombinationFourOfaKindABBBB() {
		hand.add(new Card(Suit.CLUBS, 'A'));
		hand.add(new Card(Suit.DIAMOND, '2'));
		hand.add(new Card(Suit.HEART, '2'));
		hand.add(new Card(Suit.SPADES, '2'));
		hand.add(new Card(Suit.CLUBS, '2'));
		assertEquals("8 2 14", hand.getCombinationOnFiveCards().getCombCode());
	}
	
	@Test
	public void testCombinationStraight() {
		hand.add(new Card(Suit.CLUBS, 'K'));
		hand.add(new Card(Suit.DIAMOND, 'Q'));
		hand.add(new Card(Suit.HEART, 'J'));
		hand.add(new Card(Suit.SPADES, 'T'));
		hand.add(new Card(Suit.CLUBS, '9'));
		assertEquals("5 13", hand.getCombinationOnFiveCards().getCombCode());
	}
	
	@Test
	public void testCombinationWheelStraight() {
		hand.add(new Card(Suit.CLUBS, 'A'));
		hand.add(new Card(Suit.DIAMOND, '5'));
		hand.add(new Card(Suit.HEART, '4'));
		hand.add(new Card(Suit.SPADES, '3'));
		hand.add(new Card(Suit.CLUBS, '2'));
		assertEquals("5 5", hand.getCombinationOnFiveCards().getCombCode());
	}
	
	@Test
	public void testCombinationStraightFlush() {
		hand.add(new Card(Suit.CLUBS, 'K'));
		hand.add(new Card(Suit.CLUBS, 'Q'));
		hand.add(new Card(Suit.CLUBS, 'J'));
		hand.add(new Card(Suit.CLUBS, 'T'));
		hand.add(new Card(Suit.CLUBS, '9'));
		assertEquals("9 13", hand.getCombinationOnFiveCards().getCombCode());
	}
	
	@Test
	public void testCombinationWheelStraightFlush() {
		hand.add(new Card(Suit.CLUBS, 'A'));
		hand.add(new Card(Suit.CLUBS, '5'));
		hand.add(new Card(Suit.CLUBS, '4'));
		hand.add(new Card(Suit.CLUBS, '3'));
		hand.add(new Card(Suit.CLUBS, '2'));
		assertEquals("9 5", hand.getCombinationOnFiveCards().getCombCode());
	}
	
	@Test
	public void testCombinationRoyalFlush() {
		hand.add(new Card(Suit.CLUBS, 'A'));
		hand.add(new Card(Suit.CLUBS, 'K'));
		hand.add(new Card(Suit.CLUBS, 'Q'));
		hand.add(new Card(Suit.CLUBS, 'J'));
		hand.add(new Card(Suit.CLUBS, 'T'));
		assertEquals("10", hand.getCombinationOnFiveCards().getCombCode());
	}
	

}
