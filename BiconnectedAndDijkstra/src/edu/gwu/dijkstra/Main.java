package edu.gwu.dijkstra;


import java.util.ArrayList;
import java.util.Collections;


public class Main {

	public static void main(String[] args) {
		
        // Define your map here:
		RoutesMap map = new DenseRoutesMap(4);
		map.addDirectRoute(City.A, City.B, 1);
		map.addDirectRoute(City.A, City.D, 4);
		map.addDirectRoute(City.B, City.D, 2);
		map.addDirectRoute(City.B, City.C, 5);
		map.addDirectRoute(City.D, City.C, 1);

		// set the start and end point of you map
		City startCity = City.A;
		City endcCity = City.C;
		
		// you don't need to modify the following code
		Dijkstra engine = new Dijkstra(map);
		engine.calculate(startCity, endcCity);
		int distance = engine.getShortestDistance(endcCity);
		System.out.println(distance);
		ArrayList<City> l = new ArrayList<City>();
         for (City city = City.C; city != null; city = engine.getPredecessor(city)) {
        	 l.add(city);
         }
		 Collections.reverse(l);
		 System.out.println(l);
	}

}
