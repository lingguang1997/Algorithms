package edu.gwu.dijkstra;


import java.util.List;

public interface RoutesMap {

	public void addDirectRoute(City start, City end, int distance);

	public int getDistance(City start, City end);

	public List<City> getDestinations(City city); 

	public List<City> getPredecessors(City city);

	public RoutesMap getInverse();

}
