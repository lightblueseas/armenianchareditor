package gr.frame.actions;

import de.alpharogroup.string.StringExtensions;
import gr.characters.util.GreekAlphabetUtil;
import gr.frame.MainFrame;
import gr.frame.util.Constants;

import java.awt.event.ActionEvent;
import java.util.Properties;

import javax.swing.AbstractAction;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class Iso8859_7TATransformAction extends AbstractAction implements Constants  {

	/** The iso_8859_7_ to greek. */
	private Properties iso_8859_7_ToGreek = null;

	/** The iso_8859_7_ to gr4 html. */
	private Properties iso_8859_7_ToGr4HTML = null;

	/** The iso_8859_7_ to latin. */
	private Properties iso_8859_7_ToLatin = null;

	public Iso8859_7TATransformAction(String name) {
		super(name);
		this.iso_8859_7_ToGr4HTML = GreekAlphabetUtil.getISO8859_7ToHTMLEntitys();
		this.iso_8859_7_ToGreek = GreekAlphabetUtil.getISO8859_7ToGreekUnicode();
		this.iso_8859_7_ToLatin = GreekAlphabetUtil.getISO8859_7ToLatin();

	}


	@Override
	public void actionPerformed(ActionEvent e) {
		MainFrame frame = MainFrame.getInstance();
		JTextArea textAreaInput = frame.getMainPanel().getJtaInput();
		JTextArea textAreaPreview = frame.getMainPanel().getJtaPreview();
		JTextArea textAreaHtmlEntitys = frame.getMainPanel().getJtaHtmlEntitys();
		JTextArea textAreaISO_8859_7 = frame.getMainPanel().getJtaIso8859_7();
		JTextArea textAreaUnicode = frame.getMainPanel().getJtaUnicode();
		transformISO_8859_7_Chars(textAreaInput, textAreaPreview, textAreaHtmlEntitys, textAreaISO_8859_7, textAreaUnicode);
	}

	/**
	 * Transforms the input from the textarea "textAreaISO_8859_7" to the other encodings.
	 *
	 * @param textAreaInput the text area input
	 * @param textAreaPreview the text area preview
	 * @param textAreaHtmlEntitys the text area html entitys
	 * @param textAreaISO_8859_7 the text area is o_8859_7
	 * @param textAreaUnicode the text area unicode
	 */
	private void transformISO_8859_7_Chars(JTextArea textAreaInput, JTextArea textAreaPreview, JTextArea textAreaHtmlEntitys, JTextArea textAreaISO_8859_7, JTextArea textAreaUnicode) {
		StringBuffer outputLatinChars = new StringBuffer();
		StringBuffer outputHtmlEntitys = new StringBuffer();
		StringBuffer outputGreekChars = new StringBuffer();
		String iso_8859_7 = textAreaISO_8859_7.getText();
		int length = iso_8859_7.length();

		for (int i = 0; i < length; i++) {
			char current = iso_8859_7.charAt(i);
			String crrnt = EMPTYSTRING + current;
			if(iso_8859_7_ToLatin.containsKey(crrnt)) {
				outputLatinChars.append(iso_8859_7_ToLatin.getProperty(crrnt));
				outputHtmlEntitys.append(iso_8859_7_ToGr4HTML.getProperty(crrnt));
				outputGreekChars.append(iso_8859_7_ToGreek.getProperty(crrnt));
			} else {
				outputLatinChars.append(current);
				outputHtmlEntitys.append(current);
				outputGreekChars.append(current);
			}
		}
		textAreaInput.setText(outputLatinChars.toString());
		textAreaHtmlEntitys.setText(outputHtmlEntitys.toString());
		textAreaPreview.setText(outputGreekChars.toString());
		textAreaUnicode.setText(StringExtensions.toUnicodeChars(outputGreekChars.toString(), false));
	}


}
