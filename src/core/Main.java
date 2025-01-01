package core;

import java.util.LinkedList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		
		System.out.println("Cube Conundrum");
		System.out.println("");
		
		List<Game> games = exampleGameList();
		
		// Print each game
		games.stream()
			.map(Game::toString)
			.forEach(System.out::println);

	}
	
	public static List<Game> exampleGameList() {
		
		List<Game> games = new LinkedList<>();
		
		// Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green
		games.add(new Game(List.of(new CubeSet(4,0,3), new CubeSet(1,2,6), new CubeSet(0,2,0)))); 
		
		// Game 2: 1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue
		games.add(new Game(List.of(new CubeSet(0,2,1), new CubeSet(1,3,4), new CubeSet(0,1,1)))); 
		
		// Game 3: 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red
		games.add(new Game(List.of(new CubeSet(20,8,6), new CubeSet(4,13,5), new CubeSet(1,5,0)))); 
		
		// Game 4: 1 green, 3 red, 6 blue; 3 green, 6 red; 3 green, 15 blue, 14 red
		games.add(new Game(List.of(new CubeSet(3,1,6), new CubeSet(6,3,0), new CubeSet(14,3,15)))); 
		
		// Game 5: 6 red, 1 blue, 3 green; 2 blue, 1 red, 2 green
		games.add(new Game(List.of(new CubeSet(6,3,1), new CubeSet(1,2,2))));
		
		return games;
	}

}
