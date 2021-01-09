package gr.frame.help.info;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class InfoJPanel extends JPanel {
	private static final String LABEL_COPYRIGHTHOLDER = Messages.getString("InfoJPanel.copyright.value"); //$NON-NLS-1$

	private static final String LABEL_COPYRIGHT = Messages.getString("InfoJPanel.copyright.key"); //$NON-NLS-1$

	private static final String LABEL_VERSION_NUMBER = Messages.getString("InfoJPanel.version.value"); //$NON-NLS-1$

	private static final String LABEL_VERSION = Messages.getString("InfoJPanel.version.key"); //$NON-NLS-1$

	private static final String LABEL_APPLICATION_NAME_VALUE = Messages.getString("InfoJPanel.application.name.value"); //$NON-NLS-1$

	private static final String LABEL_APPLICATION_NAME = Messages.getString("InfoJPanel.application.name.key"); //$NON-NLS-1$

	private static final String WARNING_TEXT = Messages.getString("InfoJPanel.warning") ; //$NON-NLS-1$

	/** The generaded serialVersionUID. */
	private static final long serialVersionUID = -5173953432663432688L;

	/**     */
    private JLabel applicationName = null;

    /**     */
    private JLabel labelApplicationName = null;

    /**     */
    private JLabel versionNumber = null;

    /**     */
    private JLabel labelversionNumber = null;

    /**     */
    private JLabel copyright = null;

    /**     */
    private JLabel labelCopyright = null;

    /**     */
    private String warning = null;

    /**     */
    private JTextArea jtaWarning = null;
    /**     */
//    private JScrollPane jscrollPaneJtaWarning = null;
//    /**     */
//    private JLabel labelWarning = null;
//
//    /**     */
//    private JLabel labelPlaceholder = null;

    /**
     *
     */
    public InfoJPanel() {
        createLayout();
    }

    private void createLayout() {
        Insets oneInsent = new Insets(1, 1, 1, 1);
        GridBagLayout gbl = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        setLayout(gbl);
        warning = WARNING_TEXT;
        labelApplicationName = new JLabel(LABEL_APPLICATION_NAME);
        applicationName = new JLabel(LABEL_APPLICATION_NAME_VALUE);
        labelversionNumber = new JLabel(LABEL_VERSION);
        versionNumber = new JLabel(LABEL_VERSION_NUMBER);
        labelCopyright = new JLabel(LABEL_COPYRIGHT);
        copyright = new JLabel(LABEL_COPYRIGHTHOLDER);
        jtaWarning = new JTextArea(warning);
        jtaWarning.setLineWrap(true);
        jtaWarning.setWrapStyleWord(true);
        jtaWarning.setEditable(false);
        //jscrollPaneJtaWarning = new JScrollPane(jtaWarning);

//        Panel applname = new Panel();
//        applname.setLayout(new BorderLayout());
//        applname.add(labelApplicationName, BorderLayout.CENTER);


        gbc.anchor = GridBagConstraints.EAST;
        gbc.fill = GridBagConstraints.NONE;
        gbc.insets = oneInsent;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weighty = 1;
        gbc.weightx = 1;
        gbc.ipadx = 0;
        gbc.ipady = 0;
        gbl.setConstraints(labelApplicationName, gbc);
        add(labelApplicationName);

        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.NONE;
        gbc.insets = oneInsent;
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weighty = 1;
        gbc.weightx = 1;
        gbc.ipadx = 0;
        gbc.ipady = 0;
        gbl.setConstraints(applicationName, gbc);
        add(applicationName);

        gbc.anchor = GridBagConstraints.EAST;
        gbc.fill = GridBagConstraints.NONE;
        gbc.insets = oneInsent;
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weighty = 1;
        gbc.weightx = 1;
        gbc.ipadx = 0;
        gbc.ipady = 0;
        gbl.setConstraints(labelversionNumber, gbc);
        add(labelversionNumber);

        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.NONE;
        gbc.insets = oneInsent;
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weighty = 1;
        gbc.weightx = 1;
        gbc.ipadx = 0;
        gbc.ipady = 0;
        gbl.setConstraints(versionNumber, gbc);
        add(versionNumber);

        gbc.anchor = GridBagConstraints.EAST;
        gbc.fill = GridBagConstraints.NONE;
        gbc.insets = oneInsent;
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weighty = 1;
        gbc.weightx = 1;
        gbc.ipadx = 0;
        gbc.ipady = 0;
        gbl.setConstraints(labelCopyright, gbc);
        add(labelCopyright);

        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.NONE;
        gbc.insets = oneInsent;
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weighty = 1;
        gbc.weightx = 1;
        gbc.ipadx = 0;
        gbc.ipady = 0;
        gbl.setConstraints(copyright, gbc);
        add(copyright);

    }

}
