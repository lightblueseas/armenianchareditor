package io.github.astrapi69.chareditor.util;

import org.junit.jupiter.api.Test;

import java.util.Properties;

import static org.junit.jupiter.api.Assertions.*;

class AlphabetExtensionsTest {

    @Test
    void getLatin2Armenian() {
        Properties latin2Armenian = AlphabetExtensions.getLatin2Armenian();
        assertNotNull(latin2Armenian);
    }

    @Test
    void getArmenian2Latin() {
        Properties armenian2Latin = AlphabetExtensions.getArmenian2Latin();
        assertNotNull(armenian2Latin);
    }

    @Test
    void getHtmlEntitys2Latin() {
        Properties htmlEntitys2Latin = AlphabetExtensions.getHtmlEntitys2Latin();
        assertNotNull(htmlEntitys2Latin);
    }

    @Test
    void getHtmlEntitys2Armenian() {
        Properties htmlEntitys2Armenian = AlphabetExtensions.getHtmlEntitys2Armenian();
        assertNotNull(htmlEntitys2Armenian);
    }
}
