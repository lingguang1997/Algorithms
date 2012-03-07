package edu.gwu.dijkstra;


public final class City implements Comparable<City> {

	public static final int MAX_NUMBER = 26;

	private static final City[] cities = new City[MAX_NUMBER];

	static {
		for (char c = 'A'; c <= 'Z'; c++) {
			cities[getIndexForName(c)] = new City(c);
		}		
	}

	private static int getIndexForName(char name) {
		return name - 'A';
	}	

	private static char getNameForIndex(int index) {
		return (char)('A' + index);
	}	

	public static City valueOf(char name) {
		if (name < 'A' || name > 'Z') {
			throw new IllegalArgumentException("Invalid city name: " + name);	
		}

		return cities[getIndexForName(name)];
	}

	static City valueOf(int n) {
		if (n < 0 || n > 25) {
			throw new IllegalArgumentException("Invalid city number: " + n);
		}

		return valueOf(getNameForIndex(n));		
	}

	private final char name;

	private City(char name) {
		this.name = name;	
	}

	public char getName() {
		return name;	
	}

	int getIndex() {
		return getIndexForName(name);
	}	

	public String toString() {
		return String.valueOf(name);
	}

	public boolean equals(Object o) {
		return this == o || equals((City) o);
	}

	private boolean equals(City c) {
		return this.name == c.name;
	}

	@Override
	public int compareTo(City c) {
		return this.name - c.name;
	}

	public static final City A = City.valueOf('A');
	public static final City B = City.valueOf('B');
	public static final City C = City.valueOf('C');
	public static final City D = City.valueOf('D');
	public static final City E = City.valueOf('E');
	public static final City F = City.valueOf('F');
	public static final City G = City.valueOf('G');
	public static final City H = City.valueOf('H');
	public static final City I = City.valueOf('I');
	public static final City J = City.valueOf('J');
	public static final City K = City.valueOf('K');
	public static final City L = City.valueOf('L');
	public static final City M = City.valueOf('M');
	public static final City N = City.valueOf('N');
	public static final City O = City.valueOf('O');
	public static final City P = City.valueOf('P');
	public static final City Q = City.valueOf('Q');
	public static final City R = City.valueOf('R');
	public static final City S = City.valueOf('S');
	public static final City T = City.valueOf('T');
	public static final City U = City.valueOf('U');
	public static final City V = City.valueOf('V');
	public static final City W = City.valueOf('W');
	public static final City X = City.valueOf('X');
	public static final City Y = City.valueOf('Y');
	public static final City Z = City.valueOf('Z');

}
