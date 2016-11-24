package controller;

import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JComboBox;

import javafx.util.Pair;
import model.*;
import view.*;

/**
 * this class is to build up the controller to control the game system
 */
public class Controller implements ActionListener, KeyListener {

    private enum OperationMode {
        shoot, turn
    }

    private Game game;
    private GameStartView gameStartView;
    private SetGameModeView setGameModeView;
    private GameBoardView gameBoardView;

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
     * (m, s, t, 0, 1, 2, 3, 4, 5)
     */
    private void addListener() {
        this.getGameStartView().getExitButton().addActionListener(this);
        this.getGameStartView().getStartButton().addActionListener(this);
        this.getGameStartView().getGarageButton().addActionListener(this);

        KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(new KeyEventDispatcher() {

            @Override
            public boolean dispatchKeyEvent(KeyEvent e) {
                if (e.getID() == KeyEvent.KEY_PRESSED) {
                    switch (e.getKeyCode()) {
                        case KeyEvent.VK_SPACE:
                            System.out.println("Pressed Space");
                            getGame().runPlay();
                            // update UI here
                            break;
                        case KeyEvent.VK_M:
                            // move robot
                            this.moveOperation();
                            System.out.println("Pressed M");
                            break;
                        case KeyEvent.VK_S:
                            // set operation mode to shoot
                            operationMode = OperationMode.shoot;
                            gameBoardView.updateOperationState("Shoot");
                            System.out.println("Pressed S");
                            break;
                        case KeyEvent.VK_T:
                            // set operation mode to turn
                            operationMode = OperationMode.turn;
                            gameBoardView.updateOperationState("Turn");
                            System.out.println("Pressed T");
                            break;
                        case KeyEvent.VK_0:
                            System.out.println("Pressed 0");
                            // if the operation mode is turn
                            if (operationMode == OperationMode.turn) {
                                this.turnOperation(0);
                            } // if the operation mode is shoot
                            else if (operationMode == OperationMode.shoot) {
                                this.shootOperation(0);
                            }
                            break;
                        case KeyEvent.VK_1:
                            System.out.println("Pressed 1");
                            // if the operation mode is turn
                            if (operationMode == OperationMode.turn) {
                                this.turnOperation(1);
                            } // if the operation mode is shoot
                            else if (operationMode == OperationMode.shoot) {
                                this.shootOperation(1);
                            }
                            break;
                        case KeyEvent.VK_2:
                            System.out.println("Pressed 2");
                            // if the operation mode is turn
                            if (operationMode == OperationMode.turn) {
                                this.turnOperation(2);
                            } // if the operation mode is shoot
                            else if (operationMode == OperationMode.shoot) {
                                this.shootOperation(2);
                            }
                            break;
                        case KeyEvent.VK_3:
                            System.out.println("Pressed 3");
                            // if the operation mode is turn
                            if (operationMode == OperationMode.turn) {
                                this.turnOperation(3);
                            } // if the operation mode is shoot
                            else if (operationMode == OperationMode.shoot) {
                                this.shootOperation(3);
                            }
                            break;
                        case KeyEvent.VK_4:
                            System.out.println("Pressed 4");
                            // if the operation mode is turn
                            if (operationMode == OperationMode.turn) {
                                this.turnOperation(4);
                            }
                            break;
                        case KeyEvent.VK_5:
                            System.out.println("Pressed 5");
                            // if the operation mode is turn
                            if (operationMode == OperationMode.turn) {
                                this.turnOperation(5);
                            }
                            break;
                    }
                }

                return true;
            }

            /**
             *
             * @param direction
             */
            private void turnOperation(int direction) {
                getGame().getPlayerHashMap().get(getGame().getCurrentPlayerIndex())
                        .getCurrentRobot().turn(direction);
                //update UI here
            }

            /**
             *
             * @param shootDistance
             */
            private void shootOperation(int shootDistance) {
                Pair<Coordinate, Integer> pair = null;
                try {
                    pair = getGame().getPlayerHashMap().get(getGame().getCurrentPlayerIndex())
                            .getCurrentRobot().shoot(shootDistance, getGame().getGameMap().getMapSize());
                } catch (Exception e) {
                    e.printStackTrace();
                }

                getGame().updateGameShootDamaged(pair);
                //update UI here
                for (Pair<Integer, String> deadRobot : getGame().updateGameShootDead(pair)) {
                    getGameBoardView().updateRobotDestruction(
                            deadRobot.getKey(), deadRobot.getValue());
                }

            }

            /**
             * this method is a helper function for robot move
             */
            private void moveOperation() {
                try {
                    getGame().getPlayerHashMap().get(getGame().getCurrentPlayerIndex())
                            .getCurrentRobot().move(
                                    getGame().getGameMap().getMapSize());
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
                // update the game after the move action
                getGame().updateGameMove(
                        getGame().getPlayerHashMap().get(getGame().getCurrentPlayerIndex()));
                
                // update UI
                Player currentPlayer = getGame().getPlayerHashMap().get(getGame().getCurrentPlayerIndex());
                Robot currentRobot = currentPlayer.getCurrentRobot();
                gameBoardView.updateRobotLocation(
                        getGame().getCurrentPlayerIndex(), 
                        currentRobot.getType().toString(),
                        currentRobot.getCoord().toString()
                );
            }
        });
        //this.getSetGameModeView().getConfirmButton().addActionListener(this);
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
     *
     * @return operationMode
     */
    public OperationMode getOperationMode() {
        return operationMode;
    }

    /**
     * this method is to set Operation Mode
     *
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
//	public boolean isMoveMode() {
//		return this.operationMode == OperationMode.move;
//	}
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
     * @return the gameBoardView
     */
    public GameBoardView getGameBoardView() {
        return gameBoardView;
    }

    /**
     * @param gameBoardView the gameBoardView to set
     */
    public void setGameBoardView(GameBoardView gameBoardView) {
        this.gameBoardView = gameBoardView;
    }

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
        if (e.getSource().equals(this.getGameStartView().getStartButton())) {
            this.getGameStartView().setVisible(false);
            this.setGameModeView = new SetGameModeView();
            this.getSetGameModeView().getConfirmButton().addActionListener(this);
            this.getSetGameModeView().setVisible(true);
        } // garage button
        else if (e.getSource().equals(null)) {

        } // exit button
        else if (e.getSource().equals(this.getGameStartView().getExitButton())) {
            System.exit(0);
        } // confirm button
        else if (e.getSource().equals(this.getSetGameModeView().getConfirmButton())) {

            int playerNum = -1;
            HashMap<Integer, Player> playerHashMap = new HashMap<Integer, Player>();

            if (this.getSetGameModeView().getTwoPlayersRadioButton().isSelected()) {
                playerNum = 2;
                // red player: index 0
                this.initializePlayer(
                        this.getSetGameModeView().getPlayerTypeComboBox1(),
                        new Coordinate(-4, 4, 0), 5, playerHashMap, 0);
                // green player: index 3
                this.initializePlayer(
                        this.getSetGameModeView().getPlayerTypeComboBox4(),
                        new Coordinate(4, -4, 0), 5, playerHashMap, 3);
            } else if (this.getSetGameModeView().getThreePlayersRadioButton().isSelected()) {
                playerNum = 3;
                // red player: index 0
                this.initializePlayer(
                        this.getSetGameModeView().getPlayerTypeComboBox1(),
                        new Coordinate(-4, 4, 0), 5, playerHashMap, 0);
                // yellow player: index 2
                this.initializePlayer(
                        this.getSetGameModeView().getPlayerTypeComboBox3(),
                        new Coordinate(4, 0, -4), 5, playerHashMap, 2);
                // blue player: index 4
                this.initializePlayer(
                        this.getSetGameModeView().getPlayerTypeComboBox5(),
                        new Coordinate(0, -4, 4), 5, playerHashMap, 4);
            } else if (this.getSetGameModeView().getSixPlayersRadioButton().isSelected()) {
                playerNum = 6;
                // red player: index 0
                this.initializePlayer(
                        this.getSetGameModeView().getPlayerTypeComboBox1(),
                        new Coordinate(-6, 6, 0), 7, playerHashMap, 0);
                // orange player: index 1
                this.initializePlayer(
                        this.getSetGameModeView().getPlayerTypeComboBox2(),
                        new Coordinate(0, 6, -6), 7, playerHashMap, 1);
                // yellow player: index 2
                this.initializePlayer(
                        this.getSetGameModeView().getPlayerTypeComboBox3(),
                        new Coordinate(6, 0, -6), 7, playerHashMap, 2);
                // green player: index 3
                this.initializePlayer(
                        this.getSetGameModeView().getPlayerTypeComboBox4(),
                        new Coordinate(6, -6, 0), 7, playerHashMap, 3);
                // blue player: index 4
                this.initializePlayer(
                        this.getSetGameModeView().getPlayerTypeComboBox5(),
                        new Coordinate(0, -6, 6), 7, playerHashMap, 4);
                // purple player: index 5
                this.initializePlayer(
                        this.getSetGameModeView().getPlayerTypeComboBox6(),
                        new Coordinate(-6, 0, 6), 7, playerHashMap, 5);
            }

            if (playerNum != -1) {
                this.game = new Game(playerHashMap, playerNum);
                this.getGame().setCurrentPlayerIndex(0);
                this.gameBoardView = new GameBoardView();
                // Sean added for testing
                this.game.getPlayerHashMap().put(0, new Player(new Coordinate(-4, 4, 0), playerNum));
                this.game.getPlayerHashMap().put(3, new Player(new Coordinate(4, -4, 0), playerNum));
                // Sean added for testing
                this.getGameBoardView().updateRobotLocation(
                		0, "Tank", (new Coordinate(-4, 4, 0).toString()));
                this.getGameBoardView().updateRobotLocation(
                		0, "Scout", (new Coordinate(-4, 4, 0).toString()));
                this.getGameBoardView().updateRobotLocation(
                		0, "Sniper", (new Coordinate(-4, 4, 0).toString()));
                this.getGameBoardView().updateRobotLocation(
                		3, "Tank", (new Coordinate(4, -4, 0).toString()));
                this.getGameBoardView().updateRobotLocation(
                		3, "Scout", (new Coordinate(4, -4, 0).toString()));
                this.getGameBoardView().updateRobotLocation(
                		3, "Sniper", (new Coordinate(4, -4, 0).toString()));
                this.addGameBoardViewListener();
                this.getGameBoardView().setVisible(true);
                this.getSetGameModeView().setVisible(false);
                //System.out.print(playerNum + '\n');
                for (int i = 0; i < 6; i++) {
                    if (playerHashMap.get(i) != null) {
                        System.out.println("player" + i);
                    }
                }
                
                // testing timer
                new Timer().schedule(new TimerTask() {

                    int timerNumber = 10;
                    
                    @Override
                    public void run() {
                        if (timerNumber == 0) {
                            timerNumber = 10;
                        } else {
                            timerNumber--;
                        }

                        gameBoardView.updateTimerNumber(timerNumber);
                    }
                }, 0, 1000);
            }
        } // end play button
        else if (e.getSource().equals(this.getGameBoardView().getEndPlayButton())) {
            this.getGame().runPlay();
        } // home button
        else if (e.getSource().equals(this.getGameBoardView().getHomeButton())) {
            System.out.println("home");
            this.setGame(null);
            this.getGameBoardView().setVisible(false);
            this.setGameBoardView(null);
            this.setSetGameModeView(null);
            this.getGameStartView().setVisible(true);
        } // give up button
        else if (e.getSource().equals(this.getGameBoardView().getGiveUpButton())) {
            System.out.println("I Surrender!");
            // call surrender() method
            this.getGame().getPlayerHashMap().get(getGame().getCurrentPlayerIndex())
                    .surrender();
            this.getGameBoardView().updatePlayerDeath(this.getGame().getCurrentPlayerIndex());
        }
    }

    /**
     * this method is to add the listeners for the game board view
     */
    private void addGameBoardViewListener() {
        this.getGameBoardView().getEndPlayButton().addActionListener(this);
        this.getGameBoardView().getHomeButton().addActionListener(this);
        this.getGameBoardView().getGiveUpButton().addActionListener(this);
    }

    /**
     * this method is to help the confirm button action perform initialize
     * players
     *
     * @param comboBox
     * @param initialCoord
     * @param mapSize
     * @param playerHashMap
     * @param playerIndex
     */
    private void initializePlayer(JComboBox comboBox,
            Coordinate initialCoord,
            int mapSize,
            HashMap<Integer, Player> playerHashMap,
            int playerIndex
    ) {
        // model part
        Player newPlayer;
        if (comboBox.getSelectedItem() instanceof AIPlayer) {
            newPlayer = new AIPlayer(new Coordinate(-4, 4, 0), 5);
        } else {
            newPlayer = new HumanPlayer(new Coordinate(4, -4, 0), 5);
        }
        playerHashMap.put(playerIndex, newPlayer);

        // view part
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
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            System.out.print("abc");
            this.getGame().goNextPlayer();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

        // move 
        if (e.getKeyChar() == 'm' || e.getKeyChar() == 'M') {
            // move the current robot of the current player
            try {
                this.getGame().getPlayerHashMap().get(this.getGame().getCurrentPlayerIndex())
                        .getCurrentRobot().move(
                                this.getGame().getGameMap().getMapSize());
            } catch (Exception e1) {
                e1.printStackTrace();
            }
            // update the game after the move action
            this.getGame().updateGameMove(
                    this.getGame().getPlayerHashMap().get(this.getGame().getCurrentPlayerIndex()));
        } // shoot
        else if (e.getKeyChar() == 's' || e.getKeyChar() == 'S') {
            // the current robot of the current player shoot
            try {
                this.getGame().getPlayerHashMap().get(this.getGame().getCurrentPlayerIndex())
                        .getCurrentRobot().shoot(this.getShootDistance(),
                                this.getGame().getGameMap().getMapSize());
            } catch (Exception e1) {
                e1.printStackTrace();
            }
            // update the game after the shoot action
            this.getGame().updateGameShootDamaged(this.getShootTarget());
        }

    }

}
