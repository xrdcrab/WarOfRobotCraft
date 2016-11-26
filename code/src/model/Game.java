package model;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;
import java.util.Timer;

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
     * @param playerHashMap
     * @param playerNumber
     * @param currentPlayer
     * @param map
     */
    public Game(HashMap<Integer, Player> playerHashMap,
            int playerNumber, int currentPlayer,
            Map map, int alivePlayerNumber) {
        super();

        this.playerNumber = playerNumber;
        this.playerHashMap = new HashMap<Integer, Player>();
        this.currentPlayerIndex = currentPlayer;
        this.gameMap = map;
        this.alivePlayerNumber = alivePlayerNumber;
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
    
    /**
     * this method is to run a play
     */
//	public void runPlay() {
//
//		while ( this.getAlivePlayerNum() > 1 ) {
//			if ( !this.getPlayerHashMap().get(this.getCurrentPlayerIndex()).isDead() ) {
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
    private boolean areAllRobotsPlayed(Player currentPlayer) {
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
        this.getPlayerHashMap().get(this.getCurrentPlayerIndex()).getCurrentRobot().setHasMoved(true);

        // enter the next play
        this.goNextPlayer();
        Player currentPlayer = getPlayerHashMap().get(this.getCurrentPlayerIndex());
        System.out.println(this.getCurrentPlayerIndex());
        if (getPlayerHashMap() == null) System.out.println("player map is null");
        if (currentPlayer == null) System.out.println("currentPlayer is null");
        currentPlayer.goNextRobot();

        // it is a new turn
        if (areAllRobotsPlayed(currentPlayer)) {
            currentPlayer.getScoutRobot().setHasMoved(false);
            currentPlayer.getSniperRobot().setHasMoved(false);
            currentPlayer.getTankRobot().setHasMoved(false);
            currentPlayer.goNextRobot();
        }

        currentPlayer.getCurrentRobot().resetStatus();

//            //if the current player's current robot has not moved
//		if(!this.getPlayerHashMap().get(this.getCurrentPlayerIndex()).getCurrentRobot().isHasMoved()){
//			this.getPlayerHashMap().get(this.getCurrentPlayerIndex()).getCurrentRobot().setHasMoved(true);
//			this.getPlayerHashMap().get(this.getCurrentPlayerIndex()).getCurrentRobot().resetStatus();
//			this.goNextPlayer();
//		}
//		//else if the current player's current robot has moved, end this turn. 
//		else{
//			
//		}
    }

    /**
     * this method is to update the game when player perform actions: move or
     * shoot
     *
     * @param pair the the pair that
     */
    public void updateGameShootDamaged(Pair<Coordinate, Integer> pair) {
        // update robots
        this.setAlivePlayerNumber(0);
        for (Integer key : playerHashMap.keySet()) {
            Player traversedPlayer = this.getPlayerHashMap().get(key);
            if (!traversedPlayer.isDead()) {
                // case 1: the scout robot is get damaged
                if (!traversedPlayer.getScoutRobot().isDead()
                        && traversedPlayer.getScoutRobot().getCoord().equals(pair.getKey())) {
                    traversedPlayer.getScoutRobot().damaged(pair.getValue());
                }
                // case 2: the sniper robot is get damaged
                if (!traversedPlayer.getSniperRobot().isDead()
                        && traversedPlayer.getSniperRobot().getCoord().equals(pair.getKey())) {
                    traversedPlayer.getSniperRobot().damaged(pair.getValue());
                }
                // case 3: the tank robot is get damaged
                if (!traversedPlayer.getTankRobot().isDead()
                        && traversedPlayer.getTankRobot().getCoord().equals(pair.getKey())) {
                    traversedPlayer.getTankRobot().damaged(pair.getValue());
                }
                this.setAlivePlayerNumber(this.getAlivePlayerNumber() + 1);
            }
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

        this.setAlivePlayerNumber(0);
        for (Integer key : playerHashMap.keySet()) {
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

}
