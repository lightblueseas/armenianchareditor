package gr.frame.actions;

import de.alpharogroup.string.StringExtensions;
import gr.characters.util.GreekAlphabetUtil;
import gr.frame.MainFrame;

import java.awt.event.ActionEvent;
import java.util.Properties;

import javax.swing.AbstractAction;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class InputTATranformAction extends AbstractAction  {

	/** The Constant HTMLENTITY_UNDERSCORE. */
	private static final String HTMLENTITY_UNDERSCORE = "&#95;";
	/** The Constant COLONUNDERSCORE. */
	private static final String COLONUNDERSCORE = ":_";

	/** The Constant COLON. */
	private static final String COLON = ":";
	/** The Constant EMPTYSTRING. */
	private static final String EMPTYSTRING = "";

	/** The Constant UNDERSCORE. */
	private static final String UNDERSCORE = "_";

	/** The latin2 greek. */
	private Properties latin2Greek = null;

	/** The latin2 gr4 html. */
	private Properties latin2Gr4HTML = null;

	/** The latin2 is o_8859_7. */
	private Properties latin2ISO_8859_7 = null;


	public InputTATranformAction(String name) {
		super(name);
		this.latin2Greek = GreekAlphabetUtil.getLatin2Greek();
		this.latin2Gr4HTML = GreekAlphabetUtil.getLatin2GrHTMLEntitys();
		this.latin2ISO_8859_7 = GreekAlphabetUtil.getLatin2ISO_8859_7();
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		MainFrame frame = MainFrame.getInstance();
		JTextArea textAreaInput = frame.getJtaInput();
		JTextArea textAreaPreview = frame.getJtaPreview();
		JTextArea textAreaHtmlEntitys = frame.getJtaHtmlEntitys();
		JTextArea textAreaISO_8859_7 = frame.getJtaIso8859_7();
		JTextArea textAreaUnicode = frame.getJtaUnicode();
		transformLatin2HtmlEntities(textAreaInput, textAreaPreview,
				textAreaHtmlEntitys, textAreaISO_8859_7, textAreaUnicode);
	}



	/**
	 * Transform latin2 html entities.
	 *
	 * @param textAreaInput the text area input
	 * @param textAreaPreview the text area preview
	 * @param textAreaHtmlEntitys the text area html entitys
	 * @param textAreaISO_8859_7 the text area is o_8859_7
	 * @param textAreaUnicode the text area unicode
	 */
	private void transformLatin2HtmlEntities(JTextArea textAreaInput,
			JTextArea textAreaPreview, JTextArea textAreaHtmlEntitys,
			JTextArea textAreaISO_8859_7, JTextArea textAreaUnicode) {
		StringBuffer outputGreekChars = new StringBuffer();
		StringBuffer outputhtmlChars = new StringBuffer();
		StringBuffer outputISO_8859_7 = new StringBuffer();
		String buffer = EMPTYSTRING, underscore = UNDERSCORE, doppelpunkt = COLON, combi = COLONUNDERSCORE;
		String input = textAreaInput.getText();
		int length = input.length();

		for (int i = 0; i < length; i++) {
			char current = input.charAt(i);
			// If the buffer is not empty than its a control character
			if (0 < buffer.length()) {
				// if the buffer is an underscore
				if (buffer.equals(underscore)) { // than
					// check if the current is an underscore too if yes
					if (current == '_') { // than
						// append the buffer and the current to the Stringbuffer.
						outputGreekChars.append(buffer + current);
						// entity-html for underscore is "&#95;"
						outputhtmlChars.append(HTMLENTITY_UNDERSCORE + HTMLENTITY_UNDERSCORE);
						outputISO_8859_7.append(buffer + current);
					} else { // otherwise
						// if the properties contains that key its a special character.
						if (latin2Greek.containsKey(buffer + current)) { // than
							// append the special character to each stringbuffer
							outputGreekChars.append(latin2Greek
									.getProperty(buffer + current));
							outputhtmlChars.append(latin2Gr4HTML
									.getProperty(buffer + current));
							outputISO_8859_7.append(latin2ISO_8859_7.getProperty(buffer + current));
						} else { // otherwise
							// its not a special character append like it is to each stringbuffer
							outputGreekChars.append(buffer + current);
							outputhtmlChars.append(HTMLENTITY_UNDERSCORE + current);
							outputISO_8859_7.append(buffer + current);
						}
					}
					// reset the buffer
					buffer = EMPTYSTRING;
					// if the buffer is a colon
				} else if (buffer.equals(doppelpunkt)) { // than
					// check if the current is an underscore if yes
					if (current == '_') { // than
						// append the current to the buffer
						buffer = buffer + current;
					} else { // otherwise
						// if the properties contains that key its a special character.
						if (latin2Greek.containsKey(buffer + current)) { // than
							// append the special character to each stringbuffer
							outputGreekChars.append(latin2Greek
									.getProperty(buffer + current));
							outputhtmlChars.append(latin2Gr4HTML
									.getProperty(buffer + current));
							outputISO_8859_7.append(latin2ISO_8859_7.getProperty(buffer + current));
						} else { // otherwise
							// its not a special character append like it is to each stringbuffer
							outputGreekChars.append(buffer + current);
							outputhtmlChars.append(buffer + current);
							outputISO_8859_7.append(buffer + current);
						}
						// reset the buffer
						buffer = EMPTYSTRING;
					}
					// if the buffer is a combination from a colon and a underscore
				} else if (buffer.equals(combi)) { // than
					// check if the current is an underscore if yes
					if (current == '_') { // than
						// append the buffer and the current to the Stringbuffer.
						outputGreekChars.append(buffer + current);
						outputhtmlChars.append(buffer + current);
						outputISO_8859_7.append(buffer + current);
					} else { // otherwise
						// if the properties contains that key its a special character.
						if (latin2Greek.containsKey(buffer + current)) { // than
							// append the special character to each stringbuffer
							outputGreekChars.append(latin2Greek
									.getProperty(buffer + current));
							outputhtmlChars.append(latin2Gr4HTML
									.getProperty(buffer + current));
							outputISO_8859_7.append(latin2ISO_8859_7.getProperty(buffer + current));
						} else { // otherwise
							// its not a special character append like it is to each stringbuffer
							outputGreekChars.append(buffer + current);
							outputhtmlChars.append(buffer + current);
							outputISO_8859_7.append(buffer + current);
						}
					} // reset the buffer
					buffer = EMPTYSTRING;
				}
				// if buffer is empty
			} else { // than we must control the char
				// check if the current is an underscore if yes
				if (current == '_') { // than
					// set the buffer to underscore
					buffer = underscore;
					// check if the current is a colon
				} else if (current == ':') { // than
					// set the buffer to a colon
					buffer = doppelpunkt;
				} else { // otherwise
					// if the properties contains that key its a character we must transform.
					if (latin2Greek.containsKey(EMPTYSTRING + current)) { // than
						// append the transformed character to each stringbuffer
						outputGreekChars.append(latin2Greek.getProperty(EMPTYSTRING
								+ current));
						outputhtmlChars.append(latin2Gr4HTML.getProperty(EMPTYSTRING
								+ current));
						outputISO_8859_7.append(latin2ISO_8859_7.getProperty(EMPTYSTRING + current));
					} else { // otherwise
						// its not a character to transform so append like it to each stringbuffer
						outputGreekChars.append(EMPTYSTRING + current);
						outputhtmlChars.append(EMPTYSTRING + current);
						outputISO_8859_7.append(EMPTYSTRING + current);
					}
				}
			}
		}
		// if the buffer is not empty
		if(!buffer.equals(EMPTYSTRING)){// than
			// append the buffer to the editors
			outputGreekChars.append(buffer);
			outputhtmlChars.append(buffer);
			outputISO_8859_7.append(buffer);
			// and reset the buffer for the last time
			buffer = EMPTYSTRING;
		}
		// Set all Textareas with the new input.
		textAreaPreview.setText(outputGreekChars.toString());
		textAreaHtmlEntitys.setText(outputhtmlChars.toString());
		textAreaISO_8859_7.setText(outputISO_8859_7.toString());
		textAreaUnicode.setText(StringExtensions.toUnicodeChars(outputGreekChars.toString(), false));
	}

}
