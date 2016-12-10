/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aiutil;

/**
 *
 * @author seanw
 */
public class AIEvent extends java.util.EventObject {

    String action = "";
    int value; 

    public String getActionString() {
        return this.action;
    }

    /**
	 * @return the value
	 */
	public int getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(int value) {
		this.value = value;
	}

	public void setActionString(String actionString) {
        this.action = actionString;
    }

    public AIEvent(Object source) {
        super(source);
    }
}
