package io.github.astrapi69.chareditor.actions;

import io.github.astrapi69.chareditor.util.ClipboardUtils;
import io.github.astrapi69.chareditor.SpringBootSwingApplication;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class InputTACopyHtmlEntitys2ClipboardAction extends AbstractAction
		 {

	public InputTACopyHtmlEntitys2ClipboardAction(String name) {
		super(name);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		SpringBootSwingApplication frame = SpringBootSwingApplication.getInstance();
		JTextArea textAreaInput = frame.getMainPanel().getJtaInput();
		JTextArea textAreaHtmlEntitys = frame.getMainPanel().getJtaHtmlEntitys();
		ClipboardUtils
				.copy2Clipboard(textAreaInput, textAreaHtmlEntitys, false);

	}

}
