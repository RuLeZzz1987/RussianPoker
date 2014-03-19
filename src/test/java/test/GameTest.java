package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import source.GameType;
import source.Table;

public class GameTest {
	
	private Table table;
	
	@Before
	public void setUp() {
		table = new Table(GameType.FiveCard);		
	}
	
	@Test
	public void testDeal() {
		table.makeBets(10, 15, 25);
		table.deal(1);
		System.out.println(table.toString());
	}

}
