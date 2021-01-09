package gr.frame.main;

import de.alpharogroup.swing.plaf.LookAndFeels;
import gr.frame.MainFrame;
import gr.frame.events.SystemTrayMenu;

import java.awt.Toolkit;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;


public class StartApplication {
    /**
     * @param args
     */
    public static void main(String[] args) {
		// make the systemtray visible...
		// TODO check if system tray is supported
//		SystemTrayMenu.getInstance();
		final MainFrame mainFrame = MainFrame.getInstance();
        int x = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
        int y = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
        mainFrame.setLocation(0, 0);
        mainFrame.setSize(x, y-70);
        mainFrame.setVisible(true);

        // Set default look and feel...
    	SwingUtilities.invokeLater(new Runnable() {

			public void run() {

				try {
					UIManager.setLookAndFeel(LookAndFeels.SYSTEM.getLookAndFeelName());
					SwingUtilities.updateComponentTreeUI(mainFrame);
					mainFrame.setCurrentLookAndFeels(LookAndFeels.SYSTEM);
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (InstantiationException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IllegalAccessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (UnsupportedLookAndFeelException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});

    }
}
