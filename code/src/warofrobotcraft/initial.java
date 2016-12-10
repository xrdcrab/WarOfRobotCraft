package warofrobotcraft;

import controller.*;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import sun.applet.Main;

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
		// get started with new controller
		Controller newGame = new Controller();     

		// play the background music
		try {
			Clip clip = AudioSystem.getClip();
			AudioInputStream inputStream = AudioSystem.getAudioInputStream(
					Main.class.getResourceAsStream("/Resources/background.wav"));
			clip.open(inputStream);
			// start to play the background music
			clip.start();
			// loop the background music
			clip.loop(1000000000);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
}
