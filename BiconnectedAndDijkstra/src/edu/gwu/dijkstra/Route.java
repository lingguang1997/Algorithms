package edu.gwu.dijkstra;


import java.util.ArrayList;

public final class Route implements Cloneable {

	private ArrayList<City> cities = new ArrayList<City>();

	private int distance = 0;

	Route() {}

	public Route clone() {
		Route newInstance = null;

		try {
			newInstance = (Route) super.clone();	
		}
		catch (CloneNotSupportedException cnfe) {
			assert false : cnfe;
		}

		newInstance.cities = (ArrayList<City>) cities.clone();

		return newInstance;
	}

	void addStop(City stop, int distance) {
		if (!cities.isEmpty()) {
			this.distance += distance;		
		}

		cities.add(stop);
	}

	public int getDistance() {
		return distance;	
	}

	public int getLength() {
		return (cities.isEmpty()) ? 0 : cities.size() - 1;
	}

	public City getLastStop() {
		if (cities.isEmpty()) {
			return null;
		} else {
			return cities.get(cities.size() - 1);
		}
	}

	public boolean hasCity(City city) {
		return cities.contains(city);
	}

	public String toString() {
		StringBuffer temp = new StringBuffer();

		temp.append("l=").append(getLength()).append(" d=").append( getDistance() )
		           .append(" ").append(cities);

		return temp.toString();
	}

}
