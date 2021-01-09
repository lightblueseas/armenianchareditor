package gr.frame.events;

import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import gr.frame.MainFrame;
import gr.frame.filefilter.GRCFilter;
import gr.frame.util.Constants;

import javax.swing.AbstractAction;
import javax.swing.JFileChooser;
import javax.swing.JTextArea;

public class OpenFileAction extends AbstractAction implements Constants  {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;


	public OpenFileAction(String name) {
		super(name);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		MainFrame frame = MainFrame.getInstance();
        JTextArea textAreaInput = frame.getMainPanel().getJtaInput();
        JTextArea textAreaPreview = frame.getMainPanel().getJtaPreview();
        JTextArea textAreaHtmlEntitys = frame.getMainPanel().getJtaHtmlEntitys();
        JTextArea textAreaIso_8859_7 =frame.getMainPanel().getJtaIso8859_7();
        openFile(textAreaInput, textAreaPreview, textAreaHtmlEntitys, textAreaIso_8859_7);

	}


	private void openFile(JTextArea textAreaInput, JTextArea textAreaPreview, JTextArea textAreaHtmlEntitys, JTextArea textAreaIso_8859_7) {

		MainFrame frame = MainFrame.getInstance();
		GRCFilter filter = new GRCFilter();
		JFileChooser fc = frame.getJfileChooser();
		fc.setFileFilter(filter);
		int returnVal = fc.showOpenDialog(frame);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
		    File file = fc.getSelectedFile();
		    ObjectInputStream ois = null;
		    try {
		        ois = new ObjectInputStream(new FileInputStream(file));
		        SaveModel model = (SaveModel) ois.readObject();
		        textAreaPreview.setText(model.getInputFromTAPreview());
		        textAreaInput.setText(model.getInputFromTAInput());
		        textAreaHtmlEntitys.setText(model.getInputFromTAHtmlEntitys());
		        textAreaIso_8859_7.setText(model.getInputFromTAIso_8859_7());
		        ois.close();
		    } catch (IOException e1) {
		        System.err.println("Error by opening the editors.");
		    } catch (ClassNotFoundException e1) {
		        e1.printStackTrace();
		    } finally {
		    	try {
					ois.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
		    }

		} else {
		    //Do nothing
		    //System.err.println("Abbrechen wurde gedr�ckt.");
		}
	}

}
