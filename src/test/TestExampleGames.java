package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import core.CubeSet;
import core.Game;
import core.Main;

@TestInstance(Lifecycle.PER_CLASS)
class TestExampleGames {
	
	private List<Game> games;
	private CubeSet bag;
	
	@BeforeAll
	public void init() {
		
		games = Main.exampleGameList();
		
		/*
		 * The Elf would first like to know which games would have been possible
		 * if the bag contained only 12 red cubes, 13 green cubes, and 14 blue cubes?
		 */
		bag = new CubeSet(12,13,14);
		
	}
	
	
	/* games 1, 2, and 5 would have been possible if 
	 * the bag had been loaded with that configuration. */
	
	@Test
	void testGame1() {
		assertTrue(games.get(0).test(bag));
	}
	
	@Test
	void testGame2() {
		assertTrue(games.get(1).test(bag));
	}
	
	@Test
	void testGame5() {
		assertTrue(games.get(4).test(bag));
	}
	
	
	/* game 3 would have been impossible because at one 
	 * point the Elf showed you 20 red cubes at once */
	
	@Test
	void testGame3() {
		assertFalse(games.get(2).test(bag));
	}
	
	
	/*
	 * game 4 would also have been impossible because
	 * the Elf showed you 15 blue cubes at once */
	
	@Test
	void testGame4() {
		assertFalse(games.get(3).test(bag));
	}
	
	
	/* If you add up the IDs of the games that 
	 * would have been possible, you get 8. */
	
	@Test
	void testSumIds() {
		int sumIds = games.stream()
				.filter((g) -> g.test(bag))
				.mapToInt((g) -> g.id)
				.sum();
		
		assertEquals(8, sumIds);
	}
	
	@Test 
	void testNotEnoughBlueCubes() {
		assertFalse(games.get(2).test(new CubeSet(20,13,0)));
	}
	
	@Test 
	void testNotEnoughGreenCubes() {
		assertFalse(games.get(2).test(new CubeSet(20,0,5)));
	}
}