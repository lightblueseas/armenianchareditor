package gr.frame.actions;

import gr.frame.MainFrame;
import gr.frame.util.Constants;
import gr.frame.utils.ClipboardUtils;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class InputTACopyIso_8859_7_ToClipboardAction extends AbstractAction
		implements Constants {

	public InputTACopyIso_8859_7_ToClipboardAction(String name) {
		super(name);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		MainFrame frame = MainFrame.getInstance();
		JTextArea textAreaInput = frame.getJtaInput();
		JTextArea textAreaISO_8859_7 = frame.getJtaIso8859_7();
		ClipboardUtils
				.copy2Clipboard(textAreaInput, textAreaISO_8859_7, false);

	}

}
