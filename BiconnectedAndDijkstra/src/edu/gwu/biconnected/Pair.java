package edu.gwu.biconnected;

public class Pair {

	int i;

	int j;

	Pair(int i, int j) {
		this.i = i;
		this.j = j;
	}

	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

	public int getJ() {
		return j;
	}

	public void setJ(int j) {
		this.j = j;
	}

	public String toString() {
		return "[" + i + "," + j +"]";
	}

}
