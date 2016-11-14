package model;

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
	
	public Player(String name, int score, Robot scoutRobot, Robot sniperRobot, Robot tankRobot) {
		super();
		this.name = name;
		this.score = score;
		this.currentRobot = null;
		this.scoutRobot = scoutRobot;
		this.sniperRobot = sniperRobot;
		this.tankRobot = tankRobot;
	}

	/**
	 * this method is to determine whether all the robot are dead. 
	 */
	public boolean isDead(){
		return scoutRobot.isDead() && sniperRobot.isDead() && tankRobot.isDead();
	}
	
	/**
	 * this method is to get current robot.
	 */
	public Robot getCurrentRobot(){
		return currentRobot;
	}
	
	/**
	 * this method is to set current robot.
	 */
	public void goNextRobot(){
		if(!(scoutRobot.isHasMoved()&&scoutRobot.isHasShot())){
			currentRobot = scoutRobot;
		}
		else if(!(sniperRobot.isHasMoved()&&sniperRobot.isHasShot())){
			currentRobot = sniperRobot;
		}
		else if(!(tankRobot.isHasMoved()&&tankRobot.isHasShot())){
			currentRobot = tankRobot;
		}
		else{
			currentRobot = null;
		}
	}

	/**
	 * @return the name
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
	
	

}
