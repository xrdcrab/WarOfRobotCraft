
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
     * @param playerIndex
     * @param robotType 
     */
    public RobotLabel ( int playerIndex, String robotType ) {
        super();
//        ImageIcon robotIcon = new ImageIcon();
//        this.setIcon(new javax.swing.ImageIcon(getClass().getResource(
//                this.playerIndexToColor(playerIndex) + robotType + ".png")));
        try {
			Image image = ImageIO.read(ClassLoader.getSystemResource(
					"Resources/" + 
							robotType + 
								this.playerIndexToColor(playerIndex) + 
									".png"));
			ImageIcon imageIcon = new ImageIcon(image);
			this.setIcon(imageIcon);
    	} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    /**
     * this helper method is to convert player index to color
     * 
     * @param playerIndex the player index
     * @return color the color that the player index consistent with
     */
    private String playerIndexToColor( int playerIndex ) {
        String color = "";
    
        switch ( playerIndex ) {
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
    
    public static void main (String args[]) {
//    	RobotLabel robot = new RobotLabel(0, "Tank");
//    	robot.setIcon(new javax.swing.ImageIcon(getClass().getResource(
//    			robot.playerIndexToColor(0) + "Tank" + ".png")));
//    	Image image;
//    	try {
//			image = ImageIO.read(ClassLoader.getSystemResource("Resources/endPlay.png"));
//			ImageIcon imageIcon = new ImageIcon(image);
//			JLabel label = new JLabel(imageIcon);
//			JFrame frame = new JFrame();
//			frame.add(label);
//			frame.setVisible(true);
//			frame.setSize(400, 300);
//    	} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
    	
    	RobotLabel label = new RobotLabel(0, "Scout");
		JFrame frame = new JFrame();
		frame.add(label);
		frame.setVisible(true);
		frame.setSize(400, 300);
    }
}
