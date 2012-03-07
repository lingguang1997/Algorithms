package edu.gwu.biconnected;


public class Gragh {

	private int[][] adjMat; 
	private int pos = -1;
	private int size = 0;

	Gragh(int size) {
		this.size = size;
		this.adjMat = new int[size][size];  
	} 

	void connect(int from, int to) {  
		adjMat[from][to] = 1;
		adjMat[to][from] = 1;
	}  

	void disConnect(int from, int to) {  
		adjMat[from][to] = 0;
		adjMat[to][from] = 0;
	}

	public int[][] getAdjMat() {
		return adjMat;
	}

	public void setAdjMat(int[][] adjMat) {
		this.adjMat = adjMat;
	}

	public int getPos() {
		return pos;
	}

	public void setPos(int pos) {
		this.pos = pos;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public String toString() {
		StringBuffer sbBuffer = new StringBuffer();
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				sbBuffer.append(adjMat[i][j]);
			}
			sbBuffer.append("\r\n");
		}
		return sbBuffer.toString();
	}

	/**
	 * @param args
	 */
	 public static void main(String[] args) {
		Gragh gragh = new Gragh(4);

		gragh.connect(0, 1);
		gragh.connect(1, 2);
		gragh.connect(1, 3);
		gragh.connect(2, 3);
		
		System.out.println(gragh);
	}

}
