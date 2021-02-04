package io.github.astrapi69.chareditor.actions;

import de.alpharogroup.string.StringExtensions;
import io.github.astrapi69.chareditor.SpringBootSwingApplication;
import io.github.astrapi69.chareditor.util.AlphabetExtensions;

import java.awt.event.ActionEvent;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

import javax.swing.AbstractAction;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class UnicodeTATransformAction extends AbstractAction   {


	/** The greek2latin. */
	private Properties greek2latin = null;

	/** The greek2 gr html entitys. */
	private Properties greek2GrHTMLEntitys = null;

	public UnicodeTATransformAction(String name) {
		super(name);

		this.greek2latin = AlphabetExtensions.getArmenian2Latin();
		this.greek2GrHTMLEntitys = AlphabetExtensions.getArmenian2GrHTMLEntitys();
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		SpringBootSwingApplication frame = SpringBootSwingApplication.getInstance();
		JTextArea textAreaInput = frame.getMainPanel().getJtaInput();
		JTextArea textAreaPreview = frame.getMainPanel().getJtaPreview();
		JTextArea textAreaHtmlEntitys = frame.getMainPanel().getJtaHtmlEntitys();
		JTextArea textAreaUnicode = frame.getMainPanel().getJtaUnicode();
		try {
			transformUnicodeCharacters(textAreaInput, textAreaPreview, textAreaHtmlEntitys, textAreaUnicode);
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
	 * @param textAreaUnicode the text area unicode
	 * @throws UnsupportedEncodingException the unsupported encoding exception
	 */
	private void transformUnicodeCharacters(JTextArea textAreaInput,
			JTextArea textAreaPreview, JTextArea textAreaHtmlEntitys,
			JTextArea textAreaUnicode) throws UnsupportedEncodingException {
		StringBuffer outputGreekChars = new StringBuffer();
		StringBuffer outputLatinChars = new StringBuffer();
		StringBuffer outputHtmlEntitys = new StringBuffer();
		String unicode = textAreaUnicode.getText();
		int length = unicode.length();

		for (int i = 0; i < length; i++) {
			char current = unicode.charAt(i);
			if (current == '\\') {
				String unicodeString = unicode.substring(i, i+6);
				StringExtensions.convertUnicodeStringToCharacter(unicodeString);
				char ch = StringExtensions.convertUnicodeStringToCharacter(unicodeString);
				String crrnt = "" + ch;
				outputGreekChars.append(ch);
				outputLatinChars.append(greek2latin.getProperty(crrnt));
				outputHtmlEntitys.append(greek2GrHTMLEntitys.getProperty(crrnt));
				i = i+5;
			}
			if(current == ' '){
				outputGreekChars.append(current);
			}
		}

		textAreaPreview.setText(outputGreekChars.toString());
		textAreaInput.setText(outputLatinChars.toString());
		textAreaHtmlEntitys.setText(outputHtmlEntitys.toString());

	}



}
