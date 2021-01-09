package gr.characters.util;

import gr.characters.constants.GreekAlphabet;
import gr.characters.constants.HTML_EntitysConst;
import gr.characters.constants.ISO8859_7Const;
import gr.characters.constants.LatinToGreekConst;
import gr.characters.constants.UnicodeConst;

import java.io.UnsupportedEncodingException;
import java.util.Properties;

/**
 * This class uses the class GreekAlphabet to convert to all Characters that are
 * in the class GreekAlphabet.
 * 
 * @author Asterios Raptis created first on 02.01.2006 in Projekt
 *         GreekCharsEncoding
 */
public class GreekAlphabetUtil {
	/**
	 * Helper-Method that creates an StringBuffer mapping from the properties.
	 * 
	 * @param entitys
	 *            The HTML-Entitys to be converted.
	 * @param properties
	 *            The Properties to map to.
	 * @return The result.
	 */
	public static StringBuffer handleHTMLEntitys(String entitys,
			Properties properties) {
		StringBuffer sb = new StringBuffer();
		int length = entitys.length();
		for (int i = 0; i < length; i++) {
			char current = entitys.charAt(i);
			String rest = entitys.substring(i);
			if (current == '&') {
				int semi = rest.indexOf(";");
				if ((semi == -1) || ((semi - i) > 7)) {
					sb.append(current);
					continue;
				}
				int end = semi + 1;
				String entity = rest.substring(0, end);
				if (entity.charAt(1) == ' ') {
					sb.append(current);
					continue;
				}
				if (entity.charAt(1) == '#') {
					if (properties.containsKey(entity)) {
						sb.append(properties.getProperty(entity));
						i += semi;
					} else {
						sb.append(entity);
						i += semi;
					}
				}
			} else {
				sb.append(current);
			}
		}
		return sb;
	}

	/**
	 * Converts the given HTML Entitys to an ISO-8859-7 String. For instance: We
	 * have a String in HTML Entitys like this:
	 * "&#917;&#947;&#947;&#961;&#945;&#966;&#942;&#962". It will convert to the
	 * ISO-8859-7 String:"ÅããñáöÞò"
	 * 
	 * @param entitys
	 *            The HTML Entitys to be converted.
	 * @return The converted String in a ISO-8859-7 String.
	 */
	public static String convertHTML_EntitysToISO_8859_7(String entitys) {
		Properties htmlEntitys2ISO_8859_7 = GreekAlphabetUtil
				.getHtmlEntitys2ISO_8859_7();
		StringBuffer outputISO_8859_7Chars = GreekAlphabetUtil
				.handleHTMLEntitys(entitys, htmlEntitys2ISO_8859_7);
		return outputISO_8859_7Chars.toString();
	}

	/**
	 * Converts the given HTML Entitys to GreekUnicode characters. For instance:
	 * We have a String in HTML Entitys like this:
	 * "&#917;&#947;&#947;&#961;&#945;&#966;&#942;&#962". It will convert to
	 * GreekUnicode
	 * characters:"\u0395\u03b3\u03b3\u03c1\u03b1\u03c6\u03ae\u03c2"
	 * 
	 * @param entitys
	 *            The HTML Entitys to be converted.
	 * @return The converted String in GreekUnicode characters.
	 */
	public static String convertHTML_EntitysToGreekUnicode(String entitys) {
		Properties htmlEntitys2Greek = GreekAlphabetUtil.getHtmlEntitys2Greek();
		StringBuffer outputGreekChars = GreekAlphabetUtil.handleHTMLEntitys(
				entitys, htmlEntitys2Greek);
		return outputGreekChars.toString();
	}

	/**
	 * Converts the given HTML Entitys to Latin-mappers. For instance: We have a
	 * String in HTML Entitys like this:
	 * "&#917;&#947;&#947;&#961;&#945;&#966;&#942;&#962". It will convert to the
	 * Latin-mappers String:"Eggraf_h_s".
	 * 
	 * @param entitys
	 *            The HTML Entitys to be converted.
	 * @return The converted String in Latin-mappers.
	 */
	public static String convertHTML_EntitysToLatin(String entitys) {
		Properties htmlEntitys2Latin = GreekAlphabetUtil.getHtmlEntitys2Latin();
		StringBuffer outputLatinChars = GreekAlphabetUtil.handleHTMLEntitys(
				entitys, htmlEntitys2Latin);
		return outputLatinChars.toString();
	}

	/**
	 * Helper-Method that creates an StringBuffer mapping from the properties.
	 * 
	 * @param iso_8859_7
	 *            The ISO-8859-7 String to be converted.
	 * @param iSO_8859_7ToHTMLEntitys
	 *            The Properties to map to.
	 * @return The result.
	 */
	public static StringBuffer handle_ISO_8859_7(String iso_8859_7,
			Properties iSO_8859_7ToHTMLEntitys) {
		StringBuffer sb = new StringBuffer();
		int length = iso_8859_7.length();
		for (int i = 0; i < length; i++) {
			char current = iso_8859_7.charAt(i);
			String search = "" + current;
			if (iSO_8859_7ToHTMLEntitys.containsKey(search)) {
				sb.append(iSO_8859_7ToHTMLEntitys.getProperty(search));
			} else {
				sb.append(search);
			}
		}
		return sb;
	}

	/**
	 * Converts an(greek) ISO-8859-7 String to HTML Entitys so you can read it
	 * with any set encoding from the browser. For instance: We have a String in
	 * ISO-8859-7 String like this: "ÅããñáöÞò". It will convert to the HTML
	 * Entitys: "&#917;&#947;&#947;&#961;&#945;&#966;&#942;&#962;"
	 * 
	 * @param iso_8859_7
	 *            the ISO-8859-7 String to be converted.
	 * @return The converted String in HTML Entitys.
	 */
	public static String convertISO_8859_7ToHTML_Entitys(String iso_8859_7) {
		Properties iSO_8859_7ToHTMLEntitys = GreekAlphabetUtil
				.getISO8859_7ToHTMLEntitys();
		StringBuffer sb = handle_ISO_8859_7(iso_8859_7, iSO_8859_7ToHTMLEntitys);
		return sb.toString();
	}

	/**
	 * Converts an(greek) ISO-8859-7 String to GreekUnicode. For instance: We
	 * have a String in ISO-8859-7 String like this:"ÅããñáöÞò". It will convert
	 * to the GreekUnicode
	 * String:"\u0395\u03b3\u03b3\u03c1\u03b1\u03c6\u03ae\u03c2".
	 * 
	 * @param iso_8859_7
	 *            the ISO-8859-7 String to be converted.
	 * @return The converted String in GreekUnicode.
	 */
	public static String convertISO_8859_7ToGreekUnicode(String iso_8859_7) {
		Properties iSO_8859_7ToGreekUnicode = GreekAlphabetUtil
				.getISO8859_7ToGreekUnicode();
		StringBuffer sb = handle_ISO_8859_7(iso_8859_7,
				iSO_8859_7ToGreekUnicode);
		return sb.toString();
	}

	/**
	 * Converts an(greek) ISO-8859-7 String to Greek chars. It makes the same
	 * thing like the method
	 * GreekAlphabetUtil.convertISO_8859_7ToGreekUnicode(String) only that this
	 * method uses the UTF-16 encoding. For instance: We have a String in
	 * ISO-8859-7 String like this:"ÅããñáöÞò". It will convert to the
	 * GreekUnicode String:"\u0395\u03b3\u03b3\u03c1\u03b1\u03c6\u03ae\u03c2".
	 * 
	 * @param iso_8859_7
	 *            the ISO-8859-7 String to be converted.
	 * @return The converted String in Greek chars.
	 */
	public static String convertISO_8859_7ToGreekChars(String iso_8859_7) {
		StringBuffer returnSB = null;
		if (iso_8859_7 != null) {
			try {
				// Convert from Unicode to UTF-16
				byte[] utf16 = iso_8859_7.getBytes("UTF-16");
				returnSB = new StringBuffer();
				// Convert from UTF-16 to ISO-8859-7
				iso_8859_7 = new String(utf16, "ISO-8859-7");
				// Get only the char we need.
				for (int i = 0; i < iso_8859_7.length(); i++) {
					if (i < 2) {
						continue;
					}
					if (i % 2 != 0) {
						returnSB.append(iso_8859_7.charAt(i));
					}
				}
			} catch (UnsupportedEncodingException exception) {
				exception.printStackTrace();
			}
		} else {
			returnSB = new StringBuffer();
		}

		return returnSB.toString();
	}

	/**
	 * Converts an(greek) ISO-8859-7 String to Latin-mappers. For instance: We
	 * have a String in ISO-8859-7 String like this:"ÅããñáöÞò". It will convert
	 * to the Latin-mappers String:"Eggraf_h_s".
	 * 
	 * @param iso_8859_7
	 *            the ISO-8859-7 String to be converted.
	 * @return The converted String in Latin-mappers.
	 */
	public static String convertISO_8859_7ToLatin(String iso_8859_7) {
		Properties iSO_8859_7ToLatin = GreekAlphabetUtil.getISO8859_7ToLatin();
		StringBuffer sb = handle_ISO_8859_7(iso_8859_7, iSO_8859_7ToLatin);
		return sb.toString();
	}

	/**
	 * Helper-Method that creates an StringBuffer mapping from the properties.
	 * 
	 * @param greekUnicode
	 *            The GreekUnicode String to be converted.
	 * @param greek2GrHTMLEntitys
	 *            The Properties to map to.
	 * @return The result.
	 */
	public static StringBuffer handleGreekUnicode(String greekUnicode,
			Properties greek2GrHTMLEntitys) {
		StringBuffer outputHtmlEntitys = new StringBuffer();
		int length = greekUnicode.length();
		for (int i = 0; i < length; i++) {
			char current = greekUnicode.charAt(i);
			String search = "" + current;
			if (greek2GrHTMLEntitys.containsKey(search)) {
				outputHtmlEntitys.append(greek2GrHTMLEntitys
						.getProperty(search));
			} else {
				outputHtmlEntitys.append(current);
			}
		}
		return outputHtmlEntitys;
	}

	/**
	 * Converts an GreekUnicode String to HTML Entitys so you can read it with
	 * any set encoding from the browser. For instance:We have a String in
	 * GreekUnicode like
	 * this:"\u0395\u03b3\u03b3\u03c1\u03b1\u03c6\u03ae\u03c2". It will convert
	 * to the HTML Entitys: "&#917;&#947;&#947;&#961;&#945;&#966;&#942;&#962;".
	 * 
	 * @param greekUnicode
	 *            the GreekUnicode String to be converted.
	 * @return The converted String in HTML Entitys.
	 */
	public static String convertGreekUnicodeToHTML_Entitys(String greekUnicode) {
		Properties greek2GrHTMLEntitys = GreekAlphabetUtil
				.getGreek2GrHTMLEntitys();
		StringBuffer outputHtmlEntitys = handleGreekUnicode(greekUnicode,
				greek2GrHTMLEntitys);
		return outputHtmlEntitys.toString();
	}

	/**
	 * Converts an GreekUnicode String to an ISO-8859-7 String. For instance:We
	 * have a String in GreekUnicode like
	 * this:"\u0395\u03b3\u03b3\u03c1\u03b1\u03c6\u03ae\u03c2". It will convert
	 * to the ISO-8859-7 String:"ÅããñáöÞò".
	 * 
	 * @param greekUnicode
	 *            the GreekUnicode String to be converted.
	 * @return The converted String in ISO-8859-7 String.
	 */
	public static String convertGreekUnicodeToISO_8859_7(String greekUnicode) {
		Properties greek2GrISO8859_7 = GreekAlphabetUtil.getGreek2GrISO8859_7();
		StringBuffer sb = handleGreekUnicode(greekUnicode, greek2GrISO8859_7);
		return sb.toString();
	}

	/**
	 * Converts an GreekUnicode String to an Latin-mappers String. For
	 * instance:We have a String in GreekUnicode like
	 * this:"\u0395\u03b3\u03b3\u03c1\u03b1\u03c6\u03ae\u03c2". It will convert
	 * to the Latin-mappers String:"Eggraf_h_s".
	 * 
	 * @param greekUnicode
	 *            the GreekUnicode String to be converted.
	 * @return The converted String in Latin-mappers String.
	 */
	public static String convertGreekUnicodeToLatin(String greekUnicode) {
		Properties greek2latin = GreekAlphabetUtil.getGreek2Latin();
		StringBuffer sb = handleGreekUnicode(greekUnicode, greek2latin);
		return sb.toString();
	}

	/**
	 * Converts an Latin-mappers String to HTML Entitys. For instance:We have a
	 * String in Latin-mappers String like this:"Eggraf_h_s". It will convert to
	 * the HTML Entitys:"&#917;&#947;&#947;&#961;&#945;&#966;&#942;&#962;".
	 * 
	 * @param input
	 *            The Latin-mappers String to be converted.
	 * @return The converted String in HTML Entitys.
	 */
	public static String convertLatinToHTML_Entitys(String input) {
		Properties latin2Gr4HTML = GreekAlphabetUtil.getLatin2GrHTMLEntitys();
		StringBuffer outputhtmlChars = new StringBuffer();
		String buffer = "", underscore = "_", doppelpunkt = ":", combi = ":_";
		int length = input.length();
		for (int i = 0; i < length; i++) {
			char current = input.charAt(i);
			// If the buffer is not empty than its a control character
			if (0 < buffer.length()) {
				if (buffer.equals(underscore)) {
					if (current == '_') {

						// entity-html for underscore is "&#95;"
						outputhtmlChars.append("&#95;" + "&#95;");
					} else {
						if (latin2Gr4HTML.containsKey(buffer + current)) {
							outputhtmlChars.append(latin2Gr4HTML
									.getProperty(buffer + current));
						} else {
							outputhtmlChars.append("&#95;" + current);
						}
					}
					buffer = "";
				} else if (buffer.equals(doppelpunkt)) {
					if (current == '_') {
						buffer = buffer + current;
					} else {
						if (latin2Gr4HTML.containsKey(buffer + current)) {
							outputhtmlChars.append(latin2Gr4HTML
									.getProperty(buffer + current));
						} else {
							outputhtmlChars.append(buffer + current);
						}
						buffer = "";
					}
				} else if (buffer.equals(combi)) {
					if (current == '_') {
						outputhtmlChars.append(buffer + current);
					} else {
						if (latin2Gr4HTML.containsKey(buffer + current)) {
							outputhtmlChars.append(latin2Gr4HTML
									.getProperty(buffer + current));
						} else {
							outputhtmlChars.append(buffer + current);
						}
					}
					buffer = "";
				}
			} else {// if buffer is empty than control the char
				if (current == '_') {
					buffer = underscore;
				} else if (current == ':') {
					buffer = doppelpunkt;
				} else {
					if (latin2Gr4HTML.containsKey("" + current)) {
						outputhtmlChars.append(latin2Gr4HTML.getProperty(""
								+ current));
					} else {
						outputhtmlChars.append("" + current);
					}
				}
			}
		}
		return outputhtmlChars.toString();
	}

	/**
	 * Converts an Latin-mappers String to GreekUnicode. For instance:We have a
	 * String in Latin-mappers String like this:"Eggraf_h_s". It will convert to
	 * the GreekUnicode:"\u0395\u03b3\u03b3\u03c1\u03b1\u03c6\u03ae\u03c2".
	 * 
	 * @param input
	 *            The Latin-mappers String to be converted.
	 * @return The converted String in GreekUnicode.
	 */
	public static String convertLatinToGreekUnicode(String input) {
		Properties latin2Greek = GreekAlphabetUtil.getLatin2Greek();
		StringBuffer outputgreekChars = new StringBuffer();
		String buffer = "", underscore = "_", doppelpunkt = ":", combi = ":_";
		int length = input.length();
		for (int i = 0; i < length; i++) {
			char current = input.charAt(i);
			// If the buffer is not empty than its a control character
			if (0 < buffer.length()) {
				if (buffer.equals(underscore)) {
					if (current == '_') {
						outputgreekChars.append(buffer + current);
					} else {
						if (latin2Greek.containsKey(buffer + current)) {
							outputgreekChars.append(latin2Greek
									.getProperty(buffer + current));
						} else {
							outputgreekChars.append(buffer + current);
						}
					}
					buffer = "";
				} else if (buffer.equals(doppelpunkt)) {
					if (current == '_') {
						buffer = buffer + current;
					} else {
						if (latin2Greek.containsKey(buffer + current)) {
							outputgreekChars.append(latin2Greek
									.getProperty(buffer + current));
						} else {
							outputgreekChars.append(buffer + current);
						}
						buffer = "";
					}
				} else if (buffer.equals(combi)) {
					if (current == '_') {
						outputgreekChars.append(buffer + current);
					} else {
						if (latin2Greek.containsKey(buffer + current)) {
							outputgreekChars.append(latin2Greek
									.getProperty(buffer + current));
						} else {
							outputgreekChars.append(buffer + current);
						}
					}
					buffer = "";
				}
			} else {// if buffer is empty than control the char
				if (current == '_') {
					buffer = underscore;
				} else if (current == ':') {
					buffer = doppelpunkt;
				} else {
					if (latin2Greek.containsKey("" + current)) {
						outputgreekChars.append(latin2Greek.getProperty(""
								+ current));
					} else {
						outputgreekChars.append("" + current);
					}
				}
			}
		}
		return outputgreekChars.toString();
	}

	/**
	 * Converts an Latin-mappers String to an ISO-8859-7 String. For instance:We
	 * have a String in Latin-mappers String like this:"Eggraf_h_s". It will
	 * convert to the ISO-8859-7 String:"ÅããñáöÞò".
	 * 
	 * @param input
	 *            The Latin-mappers String to be converted.
	 * @return The converted String in ISO-8859-7 String.
	 */
	public static String convertLatinToISO_8859_7(String latin) {
		String greekUnicode = GreekAlphabetUtil
				.convertLatinToGreekUnicode(latin);
		String iso_8859_7 = GreekAlphabetUtil
				.convertGreekUnicodeToISO_8859_7(greekUnicode);
		return iso_8859_7;
	}

	/**
	 * This method gets a Properties-object that maps the latin-character to the
	 * HTML-Entity. For instance: a=&\#945; _a=&\#940; and so on...
	 * 
	 * @return The produced Properties.
	 */
	public static Properties getLatin2GrHTMLEntitys() {
		Properties latin2Gr4HTML = new Properties();
		int length = GreekAlphabet.greekAlphabet.length;
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < GreekAlphabet.greekAlphabet[i].length; j++) {
				if (j == 1) {
					latin2Gr4HTML.setProperty(
							GreekAlphabet.greekAlphabet[i][j],
							GreekAlphabet.greekAlphabet[i][j + 1]);
				}
			}
		}
		return latin2Gr4HTML;
	}

	/**
	 * This method gets a Properties-object that maps the latin-character to the
	 * greek-character as a unicode. For instance: a=\u03B1 _a=\u03AC and so
	 * on...
	 * 
	 * @return The produced Properties.
	 */
	public static Properties getLatin2Greek() {
		Properties properties = new Properties();
		int length = GreekAlphabet.greekAlphabet.length;
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < GreekAlphabet.greekAlphabet[i].length; j++) {
				if (j == 1) {
					properties.setProperty(GreekAlphabet.greekAlphabet[i][j],
							GreekAlphabet.greekAlphabet[i][j - 1]);
				}
			}
		}
		return properties;
	}

	/**
	 * This method gets a Properties-object that maps the latin-character to the
	 * ISO-8859-7. For instance: a=\u00E1 _a=\u00DC and so on...
	 * 
	 * @return The produced Properties.
	 */
	public static Properties getLatin2ISO_8859_7() {
		Properties properties = new Properties();
		int length = GreekAlphabet.greekAlphabet.length;
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < GreekAlphabet.greekAlphabet[i].length; j++) {
				if (j == 1) {
					properties.setProperty(GreekAlphabet.greekAlphabet[i][j],
							GreekAlphabet.greekAlphabet[i][j + 2]);
				}
			}
		}
		return properties;
	}

	/**
	 * This method gets a Properties-object that maps the greek-character to the
	 * latin-character. For instance: \u03B1=a \u03AC=_a and so on...
	 * 
	 * @return The produced Properties.
	 */
	public static Properties getGreek2Latin() {
		Properties properties = new Properties();
		int length = GreekAlphabet.greekAlphabet.length;
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < GreekAlphabet.greekAlphabet[i].length; j++) {
				if (j == 1) {
					properties.setProperty(
							GreekAlphabet.greekAlphabet[i][j - 1],
							GreekAlphabet.greekAlphabet[i][j]);
				}
			}
		}
		return properties;
	}

	/**
	 * This method gets a Properties-object that maps the greek-character as a
	 * unicode to the HTML-Entity. For instance: \u03B5=&\#949; \u03B4=&\#948;
	 * and so on...
	 * 
	 * @return The produced Properties.
	 */
	public static Properties getGreek2GrHTMLEntitys() {
		Properties properties = new Properties();
		int length = GreekAlphabet.greekAlphabet.length;
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < GreekAlphabet.greekAlphabet[i].length; j++) {
				if (j == 1) {
					properties.setProperty(
							GreekAlphabet.greekAlphabet[i][j - 1],
							GreekAlphabet.greekAlphabet[i][j + 1]);
				}
			}
		}
		return properties;
	}

	/**
	 * This method gets a Properties-object that maps the greek-character as a
	 * unicode to the ISO-8859-7. For instance: \u03B5=\u00E5 \u03B4=\u00E4 and
	 * so on...
	 * 
	 * @return The produced Properties.
	 */
	public static Properties getGreek2GrISO8859_7() {
		Properties properties = new Properties();
		int length = GreekAlphabet.greekAlphabet.length;
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < GreekAlphabet.greekAlphabet[i].length; j++) {
				if (j == 1) {
					properties.setProperty(
							GreekAlphabet.greekAlphabet[i][j - 1],
							GreekAlphabet.greekAlphabet[i][j + 2]);
				}
			}
		}
		return properties;
	}

	/**
	 * This method gets a Properties-object that maps the HTML-Entity as a
	 * unicode to the greek-character as a unicode. For instance: &\#953;=\u03B9
	 * &\#921;=\u0399 and so on...
	 * 
	 * @return The produced Properties.
	 */
	public static Properties getHtmlEntitys2Greek() {
		Properties properties = new Properties();
		int length = GreekAlphabet.greekAlphabet.length;
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < GreekAlphabet.greekAlphabet[i].length; j++) {
				if (j == 1) {
					properties.setProperty(
							GreekAlphabet.greekAlphabet[i][j + 1],
							GreekAlphabet.greekAlphabet[i][j - 1]);
				}
			}
		}
		return properties;
	}

	/**
	 * This method gets a Properties-object that maps the HTML-Entity as a
	 * unicode to the latin-character. For instance: &\#945;=a &\#940;=_a and so
	 * on...
	 * 
	 * @return The produced Properties.
	 */
	public static Properties getHtmlEntitys2Latin() {
		Properties properties = new Properties();
		int length = GreekAlphabet.greekAlphabet.length;
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < GreekAlphabet.greekAlphabet[i].length; j++) {
				if (j == 1) {
					properties.setProperty(
							GreekAlphabet.greekAlphabet[i][j + 1],
							GreekAlphabet.greekAlphabet[i][j]);
				}
			}
		}
		return properties;
	}

	/**
	 * This method gets a Properties-object that maps the HTML-Entity as a
	 * unicode to the ISO-8859-7 character. For instance: &\#953;=\u00E9
	 * &\#921;=\u00C9 and so on...
	 * 
	 * @return The produced Properties.
	 */
	public static Properties getHtmlEntitys2ISO_8859_7() {
		Properties properties = new Properties();
		int length = GreekAlphabet.greekAlphabet.length;
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < GreekAlphabet.greekAlphabet[i].length; j++) {
				if (j == 1) {
					properties.setProperty(
							GreekAlphabet.greekAlphabet[i][j + 1],
							GreekAlphabet.greekAlphabet[i][j + 2]);
				}
			}
		}
		return properties;
	}

	/**
	 * This method gets a Properties-object that maps the ISO-8859-7 characters
	 * to the HTML-Entity. For instance: \u00BC=&\#908; \u00BA=&\#906; and so
	 * on...
	 * 
	 * @return The produced Properties.
	 */
	public static Properties getISO8859_7ToHTMLEntitys() {
		Properties properties = new Properties();
		int length = GreekAlphabet.greekAlphabet.length;
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < GreekAlphabet.greekAlphabet[i].length; j++) {
				if (j == 1) {
					properties.setProperty(
							GreekAlphabet.greekAlphabet[i][j + 2],
							GreekAlphabet.greekAlphabet[i][j + 1]);
				}
			}
		}
		return properties;
	}

	/**
	 * This method gets a Properties-object that maps the ISO-8859-7 characters
	 * to the Latin-mappers. For instance: \u00BC=&\#908; \u00BA=&\#906; and so
	 * on...
	 * 
	 * @return The produced Properties.
	 */
	public static Properties getISO8859_7ToLatin() {
		Properties properties = new Properties();
		int length = GreekAlphabet.greekAlphabet.length;
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < GreekAlphabet.greekAlphabet[i].length; j++) {
				if (j == 1) {
					properties.setProperty(
							GreekAlphabet.greekAlphabet[i][j + 2],
							GreekAlphabet.greekAlphabet[i][j]);
				}
			}
		}
		return properties;
	}

	/**
	 * This method gets a Properties-object that maps the ISO-8859-7 characters
	 * to the GreekUnicode. For instance: \u00BC=\u038C \u00BA=\u038A and so
	 * on...
	 * 
	 * @return The produced Properties.
	 */
	public static Properties getISO8859_7ToGreekUnicode() {
		Properties properties = new Properties();
		int length = GreekAlphabet.greekAlphabet.length;
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < GreekAlphabet.greekAlphabet[i].length; j++) {
				if (j == 1) {
					properties.setProperty(
							GreekAlphabet.greekAlphabet[i][j + 2],
							GreekAlphabet.greekAlphabet[i][j - 1]);
				}
			}
		}
		return properties;
	}

	/**
	 * Helper-Method to give the GreekAlphabet as Unicode. The GreekAlphabet is
	 * in the interface UnicodeConst.
	 * 
	 * @return The GreekAlphabet as a Unicode String.
	 */
	public static String getGreekAlphabetAsUnicode() {
		StringBuffer sbGreekAlphabet = new StringBuffer();
		int length = UnicodeConst.greekAlphabetCharArray_UNICODE.length;
		for (int i = 0; i < length; i++) {
			sbGreekAlphabet
					.append(UnicodeConst.greekAlphabetCharArray_UNICODE[i]
							+ "\n");
		}
		return sbGreekAlphabet.toString();
	}

	/**
	 * Helper-Method to give the GreekAlphabet as HTML Entitys. The
	 * GreekAlphabet is in the interface HTML_EntitysConst.
	 * 
	 * @return The GreekAlphabet as a HTML Entitys String.
	 */
	public static String getGreekAlphabetAsHTMLEntitys() {
		StringBuffer sbGreekAlphabet = new StringBuffer();
		int length = HTML_EntitysConst.greekAlphabet_HTML_ENTITYS.length;
		for (int i = 0; i < length; i++) {
			sbGreekAlphabet
					.append(HTML_EntitysConst.greekAlphabet_HTML_ENTITYS[i]
							+ "\n");
		}
		return sbGreekAlphabet.toString();
	}

	/**
	 * Helper-Method to give the GreekAlphabet as ISO-8859-7 characters. The
	 * GreekAlphabet is in the interface ISO8859_7Const.
	 * 
	 * @return The GreekAlphabet as a ISO-8859-7 String.
	 */
	public static String getGreekAlphabetAsISO8859_7() {
		StringBuffer sbGreekAlphabet = new StringBuffer();
		int length = ISO8859_7Const.greekAlphabetStringArray_ISO8859_7.length;
		for (int i = 0; i < length; i++) {
			sbGreekAlphabet
					.append(ISO8859_7Const.greekAlphabetStringArray_ISO8859_7[i]
							+ "\n");
		}
		return sbGreekAlphabet.toString();
	}

	/**
	 * Helper-Method to give the GreekAlphabet as Latin-mappers characters. The
	 * GreekAlphabet is in the interface LatinToGreekConst_7Const.
	 * 
	 * @return The GreekAlphabet as a Latin-mappers String.
	 */
	public static String getGreekAlphabetAsLatin() {
		StringBuffer sbGreekAlphabet = new StringBuffer();
		int length = LatinToGreekConst.greekAlphabet_LATIN.length;
		for (int i = 0; i < length; i++) {
			sbGreekAlphabet.append(LatinToGreekConst.greekAlphabet_LATIN[i]
					+ "\n");
		}
		return sbGreekAlphabet.toString();
	}

	/**
	 * This method returns null or the transformed attribut as a Unicode and
	 * copys the input into the copyFromAttribut.
	 * 
	 * @param attribut
	 *            The attribut.
	 * @param copyFromAttribut
	 *            The copyFromAttribut.
	 * @return The transformed attribut.
	 */
	public static String handleAttribut(String attribut, String copyFromAttribut) {
		String returnString = null;
		if (attribut == null) {
			return attribut;
		} else {
			StringBuffer sb = new StringBuffer(attribut);
			copyFromAttribut = sb.toString();
//			returnString = GreekAlphabetUtil
//					.convertISO_8859_7ToGreekChars(attribut);
			returnString = GreekAlphabetUtil.convertISO_8859_7ToGreekUnicode(attribut);
			return returnString;
		}
	}

	/**
	 * This method returns the attribut from the bean and copys it in the
	 * copyFromAttribut.
	 * 
	 * @param attribut
	 *            The attribut.
	 * @param copyFromAttribut
	 *            The copyFromAttribut.
	 * @return The attribut.
	 */
	public static String handleSimpleAttribut(String attribut,
			String copyFromAttribut) {
		if (attribut == null) {
			return attribut;
		} else {
			StringBuffer sb = new StringBuffer(attribut);
			copyFromAttribut = sb.toString();
			return attribut;
		}
	}
}
