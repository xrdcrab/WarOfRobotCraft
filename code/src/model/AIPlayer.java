package model;

import java.util.EventObject;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Vector;

import aiutil.RealInterpreter;
import javafx.util.Pair;

public class AIPlayer extends Player {

    /**
     * all the enemy robots with coordinate
     */
    private HashMap<Coordinate, LinkedList<Robot>> enemyMap;
    
    private int mapSize; 	
	
    /**
     * this constructor is to construct the AI player with all parameters
     *
     * @param name
     * @param score
     * @param scoutRobot
     * @param sniperRobot
     * @param tankRobot
     * @param viewRangeList
     */
    public AIPlayer(String name,
            int score,
            Robot scoutRobot,
            Robot sniperRobot,
            Robot tankRobot,
            LinkedList<Coordinate> viewRangeList,
            HashMap<Coordinate, Robot> enemyMap) {
        super(name, score, scoutRobot, sniperRobot, tankRobot, viewRangeList);
        this.enemyMap = new HashMap<Coordinate, LinkedList<Robot>>();
    }

    /**
     * this constructor is to construct the AI player with initial coordinate
     * and the map size
     *
     * @param initialCoord the initial coordinate for the player
     * @param mapSize the map size for the game
     */
    public AIPlayer(Coordinate initialCoord, int mapSize, int playerIndex) {
        super(initialCoord, mapSize, playerIndex);
        this.enemyMap = new HashMap<Coordinate, LinkedList<Robot>>();
    }

    /**
     * this method is to scan all the coordinates the player can see, then store
     * the enemies' robots in the enemyMap.
     */
    public void scan(HashMap<Coordinate, LinkedList<Robot>> robotMap) {
        this.enemyMap = new HashMap<Coordinate, LinkedList<Robot>>();
        for (Coordinate coord : super.getViewRangeList()) {
            if (robotMap.containsKey(coord)) {
                LinkedList<Robot> robotList = new LinkedList<Robot>();
                if (robotList.addAll(robotMap.get(coord))) {
                    this.getEnemyMap().put(coord, robotList);
                };
            }
        }
    }

    /**
     * @return the enemyMap
     */
    public HashMap<Coordinate, LinkedList<Robot>> getEnemyMap() {
        return enemyMap;
    }

    /**
     * @param enemyMap the enemyMap to set
     */
    public void setEnemyMap(HashMap<Coordinate, LinkedList<Robot>> enemyMap) {
        this.enemyMap = enemyMap;
    }

    private Vector vectorListeners = new Vector();

    public synchronized void addAIEventListener(AIEventListener ml) {
        vectorListeners.addElement(ml);
    }

    public synchronized void removeAIEventListener(AIEventListener ml) {
        vectorListeners.removeElement(ml);
    }

    protected void activateAIEvent(String actionString, int value) {
        Vector tempVector = null;

        AIEvent e = new AIEvent(this);
        e.setActionString(actionString);
        e.setValue(value);

        synchronized (this) {
            tempVector = (Vector) vectorListeners.clone();

            for (int i = 0; i < tempVector.size(); i++) {
                AIEventListener ml = (AIEventListener) tempVector.elementAt(i);
                ml.EventActivated(e);
            }
        }

    }

    public void activateEvent(String actionString, int value){
        activateAIEvent(actionString, value);
    }
    
    @Override
    public void move(int mapSize){
    	super.move(mapSize);
    	activateEvent("move", -1);  
    	try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    @Override
    public void turn(int direction){
    	super.turn(direction);
    	activateEvent("turn", direction);    
    	try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    @Override
    public Pair<Coordinate, Integer> shoot(int distance, int mapSize){
		Pair<Coordinate, Integer> pair = super.shoot(distance, mapSize);
		activateEvent("shoot", distance);
		return pair;
	}

    
    public void startPlay(){
    	 this.getCurrentRobot().getCode();
    	 new RealInterpreter().run(this);
    	
    	activateEvent("end play", -1);
    }
    
    
    
}
