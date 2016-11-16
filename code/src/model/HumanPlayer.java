/*
 * Name: Ruida Xie
 * NSID: rux793
 * Student Number: 11194258
 */
package model;

import java.util.LinkedList;
import model.Map;


/**
 * @author ruidaxie
 *
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
	 * this method moves a robot of the player one cell forward
	 * @throws Exception 
	 */
	public void move() throws Exception{
		try{
			this.getCurrentRobot().move(Map.getMapSize());
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


}
