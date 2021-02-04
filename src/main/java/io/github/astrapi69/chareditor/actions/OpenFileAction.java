package io.github.astrapi69.chareditor.actions;

import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import io.github.astrapi69.chareditor.SpringBootSwingApplication;
import io.github.astrapi69.chareditor.filefilter.GRCFilter;
import io.github.astrapi69.chareditor.util.Constants;

import javax.swing.AbstractAction;
import javax.swing.JFileChooser;
import javax.swing.JTextArea;

public class OpenFileAction extends AbstractAction implements Constants {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;


	public OpenFileAction(String name) {
		super(name);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		SpringBootSwingApplication frame = SpringBootSwingApplication.getInstance();
        JTextArea textAreaInput = frame.getMainPanel().getJtaInput();
        JTextArea textAreaPreview = frame.getMainPanel().getJtaPreview();
        JTextArea textAreaHtmlEntitys = frame.getMainPanel().getJtaHtmlEntitys();
        openFile(textAreaInput, textAreaPreview, textAreaHtmlEntitys);

	}


	private void openFile(JTextArea textAreaInput, JTextArea textAreaPreview, JTextArea textAreaHtmlEntitys) {

		SpringBootSwingApplication frame = SpringBootSwingApplication.getInstance();
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
