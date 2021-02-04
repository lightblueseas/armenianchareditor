package io.github.astrapi69.chareditor.actions;

import de.alpharogroup.string.StringExtensions;
import io.github.astrapi69.chareditor.SpringBootSwingApplication;
import io.github.astrapi69.chareditor.util.AlphabetExtensions;

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
		this.latin2Greek = AlphabetExtensions.getLatin2Armenian();
		this.latin2Gr4HTML = AlphabetExtensions.getLatin2GrHTMLEntitys();
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		SpringBootSwingApplication frame = SpringBootSwingApplication.getInstance();
		JTextArea textAreaInput = frame.getMainPanel().getJtaInput();
		JTextArea textAreaPreview = frame.getMainPanel().getJtaPreview();
		JTextArea textAreaHtmlEntitys = frame.getMainPanel().getJtaHtmlEntitys();
		JTextArea textAreaUnicode = frame.getMainPanel().getJtaUnicode();
		transformLatin2HtmlEntities(textAreaInput, textAreaPreview,
				textAreaHtmlEntitys, textAreaUnicode);
	}



	/**
	 * Transform latin2 html entities.
	 *
	 * @param textAreaInput the text area input
	 * @param textAreaPreview the text area preview
	 * @param textAreaHtmlEntitys the text area html entitys
	 * @param textAreaUnicode the text area unicode
	 */
	private void transformLatin2HtmlEntities(JTextArea textAreaInput,
			JTextArea textAreaPreview, JTextArea textAreaHtmlEntitys,
			JTextArea textAreaUnicode) {
		StringBuffer outputGreekChars = new StringBuffer();
		StringBuffer outputhtmlChars = new StringBuffer();
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
					} else { // otherwise
						// if the properties contains that key its a special character.
						if (latin2Greek.containsKey(buffer + current)) { // than
							// append the special character to each stringbuffer
							outputGreekChars.append(latin2Greek
									.getProperty(buffer + current));
							outputhtmlChars.append(latin2Gr4HTML
									.getProperty(buffer + current));
						} else { // otherwise
							// its not a special character append like it is to each stringbuffer
							outputGreekChars.append(buffer + current);
							outputhtmlChars.append(HTMLENTITY_UNDERSCORE + current);
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
						} else { // otherwise
							// its not a special character append like it is to each stringbuffer
							outputGreekChars.append(buffer + current);
							outputhtmlChars.append(buffer + current);
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
					} else { // otherwise
						// if the properties contains that key its a special character.
						if (latin2Greek.containsKey(buffer + current)) { // than
							// append the special character to each stringbuffer
							outputGreekChars.append(latin2Greek
									.getProperty(buffer + current));
							outputhtmlChars.append(latin2Gr4HTML
									.getProperty(buffer + current));
						} else { // otherwise
							// its not a special character append like it is to each stringbuffer
							outputGreekChars.append(buffer + current);
							outputhtmlChars.append(buffer + current);
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
					} else { // otherwise
						// its not a character to transform so append like it to each stringbuffer
						outputGreekChars.append(EMPTYSTRING + current);
						outputhtmlChars.append(EMPTYSTRING + current);
					}
				}
			}
		}
		// if the buffer is not empty
		if(!buffer.equals(EMPTYSTRING)){// than
			// append the buffer to the editors
			outputGreekChars.append(buffer);
			outputhtmlChars.append(buffer);
			// and reset the buffer for the last time
			buffer = EMPTYSTRING;
		}
		// Set all Textareas with the new input.
		textAreaPreview.setText(outputGreekChars.toString());
		textAreaHtmlEntitys.setText(outputhtmlChars.toString());
		textAreaUnicode.setText(StringExtensions.toUnicodeChars(outputGreekChars.toString(), false));
	}

}
