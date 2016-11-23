/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

/**
 *
 * @author chen
 */
public class GameStartView extends javax.swing.JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
     * Creates new form GameStartView
     */
    public GameStartView() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        exitButton = new javax.swing.JButton();
        startButton = new javax.swing.JButton();
        garageButton = new javax.swing.JButton();
        gameNameLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1003, 748));
        setMinimumSize(new java.awt.Dimension(1003, 748));
        setSize(new java.awt.Dimension(1003, 748));
        getContentPane().setLayout(null);

        exitButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Exit.png"))); // NOI18N
        exitButton.setBorderPainted(false);
        exitButton.setContentAreaFilled(false);
        exitButton.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/ExitL.png"))); // NOI18N
        exitButton.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/ExitL1.png"))); // NOI18N
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });
        getContentPane().add(exitButton);
        exitButton.setBounds(360, 550, 260, 80);

        startButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/start.png"))); // NOI18N
        startButton.setBorderPainted(false);
        startButton.setContentAreaFilled(false);
        startButton.setOpaque(false);
        startButton.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/startL.png"))); // NOI18N
        startButton.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/startL1.png"))); // NOI18N
        startButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startButtonActionPerformed(evt);
            }
        });
        getContentPane().add(startButton);
        startButton.setBounds(370, 340, 250, 80);

        garageButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Garage.png"))); // NOI18N
        garageButton.setBorderPainted(false);
        garageButton.setContentAreaFilled(false);
        garageButton.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/GarageL.png"))); // NOI18N
        garageButton.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/GarageL1.png"))); // NOI18N
        garageButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                garageButtonActionPerformed(evt);
            }
        });
        getContentPane().add(garageButton);
        garageButton.setBounds(370, 450, 250, 70);

        gameNameLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/gameStartBG.png"))); // NOI18N
        getContentPane().add(gameNameLabel);
        gameNameLabel.setBounds(0, 0, 1003, 748);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_exitButtonActionPerformed

    private void startButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_startButtonActionPerformed

    private void garageButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_garageButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_garageButtonActionPerformed

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
            java.util.logging.Logger.getLogger(GameStartView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GameStartView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GameStartView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GameStartView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GameStartView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton exitButton;
    private javax.swing.JLabel gameNameLabel;
    private javax.swing.JButton garageButton;
    private javax.swing.JButton startButton;
    // End of variables declaration//GEN-END:variables
	/**
	 * @return the exitButton
	 */
	public javax.swing.JButton getExitButton() {
		return exitButton;
	}

	/**
	 * @param exitButton the exitButton to set
	 */
	public void setExitButton(javax.swing.JButton exitButton) {
		this.exitButton = exitButton;
	}

	/**
	 * @return the gameNameLabel
	 */
	public javax.swing.JLabel getGameNameLabel() {
		return gameNameLabel;
	}

	/**
	 * @param gameNameLabel the gameNameLabel to set
	 */
	public void setGameNameLabel(javax.swing.JLabel gameNameLabel) {
		this.gameNameLabel = gameNameLabel;
	}

	/**
	 * @return the garageButton
	 */
	public javax.swing.JButton getGarageButton() {
		return garageButton;
	}

	/**
	 * @param garageButton the garageButton to set
	 */
	public void setGarageButton(javax.swing.JButton garageButton) {
		this.garageButton = garageButton;
	}

	/**
	 * @return the startButton
	 */
	public javax.swing.JButton getStartButton() {
		return startButton;
	}

	/**
	 * @param startButton the startButton to set
	 */
	public void setStartButton(javax.swing.JButton startButton) {
		this.startButton = startButton;
	}
    

}
