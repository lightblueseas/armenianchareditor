package io.github.astrapi69.chareditor.actions;

import de.alpharogroup.string.StringExtensions;
import io.github.astrapi69.chareditor.SpringBootSwingApplication;
import io.github.astrapi69.chareditor.panels.MainPanel;
import io.github.astrapi69.chareditor.util.AlphabetExtensions;

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


	public PreviewTATransformAction(String name) {
		super(name);
		this.greek2latin = AlphabetExtensions.getArmenian2Latin();
		this.greek2GrHTMLEntitys = AlphabetExtensions.getArmenian2GrHTMLEntitys();
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		SpringBootSwingApplication instance = SpringBootSwingApplication.getInstance();
		MainPanel mainPanel = (MainPanel) instance.getMainComponent();
		JTextArea textAreaInput = mainPanel.getJtaInput();
		JTextArea textAreaPreview = mainPanel.getJtaPreview();
		JTextArea textAreaHtmlEntitys = mainPanel.getJtaHtmlEntitys();
		JTextArea textAreaUnicode = mainPanel.getJtaUnicode();
		transformGreek2HtmlEntities(textAreaInput, textAreaPreview,
				textAreaHtmlEntitys, textAreaUnicode);

	}


	/**
	 * Transform greek2 html entities.
	 *
	 * @param textAreaInput the text area input
	 * @param textAreaPreview the text area preview
	 * @param textAreaHtmlEntitys the text area html entitys
	 * @param textAreaUnicode the text area unicode
	 */
	private void transformGreek2HtmlEntities(JTextArea textAreaInput,
			JTextArea textAreaPreview, JTextArea textAreaHtmlEntitys,
			JTextArea textAreaUnicode) {
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
			} else {
				outputLatinChars.append(current);
				outputHtmlEntitys.append(current);
				outputISO_8859_7.append(current);
			}
		}
		String latinChars = outputLatinChars.toString();
		textAreaInput.setText(latinChars);
		textAreaHtmlEntitys.setText(outputHtmlEntitys.toString());
		String greekChars = AlphabetExtensions.convertLatinToGreekUnicode(latinChars);
		textAreaUnicode.setText(StringExtensions.toUnicodeChars(greekChars, false));
	}

}
