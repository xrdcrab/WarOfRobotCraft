/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author seanw
 */
public class UITest {

    public static void main(String[] args) {

        try {
            // test updateRobotLocation()
            GameBoardView gbv = new GameBoardView();
            gbv.setVisible(true);
            RobotLabel rl = new RobotLabel(0, "Sniper");
            
            gbv.updateRobotLocation(3, "Tank", "z0p1n1");
            Thread.sleep(1000);
            gbv.updateRobotLocation(0, "Sniper", "n1p1z0");
            Thread.sleep(1000);
            gbv.updateRobotLocation(3, "Tank", "z0z0z0");
            Thread.sleep(1000);
            gbv.updateRobotLocation(0, "Sniper", "z0z0z0");
            Thread.sleep(1000);
            gbv.updateRobotLocation(0, "Sniper", "z0n1p1");
            Thread.sleep(1000);
            gbv.updateRobotLocation(0, "Sniper", "z0n2p2");
            Thread.sleep(1000);
            gbv.updateRobotLocation(0, "Sniper", "n1n1p2");
            Thread.sleep(1000);
            gbv.updateRobotDestruction(0, "Sniper");
            Thread.sleep(1000);
            HashMap<String,Boolean> hm = new HashMap<String,Boolean>();
            hm.put("z0z0z0", false);
            hm.put("z0n1p1", false);
            hm.put("z0n2p2", true);
            gbv.updateMist(hm);
        } catch (InterruptedException ex) {
            Logger.getLogger(UITest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        JFrame jf = new JFrame();
        RobotStatusView rsv = new RobotStatusView();
        rsv.updateRobotName("HAHAHA");
        rsv.updateRobotType("Superman");
        rsv.updateHealthPointLimit(10);
        rsv.updateHealthPoint(5);
        rsv.updateMovingPointLimit(5);
        rsv.updateMovingPoint(3);
        jf.add(rsv);
        jf.setVisible(true);
    }
}
