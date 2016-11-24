/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

/**
 *
 * @author seanw
 */
public class UITest {

    public static void main(String[] args) {

        // test updateRobotLocation()
        GameBoardView gbv = new GameBoardView();
        gbv.setVisible(true);
        RobotLabel rl = new RobotLabel(0, "Sniper");
        gbv.updateRobotLocation(0, "Sniper", "z0z0z0");
    }
}
