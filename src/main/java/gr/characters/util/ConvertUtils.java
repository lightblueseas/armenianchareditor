package gr.characters.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import de.alpharogroup.lang.ClassExtensions;

public class ConvertUtils {

	private static final String AllKnownHtmlEntitiesFromUnicodeToHtmlEntities = "properties/AllKnownHtmlEntitiesFromUnicodeToHtmlEntities.properties";

	public static String convertUnicodeToHtmlEntity(String unicode) throws IOException {
		Properties properties = new Properties();
		InputStream isProperties = ClassExtensions.getResourceAsStream(AllKnownHtmlEntitiesFromUnicodeToHtmlEntities);
		properties.load(isProperties);
        return properties.getProperty(unicode);

	}

	public static void main(String []args) throws IOException {
		String unicode = "\\u2665";
		String htmlEntity = convertUnicodeToHtmlEntity(unicode);
		System.out.println("Unicode:"+unicode+ " is HTML-Entity:"+htmlEntity);
	}

}
