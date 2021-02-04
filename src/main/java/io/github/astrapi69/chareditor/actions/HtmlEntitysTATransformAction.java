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
public class HtmlEntitysTATransformAction extends AbstractAction {


	/** The html entitys2 greek. */
	private Properties htmlEntitys2Greek = null;


	/** The html entitys2 latin. */
	private Properties htmlEntitys2Latin = null;


	/** The html entitys2 is o_8859_7. */
	private Properties htmlEntitys2ISO_8859_7 = null;

	public HtmlEntitysTATransformAction(String name) {
		super(name);

		this.htmlEntitys2Greek = AlphabetExtensions.getHtmlEntitys2Armenian();
		this.htmlEntitys2Latin = AlphabetExtensions.getHtmlEntitys2Latin();
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		SpringBootSwingApplication instance = SpringBootSwingApplication.getInstance();
		MainPanel mainPanel = (MainPanel) instance.getMainComponent();
		JTextArea textAreaInput = mainPanel.getJtaInput();
		JTextArea textAreaPreview = mainPanel.getJtaPreview();
		JTextArea textAreaHtmlEntitys = mainPanel.getJtaHtmlEntitys();
		JTextArea textAreaUnicode = mainPanel.getJtaUnicode();
		transformHtmlEntities(textAreaInput, textAreaPreview,
				textAreaHtmlEntitys, textAreaUnicode);

	}


	/**
	 * Transform html entities.
	 *
	 * @param textAreaInput the text area input
	 * @param textAreaPreview the text area preview
	 * @param textAreaHtmlEntitys the text area html entitys
	 * @param textAreaUnicode the text area unicode
	 */
	private void transformHtmlEntities(JTextArea textAreaInput,
			JTextArea textAreaPreview, JTextArea textAreaHtmlEntitys,
			JTextArea textAreaUnicode) {
		StringBuffer outputLatinChars = new StringBuffer();
		StringBuffer outputGreekChars = new StringBuffer();

		String entitys = textAreaHtmlEntitys.getText();
		int length = entitys.length();

		for (int i = 0; i < length; i++) {
			char current = entitys.charAt(i);
			String rest = entitys.substring(i);
			if (current == '&') {
				int semi = rest.indexOf(";");
				if ((semi == -1) || ((semi - i) > 7)) {
					outputLatinChars.append(current);
					outputGreekChars.append(current);
					continue;
				}
				int end = semi + 1;
				String entity = rest.substring(0, end);
				if (entity.charAt(1) == ' ') {
					outputLatinChars.append(current);
					outputGreekChars.append(current);
					continue;
				}
				if (entity.charAt(1) == '#') {
					if (htmlEntitys2Greek.containsKey(entity)) {
						outputLatinChars.append(htmlEntitys2Latin
								.getProperty(entity));
						outputGreekChars.append(htmlEntitys2Greek
								.getProperty(entity));
						i += semi;
					} else {
						outputLatinChars.append(entity);
						outputGreekChars.append(entity);
						i += semi;
					}
				}
			} else {
				outputLatinChars.append(current);
				outputGreekChars.append(current);
			}
		}
		textAreaPreview.setText(outputGreekChars.toString());
		textAreaInput.setText(outputLatinChars.toString());
		textAreaUnicode.setText(StringExtensions.toUnicodeChars(outputGreekChars.toString(), false));
	}
}
