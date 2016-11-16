package controller;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;

import model.*;
import view.*;

/**
 * this class is to build up the controller to control the game system
 */
public class Controller implements ActionListener, KeyListener {

	private Game game;
	private GameStartView gameStartView;
	private SetGameModeView setGameModeView;
	
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
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
		// move 
		if ( e.getKeyCode() == 'M') {
			try {
				this.getGame().getPlayerMap().get(this.getGame().getCurrentPlayerIndex())
					.getCurrentRobot().move(
						this.getGame().getGameMap().getMapSize());
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		// shoot
	}


}
