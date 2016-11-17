package controller;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;
import java.util.LinkedList;

import javafx.util.Pair;
import model.*;
import view.*;

/**
 * this class is to build up the controller to control the game system
 */
public class Controller implements ActionListener, KeyListener {
	private enum OperationMode{move, shoot, turn}
	
	private Game game;
	private GameStartView gameStartView;
	private SetGameModeView setGameModeView;
	
	//private boolean isMoveMode;
	//private boolean isShootMode;
	//private boolean isTurnMode;
	private OperationMode operationMode;
	

	private int shootDistance;
	private Pair<Coordinate, Integer> shootTarget;
	
	/**
	 * this constructor is for the game entry point
	 * 
	 * @param gameStartView the start view for the game system
	 */
	public Controller() {
		super();

		this.gameStartView = new GameStartView();
		this.getGameStartView().setVisible(true);
		this.addListener();
	}

	/**
	 * this method is to add listener for all buttons
	 */
	private void addListener() {
		this.getGameStartView().getExitButton().addActionListener(this);
		this.getGameStartView().getStartButton().addActionListener(this);
		this.getGameStartView().getGarageButton().addActionListener(this);
		this.getSetGameModeView().getConfirmButton().addActionListener(this);
	}
	
	/**
	 * @return the game
	 */
	public Game getGame() {
		return game;
	}

	/**
	 * @param game the game to set
	 */
	public void setGame(Game game) {
		this.game = game;
	}

	/**
	 * @return the gameStartView
	 */
	public GameStartView getGameStartView() {
		return gameStartView;
	}

	/**
	 * @param gameStartView the gameStartView to set
	 */
	public void setGameStartView(GameStartView gameStartView) {
		this.gameStartView = gameStartView;
	}

	/**
	 * @return the setGameModelView
	 */
	public SetGameModeView getSetGameModeView() {
		return setGameModeView;
	}

	/**
	 * @param setGameModelView the setGameModelView to set
	 */
	public void setSetGameModeView(SetGameModeView setGameModeView) {
		this.setGameModeView = setGameModeView;
	}
	
	/**
	 * this method will get the Operation Mode
	 * @return operationMode
	 */
	public OperationMode getOperationMode() {
		return operationMode;
	}
	
	/**
	 * this method is to set Operation Mode
	 * @param operationMode
	 */
	public void setOperationMode(OperationMode operationMode) {
		this.operationMode = operationMode;
	}
	
	/**
	 * @return the isMoveMode
	 */
//	public boolean isMoveMode() {
//		return this.isMoveMode;
//	}
	
	/**
	 * @return true if the operation mode is move mode, false otherwise
	 */
	public boolean isMoveMode() {
		return this.operationMode == OperationMode.move;
	}

	/**
	 * @param isMoveMode the isMoveMode to set
	 */
//	public void setMoveMode(boolean isMoveMode) {
//		this.isMoveMode = isMoveMode;
//	}

	/**
	 * @return the isShootMode
	 */
//	public boolean isShootMode() {
//		return this.isShootMode;
//	}
	
	/**
	 * @return true if the Operation Mode is shoot mode
	 */
	public boolean isShootMode() {
		return this.operationMode == OperationMode.shoot;
	}

	/**
	 * @param isShootMode the isShootMode to set
	 */
//	public void setShootMode(boolean isShootMode) {
//		this.isShootMode = isShootMode;
//	}
	
	/**
	 * @return the isTurnMode
	 */
//	public boolean isTurnMode() {
//		return this.isTurnMode;
//	}

	/**
	 * @return the true if the Operation Mode is turn mode
	 */
	public boolean isTurnMode() {
		return this.operationMode == OperationMode.turn;
	}

	/**
	 * @param isTurnMode the isTurnMode to set
	 */
//	public void setTurnMode(boolean isTurnMode) {
//		this.isTurnMode = isTurnMode;
//	}
	
	/**
	 * @return the shootDistance
	 */
	public int getShootDistance() {
		return shootDistance;
	}

	/**
	 * @param shootDistance the shootDistance to set
	 */
	public void setShootDistance(int shootDistance) {
		this.shootDistance = shootDistance;
	}

	/**
	 * @return the shootTarget
	 */
	public Pair<Coordinate, Integer> getShootTarget() {
		return shootTarget;
	}

	/**
	 * @param shootTarget the shootTarget to set
	 */
	public void setShootTarget(Pair<Coordinate, Integer> shootTarget) {
		this.shootTarget = shootTarget;
	}

	/**
	 * this method is to define the action for each button when clicked
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		
		// start game button
		if ( e.getSource().equals(this.getGameStartView().getStartButton()) ) {
			this.getGameStartView().setVisible(false);
			this.setGameModeView = new SetGameModeView();
			this.getSetGameModeView().setVisible(true);
		} 
		// garage button
		else if ( e.getSource().equals(null) ) {
			
		}
		// exit button
		else if ( e.getSource().equals(this.getGameStartView().getExitButton()) ) {
			System.exit(0);
		}
		// confirm button
		else if ( e.getSource().equals(this.getSetGameModeView().getConfirmButton() ) ) {
			int playerNum = -1;
			HashMap<Integer, Player> playerMap = new HashMap<Integer, Player>();
			
			if ( this.getSetGameModeView().getTwoPlayersRadioButton().isSelected() ) {
				playerNum = 2;
				//playerMap.put(0, new Player("", 0, new Robot()));
			}
			else if ( this.getSetGameModeView().getThreePlayersRadioButton().isSelected() ) {
				playerNum = 3;
			}
			else if ( this.getSetGameModeView().getSixPlayersRadioButton().isSelected() ) {
				playerNum = 6;
			}
			
			
			
			if ( playerNum != -1 ) {
				//this.setGame(new Game(playerNum, ));
			}
			
			
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		LinkedList<Integer> numberList = new LinkedList<Integer>();
		//numberList.add(Integer.parseUnsignedInt(e.getKeyChar(), 0));
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// go the next player when a play finished
		if ( e.getKeyCode() == KeyEvent.VK_SPACE ) {
			this.getGame().goNextPlayer();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
		// move 
		if ( e.getKeyChar() == 'm' || e.getKeyChar() == 'M' ) {
			// move the current robot of the current player
			try {
				this.getGame().getPlayerMap().get(this.getGame().getCurrentPlayerIndex())
					.getCurrentRobot().move(
						this.getGame().getGameMap().getMapSize());
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			// update the game after the move action
			this.getGame().updateGameMove(
					this.getGame().getPlayerMap().get(this.getGame().getCurrentPlayerIndex()));
		}
		// shoot
		else if ( e.getKeyChar() == 's' || e.getKeyChar() == 'S' ) {
			// the current robot of the current player shoot
			try {
				this.getGame().getPlayerMap().get(this.getGame().getCurrentPlayerIndex())
					.getCurrentRobot().shoot(this.getShootDistance(), 
											this.getGame().getGameMap().getMapSize());
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			// update the game after the shoot action
			this.getGame().updateGameShoot(this.getShootTarget());
		}
		// turn
		else if ( e.getKeyChar() == 't' || e.getKeyChar() == 'T' ) {
			// the current robot of the current player shoot
			try {
				this.getGame().getPlayerMap().get(this.getGame().getCurrentPlayerIndex())
					.getCurrentRobot().turn(direction);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			// update the game after the shoot action
			this.getGame().updateGameMove(currentPlayer);
		}
		
	}


}
