package model;

import java.util.HashMap;

/**
 * this class is to create a map of the game
 */
public class Map {

	/** the size of any side of the map */
	private int mapSize;

	/** the coordinate HashMap for the map */
	// private LinkedList<Pair<Coordinate, Boolean>> coordinateList;
	private HashMap<Coordinate, Boolean> coordinateMap;

	/**
	 * this constructor is to create a map for the game
	 * 
	 * @param mapSize
	 *            the size of any side of the map
	 */
	public Map(int mapSize) {
		super();
		if (mapSize == 5 || mapSize == 7) {
			this.mapSize = mapSize;
			this.coordinateMap = new HashMap<Coordinate, Boolean>();
			this.initializeMap();
		}
	}

	/**
	 * coordinateMap this method is to initialize map, which is to set all
	 * coordinates to false
	 */
	private void initializeMap() {

		Coordinate center = new Coordinate(0, 0, 0);
		this.coordinateMap = center.getRange(this.getMapSize());
	}

	/**
	 * this method is to update the mist when robot moved
	 * 
	 * @param currentPlayer
	 *            the current player of the game
	 */
	public void updateMist(Player currentPlayer) {
		getCoordinateMap().forEach((coord, isVisible) -> {
			if (currentPlayer.getViewRangeList().contains(coord)) {
				// isVisible = false; //Changed
				getCoordinateMap().replace(coord, true);
			} else {
				// isVisible = true; //Changed
				getCoordinateMap().replace(coord, false);
			}
		});
	}

	/**
	 * @return the mapSize
	 */
	public int getMapSize() {
		return mapSize;
	}

	/**
	 * @param mapSize
	 *            the mapSize to set
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
	 * @param coordinateMap
	 *            the coordinateMap to set
	 */
	public void setCoordinateMap(HashMap<Coordinate, Boolean> coordinateMap) {
		this.coordinateMap = coordinateMap;
	}

	public static void main(String[] args) {
		Map map = new Map(5);
		map.initializeMap();
		// System.out.println(map.getCoordinateMap().size());
		// map.updateMist(null);
	}
}
