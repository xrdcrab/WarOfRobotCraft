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
		LinkedList<String> stringList = new LinkedList<String>();

		for ( String retriveString: forthString.split("\\s+") ) {
				stringList.add( retriveString );		
		}
		
		return stringList;
	}
	
	/**
	 * this main method is to test methods in the interpreter class
	 * @param args should be not used
	 */
	public static void main(String args[]) {
		
		Interpreter interpreter = new Interpreter();
		LinkedList<String> stringList = new LinkedList<String>();
		for ( String str: interpreter.stringToList("hello        dutchyn	!  ")) {
			System.out.println(str + '/');
		}
	}
}
