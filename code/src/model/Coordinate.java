package model;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * this class is to create a coordinate in a map
 the coordinate is defined by 3 directions in a panel, 
 which are i, y, z.
 */
public class Coordinate {
	/** coordinate x **/
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
	 * this method is to get the x coordinate
	 * 
	 * @return x the x coordinate
	 */
	public int getX() {
		return x;
	}


	/**
	 * this method is to set the x coordinate
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
	 * this method is to move along the x positive direction within give steps
	 */
	public void moveXPositive(int step) {
		this.x += step;
		this.y -= step;
	}
	
	/**
	 * this method is to move along the x negative direction within give steps
	 */
	public void moveXNegative(int step) {
		this.x -= step;
		this.y += step;
	}
	
	/**
	 * this method is to move along the y positive direction within give steps
	 */
	public void moveYPositive(int step) {
		this.y += step;
		this.z -= step;
	}
	
	/**
	 * this method is to move along the y negative direction within give steps
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
			newCoordindate.x++;
			newCoordindate.y--;
			break;
		case 1:
			newCoordindate.y--;
			newCoordindate.z++;
			break;
		case 2:
			newCoordindate.x--;
			newCoordindate.z++;
			break;
		case 3:
			newCoordindate.y++;
			newCoordindate.x--;
			break;
		case 4:
			newCoordindate.y++;
			newCoordindate.z--;
			break;
		case 5:
			newCoordindate.x++;
			newCoordindate.z--;
			break;
		default:
			break;
		}
		
		if(!newCoordindate.checkRange(mapSize)){
			throw new Exception("The coordinate is out of the range.");
		}
		
		return newCoordindate;
	}
        
	/**
	 * this method is to get the hexagons in the range of a center hexagon
	 * 
	 * @param range the range to search 
	 * @param mapSize the map size
	 * @return rangeList the list of the all the hexagons in the range
	 */
	public LinkedList<Coordinate> getRange(int range, int mapSize) {
		LinkedList<Coordinate> rangeList = new LinkedList<>();

		for ( int x = this.getX() - range; x <= this.getX() + range; x++ ) {
			for ( int y = Math.max(this.getY() - range, - x - (this.getZ()+range)); 
					y <= Math.min(this.getY() + range, - x - (this.getZ() - range)); y++ ) {
				int z = - x - y;
				Coordinate newCoord = new Coordinate(x, y, z);
				if ( newCoord.checkRange(mapSize))
					rangeList.add( newCoord );
			}
		}

		return rangeList;
	}
        
	/**
	 * this method is to create the map with center point
	 * 
	 * @param mapSize the map size
	 * @return rangeList the list of the all the hexagons in the range
	 */
	public HashMap<Coordinate, Boolean> getRange(int mapSize) {
		HashMap<Coordinate, Boolean> initialMap = new HashMap<Coordinate, Boolean>();
		mapSize -= 1;
		for ( int x = this.getX() - mapSize; x <= this.getX() + mapSize; x++ ) {
			for ( int y = Math.max(this.getY() - mapSize, - x - (this.getZ()+mapSize)); 
					y <= Math.min(this.getY() + mapSize, - x - (this.getZ() - mapSize)); y++ ) {
				int z = - x - y;				
				initialMap.put( new Coordinate(x, y, z), false);
			}
		}
		
		return initialMap;
	}
	
	/**
	 * this method is used to compare two coordinate object
	 * @param obj the coordinate object to be compared with
	 */
	@Override
	public boolean equals(Object obj){
		if(obj == null){
			return false;
		}
		if(!Coordinate.class.isAssignableFrom(obj.getClass())){
			return false;
		}
		final Coordinate coord = (Coordinate)obj;
		if(this.x != coord.x ){
			return false;
		}
		if(this.y != coord.y){
			return false;
		}
		if(this.z != coord.z){
			return false;
		}

		return true;
	};

	/**
	 * this method is to help the toString() 
	 * to get the x, y or z coordinate to string
	 * 
	 * @param coord the x, y, or z
	 * @return coordString the string of the x, y or z coordinate
	 */
	private String coordToString(int coord) {
		String coordString = "";
		if ( coord == 0 ) {
			coordString += "z0";
		}
		else if ( coord <0 ) {
			int abs = Math.abs( coord );
			coordString += "n" + abs;
		}
		else if ( coord > 0 ) {
			coordString += "p" + coord;
		}
		return coordString;
	}
	
	/**
	 * this method is to override the toString() method 
	 * to get the string of a coordinate
	 * 
	 * @return coordString the string of a coordinate
	 */
	@Override
	public String toString() {
		String coordString = "";
		coordString += this.coordToString(this.getX());
		coordString += this.coordToString(this.getY());
		coordString += this.coordToString(this.getZ());
		return coordString;
		
	}
	
	/**
	 * 
	 * @param mapSize
	 * @return ringMap A hashMap of the key pair of direction and surrounding coordinates. 
	 */
	public HashMap<Integer, Coordinate> getRing(int mapSize){
		HashMap<Integer, Coordinate> ringMap = new HashMap<Integer, Coordinate>();
		
		if((Math.abs(x+1)<=mapSize-1)&&(Math.abs(y-1)<=mapSize-1)){
			ringMap.put(0, new Coordinate(x+1, y-1, z));
		}
		
		if((Math.abs(z+1)<=mapSize-1)&&(Math.abs(y-1)<=mapSize-1)){
			ringMap.put(1, new Coordinate(x, y-1, z+1));
		}
		
		if((Math.abs(x-1)<=mapSize-1)&&(Math.abs(z+1)<=mapSize-1)){
			ringMap.put(2, new Coordinate(x-1, y, z+1));
		}
		
		if((Math.abs(x-1)<=mapSize-1)&&(Math.abs(y+1)<=mapSize-1)){
			ringMap.put(3, new Coordinate(x-1, y+1, z));
		}
		
		if((Math.abs(z-1)<=mapSize-1)&&(Math.abs(y+1)<=mapSize-1)){
			ringMap.put(4, new Coordinate(x, y+1, z-1));
		}
			
		if((Math.abs(z-1)<=mapSize-1)&&(Math.abs(x+1)<=mapSize-1)){
			ringMap.put(5, new Coordinate(x+1, y, z-1));
		}			

		return ringMap;
	}
	
	public static void main(String[] args) {
		LinkedList<Coordinate> rangeList = new Coordinate(0, 0, 0).getRange(2, 5);
		rangeList = new Coordinate(4, -4, 0).getRange(2, 5);
                
                boolean b = new Coordinate(1, 2, 3).equals(new Coordinate(1, 2, 3));
                b = new Coordinate(1, 2, 3).equals(new Coordinate(1, 2, 2));
                
                LinkedList<Coordinate> list1 = new Coordinate(0, 0, 0).getRange(1, 5);
                LinkedList<Coordinate> list2 = new Coordinate(1, -1, 0).getRange(1, 5);
                list1.removeAll(list2);
                list1.addAll(list2);
                
        Coordinate coord = new Coordinate (-1, 0, 1);
        System.out.println(coord.toString());
        
        
//        Test for getRing 
        Coordinate coordzzz = new Coordinate (-4, 0, 4);
        System.out.println(coordzzz.getRing(5));
        
	}
}
