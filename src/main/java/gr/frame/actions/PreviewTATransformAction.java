package gr.frame.actions;

import de.alpharogroup.string.StringExtensions;
import gr.characters.util.GreekAlphabetUtil;
import gr.frame.MainFrame;

import java.awt.event.ActionEvent;
import java.util.Properties;

import javax.swing.AbstractAction;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class PreviewTATransformAction extends AbstractAction  {

	/** The greek2latin. */
	private Properties greek2latin = null;

	/** The greek2 gr html entitys. */
	private Properties greek2GrHTMLEntitys = null;

	/** The greek2 is o_8859_7. */
	private Properties greek2ISO_8859_7 = null;


	public PreviewTATransformAction(String name) {
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
		transformGreek2HtmlEntities(textAreaInput, textAreaPreview,
				textAreaHtmlEntitys, textAreaISO_8859_7, textAreaUnicode);

	}


	/**
	 * Transform greek2 html entities.
	 *
	 * @param textAreaInput the text area input
	 * @param textAreaPreview the text area preview
	 * @param textAreaHtmlEntitys the text area html entitys
	 * @param textAreaISO_8859_7 the text area is o_8859_7
	 * @param textAreaUnicode the text area unicode
	 */
	private void transformGreek2HtmlEntities(JTextArea textAreaInput,
			JTextArea textAreaPreview, JTextArea textAreaHtmlEntitys,
			JTextArea textAreaISO_8859_7, JTextArea textAreaUnicode) {
		StringBuffer outputLatinChars = new StringBuffer();
		StringBuffer outputHtmlEntitys = new StringBuffer();
		StringBuffer outputISO_8859_7 = new StringBuffer();
		String preview = textAreaPreview.getText();
		int length = preview.length();
		for (int i = 0; i < length; i++) {
			char current = preview.charAt(i);
			String crrnt = "" + current;
			if (greek2latin.containsKey(crrnt)) {
				outputLatinChars.append(greek2latin.getProperty(crrnt));
				outputHtmlEntitys.append(greek2GrHTMLEntitys.getProperty(crrnt));
				outputISO_8859_7.append(greek2ISO_8859_7.getProperty(crrnt));
			} else {
				outputLatinChars.append(current);
				outputHtmlEntitys.append(current);
				outputISO_8859_7.append(current);
			}
		}
		String latinChars = outputLatinChars.toString();
		textAreaInput.setText(latinChars);
		textAreaHtmlEntitys.setText(outputHtmlEntitys.toString());
		textAreaISO_8859_7.setText(outputISO_8859_7.toString());
		String greekChars = GreekAlphabetUtil.convertLatinToGreekUnicode(latinChars);
		textAreaUnicode.setText(StringExtensions.toUnicodeChars(greekChars, false));
	}

}
