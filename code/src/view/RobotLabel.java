
package view;

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
        this.setIcon(new javax.swing.ImageIcon(getClass().getResource(
                this.playerIndexToColor(playerIndex) + robotType + ".png")));
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
}
