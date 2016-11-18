
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
	public HumanPlayer ( Coordinate initialCoord, int mapSize ) {
		super ( initialCoord, mapSize );
	}
	
	/**
	 * this method moves a robot of the player one cell forward
	 * @throws Exception 
	 */
	public void move(int mapSize){
		try{
			this.getCurrentRobot().move(mapSize);
		}
		catch (Exception e){
			
		}
	}
	
	/**
	 * this method makes a robot of the player face a different direction.
	 * @param direction, the direction to which the robot will face
	 */
	public void turn(int direction){
		this.getCurrentRobot().turn(direction);
	}
	
	/**
	 * a robot of the player fires to the direction it facing.
	 * @param Coordinate, the coordinate of the target.
	 * @return Pair<Coordinate, Integer> contain the shoot target coordinate and the attack point.
	 */
	public Pair<Coordinate, Integer> shoot(int distance, int mapSize){
		Pair<Coordinate, Integer> pair = null;
		try {
			pair = this.getCurrentRobot().shoot(distance, mapSize);
		} 
		catch (Exception e) {
			
		}
		return pair;
	}


}
