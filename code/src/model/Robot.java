package model;

import java.util.HashMap;
import java.util.LinkedList;
import javafx.util.Pair;

/**
 * this class is to create a robot
 */
public class Robot {

    /**
     * robot type *
     */
    public enum RobotType {
        scout, sniper, tank
    };

    /**
     * robot type *
     */
    private RobotType type;

    /**
     * robot name *
     */
    private String name;

    /**
     * robot attack point *
     */
    private int attackPoint;

    /**
     * robot health point *
     */
    private int healthPoint;

    /**
     * robot movement point *
     */
    private int movementPoint;

    /**
     * robot view range
     */
    private int range;

    /**
     * robot absolute coordinate *
     */
    private Coordinate coord;

    /**
     * robot fire direction *
     */
    private int direction;

    /**
     * robot has moved in a play *
     */
    private boolean hasMoved;

    /**
     * robot has shot in a play *
     */
    private boolean hasShot;

    /**
     * robot view range
     */
    private LinkedList<Coordinate> viewRangeList;

    /**
     * getRange() method this constructor is to create a robot with parameters
     *
     * @param type
     * @param name
     * @param attackPoint
     * @param healthPoint
     * @param movementPoint
     * @param coord
     * @param direction
     */
    public Robot(RobotType type,
            String name,
            int attackPoint,
            int healthPoint,
            int movementPoint,
            Coordinate coord,
            int direction,
            boolean hasMoved,
            boolean hasShot,
            LinkedList<Coordinate> viewRangeList) {

        this.type = type;
        this.name = name;
        this.attackPoint = attackPoint;
        this.healthPoint = healthPoint;
        this.movementPoint = movementPoint;
        this.coord = coord;
        this.direction = direction;
        this.hasMoved = hasMoved;
        this.hasShot = hasShot;
        this.viewRangeList = viewRangeList;

        switch (type) {
            case scout:
                range = 2;
                break;
            case sniper:
                range = 3;
                break;
            case tank:
                range = 1;
                break;
            default:
                break;
        }
    }

    /**
     * @return the type
     */
    public RobotType getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(RobotType type) {
        this.type = type;
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
     * @return the attackPoint, int value, unique by robot type.
     */
    public int getAttackPoint() {
        return attackPoint;
    }

    /**
     * @param attackPoint the attackPoint to set
     */
    public void setAttackPoint(int attackPoint) {
        this.attackPoint = attackPoint;
    }

    /**
     * @return the healthPoint, int value, unique by robot type.
     */
    public int getHealthPoint() {
        return healthPoint;
    }

    /**
     * @param healthPoint the healthPoint to set
     */
    public void setHealthPoint(int healthPoint) {
        this.healthPoint = healthPoint;
    }

    /**
     * @return the movementPoint, int value, unique by robot type.
     */
    public int getMovementPoint() {
        return movementPoint;
    }

    /**
     * @param movementPoint the movementPoint to set
     */
    public void setMovementPoint(int movementPoint) {
        this.movementPoint = movementPoint;
    }

    /**
     * @return the coord
     */
    public Coordinate getCoord() {
        return coord;
    }

    /**
     * @param coord the coord to set
     */
    public void setCoord(Coordinate coord) {
        this.coord = coord;
    }

    /**
     * @return the direction, int value range form 0 to 5
     */
    public int getDirection() {
        return direction;
    }

    /**
     * @param direction the direction to set
     */
    public void setDirection(int relativeDirection) {
        this.direction = (direction+relativeDirection)%6;
    }

    /**
     * @return the hasMoved boolean value
     */
    public boolean isHasMoved() {
        return hasMoved;
    }

    /**
     * @param hasMoved the hasMoved to set
     */
    public void setHasMoved(boolean hasMoved) {
        this.hasMoved = hasMoved;
    }

    /**
     * @return the hasShot boolean value
     */
    public boolean isHasShot() {
        return hasShot;
    }

    /**
     * @param hasShot the hasShot to set
     */
    public void setHasShot(boolean hasShot) {
        this.hasShot = hasShot;
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
     * @return the visible range of the robot
     */
    public int getRange() {
        return range;
    }

    /**
     * @param range the range to set
     */
    public void setRange(int range) {
        this.range = range;
    }

    /**
     * this method is to determine whether the robot is dead
     *
     * @return true if the robot is dead, false otherwise
     */
    public boolean isDead() {
        return (this.healthPoint <= 0);
    }

    /**
     * this method turns the direction of robot.
     *
     * @param direction the direction that to be turned
     */
    public void turn(int direction) {
        if (!this.isDead()) {
            this.setDirection(direction);
        }
    }

    /**
     * this method is to move a robot
     *
     * @param mapSize the size of map
     * @throws Exception when robot is dead or move out of the map range.
     */
    public void move(int mapSize) throws Exception {
        if (this.isDead()) {
            throw new Exception("Died robot cannot move.");
        } else {
            if (this.getMovementPoint() > 0) {
                try {
                    this.coord = this.coord.getNewCoordinate(this.direction, 1, mapSize);
                } catch (Exception e) {
                    throw new Exception("The move is out of map range.");
                }
                this.movementPoint--;
                this.setViewRange(mapSize);
            } else {
                return;
            }
        }
    }

    /**
     * this method is to set the damage of the robot get fired
     *
     * @param attackPoint the attackPoint that the robot received
     */
    public void damaged(int attackPoint) {
        if (!this.isDead()) {
            this.setHealthPoint(this.getHealthPoint() - attackPoint);
        }
    }

    /**
     * this method is to shoot at a specific record
     *
     * @param distance the distance to shoot
     * @param mapSize the size of map
     * @throws Exception
     * @return Pair<Coordinate, Integer> contain the shoot target coordinate and
     * the attack point.
     */
    public Pair<Coordinate, Integer> shoot(int distance, int mapSize) throws Exception {
        if (this.isDead()) {
            throw new Exception("Died robot cannot shoot.");
        } 
        else {
            if (this.hasShot) {
                throw new Exception("Cannot shoot twice in one play.");
            } 
            else {
                Pair<Coordinate, Integer> pair;
                try {
                    pair = new Pair<Coordinate, Integer>(
                            this.coord.getNewCoordinate(this.direction, distance, mapSize),
                            this.attackPoint);
                } catch (Exception e) {
                    throw new Exception("The move is out of map range.");
                }
                return pair;
            }
        }
    }

    /**
     * this method is to set the view range list for a robot
     *
     * @param mapSize the size of the map
     */
    public void setViewRange(int mapSize) {
        this.setViewRangeList(this.getCoord().getRange(this.getRange(), mapSize));
    }

    /**
     * This method is to reset a robot's status into initial status.
     */
    public void resetStatus() {
        this.setHasShot(false);
        switch (this.type) {
            case scout:
                this.setHealthPoint(1);
                this.setMovementPoint(3);
                break;
            case sniper:
                this.setHealthPoint(2);
                this.setMovementPoint(2);
                break;
            case tank:
                this.setHealthPoint(3);
                this.setMovementPoint(1);
                break;
            default:
                break;
        }
    }

    /**
     * This method is to generate the HashMap of relative direction and
     * coordinate.
     *
     * @param mapSize
     * @return ringMap the relative direction and absolute coordinate key pair
     */
    public HashMap<Integer, Coordinate> relativeDirectionToCoordinate(int mapSize) {
        HashMap<Integer, Coordinate> ringMap = new HashMap<Integer, Coordinate>();
        int difference = this.getDirection();
        ringMap = this.getCoord().getRing(mapSize);
        HashMap<Integer, Coordinate> ringMapAbsoluteDirection
                = this.getCoord().getRing(mapSize);
        for (int key : ringMapAbsoluteDirection.keySet()) {
            int relativeKey = key - difference;
            if (relativeKey < 0) {
                relativeKey += 6;
            }
            ringMap.put(relativeKey, ringMapAbsoluteDirection.get(key));
        }
        return ringMap;
    }

    public static void main(String[] args) {

        Coordinate coor = new Coordinate(0, 0, 0);

        Robot r = new Robot(RobotType.scout, "a", 1, 1, 1, coor, 3, false, false, null);
        r.relativeDirectionToCoordinate(5);
//        Test for getRing
        System.out.println(coor.getRing(5));
        System.out.println(r.relativeDirectionToCoordinate(5));
    }

}
