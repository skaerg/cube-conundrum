package core;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class CubeSet {

	private Map<Color, Integer> cubeSet;
	
	public CubeSet(int r, int g, int b) {
		
		if ((r < 0) || (g < 0) || (b < 0)) throw new IllegalArgumentException();
		
		this.cubeSet = new HashMap<>();
		this.cubeSet.put(Color.RED, r);
		this.cubeSet.put(Color.GREEN, g);
		this.cubeSet.put(Color.BLUE, b);
	}
	
	/* Getters for each color */
	
	public int getRed() { return cubeSet.get(Color.RED); }
	public int getGreen() { return cubeSet.get(Color.GREEN); }
	public int getBlue() { return cubeSet.get(Color.BLUE); }
	
	@Override
	public String toString() {
		
		List<String> l = new LinkedList<>();
		
		// Build a list that contains the number of cubes of each color
		// (if the number of cubes for that color is non-zero)
		this.cubeSet.forEach((key, value) -> { 
			if(value != 0) l.add(value + " " + key.label);
		});
		
		// Concatenate all the elements with a comma between each element
		return l.stream().reduce((s1,s2) -> s1 + ", " + s2).orElse("");
	}
	
	@Override
	public CubeSet clone() {
		return new CubeSet(
				cubeSet.get(Color.RED), 
				cubeSet.get(Color.GREEN), 
				cubeSet.get(Color.BLUE));
	}
	
}
