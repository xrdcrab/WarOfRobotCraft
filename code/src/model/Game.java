package model;

import java.util.HashMap;
import java.util.LinkedList;
import javafx.util.Pair;

/**
 * this class is to build up the game, then players can play the game in turns
 */
public class Game {

    /**
     * player list to hold all players
     */
    //private LinkedList<Player> playerList;
    private HashMap<Integer, Player> playerHashMap;

    /**
     * the number of players within the game
     */
    private int playerNumber;

    /**
     * the current player for the game
     */
    private int currentPlayerIndex;

    /**
     * the map for the game
     */
    private Map gameMap;

    /**
     * the number of alive player
     */
    private int alivePlayerNumber;
    
    /**
     * the winner player index
     */
    public int winnerPlayerIndex;
    

	/**
	 * the constructor
     * @param playerHashMap
     * @param playerNumber
     * @param currentPlayer
     * @param map
     */
    public Game(HashMap<Integer, Player> playerHashMap,
            int playerNumber, int currentPlayer,
            Map map, int alivePlayerNumber, int winnerPlayerIndex) {
        super();

        this.playerNumber = playerNumber;
        this.playerHashMap = new HashMap<Integer, Player>();
        this.currentPlayerIndex = currentPlayer;
        this.gameMap = map;
        this.alivePlayerNumber = alivePlayerNumber;
        this.winnerPlayerIndex = winnerPlayerIndex;
    }

    /**
     * this method is to overload the constructor above with two parameters
     *
     * @param playerHashMap
     * @param playerNumber
     */
    public Game(HashMap<Integer, Player> playerHashMap, int playerNumber) {
        super();

        this.playerNumber = playerNumber;
        this.playerHashMap = new HashMap<Integer, Player>();
        for ( int key: playerHashMap.keySet() ) {
        	this.getPlayerHashMap().put(key, playerHashMap.get(key));
        }
        this.gameMap = new Map(this.playerNumToMapSize(playerNumber));
        this.currentPlayerIndex = 0;
        this.alivePlayerNumber = this.playerNumber;
        this.winnerPlayerIndex = 99;
    }

    /**
     * this method is to shift the number of player to the map size accordingly
     *
     * @param playerNum the number of player that the game has
     * @return mapSize the map size corresponding to the number of player
     */
    private int playerNumToMapSize(int playerNum) {
        int mapSize = -1;

        switch (playerNum) {
            case 2:
                mapSize = 5;
                break;
            case 3:
                mapSize = 5;
                break;
            case 6:
                mapSize = 7;
                break;
            default:
                mapSize = -1;
        }

        return mapSize;
    }

    /**
     * This method is to go next player.
     *
     * @precondition 0<=currentPlayerIndex<5
     * @precondition currentPlayerIndex>=5 or currentPlayerIndex<0
     */
    public void goNextPlayer() {
        if ( this.getCurrentPlayerIndex() < 0 ) {
            this.setCurrentPlayerIndex(0);
            this.setAlivePlayerNumber(0);
        } else {
            switch ( playerNumber ) {
                case 2:
                    this.goNextPlayerHelper(currentPlayerIndex, 3, 2);
                    break;
                case 3:
                	this.goNextPlayerHelper(currentPlayerIndex, 2, 3);
                    break;
                case 6:
                    this.goNextPlayerHelper(currentPlayerIndex, 1, 6);
                    break;
                default:
                    break;
            }
        }
    }

    /**
     * this method is to help the goNextPlayer() method in each case
     * @param currentPlayerIndex the current player index
     * @param step 1 for 6 players, 2 for 3 player and 3 for 2 players
     * @param playerNum the number of players in the game
     */
    private void goNextPlayerHelper(int currentPlayerIndex, int step, int playerNum) {
    	if ( this.getAlivePlayerNumber() > 1 ) {
    		do {
        		if ( this.getCurrentPlayerIndex() < step * ( playerNum - 1 ) ) {
        			this.setCurrentPlayerIndex(this.getCurrentPlayerIndex() + step);
        		} 
        		else {
        			this.setCurrentPlayerIndex(0);
        		}
        	}
        	while (this.getPlayerHashMap().get(this.getCurrentPlayerIndex()).isDead());
    	}
    }
    
    
    /**
     * this method is a helper function to determine
     * whether all robots of one player are played.
     * @param currentPlayer
     * @return true if all robots are played.
     */
    private boolean areAllRobotsPlayed(Player currentPlayer) {
        boolean scoutPlayed = currentPlayer.getScoutRobot().getHasPlayed() || currentPlayer.getScoutRobot().isDead();
        boolean sniperPlayed = currentPlayer.getSniperRobot().getHasPlayed() || currentPlayer.getSniperRobot().isDead();
        boolean tankPlayed = currentPlayer.getTankRobot().getHasPlayed() || currentPlayer.getTankRobot().isDead();

        return scoutPlayed && sniperPlayed && tankPlayed;
    }

    /**
     * this method will run the game in the data level,
     * update current robot, current plater and determine the winner.
     */
    public void runPlay() {
        // end the current play if more than one player alive
    	if (this.getAlivePlayerNumber() > 1){
    		this.getPlayerHashMap().get(this.getCurrentPlayerIndex()).getCurrentRobot().sethasPlayed(true);

            // enter the next play
            this.goNextPlayer();
            Player currentPlayer = getPlayerHashMap().get(this.getCurrentPlayerIndex());            
            currentPlayer.goNextRobot(this.getGameMap().getMapSize());
            
            if(currentPlayer instanceof AIPlayer){
            	new Runnable() {
					public void run() {
						((AIPlayer)currentPlayer).startPlay();
					}
				}.run();      	
            }
            
            // it is a new turn
            if (areAllRobotsPlayed(currentPlayer)) {
                currentPlayer.getScoutRobot().sethasPlayed(false);
                currentPlayer.getSniperRobot().sethasPlayed(false);
                currentPlayer.getTankRobot().sethasPlayed(false);
                currentPlayer.goNextRobot(this.getGameMap().getMapSize());
            }
            
            if ( currentPlayer != null && currentPlayer.getCurrentRobot() != null ) {
            	currentPlayer.getCurrentRobot().resetStatus();
            }
    	}
    	
    	this.updateWinerIndex();
        System.out.println("the winner is: player " + this.getWinnerPlayerIndex());
		
    }
    
    /**
     * this method is to update the winner index
     */
    private void updateWinerIndex () {
    	if (this.getAlivePlayerNumber() == 1){
			// find the winner
    		// case 1: 2 players in the game
    		if (this.getPlayerNumber() == 2) {
				if ( !this.getPlayerHashMap().get(0).isDead() ) {
					this.setWinnerPlayerIndex(0);
				}
				else {
					this.setWinnerPlayerIndex(3);
				}
			}
    		// case 2: 3 players in the game
    		else if (this.getPlayerNumber() == 3) {
    			if ( !this.getPlayerHashMap().get(0).isDead() ) {
    				this.setWinnerPlayerIndex(0);
				}
				else if ( !this.getPlayerHashMap().get(2).isDead() ){
					this.setWinnerPlayerIndex(2);
				}
				else {
					this.setWinnerPlayerIndex(4);
				}
			}
    		// case 3: 6 players in the game
    		else if (this.getPlayerNumber() == 6) {
    			if ( !this.getPlayerHashMap().get(0).isDead() ) {
    				this.setWinnerPlayerIndex(0);
				}
				else if ( !this.getPlayerHashMap().get(1).isDead() ){
					this.setWinnerPlayerIndex(1);
				}
				else if ( !this.getPlayerHashMap().get(2).isDead() ){
					this.setWinnerPlayerIndex(2);
				}
				else if ( !this.getPlayerHashMap().get(3).isDead() ){
					this.setWinnerPlayerIndex(3);
				}
				else if ( !this.getPlayerHashMap().get(4).isDead() ){
					this.setWinnerPlayerIndex(4);
				}
				else {
					this.setWinnerPlayerIndex(5);
				}
			}
    	}
    }

    /**
     * this method is to update the game when player perform actions: 
     * move or shoot
     * @param pair the the pair that contains dead robot information
     * @return LinkedList<Pair<Integer, String>> a linked list of pair
     */
    public LinkedList<Pair<Integer, String>> updateGameShootDamaged(Pair<Coordinate, Integer> pair) {
    	LinkedList<Pair<Integer, String>> deadRobotList
        					= new LinkedList<Pair<Integer, String>>();
    	// update robots
        this.setAlivePlayerNumber(0);
        for (Integer key : playerHashMap.keySet()) {
            Player traversedPlayer = this.getPlayerHashMap().get(key);
            if (!traversedPlayer.isDead()) {
                // case 1: the scout robot is get damaged
                if (!traversedPlayer.getScoutRobot().isDead()
                        && traversedPlayer.getScoutRobot().getCoord().equals(pair.getKey())) {
                    traversedPlayer.getScoutRobot().damaged(pair.getValue());
                    if ( traversedPlayer.getScoutRobot().isDead() ) {
                    	deadRobotList.add(new Pair<Integer, String>(key,"Scout"));
                    }
                }
                // case 2: the sniper robot is get damaged
                if (!traversedPlayer.getSniperRobot().isDead()
                        && traversedPlayer.getSniperRobot().getCoord().equals(pair.getKey())) {
                    traversedPlayer.getSniperRobot().damaged(pair.getValue());
                    if ( traversedPlayer.getSniperRobot().isDead() ) {
                    	deadRobotList.add(new Pair<Integer, String>(key,"Sniper"));
                    }
                }
                // case 3: the tank robot is get damaged
                if (!traversedPlayer.getTankRobot().isDead()
                        && traversedPlayer.getTankRobot().getCoord().equals(pair.getKey())) {
                    traversedPlayer.getTankRobot().damaged(pair.getValue());
                    if ( traversedPlayer.getTankRobot().isDead() ) {
                    	deadRobotList.add(new Pair<Integer, String>(key,"Tank"));
                    }
                }
                
                if (!traversedPlayer.isDead()) {
                	this.setAlivePlayerNumber(this.getAlivePlayerNumber() + 1);
                } 
            }          
        }
        System.out.println("alive player number:" + this.getAlivePlayerNumber());
        this.updateWinerIndex();
        
        if ( !deadRobotList.isEmpty() ) {
        	return deadRobotList;
        }
        else {
        	return null;
        }
    }

    /**
     * this method is to get the dead robot that shot by other robot
     *
     * @param pair the coordinate and the damage point that a robot got
     * @return deadRobotList the dead robots list
     */
    public LinkedList<Pair<Integer, String>> updateGameShootDead(Pair<Coordinate, Integer> pair) {
        LinkedList<Pair<Integer, String>> deadRobotList
                = new LinkedList<Pair<Integer, String>>();
        
        HashMap<Integer, String> deadRobotMap 
        		= new HashMap<Integer, String>();
        
        this.setAlivePlayerNumber(0);
        for (int key : playerHashMap.keySet()) {
            Player traversedPlayer = this.getPlayerHashMap().get(key);
            if (!traversedPlayer.isDead()) {
                // case 1: the scout robot is get damaged 
                if (!traversedPlayer.getScoutRobot().isDead()
                        && traversedPlayer.getScoutRobot().getCoord().equals(pair.getKey())) {
                    traversedPlayer.getScoutRobot().damaged(pair.getValue());
                    if (traversedPlayer.getScoutRobot().isDead()) {
                        deadRobotList.add(new Pair<Integer, String>(key,
                                traversedPlayer.getScoutRobot().getType().toString()));
                    }
                }
                // case 2: the sniper robot is get damaged 
                if (!traversedPlayer.getSniperRobot().isDead()
                        && traversedPlayer.getSniperRobot().getCoord().equals(pair.getKey())) {
                    traversedPlayer.getSniperRobot().damaged(pair.getValue());
                    if (traversedPlayer.getSniperRobot().isDead()) {
                        deadRobotList.add(new Pair<Integer, String>(key,
                                traversedPlayer.getSniperRobot().getType().toString()));
                    }
                }
                // case 3: the tank robot is get damaged 
                if (!traversedPlayer.getTankRobot().isDead()
                        && traversedPlayer.getTankRobot().getCoord().equals(pair.getKey())) {
                    traversedPlayer.getTankRobot().damaged(pair.getValue());
                    if (traversedPlayer.getTankRobot().isDead()) {
                        deadRobotList.add(new Pair<Integer, String>(key,
                                traversedPlayer.getTankRobot().getType().toString()));
                    }
                }
                this.setAlivePlayerNumber(this.getAlivePlayerNumber() + 1);
            }
        }

        return deadRobotList;
    }

    /**
     * this method is to update the game when the current player moving
     *
     * @param currentPlayer the current player execute moving
     */
    public void updateGameMove(Player currentPlayer) {
        this.getGameMap().updateMist(currentPlayer);
    }

    /**
     * @return the playerHashMap
     */
    public HashMap<Integer, Player> getPlayerHashMap() {
        return this.playerHashMap;
    }

    /**
     * @param playerHashMap the playerHashMap to set
     */
    public void setPlayerHashMap(HashMap<Integer, Player> playerHashMap) {
        this.playerHashMap = playerHashMap;
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
    
    /**
	 * @return the winnerPlayerIndex
	 */
	public int getWinnerPlayerIndex() {
		return winnerPlayerIndex;
	}

	/**
	 * @param winnerPlayerIndex the winnerPlayerIndex to set
	 */
	public void setWinnerPlayerIndex(int winnerPlayerIndex) {
		this.winnerPlayerIndex = winnerPlayerIndex;
	}

}
