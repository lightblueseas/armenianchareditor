package io.github.astrapi69.chareditor.actions;

import io.github.astrapi69.chareditor.SpringBootSwingApplication;
import io.github.astrapi69.chareditor.util.Constants;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JTextArea;

/**
 * The Class NewFileAction.
 */
public class NewFileAction extends AbstractAction implements Constants {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new new file action.
	 *
	 * @param name the name
	 */
	public NewFileAction(String name) {
		super(name);
	}

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		SpringBootSwingApplication frame = SpringBootSwingApplication.getInstance();
        JTextArea textAreaInput = frame.getMainPanel().getJtaInput();
        JTextArea textAreaPreview = frame.getMainPanel().getJtaPreview();
        JTextArea textAreaHtmlEntitys = frame.getMainPanel().getJtaHtmlEntitys();
        textAreaInput.replaceRange(EMPTYSTRING, 0, textAreaInput.getText().length());
        textAreaPreview.replaceRange(EMPTYSTRING, 0, textAreaPreview.getText()
                .length());
        textAreaHtmlEntitys.replaceRange(EMPTYSTRING, 0, textAreaHtmlEntitys.getText()
                .length());
	}

}
