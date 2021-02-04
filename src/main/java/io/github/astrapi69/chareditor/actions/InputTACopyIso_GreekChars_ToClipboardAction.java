package io.github.astrapi69.chareditor.actions;

import io.github.astrapi69.chareditor.util.ClipboardUtils;
import io.github.astrapi69.chareditor.SpringBootSwingApplication;

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
		SpringBootSwingApplication frame = SpringBootSwingApplication.getInstance();
		JTextArea textAreaPreview = frame.getMainPanel().getJtaPreview();
		ClipboardUtils
				.copyToClipboard(textAreaPreview);

	}

}
