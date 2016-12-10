
package model;

import java.util.LinkedList;

import javafx.util.Pair;

/**
 * this class is to create a human player for the game
 */
public class HumanPlayer extends Player{

	/**
	 * this constructor is to create a HumanPlayer for the game
	 * @param name the name of the player
	 * @param score the score of the player
	 * @param scoutRobot scout robot of this player
	 * @param sniperRobot sniper robot of this player
	 * @param tankRobot tank robot of this player
	 * @param viewRangeList 
	 */
	public HumanPlayer (String name, 
			  			int score, 
			  			Robot scoutRobot,
			  			Robot sniperRobot, 
			  			Robot tankRobot,
			  			LinkedList<Coordinate> viewRangeList) {
		super(name, score, scoutRobot, sniperRobot, tankRobot, viewRangeList);
	}
	
	/**
	 * this constructor is to construct the AI player with 
	 * initial coordinate and the map size
	 * 
	 * @param initialCoord the initial coordinate for the player
	 * @param mapSize the map size for the game
	 */
	public HumanPlayer ( Coordinate initialCoord, int mapSize, int playerIndex ) {
		super ( initialCoord, mapSize, playerIndex );
	}
	


}
