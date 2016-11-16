package warOfRobotCraft;

import controller.*;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

/**
 * this is the game system entry point
 */
public class initial {

	@SuppressWarnings("unused")
	public static void main(String args[]) {
            try {
                for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                    if ("Nimbus".equals(info.getName())) {
                        UIManager.setLookAndFeel(info.getClassName());
                        break;
                    }
                }
            } catch (Exception e) {
                // If Nimbus is not available, fall back to cross-platform
                try {
                    UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
                } catch (Exception ex) {
                    // not worth my time
                }
            }
            
            Controller newGame = new Controller();
	}
}
