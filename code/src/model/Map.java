package model;

import java.util.HashMap;
import java.util.LinkedList;

import javafx.util.Pair;

/**
 * this class is to create a map of the game
 */
public class Map {

	/** the size of any side of the map */
	private int mapSize;

	/** the coordinate list for the map */
	private LinkedList<Pair<Coordinate, Boolean>> coordinateList;
	private HashMap<Coordinate, Boolean> coordinateMap;
	
	/**
	 * this constructor is to create a map for the game
	 * @param mapSize the size of any side of the map
	 */
	public Map(int mapSize) {
		super();
		if ( mapSize == 5 || mapSize == 7 ) {
			this.mapSize = mapSize;
		}	
		for (Pair<Coordinate, Boolean> pair : coordinateList) {
			/**
			pair = new Pair<Coordinate, Boolean>(
					new Coordinate ( x,  y,  z), 
					false);*/
		}
	}

	/**
	 * this method is to update the mist when robot moved
	 */
	public void updateMist () {
		
	}
	
	public int getMapSize() {
		return mapSize;
	}

	public void setMapSize(int mapSize) {
		this.mapSize = mapSize;
	}

	public LinkedList<Pair<Coordinate, Boolean>> getCoordinateList() {
		return coordinateList;
	}

	public void setCoordinateList(LinkedList<Pair<Coordinate, Boolean>> coordinateList) {
		this.coordinateList = coordinateList;
	}
}
