package aiutil;

import java.util.LinkedList;

/**
 * this class is to create a stack for the interpreter
 * analyzing the semantics
 */
public class Stack {

	private LinkedList<String> stack;
	private String topElement;
	private int elementNum;
	
	/**
	 * this constructor is to construct a stack
	 */
	public Stack () {
		this.stack = new LinkedList<String>();
		this.topElement = "";
		this.elementNum = 0;
	}

	/**
	 * this method is to do the push action in the stack
	 * 
	 * @param pushedString the string that to be pushed
	 */
	public void push ( String pushedString ) {
		if ( pushedString != null ) {
			this.getStack().addFirst( pushedString );
			this.setTopElement( this.getStack().getFirst() );
			this.setElementNum( this.getElementNum() + 1 );
		}
	}
	
	/**
	 * this method is to do the pop action in the stack
	 * 
	 * @return popUpString the string that pop up
	 */
	public String pop () {
		String popUpString = "";
		
		if ( !this.isEmpty() ) {			
			popUpString = this.getStack().removeFirst();
			this.setTopElement( this.getStack().getFirst() );
			this.setElementNum( this.getElementNum() - 1 );
		}
		
		return popUpString;
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
	 * @return the topElement
	 */
	public String getTopElement() {
		return topElement;
	}

	/**
	 * @param topElement the topElement to set
	 */
	public void setTopElement(String topElement) {
		this.topElement = topElement;
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
