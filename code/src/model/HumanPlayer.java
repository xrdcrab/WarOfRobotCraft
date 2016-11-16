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
	 * constructor
	 */
	public HumanPlayer (String name, 
			  			int score, 
			  			Robot scoutRobot,
			  			Robot sniperRobot, 
			  			Robot tankRobot,
			  			LinkedList<Coordinate> viewRangeList) {
		super(name, score, scoutRobot, sniperRobot, tankRobot, viewRangeList);
	}



}
