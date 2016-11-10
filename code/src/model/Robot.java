package model;

import java.awt.*;;
/**
 * this class is to create a robot
 */
public class Robot {
	
	/** robot type **/
	private enum type {
		scout, sniper, tank
	};
	
	/** robot name **/
	private String name;
	
	/** robot attack point **/
	private int attackPoint;
	
	/** robot health point **/
	private int healthPoint;
	
	/** robot movement point **/
	private int movementPoint;
	
	/** robot absolute coordinate **/
	private Coordinate coord;
	
	/** robot fire direction **/
	private int direction;
	
	/** robot has moved in a play **/
	private boolean hasMoved;
	
	/** robot has shot in a play **/
	private boolean hasShot;
	
	/**
	 * this constructor is to create a robot with paramaters
	 * @param type
	 * @param name
	 * @param attackPoint
	 * @param healthPoint
	 * @param movementPoint
	 * @param coord
	 * @param direction
	 */
	public Robot (type type, 
				String name, 
				int attackPoint,
				int healthPoint,
				int movementPoint,
				Coordinate coord,
				int direction,
				boolean hasMoved,
				boolean hasShot) {
		
		this.name = name;
		this.attackPoint = attackPoint;
		this.healthPoint = healthPoint;
		this.movementPoint = movementPoint;
		this.coord = coord;
		this.direction = direction;
		this.hasMoved = hasMoved;
		this.hasShot = hasShot;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAttackPoint() {
		return attackPoint;
	}

	public void setAttackPoint(int attackPoint) {
		this.attackPoint = attackPoint;
	}

	public int getHealthPoint() {
		return healthPoint;
	}

	public void setHealthPoint(int healthPoint) {
		this.healthPoint = healthPoint;
	}

	public int getMovementPoint() {
		return movementPoint;
	}

	public void setMovementPoint(int movementPoint) {
		this.movementPoint = movementPoint;
	}

	public Coordinate getCoord() {
		return coord;
	}

	public void setCoord(Coordinate coord) {
		this.coord = coord;
	}

	public int getDirection() {
		return direction;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}
	
	
	public boolean isHasMoved() {
		return hasMoved;
	}

	public void setHasMoved(boolean hasMoved) {
		this.hasMoved = hasMoved;
	}

	public boolean isHasShot() {
		return hasShot;
	}

	public void setHasShot(boolean hasShot) {
		this.hasShot = hasShot;
	}

	/**
	 * this method is to determine whether the robot is dead
	 * @return true if the robot is dead, false otherwise
	 */
	public boolean isDead() {
		return (this.healthPoint <= 0);
	}
	
	/**
	 * this method turns the direction of robot.
	 * @param direction the direction that to be turned
	 */
	public void turn(int direction) {
		if ( !this.isDead() ) {
			this.setDirection(direction);
		}
	}
	
	/**
	 * this method is to move a robot
	 */
	public void move() {
		if(this.isDead()){
			throw new Exception("Died robot cannot move.")
		} else {
			if(this.getMovementPoint() > 0){
				this.setCoord(this.getCoord().getNewCoordinate(this.direction, 1));
				this.movementPoint --;
			} else {
				return;
			}
		}
	}
	
	/**
	 * this method is to set the damage of the robot get fired
	 * @param attackPoint the attackPoint that the robot received
	 */
	public void damaged(int attackPoint) {
		if ( !this.isDead() ) {
			this.setHealthPoint( this.getHealthPoint() - attackPoint );
		}
	}
	
	/**
	 * this method is to shoot at a specific record
	 * @param targetRange the range that to shoot at
	 */
	public Pair<Coordinate, Integer> shoot(Coordinate targetRange) {
		
	}
}
