package model;

import java.util.LinkedList;

/**
 * this class is to create a coordinate in a map
 the coordinate is defined by 3 directions in a panel, 
 which are i, y, z.
 */
public class Coordinate {
	/** coordinate i **/
	private int x;
	
	/** coordinate y **/
	private int y;
	
	/** coordinate z **/
	private int z;
	
	/**
	 * this method is to create a coordinate in a map
	 * @param x
	 * @param y
	 * @param z
	 */
	public Coordinate (int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	
	/**
	 * this method is to get the i coordinate
	 * 
	 * @return i the i coordinate
	 */
	public int getX() {
		return x;
	}


	/**
	 * this method is to set the i coordinate
	 */
	public void setX(int x) {
		this.x = x;
	}


	/**
	 * this method is to get the y coordinate
	 * 
	 * @return y the y coordinate
	 */
	public int getY() {
		return y;
	}


	/**
	 * this method is to set the y coordinate
	 */
	public void setY(int y) {
		this.y = y;
	}


	/**
	 * this method is to get the z coordinate
	 * 
	 * @return z the z coordinate
	 */
	public int getZ() {
		return z;
	}


	/**
	 * this method is to set the z coordinate
	 */
	public void setZ(int z) {
		this.z = z;
	}


	/**
	 * this method is to move along the i positive direction within give steps
	 */
	public void moveXPositive(int step) {
		this.x += step;
		this.y -= step;
	}
	
	/**
	 * this method is to move along the i negative direction within give steps
	 */
	public void moveXNegative(int step) {
		this.x -= step;
		this.y += step;
	}
	
	/**
	 * this method is to move along the i positive direction within give steps
	 */
	public void moveYPositive(int step) {
		this.y += step;
		this.z -= step;
	}
	
	/**
	 * this method is to move along the i negative direction within give steps
	 */
	public void moveYNegative(int step) {
		this.y -= step;
		this.z += step;
	}
	
	/**
	 * this method is to move along the z positive direction within give steps
	 */
	public void moveZPositive(int step) {
		this.z += step;
		this.x -= step;
	}
	
	/**
	 * this method is to move along the z negative direction within give steps
	 */
	public void moveZNegative(int step) {
		this.z -= step;
		this.x += step;
	}
	
	/**
	 * Check if the coordinate is in the range of map
	 * @param mapSize the size of map
	 * @return true if the coordinate is in the map range; false otherwise
	 */
	private boolean checkRange(int mapSize) {
		return (Math.abs(this.x) < mapSize
                    && Math.abs(this.y) < mapSize
                    && Math.abs(this.z) < mapSize);
	}
	
	/**
	 * To get a new coordinate according to a direction and a distance.
	 * @param direction the direction of the new coordinate from the original coordinate
	 * @param distance the distance of the new coordinate from the original coordinate
	 * @param mapSize the size of map
	 * @return a new coordinate according to the given direction and distance
	 * @throws Exception 
	 */
	public Coordinate getNewCoordinate(int direction, int distance, int mapSize) throws Exception{
		Coordinate newCoordindate = new Coordinate(x, y, z);
		
		switch (direction){
		case 0:
			newCoordindate.moveXPositive(distance);
			newCoordindate.moveYNegative(distance);
			break;
		case 1:
			newCoordindate.moveYNegative(distance);
			newCoordindate.moveZPositive(distance);
			break;
		case 2:
			newCoordindate.moveXNegative(distance);
			newCoordindate.moveZPositive(distance);
			break;
		case 3:
			newCoordindate.moveYPositive(distance);
			newCoordindate.moveXNegative(distance);
			break;
		case 4:
			newCoordindate.moveYPositive(distance);
			newCoordindate.moveZNegative(distance);
			break;
		case 5:
			newCoordindate.moveXPositive(distance);
			newCoordindate.moveZNegative(distance);
			break;
		default:
			break;
		}
		
		if(!newCoordindate.checkRange(mapSize)){
			throw new Exception("The coordinate is out of the range.");
		}
		
		return newCoordindate;
	}
        
        public LinkedList<Coordinate> getRange(int range, int mapSize){;
            LinkedList<Coordinate> rangeList = new LinkedList<>();
            
            rangeList.add(this);
            for(int i = 0; i < range; i++){
                rangeList.add(new Coordinate(this.x + i, this.y - i, this.z));
                rangeList.add(new Coordinate(this.x + i, this.y, this.z - i));
                rangeList.add(new Coordinate(this.x - i, this.y + i, this.z));
                rangeList.add(new Coordinate(this.x, this.y + i, this.z - i));
                rangeList.add(new Coordinate(this.x - i, this.y, this.z + i));
                rangeList.add(new Coordinate(this.x, this.y - i, this.z + i));
            }
            
            LinkedList<Coordinate> removeList = new LinkedList<>();
            for(Coordinate coor : rangeList){
                if(!coor.checkRange(mapSize)){
                    removeList.add(coor);
                }
            }
            
            rangeList.removeAll(removeList);
            
            return rangeList;
        }
        
        public static void main(String[] args) {
            LinkedList<Coordinate> rangeList = new Coordinate(0, 0, 0).getRange(3, 5);
            rangeList = new Coordinate(4, -4, 0).getRange(2, 5);
        }
    }
