
package model;

import java.util.HashMap;
import java.util.LinkedList;

public class AIPlayer extends Player {

	/** all the enemy robots with coordinate */
	private HashMap<Coordinate, LinkedList<Robot>> enemyMap;
	
	/**
	 * this constructor is to construct the AI player with all parameters
	 * 
	 * @param name
	 * @param score
	 * @param scoutRobot
	 * @param sniperRobot
	 * @param tankRobot
	 * @param viewRangeList
	 */
	public AIPlayer( String name, 
					int score, 
					Robot scoutRobot,
					Robot sniperRobot, 
					Robot tankRobot,
					LinkedList<Coordinate> viewRangeList,
					HashMap<Coordinate, Robot> enemyMap ) {
		super(name, score, scoutRobot, sniperRobot, tankRobot, viewRangeList);
		this.enemyMap = new HashMap<Coordinate, LinkedList<Robot>>();
	}

	/**
	 * this method is to scan all the coordinates the player can see,
	 * then store the enemies' robots in the enemyMap.
	 */
	public void scan( HashMap<Coordinate, LinkedList<Robot>> robotMap ) {
		this.enemyMap = new HashMap<Coordinate, LinkedList<Robot>>();
		for ( Coordinate coord: super.getViewRangeList() ) {
			if ( robotMap.containsKey(coord) ) {
				LinkedList<Robot> robotList = new LinkedList<Robot>();				
				if (robotList.addAll(robotMap.get(coord))) {
					this.getEnemyMap().put(coord, robotList);
				};				
			}
		}		
	}

	/**
	 * @return the enemyMap
	 */
	public HashMap<Coordinate, LinkedList<Robot>> getEnemyMap() {
		return enemyMap;
	}

	/**
	 * @param enemyMap the enemyMap to set
	 */
	public void setEnemyMap(HashMap<Coordinate, LinkedList<Robot>> enemyMap) {
		this.enemyMap = enemyMap;
	}


}
