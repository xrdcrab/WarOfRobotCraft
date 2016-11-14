package model;

/**
 * @author HJH
 *
 */
public class Player {
	
	String name;
	int score;
	Robot currentRobot;
	Robot scoutRobot;
	Robot sniperRobot;
	Robot tankRobot;
	
	public boolean isDead(){
		return scoutRobot.isDead() && sniperRobot.isDead() && tankRobot.isDead();
	}
	
	public Robot getCurrentRobot(){
		return currentRobot;
	}
	
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
	
	

}
