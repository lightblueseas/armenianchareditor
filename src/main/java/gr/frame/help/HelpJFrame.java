package gr.frame.help;

import de.alpharogroup.layout.DisposeWindow;
import gr.frame.Messages;

import java.awt.BorderLayout;
import java.awt.Panel;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;

public class HelpJFrame extends JFrame implements ActionListener {
    private static final String BUTTONLABEL_CLOSE = Messages.getString("helpframe.button.label.close"); //$NON-NLS-1$
	private static final String LABEL_HELP = Messages.getString("helpframe.label.help"); //$NON-NLS-1$
	/** The generaded serialVersionUID. */
	private static final long serialVersionUID = 4151069054089210855L;
	/**     */
    private JLabel jlabelTitle = null;
    /**     */
    private String helptext = null;
    /**     */
    private DisposeWindow disposeWindow = null;
    /**     */
    private JTextArea jtaHelp = null;
    private JTextPane jtpHelp;
    /**     */
    private JScrollPane jscrollPanejtaHelp = null;
    /**     */
    private JButton buttonClose = null;

    public HelpJFrame(String title, String helptext){
        super(title);
        this.helptext = helptext;
        disposeWindow = new DisposeWindow();
        addWindowListener(disposeWindow);
        //Point parloc = this.getParent().getLocation();
        Point parloc = new Point(0, 0);
        setLocation(parloc.x + 30, parloc.y + 30);
        setSize(580, 600);
        createLayout();

    }

    private void createLayout() {
        jlabelTitle = new JLabel(LABEL_HELP);
        getContentPane().add(jlabelTitle, BorderLayout.NORTH);
        //JTextArea Help:
        jtaHelp = new JTextArea(10, 10);
        jtpHelp = new JTextPane();
        jtpHelp.replaceSelection(helptext);
        jtaHelp.setText(helptext);
        jtaHelp.setCaretPosition(0);
        jtaHelp.setLineWrap(true);
        jtaHelp.setWrapStyleWord(true);
        jtaHelp.setEditable(false);
        jscrollPanejtaHelp = new JScrollPane(jtpHelp);
        getContentPane().add(jscrollPanejtaHelp, BorderLayout.CENTER);
        buttonClose = new JButton(BUTTONLABEL_CLOSE);
        buttonClose.addActionListener(this);
        Panel unten = new Panel();
        unten.add(buttonClose, BorderLayout.WEST);
        getContentPane().add(unten, BorderLayout.SOUTH);

    }

    public void actionPerformed(ActionEvent event) {
        if(event.getSource() == buttonClose){
            this.dispose();
        }
    }

}
