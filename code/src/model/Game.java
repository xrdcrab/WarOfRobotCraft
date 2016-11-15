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
	private int currentPlayerIndex;
	
	/** the map for the game */
	private Map gameMap;

	/**
	 * @param playerMap
	 * @param playerNum
	 * @param currentPlayer
	 * @param map
	 */
	public Game(HashMap<Integer, Player> playerMap, int playerNum, int currentPlayer, Map map) {
		super();
		
		this.playerNum = playerNum;
		this.playerMap = new HashMap<Integer, Player>();
		this.currentPlayerIndex = currentPlayer;
		this.gameMap = map;
	}
	
	/**
	 * this method is to overload the constructor above with two parameters
	 * @param playerMap
	 * @param playerNum
	 */
	public Game(HashMap<Integer, Player> playerMap, int playerNum) {
		super();
		
		this.playerNum = playerNum;
		this.playerMap = new HashMap<Integer, Player>();
		this.gameMap = new Map(playerNum);
		this.currentPlayerIndex = -1;
	}
	
	/**
	 * This method is to go next player. 
	 * @precondition 0<=currentPlayerIndex<5
	 * @precondition  currentPlayerIndex>=5 or currentPlayerIndex<0
	 */
	public void goNextPlayer(){
		if (this.getCurrentPlayerIndex()<0||this.currentPlayerIndex>=5){
			this.setCurrentPlayerIndex(0);
		}
		else{
			this.setCurrentPlayerIndex(this.currentPlayerIndex+1);
		}
	}

	/**
	 * @return the playerMap
	 */
	public HashMap<Integer, Player> getPlayerMap() {
		return playerMap;
	}

	/**
	 * @param playerMap the playerMap to set
	 */
	public void setPlayerMap(HashMap<Integer, Player> playerMap) {
		this.playerMap = playerMap;
	}

	/**
	 * @return the playerNum
	 */
	public int getPlayerNum() {
		return playerNum;
	}

	/**
	 * @param playerNum the playerNum to set
	 */
	public void setPlayerNum(int playerNum) {
		this.playerNum = playerNum;
	}

	/**
	 * @return the currentPlayerIndex
	 */
	public int getCurrentPlayerIndex() {
		return currentPlayerIndex;
	}

	/**
	 * @param currentPlayerIndex the currentPlayerIndex to set
	 */
	public void setCurrentPlayerIndex(int currentPlayerIndex) {
		this.currentPlayerIndex = currentPlayerIndex;
	}

	/**
	 * @return the gameMap
	 */
	public Map getGameMap() {
		return gameMap;
	}

	/**
	 * @param gameMap the gameMap to set
	 */
	public void setGameMap(Map gameMap) {
		this.gameMap = gameMap;
	}

	
	
}
