package core;

/** Enumeration that represents each possible cube color */
public enum Color {
	RED("red"),
	GREEN("green"),
	BLUE("blue");
	
	public final String label;
	
	private Color (String label) {
		this.label = label;
	}
	
}
