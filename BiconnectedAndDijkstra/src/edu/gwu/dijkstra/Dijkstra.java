package edu.gwu.dijkstra;


import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;


public class Dijkstra {

	public static final int INFINITE_DISTANCE = Integer.MAX_VALUE;

	private static final int INITIAL_CAPACITY = 8;

	private final Comparator<City> shortestDistanceComparator = new Comparator<City>() {
		public int compare(City left, City right) {
			// note that this trick doesn't work for huge distances, close to Integer.MAX_VALUE
			int result = getShortestDistance(left) - getShortestDistance(right);

			return (result == 0) ? left.compareTo(right) : result;
		}
	};

	private final RoutesMap map;

	private final PriorityQueue<City> unsettledNodes = new PriorityQueue<City>(INITIAL_CAPACITY, shortestDistanceComparator);

	private final Set<City> settledNodes = new HashSet<City>();

	private final Map<City, Integer> shortestDistances = new HashMap<City, Integer>();

	private final Map<City, City> predecessors = new HashMap<City, City>();

	public Dijkstra(RoutesMap map) {
		this.map = map;
	}

	private void init(City start) {
		settledNodes.clear();
		unsettledNodes.clear();

		shortestDistances.clear();
		predecessors.clear();

		// add source
		setShortestDistance(start, 0);
		unsettledNodes.add(start);
	}

	public void calculate(City start, City destination) {
		init(start);
		City u;
		while ((u = unsettledNodes.poll()) != null) {
			assert !isSettled(u);
			if (u == destination) break;
			settledNodes.add(u);
			relaxNeighbors(u);
		}
	}

	private void relaxNeighbors(City u) {
		for (City v : map.getDestinations(u)) {
			if (isSettled(v)) continue;
			int shortDist = getShortestDistance(u) + map.getDistance(u, v);

			if (shortDist < getShortestDistance(v)) {
				setShortestDistance(v, shortDist);
				setPredecessor(v, u);
			}
		}        
	}

	private boolean isSettled(City v) {
		return settledNodes.contains(v);
	}

	public int getShortestDistance(City city) {
		Integer d = shortestDistances.get(city);
		return (d == null) ? INFINITE_DISTANCE : d;
	}
 
	private void setShortestDistance(City city, int distance) {
		unsettledNodes.remove(city);
		shortestDistances.put(city, distance);
		unsettledNodes.add(city);        
	}

	public City getPredecessor(City city) {
		return predecessors.get(city);
	}

	private void setPredecessor(City a, City b) {
		predecessors.put(a, b);
	}

}
