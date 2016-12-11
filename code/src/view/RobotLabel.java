package view;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * this class is to create the robot label for the view
 */
public class RobotLabel extends JLabel {

    /**
     * default serialVersionUID
     */
    private static final long serialVersionUID = 1L;
    
    private Timer animationTimer = new Timer();

    private int expectedRotateAngle = 0;
    private int rotateAngle = 0;
    private int animationSplitAngle = 0;

    /**
     * this class is to create the robot label with icon
     *
     * @param playerIndex
     * @param robotType
     */
    public RobotLabel(int playerIndex, String robotType) {
        super();
        try {
            Image image = ImageIO.read(ClassLoader.getSystemResource(
                    "Resources/"
                    + robotType
                    + this.playerIndexToColor(playerIndex)
                    + ".png"));
            ImageIcon imageIcon = new ImageIcon(image);
            this.setIcon(imageIcon);
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.setVerticalAlignment(CENTER);
        this.setHorizontalAlignment(CENTER);
    }

    /**
     * this helper method is to convert player index to color
     *
     * @param playerIndex the player index
     * @return color the color that the player index consistent with
     */
    private String playerIndexToColor(int playerIndex) {
        String color = "";

        switch (playerIndex) {
            case 0:
                color = "R";
                break;
            case 1:
                color = "O";
                break;
            case 2:
                color = "Y";
                break;
            case 3:
                color = "G";
                break;
            case 4:
                color = "B";
                break;
            case 5:
                color = "L";
                break;
        }
        return color;
    }
    
    
    /**
     * This is a helper function to display the current absolute direction of a robot. 
     * This is a preliminary function, but this is to be removed after the rotateImage
     * function works. 
     * @param robotLabel
     * @param direction 
     */
    private void displayAbsDirection(int direction){
        this.setText( String.valueOf(direction));
    }
    

    /**
     * this method will update robot icon when robot turn
     * @param direction, the turning direction
     */
    public void updateRotation(int direction) {
        switch (direction) {
            case 0:
                expectedRotateAngle = 0;
                break;
            case 1:
                expectedRotateAngle = 60;
                break;
            case 2:
                expectedRotateAngle = 120;
                break;
            case 3:
                expectedRotateAngle = 180;
                break;
            case 4:
                expectedRotateAngle = 240;
                break;
            case 5:
                expectedRotateAngle = 300;
                break;
            default:
                break;
        }
        
        animationSplitAngle = (expectedRotateAngle - rotateAngle) / 10;
        animationTimer.cancel();
        animationTimer = new Timer();
        animationTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                if(expectedRotateAngle == rotateAngle){
                    animationTimer.cancel();
                } else {
                    rotateAngle += animationSplitAngle;
                    repaint();
                }
            }
        }, 0, 10);
    }

    @Override
    protected void paintComponent(Graphics g
    ) {
        int w = getWidth(), h = getHeight();
        double theta = Math.toRadians(rotateAngle);
        Graphics2D g2d = (Graphics2D) g;
        g2d.rotate(theta, w / 2, h / 2);
        super.paintComponent(g);
    }

    public static void main(String args[]) {
        RobotLabel label = new RobotLabel(0, "Scout");
        JFrame frame = new JFrame();
        frame.add(label);
        frame.setVisible(true);
        frame.setSize(400, 300);
    }
}
