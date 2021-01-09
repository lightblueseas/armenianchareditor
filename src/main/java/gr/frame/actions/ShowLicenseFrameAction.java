package gr.frame.actions;

import de.alpharogroup.lang.ClassExtensions;
import de.alpharogroup.lang.PackageExtensions;
import gr.frame.help.HelpJFrame;

import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.swing.AbstractAction;

@SuppressWarnings("serial")
public class ShowLicenseFrameAction extends AbstractAction {

	private static final String LICENCE_TITLE = "Licence";


	public ShowLicenseFrameAction(String name) {
		super(name);
	}

	public void actionPerformed(ActionEvent e) {
		String licence = loadLicense();
        HelpJFrame frame = new HelpJFrame(LICENCE_TITLE, licence);
        frame.setVisible(true);
	}

	private String loadLicense() {
		InputStream is = null;
		StringBuffer license = new StringBuffer();
		try {
			String thisLine;
			String pathPrefix = null;
			pathPrefix = PackageExtensions.getPackagePath(this);
			is = ClassExtensions.getResourceAsStream("LICENSE.txt", this);
			if(is == null){
				is = ClassExtensions.getResourceAsStream(pathPrefix + "LICENSE.txt", this);
			}
			BufferedReader br = new BufferedReader
	         (new InputStreamReader(is));
	      while ((thisLine = br.readLine()) != null) {
	    	  license.append(thisLine + "\n");
	      }
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			try {
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return license.toString();
	}

}
