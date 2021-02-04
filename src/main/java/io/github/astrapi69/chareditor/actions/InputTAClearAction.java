package io.github.astrapi69.chareditor.actions;

import io.github.astrapi69.chareditor.SpringBootSwingApplication;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JTextArea;
@SuppressWarnings("serial")
public class InputTAClearAction extends AbstractAction  {


	public InputTAClearAction(String name) {
		super(name);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		SpringBootSwingApplication frame = SpringBootSwingApplication.getInstance();
		JTextArea textAreaInput = frame.getMainPanel().getJtaInput();
		JTextArea textAreaPreview = frame.getMainPanel().getJtaPreview();
		JTextArea textAreaHtmlEntitys = frame.getMainPanel().getJtaHtmlEntitys();
		JTextArea textAreaUnicode = frame.getMainPanel().getJtaUnicode();
		clearJTextAreas(textAreaInput, textAreaPreview, textAreaHtmlEntitys, textAreaUnicode);
	}


	/**
	 * Clear j text areas.
	 *
	 * @param textAreaInput the text area input
	 * @param textAreaPreview the text area preview
	 * @param textAreaHtmlEntitys the text area html entitys
	 * @param textAreaUnicode the text area unicode
	 */
	private void clearJTextAreas(JTextArea textAreaInput,
			JTextArea textAreaPreview, JTextArea textAreaHtmlEntitys,
			 JTextArea textAreaUnicode) {
		textAreaInput.replaceRange("", 0, textAreaInput.getText().length());
		textAreaPreview.replaceRange("", 0, textAreaPreview.getText().length());
		textAreaHtmlEntitys.replaceRange("", 0, textAreaHtmlEntitys.getText().length());
		textAreaUnicode.replaceRange("", 0, textAreaUnicode.getText().length());
	}

}
