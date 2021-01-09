package gr.frame.actions;

import de.alpharogroup.string.StringExtensions;
import gr.characters.util.GreekAlphabetUtil;
import gr.frame.MainFrame;
import gr.frame.util.Constants;

import java.awt.event.ActionEvent;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

import javax.swing.AbstractAction;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class UnicodeTATransformAction extends AbstractAction implements Constants  {


	/** The greek2latin. */
	private Properties greek2latin = null;

	/** The greek2 gr html entitys. */
	private Properties greek2GrHTMLEntitys = null;

	/** The greek2 is o_8859_7. */
	private Properties greek2ISO_8859_7 = null;

	public UnicodeTATransformAction(String name) {
		super(name);

		this.greek2latin = GreekAlphabetUtil.getGreek2Latin();
		this.greek2GrHTMLEntitys = GreekAlphabetUtil.getGreek2GrHTMLEntitys();
		this.greek2ISO_8859_7 = GreekAlphabetUtil.getGreek2GrISO8859_7();
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		MainFrame frame = MainFrame.getInstance();
		JTextArea textAreaInput = frame.getJtaInput();
		JTextArea textAreaPreview = frame.getJtaPreview();
		JTextArea textAreaHtmlEntitys = frame.getJtaHtmlEntitys();
		JTextArea textAreaISO_8859_7 = frame.getJtaIso8859_7();
		JTextArea textAreaUnicode = frame.getJtaUnicode();
		try {
			transformUnicodeCharacters(textAreaInput, textAreaPreview, textAreaHtmlEntitys, textAreaISO_8859_7, textAreaUnicode);
		} catch (UnsupportedEncodingException uee) {
			uee.printStackTrace();
		}
	}


	/**
	 * Transform unicode characters.
	 *
	 * @param textAreaInput the text area input
	 * @param textAreaPreview the text area preview
	 * @param textAreaHtmlEntitys the text area html entitys
	 * @param textAreaISO_8859_7 the text area is o_8859_7
	 * @param textAreaUnicode the text area unicode
	 * @throws UnsupportedEncodingException the unsupported encoding exception
	 */
	private void transformUnicodeCharacters(JTextArea textAreaInput,
			JTextArea textAreaPreview, JTextArea textAreaHtmlEntitys,
			JTextArea textAreaISO_8859_7, JTextArea textAreaUnicode) throws UnsupportedEncodingException {
		StringBuffer outputGreekChars = new StringBuffer();
		StringBuffer outputLatinChars = new StringBuffer();
		StringBuffer outputHtmlEntitys = new StringBuffer();
		StringBuffer outputISO_8859_7 = new StringBuffer();
		String unicode = textAreaUnicode.getText();
		int length = unicode.length();

		for (int i = 0; i < length; i++) {
			char current = unicode.charAt(i);
			if (current == '\\') {
				String unicodeString = unicode.substring(i, i+6);
				StringExtensions.convertUnicodeStringToCharacter(unicodeString);
				char ch = StringExtensions.convertUnicodeStringToCharacter(unicodeString);
				String crrnt = EMPTYSTRING + ch;
				outputGreekChars.append(ch);
				outputLatinChars.append(greek2latin.getProperty(crrnt));
				outputHtmlEntitys.append(greek2GrHTMLEntitys.getProperty(crrnt));
				outputISO_8859_7.append(greek2ISO_8859_7.getProperty(crrnt));
				i = i+5;
			}
			if(current == ' '){
				outputGreekChars.append(current);
			}
		}

		textAreaPreview.setText(outputGreekChars.toString());
		textAreaInput.setText(outputLatinChars.toString());
		textAreaHtmlEntitys.setText(outputHtmlEntitys.toString());
		textAreaISO_8859_7.setText(outputISO_8859_7.toString());

	}



}
