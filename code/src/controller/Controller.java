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

    private KeyEventDispatcher keyEventDispatcher = new KeyEventDispatcher() {

        @Override
        public boolean dispatchKeyEvent(KeyEvent e) {
            if (e.getID() == KeyEvent.KEY_PRESSED) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_SPACE:
                        System.out.println("Pressed Space");
                        endPlayOperation();
                        break;
                    case KeyEvent.VK_M:
                        // move robot
                        moveOperation();
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
                            turnOperation(0);
                        } // if the operation mode is shoot
                        else if (operationMode == OperationMode.shoot) {
                            shootOperation(0);
                        }
                        break;
                    case KeyEvent.VK_1:
                        System.out.println("Pressed 1");
                        // if the operation mode is turn
                        if (operationMode == OperationMode.turn) {
                            turnOperation(1);
                        } // if the operation mode is shoot
                        else if (operationMode == OperationMode.shoot) {
                            shootOperation(1);
                        }
                        break;
                    case KeyEvent.VK_2:
                        System.out.println("Pressed 2");
                        // if the operation mode is turn
                        if (operationMode == OperationMode.turn) {
                            turnOperation(2);
                        } // if the operation mode is shoot
                        else if (operationMode == OperationMode.shoot) {
                            shootOperation(2);
                        }
                        break;
                    case KeyEvent.VK_3:
                        System.out.println("Pressed 3");
                        // if the operation mode is turn
                        if (operationMode == OperationMode.turn) {
                            turnOperation(3);
                        } // if the operation mode is shoot
                        else if (operationMode == OperationMode.shoot) {
                            shootOperation(3);
                        }
                        break;
                    case KeyEvent.VK_4:
                        System.out.println("Pressed 4");
                        // if the operation mode is turn
                        if (operationMode == OperationMode.turn) {
                            turnOperation(4);
                        }
                        break;
                    case KeyEvent.VK_5:
                        System.out.println("Pressed 5");
                        // if the operation mode is turn
                        if (operationMode == OperationMode.turn) {
                            turnOperation(5);
                        }
                        break;
                }
            }

            return true;
        }

    };

    private enum OperationMode {
        shoot, turn
    }

    private Game game;
    private GameStartView gameStartView;
    private SetGameModeView setGameModeView;
    private GameBoardView gameBoardView;

    private Timer gameBoardViewTimer = new Timer();

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
     * this method is to add listener for all buttons (m, s, t, 0, 1, 2, 3, 4,
     * 5)
     */
    private void addListener() {
        this.getGameStartView().getExitButton().addActionListener(this);
        this.getGameStartView().getStartButton().addActionListener(this);
        this.getGameStartView().getGarageButton().addActionListener(this);

        KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(keyEventDispatcher);
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
     * @return the true if the Operation Mode is turn mode
     */
    public boolean isTurnMode() {
        return this.operationMode == OperationMode.turn;
    }

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

            this.gameBoardView = new GameBoardView();

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
                this.updateMist();
                this.addGameBoardViewListener();
                this.getGameBoardView().setVisible(true);
                this.getSetGameModeView().setVisible(false);
                for (int i = 0; i < 6; i++) {
                    if (this.getGame().getPlayerHashMap().get(i) != null) {
                        System.out.println("player" + i);
                    }
                }
            }
        } // end play button
        else if (e.getSource().equals(this.getGameBoardView().getEndPlayButton())) {
            endPlayOperation();
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
            this.getGame().getPlayerHashMap().
            	get(getGame().getCurrentPlayerIndex()).surrender();
            this.getGame().setAlivePlayerNumber(
            		this.getGame().getAlivePlayerNumber() - 1);
            this.getGameBoardView().updatePlayerDeath(
            		this.getGame().getCurrentPlayerIndex());
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

    private void resetGameBoardViewTimer(int countDwon) {
        gameBoardViewTimer.cancel();
        gameBoardViewTimer = new Timer();
        gameBoardViewTimer.schedule(new TimerTask() {

            int timerNumber = countDwon;

            @Override
            public void run() {
                if (timerNumber == 0) {
                    endPlayOperation();
                } else {
                    timerNumber--;
                }

                gameBoardView.updateTimerNumber(timerNumber);
            }
        }, 0, 1000);
    }

    private void endPlayOperation() {
        getGame().runPlay();
        // update UI here
        gameBoardView.updateOperationState("End Play");
        gameBoardView.updateCurrentPlayer(game.getCurrentPlayerIndex());
        gameBoardView.updateCurrentRobot(
                game.getPlayerHashMap().get(getGame().getCurrentPlayerIndex())
                        .getCurrentRobot().getType().toString()
        );
        Controller.this.updateMist();
        resetGameBoardViewTimer(20);
    }

    /**
     * This method will implement robot turn and update UI
     *
     * @param direction
     */
    private void turnOperation(int direction) {
        int currentPlayerPosition = getGame().getCurrentPlayerIndex();
        Player currentPlayer = getGame().getPlayerHashMap().get(getGame().getCurrentPlayerIndex());
        currentPlayer.getCurrentRobot().turn(direction);
        //update UI here
        gameBoardView.updateRobotTurned(
                currentPlayerPosition,
                currentPlayer.getCurrentRobot().getType().toString(),
                currentPlayer.getCurrentRobot().getDirection()
        );
    }

    /**
     * This method will implement robot shoot and update UI
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
        Controller.this.updateMist();
    }

    /**
     * this method is a helper function for robot move
     */
    private void moveOperation() {
        try {
            if (getGame().getPlayerHashMap().get(getGame().getCurrentPlayerIndex())
                    != null) {
                System.out.println("current robot is " + getGame().getPlayerHashMap().get(getGame().getCurrentPlayerIndex()).toString() + " of player " + getGame().getCurrentPlayerIndex());
            }
            try {
                getGame().getPlayerHashMap().get(getGame().getCurrentPlayerIndex())
                        .getCurrentRobot().move(
                                getGame().getGameMap().getMapSize());
            } catch (Exception e) { //move out of range exception.
                // Do Nothing
            }

        } catch (Exception e1) {
            e1.printStackTrace();
        }
        // update the game after the move action
        getGame().updateGameMove(
                getGame().getPlayerHashMap().get(getGame().getCurrentPlayerIndex()));
        Controller.this.updateMist();

        // update UI
        gameBoardView.updateOperationState("Move");
        Player currentPlayer = getGame().getPlayerHashMap().get(getGame().getCurrentPlayerIndex());
        Robot currentRobot = currentPlayer.getCurrentRobot();
        gameBoardView.updateRobotLocation(
                getGame().getCurrentPlayerIndex(),
                currentRobot.getType().toString(),
                currentRobot.getCoord().toString()
        );
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
        // initialize player in model
        Player newPlayer;
        if (comboBox.getSelectedItem() instanceof AIPlayer) {
            newPlayer = new AIPlayer(initialCoord, 5, playerIndex);
        } else {
            newPlayer = new HumanPlayer(initialCoord, 5, playerIndex);
        }
        playerHashMap.put(playerIndex, newPlayer);

        // add robot to view
        this.getGameBoardView().updateRobotLocation(
                playerIndex, "Tank", (initialCoord.toString()));
        this.getGameBoardView().updateRobotLocation(
                playerIndex, "Scout", (initialCoord.toString()));
        this.getGameBoardView().updateRobotLocation(
                playerIndex, "Sniper", (initialCoord.toString()));

        // set robot's direction
        this.getGameBoardView().updateRobotTurned(
                playerIndex, "Tank", playerIndex);
        this.getGameBoardView().updateRobotTurned(
                playerIndex, "Scout", playerIndex);
        this.getGameBoardView().updateRobotTurned(
                playerIndex, "Sniper", playerIndex);

        // update current player and robot
        this.getGameBoardView().updateCurrentPlayer(0);
        this.getGameBoardView().updateCurrentRobot("Scout");
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

    /**
     * This method is a helper function to update the mist of the game board.
     */
    private void updateMist() {
        // Get the current view range list.
        HashMap<Coordinate, Boolean> rangeMap = new HashMap<Coordinate, Boolean>();
        Player currentPlayer = this.getGame().getPlayerHashMap().get(this.getGame().getCurrentPlayerIndex());

        // Update the current player's mist range.     
        currentPlayer.updateViewRange();
        // Call the method to update the coordinateMap class in Map class
        this.getGame().getGameMap().updateMist(currentPlayer);

        // Fetch the coordinateMap from map class. 
        rangeMap = this.getGame().getGameMap().getCoordinateMap();

        // convert rangeMap into a HashMap of <String, Boolean> pair.
        HashMap<String, Boolean> rangeStringBoolMap = new HashMap<String, Boolean>();
        rangeMap.forEach((coord, isVisible) -> {
            rangeStringBoolMap.put(coord.toString(), isVisible);
        });

        //Call updateMist method of GameBoardView class using new rangeStringBoolMap as parameter.     	
        this.getGameBoardView().updateMist(rangeStringBoolMap);
    }

}
