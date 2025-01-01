package core;
import java.util.LinkedList;
import java.util.List;

/** Class that represents a finished game, i.e. a series of draws. */
public final class Game {

	protected static int nGames = 0;
	public final int id;
	protected List<CubeSet> draws;
	
	public Game(List<CubeSet> draws) {
		
		if (draws == null) throw new IllegalArgumentException();
		
		nGames++;
		this.id = nGames;
		this.draws = new LinkedList<>();
		
		draws.forEach((cs) -> this.draws.add(cs.clone()));
	}
	
	/** Returns true if this game would have been possible with a given set of cubes and false otherwise. */
	public boolean test(CubeSet cs) {
		
		// deduce the minimum number of cubes in each color in the bag from the list of draws
		CubeSet minCubes = draws.stream()
				.reduce(new CubeSet(0,0,0), 
						(cs1, cs2) -> new CubeSet(
								Integer.max(cs1.getRed(), cs2.getRed()),
								Integer.max(cs1.getGreen(), cs2.getGreen()),
								Integer.max(cs1.getBlue(), cs2.getBlue())));
		
		// For the given CubeSet cs to be a possible option, it must contain at least
		// as many cubes in each color as the minCubes CubeSet
		return ((cs.getRed() >= minCubes.getRed()) && 
				(cs.getGreen() >= minCubes.getGreen()) && 
				(cs.getBlue() >= minCubes.getBlue()));
	}
	
	@Override
	public String toString() {
		
		String drawHistory = draws.stream()
				.map(CubeSet::toString)
				.reduce((s1,s2) -> s1 + " ; " + s2)
				.orElse("no draws");
		
		return "Game " + id + " : " + drawHistory;
	}
}
