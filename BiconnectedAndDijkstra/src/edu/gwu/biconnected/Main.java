package edu.gwu.biconnected;

public class Main {

	public static void main(String[] args) {
		// define your gragh here
		Gragh gragh = new Gragh(17);

		gragh.connect(0, 1);
		gragh.connect(1, 2);
		gragh.connect(1, 3);
		gragh.connect(1, 10);
		gragh.connect(1, 12);
		gragh.connect(2, 3);
		gragh.connect(2, 4);
		gragh.connect(2, 5);
		gragh.connect(3, 4);
		gragh.connect(3, 5);
		gragh.connect(4, 5);
		gragh.connect(4, 6);
		gragh.connect(4, 7);
		gragh.connect(4, 8);
		gragh.connect(6, 8);
		gragh.connect(6, 9);
		gragh.connect(7, 8);
		gragh.connect(10, 11);
		gragh.connect(10, 12);
		gragh.connect(11, 12);
		gragh.connect(11, 13);
		gragh.connect(11, 14);
		gragh.connect(11, 15);
		gragh.connect(13, 14);
		gragh.connect(13, 15);
		gragh.connect(13, 16);
		gragh.connect(14, 15);

		// you don't need to modify the following code
        System.out.println("The adjacency matrix of the graph: \r\n");
		System.out.println(gragh);
	
		Biconnected bic = new Biconnected(gragh);
		bic.calculate();
	}

}
