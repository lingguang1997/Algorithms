package edu.gwu.dijkstra;


import java.util.ArrayList;
import java.util.List;

class DenseRoutesMap implements RoutesMap {

	private final int[][] distances;

	DenseRoutesMap(int numCities) {
		distances = new int[numCities][numCities];
	}

	public void addDirectRoute(City start, City end, int distance) {
		distances[start.getIndex()][end.getIndex()] = distance;
	}

	public int getDistance(City start, City end) {
		return distances[start.getIndex()][end.getIndex()];
	}

	public List<City> getDestinations(City city) {
		List<City> list = new ArrayList<City>();

		for (int i = 0; i < distances.length; i++) {
			if (distances[city.getIndex()][i] > 0) {
				list.add( City.valueOf(i) );
			}
		}

		return list;
	}

	public List<City> getPredecessors(City city) {
		List<City> list = new ArrayList<City>();

		for (int i = 0; i < distances.length; i++) {
			if (distances[i][city.getIndex()] > 0) {
				list.add( City.valueOf(i) );
			}
		}

		return list;
	}

	public RoutesMap getInverse() {
		DenseRoutesMap transposed = new DenseRoutesMap(distances.length);

		for (int i = 0; i < distances.length; i++) {
			for (int j = 0; j < distances.length; j++) {
				transposed.distances[i][j] = distances[j][i];
			}
		}

		return transposed;
	}

}
