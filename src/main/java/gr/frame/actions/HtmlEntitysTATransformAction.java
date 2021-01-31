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
public class HtmlEntitysTATransformAction extends AbstractAction implements Constants  {


	/** The html entitys2 greek. */
	private Properties htmlEntitys2Greek = null;


	/** The html entitys2 latin. */
	private Properties htmlEntitys2Latin = null;


	/** The html entitys2 is o_8859_7. */
	private Properties htmlEntitys2ISO_8859_7 = null;

	public HtmlEntitysTATransformAction(String name) {
		super(name);

		this.htmlEntitys2Greek = GreekAlphabetUtil.getHtmlEntitys2Greek();
		this.htmlEntitys2Latin = GreekAlphabetUtil.getHtmlEntitys2Latin();
		this.htmlEntitys2ISO_8859_7 = GreekAlphabetUtil
				.getHtmlEntitys2ISO_8859_7();
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		MainFrame frame = MainFrame.getInstance();
		JTextArea textAreaInput = frame.getMainPanel().getJtaInput();
		JTextArea textAreaPreview = frame.getMainPanel().getJtaPreview();
		JTextArea textAreaHtmlEntitys = frame.getMainPanel().getJtaHtmlEntitys();
		JTextArea textAreaISO_8859_7 = frame.getMainPanel().getJtaIso8859_7();
		JTextArea textAreaUnicode = frame.getMainPanel().getJtaUnicode();
		transformHtmlEntities(textAreaInput, textAreaPreview,
				textAreaHtmlEntitys, textAreaISO_8859_7, textAreaUnicode);

	}


	/**
	 * Transform html entities.
	 *
	 * @param textAreaInput the text area input
	 * @param textAreaPreview the text area preview
	 * @param textAreaHtmlEntitys the text area html entitys
	 * @param textAreaISO_8859_7 the text area is o_8859_7
	 * @param textAreaUnicode the text area unicode
	 */
	private void transformHtmlEntities(JTextArea textAreaInput,
			JTextArea textAreaPreview, JTextArea textAreaHtmlEntitys,
			JTextArea textAreaISO_8859_7, JTextArea textAreaUnicode) {
		StringBuffer outputLatinChars = new StringBuffer();
		StringBuffer outputGreekChars = new StringBuffer();
		StringBuffer outputISO_8859_7 = new StringBuffer();

		String entitys = textAreaHtmlEntitys.getText();
		int length = entitys.length();

		for (int i = 0; i < length; i++) {
			char current = entitys.charAt(i);
			String rest = entitys.substring(i);
			if (current == '&') {
				int semi = rest.indexOf(SEMICOLON);
				if ((semi == -1) || ((semi - i) > 7)) {
					outputLatinChars.append(current);
					outputGreekChars.append(current);
					outputISO_8859_7.append(current);
					continue;
				}
				int end = semi + 1;
				String entity = rest.substring(0, end);
				if (entity.charAt(1) == ' ') {
					outputLatinChars.append(current);
					outputGreekChars.append(current);
					outputISO_8859_7.append(current);
					continue;
				}
				if (entity.charAt(1) == '#') {
					if (htmlEntitys2Greek.containsKey(entity)) {
						outputLatinChars.append(htmlEntitys2Latin
								.getProperty(entity));
						outputGreekChars.append(htmlEntitys2Greek
								.getProperty(entity));
						outputISO_8859_7.append(htmlEntitys2ISO_8859_7.getProperty(entity));
						i += semi;
					} else {
						outputLatinChars.append(entity);
						outputGreekChars.append(entity);
						outputISO_8859_7.append(entity);
						i += semi;
					}
				}
			} else {
				outputLatinChars.append(current);
				outputGreekChars.append(current);
				outputISO_8859_7.append(current);
			}
		}
		textAreaPreview.setText(outputGreekChars.toString());
		textAreaInput.setText(outputLatinChars.toString());
		textAreaISO_8859_7.setText(outputISO_8859_7.toString());
		textAreaUnicode.setText(StringExtensions.toUnicodeChars(outputGreekChars.toString(), false));
	}
}
