package test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;

import org.junit.jupiter.api.Test;

import core.CubeSet;
import core.Game;
import core.Main;

class TestGame {
	
	@Test
	void testMain() {
		assertAll(() -> Main.main(null));
	}
	
	@Test
	void testGameCreation() {
		assertAll(() -> new Game(List.of(new CubeSet(1,2,3))));
	}
	
	@Test
	void testGameCreationWithNullCubeList() {
		assertThrows(IllegalArgumentException.class, () -> new Game(null));
	}
	
	@Test
	void testCubeSetCreation() {
		assertAll(() -> new CubeSet(1,2,3));
	}
	
	@Test
	void testCubeSetCreationNegativeRed() {
		assertThrows(IllegalArgumentException.class, () -> new CubeSet(-1,2,3));
	}
	
	@Test
	void testCubeSetCreationNegativeGreen() {
		assertThrows(IllegalArgumentException.class, () -> new CubeSet(1,-2,3));
	}
	
	@Test
	void testCubeSetCreationNegativeBlue() {
		assertThrows(IllegalArgumentException.class, () -> new CubeSet(1,2,-3));
	}

}
