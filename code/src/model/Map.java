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
	//private LinkedList<Pair<Coordinate, Boolean>> coordinateList;
	private HashMap<Coordinate, Boolean> coordinateMap;
	
	/**
	 * this constructor is to create a map for the game
	 * @param mapSize the size of any side of the map
	 */
	public Map(int mapSize) {
		super();
		if ( mapSize == 5 || mapSize == 7 ) {
			this.mapSize = mapSize;
			this.coordinateMap = new HashMap<Coordinate, Boolean>();
			this.initializeMap();
		}
	}

	/**
	 * this method is to initialize map, 
	 * which is to set all coordinates to false
	 */
	private void initializeMap() {
		for ( int i = 1 - this.getMapSize(); i < this.getMapSize(); i++ ) {
			for ( int j = 1 - this.getMapSize(); j < this.getMapSize(); j++ ) {
				for ( int k = 1 - this.getMapSize(); k < this.getMapSize(); k++ ) {
					if ( i + j + k == 0 ) {
						this.getCoordinateMap().put(new Coordinate(i,j,k), false);
					}					
				}
			}
		}
	}
	
	/**
	 * this method is to update the mist when robot moved
	 * @param currentPlayer the current player of the game
	 */
	public void updateMist(Player currentPlayer) {
		for ( Coordinate coord: currentPlayer.getViewRangeList() ) {
			this.getCoordinateMap().replace(coord, true);
		}
	}

	/**
	 * @return the mapSize
	 */
	public int getMapSize() {
		return mapSize;
	}

	/**
	 * @param mapSize the mapSize to set
	 */
	public void setMapSize(int mapSize) {
		this.mapSize = mapSize;
	}

	/**
	 * @return the coordinateMap
	 */
	public HashMap<Coordinate, Boolean> getCoordinateMap() {
		return coordinateMap;
	}

	/**
	 * @param coordinateMap the coordinateMap to set
	 */
	public void setCoordinateMap(HashMap<Coordinate, Boolean> coordinateMap) {
		this.coordinateMap = coordinateMap;
	}
	
}
