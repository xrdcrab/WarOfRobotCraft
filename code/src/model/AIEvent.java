/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author seanw
 */
public class AIEvent extends java.util.EventObject {

    String action = "";

    public String getActionString() {
        return this.action;
    }

    public void setActionString(String actionString) {
        this.action = actionString;
    }

    public AIEvent(Object source) {
        super(source);
    }
}
