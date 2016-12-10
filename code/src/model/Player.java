package model;

import java.util.LinkedList;

import com.sun.org.apache.bcel.internal.generic.RETURN;

import javafx.util.Pair;
import model.Robot.RobotType;

/**
 * This is a model class of Player.
 *
 */
public class Player {

    String name;
    int score;
    Robot currentRobot;
    Robot scoutRobot;
    Robot sniperRobot;
    Robot tankRobot;

    /**
     * the view range for a player, which takes all the range from belonging
     * robots
     */
    private LinkedList<Coordinate> viewRangeList;

    public Player(String name,
            int score,
            Robot scoutRobot,
            Robot sniperRobot,
            Robot tankRobot,
            LinkedList<Coordinate> viewRangeList) {
        super();
        this.name = name;
        this.score = score;
        this.currentRobot = null;
        this.scoutRobot = scoutRobot;
        this.sniperRobot = sniperRobot;
        this.tankRobot = tankRobot;
        this.viewRangeList = viewRangeList;
    }

    /**
     * this constructor is used when a new player create when the game get
     * started
     *
     * @param coord
     * @param viewRangeList
     */
    public Player(Coordinate initialCoord, int mapSize, int playerIndex) {
        this.name = "";
        this.score = 0;
        this.currentRobot = null;
        this.scoutRobot = new Robot(
                RobotType.scout, "", 1, 1, 3, initialCoord, playerIndex, false, false, initialCoord.getRange(3, mapSize));
        this.sniperRobot = new Robot(
                RobotType.sniper, "", 2, 2, 2, initialCoord, playerIndex, false, false, initialCoord.getRange(3, mapSize));
        this.tankRobot = new Robot(
                RobotType.tank, "", 3, 3, 1, initialCoord, playerIndex, false, false, initialCoord.getRange(3, mapSize));
        this.viewRangeList = initialCoord.getRange(3, mapSize);

        this.goNextRobot(mapSize);
    }

    /**
     * this method is to determine whether all the robot are dead.
     * @return true if all robots are dead, false otherwise.
     */
    public boolean isDead() {
        return scoutRobot.isDead() && sniperRobot.isDead() && tankRobot.isDead();
    }

    /**
     * this method is to get current robot.
     * @return current robot
     */
    public Robot getCurrentRobot() {
        return currentRobot;
    }

    /**
     * this method is to set current robot.
     */
    public void goNextRobot(int mapSize) {
        this.scoutRobot.setViewRange(mapSize);
        this.sniperRobot.setViewRange(mapSize);
        this.tankRobot.setViewRange(mapSize);                
        if (!(scoutRobot.getHasPlayed()) && !scoutRobot.isDead()) {
            currentRobot = scoutRobot;
        } else if (!(sniperRobot.getHasPlayed()) && !sniperRobot.isDead()) {
            currentRobot = sniperRobot;
        } else if (!(tankRobot.getHasPlayed()) && !tankRobot.isDead()) {
            currentRobot = tankRobot;
        } else {
            currentRobot = null;
        }
        this.updateViewRange();
    }

    /**
     * This method is to update the view range of the robot.
     */
    public void updateViewRange() {

        // dump all the elements for the previous view range
        this.setViewRangeList(new LinkedList<Coordinate>());
        
        /**
         * get new range from a robot
         */
        LinkedList<Coordinate> newList = new LinkedList<Coordinate>();
        this.setViewRangeList(newList);
        // add the scout robot view range
        if (!this.getScoutRobot().isDead()){
            for (Coordinate coord : this.getScoutRobot().getViewRangeList()){
               if (!this.getViewRangeList().contains(coord)) {
                    this.getViewRangeList().add(coord);
                } 
            }   
        }
        // add the scout robot view range		
        if (!this.getSniperRobot().isDead()) {
            for (Coordinate coord : this.getSniperRobot().getViewRangeList()) {
                if (!this.getViewRangeList().contains(coord)) {
                    this.getViewRangeList().add(coord);
                }
            }
        }

        // add the scout robot view range
        if (!this.getTankRobot().isDead()) {
            for (Coordinate coord : this.getTankRobot().getViewRangeList()) {
                if (!this.getViewRangeList().contains(coord)) {
                    this.getViewRangeList().add(coord);
                }
            }
        }
        
    }

    /**
     * @return the name of player
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the score
     */
    public int getScore() {
        return score;
    }

    /**
     * @param score the score to set
     */
    public void setScore(int score) {
        this.score = score;
    }

    /**
     * @return the scoutRobot
     */
    public Robot getScoutRobot() {
        return scoutRobot;
    }

    /**
     * @param scoutRobot the scoutRobot to set
     */
    public void setScoutRobot(Robot scoutRobot) {
        this.scoutRobot = scoutRobot;
    }

    /**
     * @return the sniperRobot
     */
    public Robot getSniperRobot() {
        return sniperRobot;
    }

    /**
     * @param sniperRobot the sniperRobot to set
     */
    public void setSniperRobot(Robot sniperRobot) {
        this.sniperRobot = sniperRobot;
    }

    /**
     * @return the tankRobot
     */
    public Robot getTankRobot() {
        return tankRobot;
    }

    /**
     * @param tankRobot the tankRobot to set
     */
    public void setTankRobot(Robot tankRobot) {
        this.tankRobot = tankRobot;
    }

    /**
     * @param currentRobot the currentRobot to set
     */
    public void setCurrentRobot(Robot currentRobot) {
        this.currentRobot = currentRobot;
    }

    /**
     * @return the viewRangeList
     */
    public LinkedList<Coordinate> getViewRangeList() {
        return viewRangeList;
    }

    /**
     * @param viewRangeList the viewRangeList to set
     */
    public void setViewRangeList(LinkedList<Coordinate> viewRangeList) {
        this.viewRangeList = viewRangeList;
    }

    /**
     * this method will set all alive robots of this player to death
     *
     * @return nothing
     */
    public void surrender() {
        if (this.getScoutRobot().getHealthPoint() > 0) {
            this.getScoutRobot().setHealthPoint(0);
        }
        if (this.getSniperRobot().getHealthPoint() > 0) {
            this.getSniperRobot().setHealthPoint(0);
        }
        if (this.getTankRobot().getHealthPoint() > 0) {
            this.getTankRobot().setHealthPoint(0);
        }
    }

    @Override
    public String toString() {
        if (this.getCurrentRobot().equals(scoutRobot)) {
            return "scout";
        } else if (this.getCurrentRobot().equals(sniperRobot)) {
            return "sniper";
        } else if (this.getCurrentRobot().equals(tankRobot)) {
            return "tank";
        }
        return "something wrong";
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
