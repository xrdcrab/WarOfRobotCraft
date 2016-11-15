package model;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * this class is to build up the game, 
 * then players can play the game in turns
 */
public class Game {

	/** player list to hold all players */
	//private LinkedList<Player> playerList;
	private HashMap<Integer, Player> playerMap;
	
	/** the number of players within the game */
	private int playerNum;
	
	/** the current player for the game */
	private Player currentPlayer;
	
	/** the map for the game */
	private Map map;

	/**
	 * @param playerMap
	 * @param playerNum
	 * @param currentPlayer
	 * @param map
	 */
	public Game(HashMap<Integer, Player> playerMap, int playerNum, Player currentPlayer, Map map) {
		super();
		
		this.playerNum = playerNum;
		this.playerMap = new HashMap<Integer, Player>();
		this.currentPlayer = currentPlayer;
		this.map = map;
	}
	
	/**
	 * 
	 * @param playerMap
	 * @param playerNum
	 */
	public Game(HashMap<Integer, Player> playerMap, int playerNum) {
		super();
		this.playerNum = playerNum;
		this.playerMap = new HashMap<Integer, Player>();
	}
	

	
	
}
