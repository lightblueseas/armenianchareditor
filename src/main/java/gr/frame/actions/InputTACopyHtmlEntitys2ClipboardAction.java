package gr.frame.actions;

import gr.frame.MainFrame;
import gr.frame.util.Constants;
import gr.frame.utils.ClipboardUtils;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class InputTACopyHtmlEntitys2ClipboardAction extends AbstractAction
		implements Constants {

	public InputTACopyHtmlEntitys2ClipboardAction(String name) {
		super(name);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		MainFrame frame = MainFrame.getInstance();
		JTextArea textAreaInput = frame.getJtaInput();
		JTextArea textAreaHtmlEntitys = frame.getJtaHtmlEntitys();
		ClipboardUtils
				.copy2Clipboard(textAreaInput, textAreaHtmlEntitys, false);

	}

}
