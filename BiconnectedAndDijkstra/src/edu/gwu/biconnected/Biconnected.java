package edu.gwu.biconnected;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class Biconnected {
	
	Gragh gragh;
	int[] visit;
	int[] a;
	Stack<Pair> stack = new Stack<Pair>();

	public Biconnected(Gragh gragh) {
		this.gragh = gragh;
		gragh.connect(0, 1);
		this.visit = new int[gragh.getSize()];
		this.a = new int[gragh.getSize()];
	    for (int i = 0; i < gragh.getSize(); i++) {
			visit[i] = -1;
			a[i] = -1;
		}
	}
	
	public void calculate() {
		int n = 0;
	    for (int i = 0; i < gragh.getSize(); i++) {
			if (visit[i] == -1) {
				DFS(i, i, n);
			}
		}
	    if (!stack.isEmpty()) {
	    	System.out.print("Biconnected Component: ");
			for (Pair pair : stack) {
				if (pair.getI() != pair.getJ()) {
					System.out.print(pair + " ");
				}
			}
		}
	}
	
	void DFS(int s, int p, int n) {
		visit[s] = n ++;
		a[s] = s;
		
		stack.push(new Pair(p, s));
		
		int numOfChind = 0;
		boolean ap = false;
		
		for (int i = 0; i < gragh.getSize(); i++) {
			if (gragh.getAdjMat()[s][i] != 0 && i != p) {
				if (visit[i] != -1) { //
					if (visit[i] < visit[a[s]]) {
						a[s] = i;
						//System.out.println("point " + s + "'s lowpoint changes to " + a[s]);
					}
				} else {
					numOfChind ++;
					DFS(i, s, n);
					if (visit[a[i]] < visit[a[s]]) {
						a[s] = a[i];
						//System.out.println("point " + s + "'s lowpoint changes to " + a[s]);
					}
					if (!(visit[a[i]] < visit[s])) {
						ap = true;
					}
					
					if (s == p && numOfChind > 1 || s != p && ap) {
						List<Pair> component = new ArrayList<Pair>();
						boolean encounterS = false;
						for (int j = stack.size() -1; j > 0; j--) {
							if (stack.peek().getI() != s) {
								if (!encounterS) {
									Pair pair = stack.pop();
									component.add(pair);
								}
							} else {
								encounterS = true;
								component.add(stack.pop());
								break;
							}

						}
						System.out.print("Biconnected Component: ");
						for (Pair pair : component) {
							System.out.print(pair + " ");
						}
						System.out.print("\r\n");
						System.out.println("Articulation Point: " + s);
					}
				}
			}
		}
	}

}
