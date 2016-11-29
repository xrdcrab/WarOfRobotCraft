package aiutil;

import java.util.LinkedList;

public class Stack {

	private LinkedList<String> stack;
	private String firtElement;
	private int elementNum;
	
	public Stack () {
		this.stack = new LinkedList<String>();
		this.firtElement = "";
		this.elementNum = 0;
	}

	public void pop () {
		if ( this.getStack() != null ) {
			
		}
	}
	
	/**
	 * this method is to determine if the stack is null
	 * 
	 * @return true if the stack is null, otherwise false
	 */
	public boolean isEmpty() {
		return ( this.stack == null );
	}
	
	/**
	 * @return the stack
	 */
	public LinkedList<String> getStack() {
		return stack;
	}

	/**
	 * @param stack the stack to set
	 */
	public void setStack(LinkedList<String> stack) {
		this.stack = stack;
	}

	/**
	 * @return the firtElement
	 */
	public String getFirtElement() {
		return firtElement;
	}

	/**
	 * @param firtElement the firtElement to set
	 */
	public void setFirtElement(String firtElement) {
		this.firtElement = firtElement;
	}

	/**
	 * @return the elementNum
	 */
	public int getElementNum() {
		return elementNum;
	}

	/**
	 * @param elementNum the elementNum to set
	 */
	public void setElementNum(int elementNum) {
		this.elementNum = elementNum;
	}
}
