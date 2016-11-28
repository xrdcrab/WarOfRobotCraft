package model;

import java.util.LinkedList;

/**
 * this class is to create an interpreter 
 * to transfer the forth script to the java code
 */
public class Interpreter {

	
	public Interpreter () {
		
	}
	
	/**
	 * this method is to transfer a string 
	 * to list of words in that string
	 * 
	 * @param forthString the string to be transfered
	 * @return stringList the linked list of words in that string
	 */
	private LinkedList<String> stringToList(String forthString) {
		LinkedList<String> stringList 
			= new LinkedList<String>();

		for ( String retriveString: forthString.split(" ") ) {
			stringList.add( retriveString );
		}
		
		return stringList;
	}
}
