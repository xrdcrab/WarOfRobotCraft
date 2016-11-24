/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Color;
import java.lang.reflect.*;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

/**
 * this class is to create the view the game board
 */
public class GameBoardView extends javax.swing.JFrame {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private Timer currentRobotBlinkTimer = new Timer();
    private Class<?> gameBoardViewClass = GameBoardView.class;

    private int currentPlayerPosition = 0;
    private String currentRobotType = "Scout";

    private JLabel player0_scout;
    private JLabel player0_sniper;
    private JLabel player0_tank;

    private JLabel player1_scout;
    private JLabel player1_sniper;
    private JLabel player1_tank;

    private JLabel player2_scout;
    private JLabel player2_sniper;
    private JLabel player2_tank;

    private JLabel player3_scout;
    private JLabel player3_sniper;
    private JLabel player3_tank;

    private JLabel player4_scout;
    private JLabel player4_sniper;
    private JLabel player4_tank;

    private JLabel player5_scout;
    private JLabel player5_sniper;
    private JLabel player5_tank;

    /**
     * Creates new form GameBoardView
     */
    public GameBoardView() {
        initComponents();
        this.getContentPane().setBackground(Color.WHITE);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        gameBoardPanel = new javax.swing.JPanel();
        n2p2z0 = new javax.swing.JLabel();
        n4p4z0 = new javax.swing.JLabel();
        n3p3z0 = new javax.swing.JLabel();
        p3n3z0 = new javax.swing.JLabel();
        p4n4z0 = new javax.swing.JLabel();
        n1p1z0 = new javax.swing.JLabel();
        z0z0z0 = new javax.swing.JLabel();
        p1n1z0 = new javax.swing.JLabel();
        p2n2z0 = new javax.swing.JLabel();
        z0p4n4 = new javax.swing.JLabel();
        n4p3p1 = new javax.swing.JLabel();
        n3p2p1 = new javax.swing.JLabel();
        n2p1p1 = new javax.swing.JLabel();
        n1z0p1 = new javax.swing.JLabel();
        p1n2p1 = new javax.swing.JLabel();
        z0n1p1 = new javax.swing.JLabel();
        p2n3p1 = new javax.swing.JLabel();
        p3n4p1 = new javax.swing.JLabel();
        n4p2p2 = new javax.swing.JLabel();
        n3p1p2 = new javax.swing.JLabel();
        n2z0p2 = new javax.swing.JLabel();
        n1n1p2 = new javax.swing.JLabel();
        z0n2p2 = new javax.swing.JLabel();
        p1n3p2 = new javax.swing.JLabel();
        p2n4p2 = new javax.swing.JLabel();
        p1n4p3 = new javax.swing.JLabel();
        z0n3p3 = new javax.swing.JLabel();
        n1n2p3 = new javax.swing.JLabel();
        n2n1p3 = new javax.swing.JLabel();
        n3z0p3 = new javax.swing.JLabel();
        n4p1p3 = new javax.swing.JLabel();
        n4z0p4 = new javax.swing.JLabel();
        n3n1p4 = new javax.swing.JLabel();
        n2n2p4 = new javax.swing.JLabel();
        n1n3p4 = new javax.swing.JLabel();
        z0n4p4 = new javax.swing.JLabel();
        n3p4n1 = new javax.swing.JLabel();
        n2p3n1 = new javax.swing.JLabel();
        n1p2n1 = new javax.swing.JLabel();
        z0p1n1 = new javax.swing.JLabel();
        p1z0n1 = new javax.swing.JLabel();
        p2n1n1 = new javax.swing.JLabel();
        p3n2n1 = new javax.swing.JLabel();
        p4n3n1 = new javax.swing.JLabel();
        p4n2n2 = new javax.swing.JLabel();
        p3n1n2 = new javax.swing.JLabel();
        p2z0n2 = new javax.swing.JLabel();
        p1p1n2 = new javax.swing.JLabel();
        z0p2n2 = new javax.swing.JLabel();
        n1p3n2 = new javax.swing.JLabel();
        n2p4n2 = new javax.swing.JLabel();
        n1p4n3 = new javax.swing.JLabel();
        z0p3n3 = new javax.swing.JLabel();
        p1p2n3 = new javax.swing.JLabel();
        p2p1n3 = new javax.swing.JLabel();
        p3z0n3 = new javax.swing.JLabel();
        p4n1n3 = new javax.swing.JLabel();
        p4z0n4 = new javax.swing.JLabel();
        p3p1n4 = new javax.swing.JLabel();
        p2p2n4 = new javax.swing.JLabel();
        p1p3n4 = new javax.swing.JLabel();
        timerLabel = new javax.swing.JLabel();
        homeButton = new javax.swing.JButton();
        endPlayButton = new javax.swing.JButton();
        giveUpButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setBounds(new java.awt.Rectangle(0, 0, 1003, 748));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMaximumSize(new java.awt.Dimension(1003, 748));
        setPreferredSize(new java.awt.Dimension(1003, 748));

        gameBoardPanel.setBackground(new java.awt.Color(255, 255, 255));
        gameBoardPanel.setMaximumSize(new java.awt.Dimension(600, 480));
        gameBoardPanel.setPreferredSize(new java.awt.Dimension(600, 480));
        gameBoardPanel.setLayout(null);

        n2p2z0.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Polygon.png"))); // NOI18N
        gameBoardPanel.add(n2p2z0);
        n2p2z0.setBounds(133, 207, 67, 66);

        n4p4z0.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Polygon.png"))); // NOI18N
        gameBoardPanel.add(n4p4z0);
        n4p4z0.setBounds(1, 207, 67, 66);

        n3p3z0.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Polygon.png"))); // NOI18N
        gameBoardPanel.add(n3p3z0);
        n3p3z0.setBounds(67, 207, 67, 66);

        p3n3z0.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Polygon.png"))); // NOI18N
        gameBoardPanel.add(p3n3z0);
        p3n3z0.setBounds(463, 207, 67, 66);

        p4n4z0.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Polygon.png"))); // NOI18N
        gameBoardPanel.add(p4n4z0);
        p4n4z0.setBounds(529, 207, 67, 66);

        n1p1z0.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Polygon.png"))); // NOI18N
        gameBoardPanel.add(n1p1z0);
        n1p1z0.setBounds(199, 207, 67, 66);

        z0z0z0.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Polygon.png"))); // NOI18N
        gameBoardPanel.add(z0z0z0);
        z0z0z0.setBounds(265, 207, 67, 66);

        p1n1z0.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Polygon.png"))); // NOI18N
        gameBoardPanel.add(p1n1z0);
        p1n1z0.setBounds(331, 207, 67, 66);

        p2n2z0.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Polygon.png"))); // NOI18N
        gameBoardPanel.add(p2n2z0);
        p2n2z0.setBounds(397, 207, 67, 66);

        z0p4n4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Polygon.png"))); // NOI18N
        gameBoardPanel.add(z0p4n4);
        z0p4n4.setBounds(133, 3, 67, 66);

        n4p3p1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Polygon.png"))); // NOI18N
        gameBoardPanel.add(n4p3p1);
        n4p3p1.setBounds(34, 258, 67, 66);

        n3p2p1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Polygon.png"))); // NOI18N
        gameBoardPanel.add(n3p2p1);
        n3p2p1.setBounds(100, 258, 67, 66);

        n2p1p1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Polygon.png"))); // NOI18N
        gameBoardPanel.add(n2p1p1);
        n2p1p1.setBounds(166, 258, 67, 66);

        n1z0p1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Polygon.png"))); // NOI18N
        gameBoardPanel.add(n1z0p1);
        n1z0p1.setBounds(232, 258, 67, 66);

        p1n2p1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Polygon.png"))); // NOI18N
        gameBoardPanel.add(p1n2p1);
        p1n2p1.setBounds(364, 258, 67, 66);

        z0n1p1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Polygon.png"))); // NOI18N
        gameBoardPanel.add(z0n1p1);
        z0n1p1.setBounds(298, 258, 67, 66);

        p2n3p1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Polygon.png"))); // NOI18N
        gameBoardPanel.add(p2n3p1);
        p2n3p1.setBounds(430, 258, 67, 66);

        p3n4p1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Polygon.png"))); // NOI18N
        gameBoardPanel.add(p3n4p1);
        p3n4p1.setBounds(496, 258, 67, 66);

        n4p2p2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Polygon.png"))); // NOI18N
        gameBoardPanel.add(n4p2p2);
        n4p2p2.setBounds(67, 309, 67, 66);

        n3p1p2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Polygon.png"))); // NOI18N
        gameBoardPanel.add(n3p1p2);
        n3p1p2.setBounds(133, 309, 67, 66);

        n2z0p2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Polygon.png"))); // NOI18N
        gameBoardPanel.add(n2z0p2);
        n2z0p2.setBounds(199, 309, 67, 66);

        n1n1p2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Polygon.png"))); // NOI18N
        gameBoardPanel.add(n1n1p2);
        n1n1p2.setBounds(265, 309, 67, 66);

        z0n2p2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Polygon.png"))); // NOI18N
        gameBoardPanel.add(z0n2p2);
        z0n2p2.setBounds(331, 309, 67, 66);

        p1n3p2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Polygon.png"))); // NOI18N
        gameBoardPanel.add(p1n3p2);
        p1n3p2.setBounds(397, 309, 67, 66);

        p2n4p2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Polygon.png"))); // NOI18N
        gameBoardPanel.add(p2n4p2);
        p2n4p2.setBounds(463, 309, 67, 66);

        p1n4p3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Polygon.png"))); // NOI18N
        gameBoardPanel.add(p1n4p3);
        p1n4p3.setBounds(430, 360, 67, 66);

        z0n3p3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Polygon.png"))); // NOI18N
        gameBoardPanel.add(z0n3p3);
        z0n3p3.setBounds(364, 360, 67, 66);

        n1n2p3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Polygon.png"))); // NOI18N
        gameBoardPanel.add(n1n2p3);
        n1n2p3.setBounds(298, 360, 67, 66);

        n2n1p3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Polygon.png"))); // NOI18N
        gameBoardPanel.add(n2n1p3);
        n2n1p3.setBounds(232, 360, 67, 66);

        n3z0p3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Polygon.png"))); // NOI18N
        gameBoardPanel.add(n3z0p3);
        n3z0p3.setBounds(166, 360, 67, 66);

        n4p1p3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Polygon.png"))); // NOI18N
        gameBoardPanel.add(n4p1p3);
        n4p1p3.setBounds(100, 360, 67, 66);

        n4z0p4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Polygon.png"))); // NOI18N
        gameBoardPanel.add(n4z0p4);
        n4z0p4.setBounds(133, 411, 67, 66);

        n3n1p4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Polygon.png"))); // NOI18N
        gameBoardPanel.add(n3n1p4);
        n3n1p4.setBounds(199, 411, 67, 66);

        n2n2p4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Polygon.png"))); // NOI18N
        gameBoardPanel.add(n2n2p4);
        n2n2p4.setBounds(265, 411, 67, 66);

        n1n3p4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Polygon.png"))); // NOI18N
        gameBoardPanel.add(n1n3p4);
        n1n3p4.setBounds(331, 411, 67, 66);

        z0n4p4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Polygon.png"))); // NOI18N
        gameBoardPanel.add(z0n4p4);
        z0n4p4.setBounds(397, 411, 67, 66);

        n3p4n1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Polygon.png"))); // NOI18N
        gameBoardPanel.add(n3p4n1);
        n3p4n1.setBounds(34, 156, 67, 66);

        n2p3n1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Polygon.png"))); // NOI18N
        gameBoardPanel.add(n2p3n1);
        n2p3n1.setBounds(100, 156, 67, 66);

        n1p2n1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Polygon.png"))); // NOI18N
        gameBoardPanel.add(n1p2n1);
        n1p2n1.setBounds(166, 156, 67, 66);

        z0p1n1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Polygon.png"))); // NOI18N
        gameBoardPanel.add(z0p1n1);
        z0p1n1.setBounds(232, 156, 67, 66);

        p1z0n1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Polygon.png"))); // NOI18N
        gameBoardPanel.add(p1z0n1);
        p1z0n1.setBounds(298, 156, 67, 66);

        p2n1n1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Polygon.png"))); // NOI18N
        gameBoardPanel.add(p2n1n1);
        p2n1n1.setBounds(364, 156, 67, 66);

        p3n2n1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Polygon.png"))); // NOI18N
        gameBoardPanel.add(p3n2n1);
        p3n2n1.setBounds(430, 156, 67, 66);

        p4n3n1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Polygon.png"))); // NOI18N
        gameBoardPanel.add(p4n3n1);
        p4n3n1.setBounds(496, 156, 67, 66);

        p4n2n2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Polygon.png"))); // NOI18N
        gameBoardPanel.add(p4n2n2);
        p4n2n2.setBounds(463, 105, 67, 66);

        p3n1n2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Polygon.png"))); // NOI18N
        gameBoardPanel.add(p3n1n2);
        p3n1n2.setBounds(397, 105, 67, 66);

        p2z0n2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Polygon.png"))); // NOI18N
        gameBoardPanel.add(p2z0n2);
        p2z0n2.setBounds(331, 105, 67, 66);

        p1p1n2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Polygon.png"))); // NOI18N
        gameBoardPanel.add(p1p1n2);
        p1p1n2.setBounds(265, 105, 67, 66);

        z0p2n2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Polygon.png"))); // NOI18N
        gameBoardPanel.add(z0p2n2);
        z0p2n2.setBounds(199, 105, 67, 66);

        n1p3n2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Polygon.png"))); // NOI18N
        gameBoardPanel.add(n1p3n2);
        n1p3n2.setBounds(133, 105, 67, 66);

        n2p4n2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Polygon.png"))); // NOI18N
        gameBoardPanel.add(n2p4n2);
        n2p4n2.setBounds(67, 105, 67, 66);

        n1p4n3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Polygon.png"))); // NOI18N
        gameBoardPanel.add(n1p4n3);
        n1p4n3.setBounds(100, 54, 67, 66);

        z0p3n3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Polygon.png"))); // NOI18N
        gameBoardPanel.add(z0p3n3);
        z0p3n3.setBounds(166, 54, 67, 66);

        p1p2n3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Polygon.png"))); // NOI18N
        gameBoardPanel.add(p1p2n3);
        p1p2n3.setBounds(232, 54, 67, 66);

        p2p1n3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Polygon.png"))); // NOI18N
        gameBoardPanel.add(p2p1n3);
        p2p1n3.setBounds(298, 54, 67, 66);

        p3z0n3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Polygon.png"))); // NOI18N
        gameBoardPanel.add(p3z0n3);
        p3z0n3.setBounds(364, 54, 67, 66);

        p4n1n3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Polygon.png"))); // NOI18N
        gameBoardPanel.add(p4n1n3);
        p4n1n3.setBounds(430, 54, 67, 66);

        p4z0n4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Polygon.png"))); // NOI18N
        gameBoardPanel.add(p4z0n4);
        p4z0n4.setBounds(397, 3, 67, 66);

        p3p1n4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Polygon.png"))); // NOI18N
        gameBoardPanel.add(p3p1n4);
        p3p1n4.setBounds(331, 3, 67, 66);

        p2p2n4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Polygon.png"))); // NOI18N
        gameBoardPanel.add(p2p2n4);
        p2p2n4.setBounds(265, 3, 67, 66);

        p1p3n4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Polygon.png"))); // NOI18N
        gameBoardPanel.add(p1p3n4);
        p1p3n4.setBounds(199, 3, 67, 66);

        timerLabel.setBackground(new java.awt.Color(255, 255, 255));
        timerLabel.setFont(new java.awt.Font("Comic Sans MS", 1, 60)); // NOI18N
        timerLabel.setForeground(new java.awt.Color(152, 180, 212));
        timerLabel.setText("10");

        homeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Home.png"))); // NOI18N
        homeButton.setToolTipText("");
        homeButton.setBorderPainted(false);
        homeButton.setContentAreaFilled(false);

        endPlayButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/endPlay.png"))); // NOI18N
        endPlayButton.setBorderPainted(false);
        endPlayButton.setContentAreaFilled(false);
        endPlayButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                endPlayButtonActionPerformed(evt);
            }
        });

        giveUpButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/giveUp.png"))); // NOI18N
        giveUpButton.setBorderPainted(false);
        giveUpButton.setContentAreaFilled(false);

        jLabel1.setText("jLabel1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(homeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(371, 371, 371)
                        .addComponent(timerLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(370, 370, 370)
                        .addComponent(endPlayButton, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(151, 151, 151)
                        .addComponent(giveUpButton, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(97, 97, 97)
                        .addComponent(jLabel1)
                        .addGap(61, 61, 61)
                        .addComponent(gameBoardPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(204, 204, 204))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(homeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(timerLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(gameBoardPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(97, 97, 97)
                        .addComponent(jLabel1)))
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(giveUpButton, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(endPlayButton))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void endPlayButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_endPlayButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_endPlayButtonActionPerformed

    public void updateTimerNumber(int number) {
        timerLabel.setText("" + number);

    }

    public void updateMist(HashMap<String, Boolean> hashMap) {

    }

    public void updateOperationState(String state) {
        jLabel1.setText(state);
    }

    public void updateRobotDestruction(int playerPosition, String RobotType) {
        JLabel robotLabel = getRobotLabel(playerPosition, RobotType);
        if (robotLabel != null) {
            gameBoardPanel.remove(robotLabel);
        }
    }

    public void updateCurrentRobot(String robotType) {
        // stop the previous timer
        currentRobotBlinkTimer.cancel();
        getRobotLabel(currentPlayerPosition, currentRobotType).setEnabled(true);

        // start a new task
        currentRobotType = robotType;
        currentRobotBlinkTimer = new Timer();
        currentRobotBlinkTimer.schedule(
                new TimerTask() {
            @Override
            public void run() {
                JLabel robotLabel = getRobotLabel(currentPlayerPosition, currentRobotType);
                robotLabel.setEnabled(!robotLabel.isEnabled());
            }
        },
                0,
                200
        );
    }

    public void updateRobotDamaged(int playerPosition, String robotType, int attackPoint) {

    }

    public void updatePlayerDeath(int playerPosition) {

    }

    public void updateCurrentPlayer(int playerPosition) {
        currentPlayerPosition = playerPosition;
    }

    public void updateRobotLocation(int playerPosition, String RobotType, String coordString) {
        JLabel robotLabel = getRobotLabel(playerPosition, RobotType.toLowerCase());
        JLabel hexagonLabel = getHexagonLabel(coordString);

        if (hexagonLabel != null) {
            if (robotLabel == null) {
                setRobotLabel(playerPosition, RobotType, new RobotLabel(playerPosition, RobotType));
                robotLabel = getRobotLabel(playerPosition, RobotType.toLowerCase());
                gameBoardPanel.add(robotLabel);
            }
            robotLabel.setBounds(hexagonLabel.getBounds());
        }
    }

    private JLabel getRobotLabel(int playerPosition, String robotType) {
        try {
            Field robotField = gameBoardViewClass.getDeclaredField("player" + playerPosition + "_" + robotType);
            robotField.setAccessible(true);
            return (JLabel) robotField.get(this);
        } catch (NoSuchFieldException | IllegalArgumentException | IllegalAccessException ex) {
            return null;
        }
    }

    private void setRobotLabel(int playerPosition, String robotType, JLabel value) {
        try {
            Field robotField = gameBoardViewClass.getDeclaredField("player" + playerPosition + "_" + robotType.toLowerCase());
            robotField.setAccessible(true);
            robotField.set(this, value);
        } catch (NoSuchFieldException | IllegalArgumentException | IllegalAccessException ex) {
            // do nothing
        }
    }

    public JLabel getHexagonLabel(String coordString) {
        try {
            Field labelField = gameBoardViewClass.getDeclaredField(coordString);
            labelField.setAccessible(true);
            return (JLabel) labelField.get(this);
        } catch (NoSuchFieldException | IllegalArgumentException | IllegalAccessException ex) {
            return null;
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GameBoardView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GameBoardView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GameBoardView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GameBoardView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GameBoardView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton endPlayButton;
    private javax.swing.JPanel gameBoardPanel;
    private javax.swing.JButton giveUpButton;
    private javax.swing.JButton homeButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel n1n1p2;
    private javax.swing.JLabel n1n2p3;
    private javax.swing.JLabel n1n3p4;
    private javax.swing.JLabel n1p1z0;
    private javax.swing.JLabel n1p2n1;
    private javax.swing.JLabel n1p3n2;
    private javax.swing.JLabel n1p4n3;
    private javax.swing.JLabel n1z0p1;
    private javax.swing.JLabel n2n1p3;
    private javax.swing.JLabel n2n2p4;
    private javax.swing.JLabel n2p1p1;
    private javax.swing.JLabel n2p2z0;
    private javax.swing.JLabel n2p3n1;
    private javax.swing.JLabel n2p4n2;
    private javax.swing.JLabel n2z0p2;
    private javax.swing.JLabel n3n1p4;
    private javax.swing.JLabel n3p1p2;
    private javax.swing.JLabel n3p2p1;
    private javax.swing.JLabel n3p3z0;
    private javax.swing.JLabel n3p4n1;
    private javax.swing.JLabel n3z0p3;
    private javax.swing.JLabel n4p1p3;
    private javax.swing.JLabel n4p2p2;
    private javax.swing.JLabel n4p3p1;
    private javax.swing.JLabel n4p4z0;
    private javax.swing.JLabel n4z0p4;
    private javax.swing.JLabel p1n1z0;
    private javax.swing.JLabel p1n2p1;
    private javax.swing.JLabel p1n3p2;
    private javax.swing.JLabel p1n4p3;
    private javax.swing.JLabel p1p1n2;
    private javax.swing.JLabel p1p2n3;
    private javax.swing.JLabel p1p3n4;
    private javax.swing.JLabel p1z0n1;
    private javax.swing.JLabel p2n1n1;
    private javax.swing.JLabel p2n2z0;
    private javax.swing.JLabel p2n3p1;
    private javax.swing.JLabel p2n4p2;
    private javax.swing.JLabel p2p1n3;
    private javax.swing.JLabel p2p2n4;
    private javax.swing.JLabel p2z0n2;
    private javax.swing.JLabel p3n1n2;
    private javax.swing.JLabel p3n2n1;
    private javax.swing.JLabel p3n3z0;
    private javax.swing.JLabel p3n4p1;
    private javax.swing.JLabel p3p1n4;
    private javax.swing.JLabel p3z0n3;
    private javax.swing.JLabel p4n1n3;
    private javax.swing.JLabel p4n2n2;
    private javax.swing.JLabel p4n3n1;
    private javax.swing.JLabel p4n4z0;
    private javax.swing.JLabel p4z0n4;
    private javax.swing.JLabel timerLabel;
    private javax.swing.JLabel z0n1p1;
    private javax.swing.JLabel z0n2p2;
    private javax.swing.JLabel z0n3p3;
    private javax.swing.JLabel z0n4p4;
    private javax.swing.JLabel z0p1n1;
    private javax.swing.JLabel z0p2n2;
    private javax.swing.JLabel z0p3n3;
    private javax.swing.JLabel z0p4n4;
    private javax.swing.JLabel z0z0z0;
    // End of variables declaration//GEN-END:variables
	/**
     * @return the endPlayButton
     */
    public javax.swing.JButton getEndPlayButton() {
        return endPlayButton;
    }

    /**
     * @param endPlayButton the endPlayButton to set
     */
    public void setEndPlayButton(javax.swing.JButton endPlayButton) {
        this.endPlayButton = endPlayButton;
    }

    /**
     * @return the giveUpButton
     */
    public javax.swing.JButton getGiveUpButton() {
        return giveUpButton;
    }

    /**
     * @param giveUpButton the giveUpButton to set
     */
    public void setGiveUpButton(javax.swing.JButton giveUpButton) {
        this.giveUpButton = giveUpButton;
    }

    /**
     * @return the homeButton
     */
    public javax.swing.JButton getHomeButton() {
        return homeButton;
    }

    /**
     *
     * public static void main(String[] args) {
     *
     * }
     *
     * @param homeButton the homeButton to set
     */
    public void setHomeButton(javax.swing.JButton homeButton) {
        this.homeButton = homeButton;
    }

    /**
     * @return the timerLabel
     */
    public javax.swing.JLabel getTimerLabel() {
        return timerLabel;
    }

    /**
     * @param timerLabel the timerLabel to set
     */
    public void setTimerLabel(javax.swing.JLabel timerLabel) {
        this.timerLabel = timerLabel;
    }
}
