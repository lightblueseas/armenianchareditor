package gr.frame.help.info;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Frame;
import java.awt.HeadlessException;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;


public class InfoJDialog extends JDialog implements ActionListener {
	private static final String PLACEHOLDER_LABEL = Messages.getString("info.dialg.label.placeholder"); //$NON-NLS-1$ "   ";
	private static final String BUTTONLABEL_CLOSE = Messages.getString("info.dialg.label.close"); //$NON-NLS-1$ "Close";
	/** The generaded serialVersionUID. */
	private static final long serialVersionUID = 5646178025613269032L;

    /**     */
    InfoJPanel panel = null;
    /**     */
    private JButton buttonClose = null;
    /**     */
    private JLabel labelPlaceholder = null;
    /**     */
    Panel buttons = null;

    /**
     * @throws HeadlessException
     */
    public InfoJDialog(Frame owner, String title) throws HeadlessException {
        setTitle(title);
        buttonClose = new JButton(BUTTONLABEL_CLOSE);
        buttonClose.addActionListener(this);
        labelPlaceholder = new JLabel(PLACEHOLDER_LABEL);
        Panel buttons = new Panel();
        buttons.add(buttonClose, BorderLayout.EAST);
        buttons.add(labelPlaceholder, BorderLayout.CENTER);
        panel = new InfoJPanel();
        Container container = getContentPane();
        container.add(panel, BorderLayout.CENTER);
        container.add(buttons, BorderLayout.SOUTH);
        int x = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
        int y = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
        setLocation( (x/3), (y/3) );
        setSize((x/3), (y/3));
    }
    public void actionPerformed(ActionEvent event) {
        if(event.getSource() == buttonClose){
            this.dispose();
        }
    }
}
