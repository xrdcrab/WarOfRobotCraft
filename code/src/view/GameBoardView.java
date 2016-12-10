/*
 * Name: Ruida Xie
 * NSID: rux793
 * Student Number: 11194258
 */
package view;

import java.util.HashMap;

/**
 * @author ruidaxie
 *
 */
public interface GameBoardView {
	 public void updateTimerNumber(int number);
	 public void updateMist(HashMap<String, Boolean> hashMap);
	 public void updateOperationState(String state);
	 public void updateRobotDestruction(int playerPosition, String RobotType);
	 public void updateCurrentRobot(String robotType);
	 public void updateRobotDamaged(int playerPosition, String robotType, int attackPoint);
	 public void updatePlayerDeath(int playerPosition);
	 public void updateRobotTurned(int playerPosition, String robotType, int direction);
	 public void updateCurrentPlayer(int playerPosition);
	 public void updateRobotLocation(int playerPosition, String RobotType, String coordString);
	 public javax.swing.JButton getEndPlayButton();
	 public javax.swing.JButton getGiveUpButton();
	 public javax.swing.JButton getHomeButton();
	 public void setVisible(boolean b);
	 public void initializeRobotPanel(int playerNum);
	 

}
