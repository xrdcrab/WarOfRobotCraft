package view;

import java.awt.Image;
import java.io.IOException;

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
                color = "V";
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
    

    public static void main(String args[]) {
        RobotLabel label = new RobotLabel(0, "Scout");
        JFrame frame = new JFrame();
        frame.add(label);
        frame.setVisible(true);
        frame.setSize(400, 300);
    }
}
