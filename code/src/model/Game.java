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
	private int playerNumber;
	
	/** the current player for the game */
	private int currentPlayerIndex;
	
	/** the map for the game */
	private Map gameMap;

	/** the number of alive player */
	private int alivePlayerNumber;
	
	/**
	 * @param playerMap
	 * @param playerNumber
	 * @param currentPlayer
	 * @param map
	 */
	public Game(HashMap<Integer, Player> playerMap, 
			int playerNumber, int currentPlayer, 
			Map map, int alivePlayerNumber) {
		super();
		
		this.playerNumber = playerNumber;
		this.playerMap = new HashMap<Integer, Player>();
		this.currentPlayerIndex = currentPlayer;
		this.gameMap = map;
		this.alivePlayerNumber = alivePlayerNumber;
	}
	
	/**
	 * this method is to overload the constructor above with two parameters
	 * @param playerMap
	 * @param playerNumber
	 */
	public Game(HashMap<Integer, Player> playerMap, int playerNumber) {
		super();
		
		this.playerNumber = playerNumber;
		this.playerMap = new HashMap<Integer, Player>();
		this.gameMap = new Map(playerNumber);
		this.currentPlayerIndex = -1;
		this.alivePlayerNumber = this.playerNumber;
	}
	
	/**
	 * This method is to go next player. 
	 * @precondition 0<=currentPlayerIndex<5
	 * @precondition  currentPlayerIndex>=5 or currentPlayerIndex<0
	 */
	public void goNextPlayer(){
		if (this.getCurrentPlayerIndex() < 0||this.currentPlayerIndex >= this.playerNumber){
			this.setCurrentPlayerIndex(0);
			this.setAlivePlayerNumber(0);
		}
		else{
			this.setCurrentPlayerIndex(this.currentPlayerIndex + 1);
			if (!this.getPlayerMap().get(this.getCurrentPlayerIndex()).isDead()) {
				this.setAlivePlayerNumber(this.getAlivePlayerNumber() + 1);
			}			
		}		
	}

	/**
	 * this method is to run a play
	 */
//	public void runPlay() {
//
//		while ( this.getAlivePlayerNum() > 1 ) {
//			if ( !this.getPlayerMap().get(this.getCurrentPlayerIndex()).isDead() ) {
//				try {
//					this.wait();
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//			
//			this.goNextPlayer();
//		}
//	}
	
        private boolean areAllRobotsPlayed(Player currentPlayer){
            boolean scoutPlayed = currentPlayer.getScoutRobot().isHasMoved();
            boolean sniperPlayed = currentPlayer.getScoutRobot().isHasMoved();
            boolean tankPlayed = currentPlayer.getTankRobot().isHasMoved();
            
            return scoutPlayed && sniperPlayed && tankPlayed;
        }
        
	/**
	 * 
	 */
	public void runPlay() {
            // end the current play
            this.getPlayerMap().get(this.getCurrentPlayerIndex()).getCurrentRobot().setHasMoved(true);
            
            // enter the next play
            this.goNextPlayer();
            
            Player currentPlayer = getPlayerMap().get(this.getCurrentPlayerIndex());
            
            // it is a new turn
            if(areAllRobotsPlayed(currentPlayer)){
                currentPlayer.getScoutRobot().setHasMoved(false);
                currentPlayer.getSniperRobot().setHasMoved(false);
                currentPlayer.getTankRobot().setHasMoved(false);
            }
            
            currentPlayer.getCurrentRobot().resetStatus();
            
//            //if the current player's current robot has not moved
//		if(!this.getPlayerMap().get(this.getCurrentPlayerIndex()).getCurrentRobot().isHasMoved()){
//			this.getPlayerMap().get(this.getCurrentPlayerIndex()).getCurrentRobot().setHasMoved(true);
//			this.getPlayerMap().get(this.getCurrentPlayerIndex()).getCurrentRobot().resetStatus();
//			this.goNextPlayer();
//		}
//		//else if the current player's current robot has moved, end this turn. 
//		else{
//			
//		}
	}
	
	
	
	
	
	
	/**
	 * this method is to update the game when player perform actions: move or shoot
	 * 
	 * @param pair the the pair that
	 */
	public void updateGameShoot(Pair<Coordinate, Integer> pair) {
		// update robots
		this.setAlivePlayerNumber(0);
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
				this.setAlivePlayerNumber(this.getAlivePlayerNumber() + 1);
			}			
		}
	}
	
	/**
	 * this method is to update the game when the current player moving
	 * @param currentPlayer the current player execute moving
	 */
	public void updateGameMove(Player currentPlayer) {
		this.getGameMap().updateMist(currentPlayer);
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
	 * @return the playerNumber
	 */
	public int getPlayerNumber() {
		return playerNumber;
	}

	/**
	 * @param playerNumber the playerNumber to set
	 */
	public void setPlayerNumber(int playerNumber) {
		this.playerNumber = playerNumber;
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
	 * @return the alivePlayerNumber
	 */
	public int getAlivePlayerNumber() {
		return alivePlayerNumber;
	}

	/**
	 * @param alivePlayerNumber the alivePlayerNumber to set
	 */
	public void setAlivePlayerNumber(int alivePlayerNumber) {
		this.alivePlayerNumber = alivePlayerNumber;
	}

	
	
}
