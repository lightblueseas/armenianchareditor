package io.github.astrapi69.chareditor.util;

import io.github.astrapi69.chareditor.viewmodel.ArmenianAlphabet;

import java.util.Properties;

public class AlphabetExtensions {

    public static void main(String... args) {
        Properties htmlEntitys2Armenian = getHtmlEntitys2Latin();
        System.out.println(htmlEntitys2Armenian);
    }

    /**
     * This method gets a Properties-object that maps the latin-character to the
     * HTML-Entity. For instance: a=&\#945; _a=&\#940; and so on...
     *
     * @return The produced Properties.
     */
    public static Properties getLatin2GrHTMLEntitys() {
        Properties latin2Gr4HTML = new Properties();
        int length = ArmenianAlphabet.alphabet.length;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < ArmenianAlphabet.alphabet[i].length; j++) {
                if (j == 1) {
                    latin2Gr4HTML.setProperty(
                            ArmenianAlphabet.alphabet[i][j],
                            ArmenianAlphabet.alphabet[i][j + 1]);
                }
            }
        }
        return latin2Gr4HTML;
    }
    /**
     * This method gets a Properties-object that maps the greek-character as a
     * unicode to the HTML-Entity. For instance: \u03B5=&\#949; \u03B4=&\#948;
     * and so on...
     *
     * @return The produced Properties.
     */
    public static Properties getArmenian2GrHTMLEntitys() {
        Properties properties = new Properties();
        int length = ArmenianAlphabet.alphabet.length;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < ArmenianAlphabet.alphabet[i].length; j++) {
                if (j == 1) {
                    properties.setProperty(
                            ArmenianAlphabet.alphabet[i][j - 1],
                            ArmenianAlphabet.alphabet[i][j + 1]);
                }
            }
        }
        return properties;
    }
    /**
     * This method gets a Properties-object that maps the latin-character to the
     * greek-character as a unicode. For instance: a=\u03B1 _a=\u03AC and so
     * on...
     *
     * @return The produced Properties.
     */
    public static Properties getLatin2Armenian() {
        Properties properties = new Properties();
        int length = ArmenianAlphabet.alphabet.length;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < ArmenianAlphabet.alphabet[i].length; j++) {
                if (j == 1) {
                    properties.setProperty(ArmenianAlphabet.alphabet[i][j],
                            ArmenianAlphabet.alphabet[i][j - 1]);
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
    public static Properties getArmenian2Latin() {
        Properties properties = new Properties();
        int length = ArmenianAlphabet.alphabet.length;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < ArmenianAlphabet.alphabet[i].length; j++) {
                if (j == 1) {
                    properties.setProperty(
                            ArmenianAlphabet.alphabet[i][j - 1],
                            ArmenianAlphabet.alphabet[i][j]);
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
        int length = ArmenianAlphabet.alphabet.length;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < ArmenianAlphabet.alphabet[i].length; j++) {
                if (j == 1) {
                    properties.setProperty(
                            ArmenianAlphabet.alphabet[i][j + 1],
                            ArmenianAlphabet.alphabet[i][j]);
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
    public static Properties getHtmlEntitys2Armenian() {
        Properties properties = new Properties();
        int length = ArmenianAlphabet.alphabet.length;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < ArmenianAlphabet.alphabet[i].length; j++) {
                if (j == 1) {
                    properties.setProperty(
                            ArmenianAlphabet.alphabet[i][j + 1],
                            ArmenianAlphabet.alphabet[i][j - 1]);
                }
            }
        }
        return properties;
    }

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

        Properties htmlEntitys2Greek = getHtmlEntitys2Armenian();
        StringBuffer outputGreekChars = handleHTMLEntitys(
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

        Properties htmlEntitys2Latin = getHtmlEntitys2Latin();
        StringBuffer outputLatinChars = handleHTMLEntitys(
                entitys, htmlEntitys2Latin);
        return outputLatinChars.toString();
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
        Properties greek2GrHTMLEntitys = getArmenian2GrHTMLEntitys();
        StringBuffer outputHtmlEntitys = handleGreekUnicode(greekUnicode,
                greek2GrHTMLEntitys);
        return outputHtmlEntitys.toString();
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
        Properties greek2latin = getArmenian2Latin();
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
        // TODO here is the handle of the latin characters to html entities
        Properties latin2Gr4HTML = getLatin2GrHTMLEntitys();
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
        // TODO here is the handle of the latin to armenian characters

        Properties latin2Greek = getLatin2Armenian();
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
