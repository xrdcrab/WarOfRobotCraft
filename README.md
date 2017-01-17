1. Introduction

  Welcome to War of Robotcraft. This is a casual robot battle game with a neat interface and simple operations. The user can select three modes in this game, which are human player versus human player, human player versus AI player and AI player versus AI player. The user can choose the number of players from 2, 3 to 6. The map size of 2 and 3 players is a big hexagon with 5 hexagons for each side, and in the situation of 6 players, the map would be a hexagon with 7 hexagons composing each side.
  
  i. Target user
  
  The people who would like playing casual games.
  
  ii. Computer requirement
  
  The computer should have keyboard and mouse as input equipment. For software, the computer should be able to run Java Virtual Machine.
  
2. Game Rules

  i. Basics
  
    There are three modes of two, three or six players. Each player holds three robots, which are scout, sniper and tank. Each robot has 4 properties: attack points, health points, movement points and range. Because of the difference of robot properties, each robot has its pros and cons.
    
     ![image](https://github.com/xrdcrab/WarOfRobotCraft/raw/master/doc/pics/gameRule1.png)
     
  ii. Timer
  
    We designed a time limitation for each human player. For each turn, each player has 20 seconds to finish all operations. If the time runs out, the current turn of the current player is terminated, and the game move on to next player starting a new turn.
    
  iii. Rounds and Turns
  
    One round consists of several turns. A turn's end means a player with at least one robot has played one robot unit. And a new turn is started by the next player. One round ends when all players have played all remaining robots once. Within each turn, each player performs the operations like shoot, move or turn directions on one robot, and each player has to finish within 20 seconds.
  
  iv. Move and shoot
  
    A robot can move at most the times of its movement points. And it can shoot at most once. It can turn its directions for any times. Movement is only towards the robot's current direction, and shoot is the same. If a player wants to move towards a different direction, the player needs to turn into a different direction.
    
  v. Surrendr
    
    If a human player decides not to finish the game and wants to quit the game earlier, the player can surrender in the middle of the game.
    
  vi. How to win
    
    Once there is only one player alive, the game ends. The remaining player is the winner. The winning situation can be formed from either all other players' robots are all dead or some players surrendered.
    
3. Interfaces

  i. Start the game
    
    When opening the game system, the game start interface is present on the screen as the following. There are three buttons you can click on start, garage, and exit. As the start button clicked, you will go to the next view where you can set up the mode for a new game. The garage button is to go the garage, but this view has not yet been done. The exit button is to exit the game system.
    
    ![image](https://github.com/xrdcrab/WarOfRobotCraft/raw/master/doc/pics/gameRule2.png)
    
  ii. Mode selection
  
    This is the mode selection menu. As the game is designed, the user can choose a number of players from 2, 3 to 6. Once a user has selected the number of players, the corresponding number of selection boxes appear below. The user can select from Human and AI for each player. After the selection is finished, user confirm the selection by pressing the Confirm button below. Then the game board is opened.
    
    ![image](https://github.com/xrdcrab/WarOfRobotCraft/raw/master/doc/pics/gameRule3.png)
    
  iii. Game board
    
    a. Layout
      
     This is the game board of robots. The hexagon in the center is the battlefield of the game. The six corners with colors are the positions where the robots are initialized. The pictures are showing the situation of three players. And for two players, the robots are initialized at the pink and green spots.
      
    b. Buttons and indicators
      
     The button 1, which is at the top left corner, is for returning to the main menu. The text pointed by number 2 is a timer. Once the timer gets zero, the current turn is terminated, and the game goes to the next turn. The number 3 at the top right corner is a status bar, which indicates current alive robot of the game. However, when we were implementing the game, we found that this status bar is not very useful for now, and the information given by the status bar will interfere the game's fairness, so we didn't implement the status bar. The detailed explanation is in below. The button 4 provides the function of skipping the current turn if you don’t feel like waiting for the timer ending. You can also press space to execute the same skipping current turn operation. The button 5, which is beside the skip button, is for surrendering when a player has decided to quit the game. If after one player surrendering there are still more than or equal to two players remaining, the game is still in progress, and the surrendered player is simplify skipped.
      
    ![image](https://github.com/xrdcrab/WarOfRobotCraft/raw/master/doc/pics/gameRule4.png)
    
4. User Operations
  
  Move is one of the basic operations, user press m for operating a robot to move one space forward in its current direction. Turn is another basic operation, there are two steps to execute a turn. First, user press t to enter the turning mode. Then, user gives a direction to the robot by pressing a number. For example, if a user needs to turn right once, the user can press "t" first and "1" second. If a user needs to turn to the opposite direction, the user can press "t" first and "3" second. Shoot operation is like turn, the user can press "s" first and then a number to choose the distance for shooting. For example, if a user wants to shoot at the spot two spaces ahead, the user can press "s" first and then press "2". Finally, if a user needs to skip the current turn if the user finishes all the operations in the current turn and decides to carry on, the user can press "Space" to skip the current turn. This operation can also be executed by click the number 4 button which is introduced in the previous part.
