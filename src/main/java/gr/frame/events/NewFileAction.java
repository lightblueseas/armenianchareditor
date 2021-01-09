package gr.frame.events;

import gr.frame.MainFrame;
import gr.frame.util.Constants;

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
		MainFrame frame = MainFrame.getInstance();
        JTextArea textAreaInput = frame.getJtaInput();
        JTextArea textAreaPreview = frame.getJtaPreview();
        JTextArea textAreaHtmlEntitys = frame.getJtaHtmlEntitys();
        JTextArea textAreaIso_8859_7 =frame.getJtaIso8859_7();
        textAreaInput.replaceRange(EMPTYSTRING, 0, textAreaInput.getText().length());
        textAreaPreview.replaceRange(EMPTYSTRING, 0, textAreaPreview.getText()
                .length());
        textAreaHtmlEntitys.replaceRange(EMPTYSTRING, 0, textAreaHtmlEntitys.getText()
                .length());
        textAreaIso_8859_7.replaceRange(EMPTYSTRING, 0, textAreaIso_8859_7.getText().length());
	}

}
