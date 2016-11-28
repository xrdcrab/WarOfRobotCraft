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
public class RobotStatusView extends javax.swing.JPanel {

    /**
     * Creates new form robotStatusView
     */
    public RobotStatusView() {
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

        robotNameLabel = new javax.swing.JLabel();
        robotTypeLabel = new javax.swing.JLabel();
        robotIconLabel = new javax.swing.JLabel();
        healthPointProgressBar = new javax.swing.JProgressBar();
        healthPointLabel = new javax.swing.JLabel();
        movingPointLabel = new javax.swing.JLabel();
        movingPointProgressBar = new javax.swing.JProgressBar();
        healthPointValueLabel = new javax.swing.JLabel();
        movingPointValueLabel = new javax.swing.JLabel();

        setLayout(null);

        robotNameLabel.setText("Robot Name");
        add(robotNameLabel);
        robotNameLabel.setBounds(6, 6, 69, 18);

        robotTypeLabel.setText("RobotType");
        add(robotTypeLabel);
        robotTypeLabel.setBounds(93, 6, 60, 18);

        robotIconLabel.setText("Icon");
        add(robotIconLabel);
        robotIconLabel.setBounds(6, 30, 24, 18);
        add(healthPointProgressBar);
        healthPointProgressBar.setBounds(120, 30, 90, 20);

        healthPointLabel.setText("Health Point");
        add(healthPointLabel);
        healthPointLabel.setBounds(40, 30, 68, 18);

        movingPointLabel.setText("Moving Point");
        add(movingPointLabel);
        movingPointLabel.setBounds(40, 50, 72, 18);
        add(movingPointProgressBar);
        movingPointProgressBar.setBounds(120, 50, 90, 20);

        healthPointValueLabel.setText("0");
        add(healthPointValueLabel);
        healthPointValueLabel.setBounds(210, 30, 10, 18);

        movingPointValueLabel.setText("0");
        add(movingPointValueLabel);
        movingPointValueLabel.setBounds(210, 50, 10, 18);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel healthPointLabel;
    private javax.swing.JProgressBar healthPointProgressBar;
    private javax.swing.JLabel healthPointValueLabel;
    private javax.swing.JLabel movingPointLabel;
    private javax.swing.JProgressBar movingPointProgressBar;
    private javax.swing.JLabel movingPointValueLabel;
    private javax.swing.JLabel robotIconLabel;
    private javax.swing.JLabel robotNameLabel;
    private javax.swing.JLabel robotTypeLabel;
    // End of variables declaration//GEN-END:variables

    public void updateRobotName(String robotName){
        robotNameLabel.setText(robotName);
    }
    
    public void updateRobotType(String robotType){
        robotTypeLabel.setText(robotType);
    }
    
    public void updateHealthPointLimit(int maxHealthPoint){
        healthPointProgressBar.setMaximum(maxHealthPoint);
    }
    
    public void updateHealthPoint(int healthPoint){
        healthPointProgressBar.setValue(healthPoint);
        healthPointValueLabel.setText(healthPoint + "");
    }
    
    public void updateMovingPointLimit(int maxMovingPoint){
        movingPointProgressBar.setMaximum(maxMovingPoint);
    }
    
    public void updateMovingPoint(int movingPoint){
        movingPointProgressBar.setValue(movingPoint);
        movingPointValueLabel.setText(movingPoint + "");
    }
}
