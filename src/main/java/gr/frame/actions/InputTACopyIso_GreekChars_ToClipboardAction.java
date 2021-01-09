package gr.frame.actions;

import gr.frame.MainFrame;
import gr.frame.util.Constants;
import gr.frame.utils.ClipboardUtils;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class InputTACopyIso_GreekChars_ToClipboardAction extends AbstractAction
		implements Constants {

	public InputTACopyIso_GreekChars_ToClipboardAction(String name) {
		super(name);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		MainFrame frame = MainFrame.getInstance();
		JTextArea textAreaPreview = frame.getJtaPreview();
		ClipboardUtils
				.copyToClipboard(textAreaPreview);

	}

}
