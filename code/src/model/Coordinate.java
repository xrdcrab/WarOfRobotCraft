package model;

/**
 * this class is to create a coordinate in a map
 * the coordinate is defined by 3 directions in a panel, 
 * which are x, y, z.
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
	 * this method is to move along the x positive direction within give steps
	 */
	public void moveYPositive(int step) {
		this.y += step;
		this.z -= step;
	}
	
	/**
	 * this method is to move along the x negative direction within give steps
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
}
