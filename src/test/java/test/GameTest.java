package test;

import java.io.IOException;

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
	public void testDeal() throws IOException {
		table.makeBets(10, 15, 25);
		table.deal();
		System.out.println(table.toString());
	}

}
