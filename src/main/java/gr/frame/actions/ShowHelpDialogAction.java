package gr.frame.actions;


import de.alpharogroup.swing.plaf.LookAndFeels;
import gr.frame.MainFrame;

import java.awt.Window;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;


@SuppressWarnings("serial")
public class ShowHelpDialogAction extends AbstractAction {

	public ShowHelpDialogAction(String name) {
		super(name);
	}

	public void actionPerformed(ActionEvent e) {
		LookAndFeels currentLaf = MainFrame.getInstance().getCurrentLookAndFeels();
		Window helpWindow = MainFrame.getInstance().getHelpWindow();
		helpWindow.setLocationRelativeTo(null);
		try {
			UIManager.setLookAndFeel(currentLaf.getLookAndFeelName());
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		SwingUtilities.updateComponentTreeUI(helpWindow);
	}
}
