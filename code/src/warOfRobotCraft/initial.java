package warOfRobotCraft;

import controller.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import model.Coordinate;
import view.GameBoardView;

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
            
            // testing
//            JLabel jLabel;
//            try {
//                jLabel = new GameBoardView().getHexagonLabel(new Coordinate(0, 0, 0).toString());
//            } catch (NoSuchFieldException ex) {
//                Logger.getLogger(initial.class.getName()).log(Level.SEVERE, null, ex);
//            } catch (IllegalArgumentException ex) {
//                Logger.getLogger(initial.class.getName()).log(Level.SEVERE, null, ex);
//            } catch (IllegalAccessException ex) {
//                Logger.getLogger(initial.class.getName()).log(Level.SEVERE, null, ex);
//            }
//            
//            Controller newGame = new Controller();
	}
}
