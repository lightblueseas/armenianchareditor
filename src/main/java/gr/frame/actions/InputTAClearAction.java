package gr.frame.actions;

import gr.frame.MainFrame;
import gr.frame.util.Constants;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JTextArea;
@SuppressWarnings("serial")
public class InputTAClearAction extends AbstractAction implements Constants  {


	public InputTAClearAction(String name) {
		super(name);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		MainFrame frame = MainFrame.getInstance();
		JTextArea textAreaInput = frame.getJtaInput();
		JTextArea textAreaPreview = frame.getJtaPreview();
		JTextArea textAreaHtmlEntitys = frame.getJtaHtmlEntitys();
		JTextArea textAreaISO_8859_7 = frame.getJtaIso8859_7();
		JTextArea textAreaUnicode = frame.getJtaUnicode();
		clearJTextAreas(textAreaInput, textAreaPreview, textAreaHtmlEntitys, textAreaISO_8859_7, textAreaUnicode);


	}


	/**
	 * Clear j text areas.
	 *
	 * @param textAreaInput the text area input
	 * @param textAreaPreview the text area preview
	 * @param textAreaHtmlEntitys the text area html entitys
	 * @param textAreaISO_8859_7 the text area is o_8859_7
	 * @param textAreaUnicode the text area unicode
	 */
	private void clearJTextAreas(JTextArea textAreaInput,
			JTextArea textAreaPreview, JTextArea textAreaHtmlEntitys,
			JTextArea textAreaISO_8859_7, JTextArea textAreaUnicode) {
		textAreaInput.replaceRange(EMPTYSTRING, 0, textAreaInput.getText().length());
		textAreaPreview.replaceRange(EMPTYSTRING, 0, textAreaPreview.getText().length());
		textAreaHtmlEntitys.replaceRange(EMPTYSTRING, 0, textAreaHtmlEntitys.getText().length());
		textAreaISO_8859_7.replaceRange(EMPTYSTRING, 0, textAreaISO_8859_7.getText().length());
		textAreaUnicode.replaceRange(EMPTYSTRING, 0, textAreaUnicode.getText().length());
	}

}
