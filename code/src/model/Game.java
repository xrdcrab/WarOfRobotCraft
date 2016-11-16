package model;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.Timer;

import javafx.util.Pair;

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

	/** the number of alive player */
	private int alivePlayerNum;
	
	/**
	 * @param playerMap
	 * @param playerNum
	 * @param currentPlayer
	 * @param map
	 */
	public Game(HashMap<Integer, Player> playerMap, 
			int playerNum, int currentPlayer, 
			Map map, int alivePlayerNum) {
		super();
		
		this.playerNum = playerNum;
		this.playerMap = new HashMap<Integer, Player>();
		this.currentPlayerIndex = currentPlayer;
		this.gameMap = map;
		this.alivePlayerNum = alivePlayerNum;
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
		this.alivePlayerNum = this.playerNum;
	}
	
	/**
	 * This method is to go next player. 
	 * @precondition 0<=currentPlayerIndex<5
	 * @precondition  currentPlayerIndex>=5 or currentPlayerIndex<0
	 */
	public void goNextPlayer(){
		if (this.getCurrentPlayerIndex()<0||this.currentPlayerIndex>=5){
			this.setCurrentPlayerIndex(0);
			this.setAlivePlayerNum(0);
		}
		else{
			this.setCurrentPlayerIndex(this.currentPlayerIndex+1);
			if (!this.getPlayerMap().get(this.getCurrentPlayerIndex()).isDead()) {
				this.setAlivePlayerNum(this.getAlivePlayerNum() + 1);
			}			
		}		
	}

	/**
	 * this method is to run a play
	 */
	public void runPlay() {

		while ( this.getAlivePlayerNum() > 1 ) {
			if ( !this.getPlayerMap().get(this.getCurrentPlayerIndex()).isDead() ) {
				try {
					this.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			this.goNextPlayer();
		}
	}
	
	/**
	 * this method is to update the game when player perform actions: move or shoot
	 * 
	 * @param pair the the pair that
	 */
	public void updateGame(Pair<Coordinate, Integer> pair) {
		// update robots
		this.setAlivePlayerNum(0);
		for ( Integer key: playerMap.keySet() ) {
			Player traversedPlayer = this.getPlayerMap().get(key);
			if ( !traversedPlayer.isDead() ) {
				// case 1: the scout robot is get damaged
				if ( !traversedPlayer.getScoutRobot().isDead() 
						&& traversedPlayer.getScoutRobot().getCoord().equals(pair.getKey()) ) {
					traversedPlayer.getScoutRobot().damaged(pair.getValue());
				}
				// case 2: the sniper robot is get damaged
				if ( !traversedPlayer.getSniperRobot().isDead() 
						&& traversedPlayer.getSniperRobot().getCoord().equals(pair.getKey()) ) {
					traversedPlayer.getSniperRobot().damaged(pair.getValue());
				}
				// case 3: the tank robot is get damaged
				if ( !traversedPlayer.getTankRobot().isDead() 
						&& traversedPlayer.getTankRobot().getCoord().equals(pair.getKey()) ) {
					traversedPlayer.getTankRobot().damaged(pair.getValue());
				}
				this.setAlivePlayerNum(this.getAlivePlayerNum() + 1);
			}			
		}
		
		// update map
		
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

	/**
	 * @return the alivePlayerNum
	 */
	public int getAlivePlayerNum() {
		return alivePlayerNum;
	}

	/**
	 * @param alivePlayerNum the alivePlayerNum to set
	 */
	public void setAlivePlayerNum(int alivePlayerNum) {
		this.alivePlayerNum = alivePlayerNum;
	}

	
	
}
