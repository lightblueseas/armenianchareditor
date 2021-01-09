package gr.frame.utils;

import gr.frame.util.Constants;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

import javax.swing.JTextArea;

public class ClipboardUtils implements Constants {


	/**
	 * Copy2 clipboard.
	 *
	 * @param textAreaInput the text area input
	 * @param textAreaHtmlEntitys the text area html entitys
	 */
	public static void copy2Clipboard(JTextArea textAreaInput,
			JTextArea textAreaHtmlEntitys, boolean withComment) {
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		StringBuffer sb = new StringBuffer();
		if (withComment) {
			sb.append(PREFIX_HTML_COMMENT);
			sb.append(textAreaInput.getText());
			sb.append(POSTFIX_HTML_COMMENT);
		}
		sb.append(textAreaHtmlEntitys.getText());
		StringSelection content = new StringSelection(sb.toString());
		clipboard.setContents(content, null);
	}

	public static void copyToClipboard(JTextArea jTextArea) {
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		StringBuffer sb = new StringBuffer();
		sb.append(jTextArea.getText());
		StringSelection content = new StringSelection(sb.toString());
		clipboard.setContents(content, null);
	}
}
