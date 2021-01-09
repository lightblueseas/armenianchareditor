package gr.frame;

import de.alpharogroup.layout.CloseWindow;
import de.alpharogroup.swing.actions.ExitApplicationAction;
import de.alpharogroup.swing.actions.OpenBrowserAction;
import de.alpharogroup.swing.menu.MenuExtensions;
import de.alpharogroup.swing.plaf.LookAndFeels;
import de.alpharogroup.swing.plaf.actions.LookAndFeelMetalAction;
import de.alpharogroup.swing.plaf.actions.LookAndFeelMotifAction;
import de.alpharogroup.swing.plaf.actions.LookAndFeelWindowsAction;
import de.alpharogroup.swing.utils.AwtExtensions;
import de.alpharogroup.swing.utils.KeyStrokeExtensions;
import gr.characters.constants.GreekAlphabet;
import gr.frame.actions.HtmlEntitysTATransformAction;
import gr.frame.actions.InputTAClearAction;
import gr.frame.actions.InputTACopyHtmlEntitys2ClipboardAction;
import gr.frame.actions.InputTACopyIso_8859_7_ToClipboardAction;
import gr.frame.actions.InputTACopyIso_GreekChars_ToClipboardAction;
import gr.frame.actions.InputTATranformAction;
import gr.frame.actions.Iso8859_7TATransformAction;
import gr.frame.actions.PreviewTATransformAction;
import gr.frame.actions.ShowHelpDialogAction;
import gr.frame.actions.ShowInfoDialogAction;
import gr.frame.actions.ShowLicenseFrameAction;
import gr.frame.actions.UnicodeTATransformAction;
import gr.frame.events.NewFileAction;
import gr.frame.events.OpenFileAction;
import gr.frame.events.SaveFileAction;
import gr.frame.util.Constants;
import lombok.Getter;

import java.awt.BorderLayout;
import java.awt.Event;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.HeadlessException;
import java.awt.Insets;
import java.awt.Window;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.URL;

import javax.help.CSH;
import javax.help.DefaultHelpBroker;
import javax.help.HelpSet;
import javax.help.HelpSetException;
import javax.help.WindowPresentation;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

@Getter
public class MainFrame extends JFrame {

	private static final long serialVersionUID = -8104731925219304594L;

	public static final String TITLE = Messages
			.getString("TransformerJFrame.title"); //$NON-NLS-1$

	public static final String ISO_8859_7 = Messages
			.getString("TransformerJFrame.iso8859_7"); //$NON-NLS-1$

	public static final String[] columnNames = {
			Messages.getString("TransformerJFrame.column.greek"), Messages.getString("TransformerJFrame.column.latin"), Messages.getString("TransformerJFrame.column.htmlentitys"), ISO_8859_7 }; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$

	// JTextAreas and JTable
	private JTextArea jtaPreview;


	private JTextArea jtaHtmlEntitys;


	private JTextArea jtaUnicode;


	private JTextArea jtaIso8859_7;


	private JTextArea jtaInput;


	private JTabbedPane jtpOutput;


	private JPanel panelJTAHtmlEntitys;


	private JPanel panelJTAUnicode;


	private JPanel panelJTAIso8859_7;


	private JTable jTableAlphabet;

	// JLabels

	private JLabel labelInput;


	private JLabel labelHtmlEntitys;

	private JLabel labelUnicode;


	private JLabel labelIso8859_7;


	private JLabel labelPreview;


	private JLabel labelAlphabet;


	private JLabel labelPlaceholder;

	// JScrollPane

	private JScrollPane jscrollPaneTableAlphabet;


	private JScrollPane jscrollPanejtaInput;


	private JScrollPane jscrollPanejtaPreview;


	private JScrollPane jscrollPanejtaHtmlEntitys;


	private JScrollPane jscrollPanejtaUnicode;


	private JScrollPane jscrollPanejtaIso8859_7;

	// Insets

	private Insets oneInsent;


	private Insets twoInsent;

	// JMenuBar and JMenus

	private JMenuBar menubar;


	private JMenu menuFile;


	private JMenu menuEdit;


	private JMenu menuLookAndFell;


	private JMenu menuHelp;

	// File-MenuItems

	private JMenuItem mifNew;


	private JMenuItem mifOpen;


	private JMenuItem mifSave;


	private JMenuItem mifSaveAs;


	private JMenuItem mifClose;

	// Look and Feel-MenuItems
	/**   */
	private JMenuItem milafMetal;

	/**   */
	private JMenuItem milafMotiv;

	/**   */
	private JMenuItem milafWindows;

	// Help-MenuItems

	private JMenuItem mihHelpContent;


	private JMenuItem mihLicence;


	private JMenuItem mihInfo;

	// Buttons

	private JButton jbutInputTATranform;


	private JButton jbutInputTACopyHtmlEntitys2Clipboard;


	private JButton jbutInputTACopyIso_8859_7_ToClipboard;

	private JButton jbutInputTACopyIso_GreekChars_ToClipboard;


	private JButton jbutInputTAClear;


	private JButton jbutPreviewTATransform;


	private JButton jbutHtmlEntitysTATransform;


	private JButton jbutUnicodeTATransform;

	public JButton getJbutUnicodeTATransform() {
		return jbutUnicodeTATransform;
	}


	private JButton jbutIso8859_7TATransform;


	private CloseWindow closeWindow;


	private JFileChooser jfileChooser;

	private Window helpWindow;

	public Window getHelpWindow() {
		return helpWindow;
	}

	public void setHelpWindow(Window helpWindow) {
		this.helpWindow = helpWindow;
	}

	private static MainFrame instance = new MainFrame();

	public static MainFrame getInstance() {
		return instance;
	}

	private LookAndFeels currentLookAndFeels = LookAndFeels.SYSTEM;

	public LookAndFeels getCurrentLookAndFeels() {
		return currentLookAndFeels;
	}

	public void setCurrentLookAndFeels(LookAndFeels currentLookAndFeels) {
		this.currentLookAndFeels = currentLookAndFeels;
	}

	/**
	 * @throws HeadlessException
	 */
	private MainFrame() throws HeadlessException {
		super(TITLE);
		try {
			AwtExtensions.setIconImage("images/logo.gif", this);
		} catch (IOException e) {
			// ignore...
		}
		closeWindow = new CloseWindow();
		jfileChooser = new JFileChooser();
		addWindowListener(closeWindow);
		createTransformPanel();
		createMenubar();
	}

	private void createTransformPanel() {
		createAllJLabels();
		createJTable();
		createAllJTextAreas();
		createAllJscrollPanes();
		createAllButtons();
		createAllInsets();
		createJPanels();
		createJTabbedPane();
		createLayout();
	}

	private JPanel newLabelWithButtonPanel(JLabel label, JButton button) {
		JPanel panel = new JPanel();
		BoxLayout boxLayoutHtmlEntitys = new BoxLayout(
				panel, BoxLayout.X_AXIS);
		panel.setLayout(boxLayoutHtmlEntitys);
		panel.add(label);
		panel.add(button);
		return panel;
	}

	private JPanel newPanelWithScrollPane(JPanel labelWithButtonPanel) {
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		panel.add(labelWithButtonPanel,	BorderLayout.NORTH);
		panel.add(jscrollPanejtaHtmlEntitys, BorderLayout.CENTER);
		return panel;
	}

	private void createJPanels() {
		panelJTAHtmlEntitys = newPanelWithScrollPane(
				newLabelWithButtonPanel(labelHtmlEntitys, jbutHtmlEntitysTATransform));

		panelJTAUnicode = newPanelWithScrollPane(
				newLabelWithButtonPanel(labelUnicode, jbutUnicodeTATransform));

		panelJTAIso8859_7 = newPanelWithScrollPane(
				newLabelWithButtonPanel(labelIso8859_7, jbutIso8859_7TATransform));
	}

	private void createJTabbedPane() {
		jtpOutput = new JTabbedPane();
		jtpOutput
				.addTab(
						Messages.getString("TransformerJFrame.htmlentitys"), panelJTAHtmlEntitys); //$NON-NLS-1$
		jtpOutput.addTab(ISO_8859_7, panelJTAIso8859_7);
		jtpOutput
		.addTab(
				Messages.getString("TransformerJFrame.unicode"), panelJTAUnicode); //$NON-NLS-1$
	}

	private void createAllInsets() {
		oneInsent = new Insets(1, 1, 1, 1);
		twoInsent = new Insets(2, 2, 2, 2);
	}

	private void createLayout() {
		GridBagLayout gbl = new GridBagLayout();
		GridBagConstraints gbc = new GridBagConstraints();
		getContentPane().setLayout(gbl);

		gbc.anchor = GridBagConstraints.NORTHWEST;
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
		gbl.setConstraints(labelAlphabet, gbc);
		getContentPane().add(labelAlphabet);

		gbc.anchor = GridBagConstraints.NORTHWEST;
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
		gbl.setConstraints(labelPlaceholder, gbc);
		getContentPane().add(labelPlaceholder);

		gbc.anchor = GridBagConstraints.NORTHWEST;
		gbc.fill = GridBagConstraints.NONE;
		gbc.insets = twoInsent;
		gbc.gridx = 2;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.weighty = 0;
		gbc.weightx = 0;
		gbc.ipadx = 1;
		gbc.ipady = 1;
		gbl.setConstraints(labelPreview, gbc);
		getContentPane().add(labelPreview);

		gbc.anchor = GridBagConstraints.NORTHWEST;
		gbc.fill = GridBagConstraints.NONE;
		gbc.insets = twoInsent;
		gbc.gridx = 3;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.weighty = 0;
		gbc.weightx = 0;
		gbc.ipadx = 1;
		gbc.ipady = 1;
		gbl.setConstraints(jbutPreviewTATransform, gbc);
		getContentPane().add(jbutPreviewTATransform);

		gbc.anchor = GridBagConstraints.NORTHWEST;
		gbc.fill = GridBagConstraints.NONE;
		gbc.insets = twoInsent;
		gbc.gridx = 4;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.weighty = 0;
		gbc.weightx = 0;
		gbc.ipadx = 1;
		gbc.ipady = 1;
		gbl.setConstraints(jbutInputTACopyIso_GreekChars_ToClipboard, gbc);
		getContentPane().add(jbutInputTACopyIso_GreekChars_ToClipboard);

		gbc.anchor = GridBagConstraints.NORTHWEST;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.insets = twoInsent;
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 2;
		gbc.gridheight = GridBagConstraints.REMAINDER;
		gbc.weighty = 0;
		gbc.weightx = 0;
		gbc.ipadx = 2;
		gbc.ipady = 1;
		gbl.setConstraints(jscrollPaneTableAlphabet, gbc);
		getContentPane().add(jscrollPaneTableAlphabet);

		gbc.anchor = GridBagConstraints.NORTHWEST;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.insets = twoInsent;
		gbc.gridx = 2;
		gbc.gridy = 1;
		gbc.gridwidth = 12;
		gbc.gridheight = 3;
		gbc.weighty = 100;
		gbc.weightx = 100;
		gbc.ipadx = 1;
		gbc.ipady = 1;
		gbl.setConstraints(jscrollPanejtaPreview, gbc);
		getContentPane().add(jscrollPanejtaPreview);

		gbc.anchor = GridBagConstraints.NORTHWEST;
		gbc.fill = GridBagConstraints.NONE;
		gbc.insets = twoInsent;
		gbc.gridx = 2;
		gbc.gridy = 5;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.weighty = 0;
		gbc.weightx = 0;
		gbc.ipadx = 1;
		gbc.ipady = 1;
		gbl.setConstraints(labelInput, gbc);
		getContentPane().add(labelInput);

		gbc.anchor = GridBagConstraints.NORTHWEST;
		gbc.fill = GridBagConstraints.NONE;
		gbc.insets = twoInsent;
		gbc.gridx = 3;
		gbc.gridy = 5;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.weighty = 0;
		gbc.weightx = 0;
		gbc.ipadx = 1;
		gbc.ipady = 1;
		gbl.setConstraints(jbutInputTATranform, gbc);
		getContentPane().add(jbutInputTATranform);

		gbc.anchor = GridBagConstraints.NORTHWEST;
		gbc.fill = GridBagConstraints.NONE;
		gbc.insets = twoInsent;
		gbc.gridx = 4;
		gbc.gridy = 5;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.weighty = 0;
		gbc.weightx = 0;
		gbc.ipadx = 1;
		gbc.ipady = 1;
		gbl.setConstraints(jbutInputTACopyHtmlEntitys2Clipboard, gbc);
		getContentPane().add(jbutInputTACopyHtmlEntitys2Clipboard);

		gbc.anchor = GridBagConstraints.NORTHWEST;
		gbc.fill = GridBagConstraints.NONE;
		gbc.insets = twoInsent;
		gbc.gridx = 5;
		gbc.gridy = 5;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.weighty = 0;
		gbc.weightx = 0;
		gbc.ipadx = 1;
		gbc.ipady = 1;
		gbl.setConstraints(jbutInputTACopyIso_8859_7_ToClipboard, gbc);
		getContentPane().add(jbutInputTACopyIso_8859_7_ToClipboard);

		gbc.anchor = GridBagConstraints.NORTHWEST;
		gbc.fill = GridBagConstraints.NONE;
		gbc.insets = twoInsent;
		gbc.gridx = 6;
		gbc.gridy = 5;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.weighty = 0;
		gbc.weightx = 0;
		gbc.ipadx = 1;
		gbc.ipady = 1;
		gbl.setConstraints(jbutInputTAClear, gbc);
		getContentPane().add(jbutInputTAClear);

		gbc.anchor = GridBagConstraints.NORTHWEST;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.insets = twoInsent;
		gbc.gridx = 2;
		gbc.gridy = 6;
		gbc.gridwidth = 12;
		gbc.gridheight = 2;
		gbc.weighty = 100;
		gbc.weightx = 100;
		gbc.ipadx = 1;
		gbc.ipady = 1;
		gbl.setConstraints(jscrollPanejtaInput, gbc);
		getContentPane().add(jscrollPanejtaInput);

		gbc.anchor = GridBagConstraints.NORTHWEST;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.insets = twoInsent;
		gbc.gridx = 2;
		gbc.gridy = 8;
		gbc.gridwidth = 12;
		gbc.gridheight = 2;
		gbc.weighty = 100;
		gbc.weightx = 100;
		gbc.ipadx = 0;
		gbc.ipady = 0;
		gbl.setConstraints(jtpOutput, gbc);
		getContentPane().add(jtpOutput);
	}

	private void createAllButtons() {
		// Buttons
		jbutPreviewTATransform = new JButton(Messages
				.getString("TransformerJFrame.button.transform.greekchars")); //$NON-NLS-1$
		jbutPreviewTATransform.setToolTipText(Messages
				.getString("TransformerJFrame.7")); //$NON-NLS-1$
		jbutPreviewTATransform.addActionListener(new PreviewTATransformAction("PreviewTATransformAction"));
		jbutInputTATranform = new JButton(Messages
				.getString("TransformerJFrame.button.transform.latinchars")); //$NON-NLS-1$
		jbutInputTATranform.setToolTipText(Messages
				.getString("TransformerJFrame.9")); //$NON-NLS-1$
		jbutInputTATranform.addActionListener(new InputTATranformAction("InputTATranformAction"));
		jbutInputTACopyHtmlEntitys2Clipboard = new JButton(
				Messages
						.getString("TransformerJFrame.button.copy.htmlentitys.to.clipboard")); //$NON-NLS-1$
		jbutInputTACopyHtmlEntitys2Clipboard
				.setToolTipText(Messages
						.getString("TransformerJFrame.button.copy.htmlentitys.to.clipboard.tooltip")); //$NON-NLS-1$
		jbutInputTACopyHtmlEntitys2Clipboard.addActionListener(new InputTACopyHtmlEntitys2ClipboardAction("InputTACopyHtmlEntitys2ClipboardAction"));
		jbutInputTACopyIso_8859_7_ToClipboard = new JButton(
				Messages
						.getString("TransformerJFrame.button.copy.iso8859_7.to.clipboard")); //$NON-NLS-1$
		jbutInputTACopyIso_8859_7_ToClipboard
				.setToolTipText(Messages
						.getString("TransformerJFrame.button.copy.iso8859_7.to.clipboard.tooltip")); //$NON-NLS-1$
		jbutInputTACopyIso_8859_7_ToClipboard.addActionListener(new InputTACopyIso_8859_7_ToClipboardAction("InputTACopyIso_8859_7_ToClipboardAction"));
		jbutInputTAClear = new JButton(Messages
				.getString("TransformerJFrame.button.clear")); //$NON-NLS-1$
		jbutInputTAClear.setToolTipText(Messages
				.getString("TransformerJFrame.button.clear.tooltip")); //$NON-NLS-1$
		jbutInputTAClear.addActionListener(new InputTAClearAction("InputTAClearAction"));

		jbutHtmlEntitysTATransform = new JButton(Messages
				.getString("TransformerJFrame.button.transform.htmlentitys")); //$NON-NLS-1$
		jbutHtmlEntitysTATransform
				.setToolTipText(Messages
						.getString("TransformerJFrame.button.transform.htmlentitys.tooltip")); //$NON-NLS-1$
		jbutHtmlEntitysTATransform.addActionListener(new HtmlEntitysTATransformAction("HtmlEntitysTATransformAction"));

		jbutUnicodeTATransform = new JButton(Messages
				.getString("TransformerJFrame.button.transform.unicode")); //$NON-NLS-1$
		jbutUnicodeTATransform
				.setToolTipText(Messages
						.getString("TransformerJFrame.button.transform.unicode.tooltip")); //$NON-NLS-1$
		jbutUnicodeTATransform.addActionListener(new UnicodeTATransformAction("UnicodeTATransformAction"));


		jbutIso8859_7TATransform = new JButton(Messages
				.getString("TransformerJFrame.button.transform.iso8859_7")); //$NON-NLS-1$
		jbutIso8859_7TATransform
				.setToolTipText(Messages
						.getString("TransformerJFrame.button.transform.iso8859_7.tootip")); //$NON-NLS-1$
		jbutIso8859_7TATransform.addActionListener(new Iso8859_7TATransformAction("Iso8859_7TATransformAction"));

		jbutInputTACopyIso_GreekChars_ToClipboard = new JButton(Messages
				.getString("TransformerJFrame.button.transform.greek.chars.to.clipboard"));
		jbutInputTACopyIso_GreekChars_ToClipboard.setToolTipText(Messages
				.getString("TransformerJFrame.button.transform.greek.chars.to.clipboard.tooltip"));
		String acInputTACopyIso_GreekChars_ToClipboardAction = "InputTACopyIso_GreekChars_ToClipboardAction";
		InputTACopyIso_GreekChars_ToClipboardAction inputTACopyIso_GreekChars_ToClipboardAction =
			new InputTACopyIso_GreekChars_ToClipboardAction(acInputTACopyIso_GreekChars_ToClipboardAction);
		jbutInputTACopyIso_GreekChars_ToClipboard.addActionListener(inputTACopyIso_GreekChars_ToClipboardAction);

		KeyStrokeExtensions.addShortcutToComponent(jbutInputTACopyIso_GreekChars_ToClipboard, KeyStroke.getKeyStroke(KeyEvent.VK_D, KeyEvent.CTRL_MASK
	            + KeyEvent.ALT_MASK),  acInputTACopyIso_GreekChars_ToClipboardAction, inputTACopyIso_GreekChars_ToClipboardAction);


	}

	private void createAllJscrollPanes() {
		// JscrollPanes
		jscrollPaneTableAlphabet = new JScrollPane(jTableAlphabet);
		jscrollPanejtaPreview = new JScrollPane(jtaPreview);
		jscrollPanejtaHtmlEntitys = new JScrollPane(jtaHtmlEntitys);
		jscrollPanejtaUnicode = new JScrollPane(jtaUnicode);
		jscrollPanejtaIso8859_7 = new JScrollPane(jtaIso8859_7);
		jscrollPanejtaInput = new JScrollPane(jtaInput);
	}

	private void createAllJTextAreas() {
		// JTextArea preview:
		jtaPreview = new JTextArea(5, 50);
		jtaPreview.setLineWrap(true);
		jtaPreview.setWrapStyleWord(true);
		jtaPreview.setEditable(true);

		// JTextArea Unicode:
		jtaUnicode =  new JTextArea(5, 50);
		jtaUnicode.setLineWrap(true);
		jtaUnicode.setWrapStyleWord(true);
		jtaUnicode.setEditable(true);

		// JTextArea HTML entitys:
		jtaHtmlEntitys = new JTextArea(5, 50);
		jtaHtmlEntitys.setLineWrap(true);
		jtaHtmlEntitys.setWrapStyleWord(true);
		jtaHtmlEntitys.setEditable(true);

		// JTextArea Input:
		jtaInput = new JTextArea(5, 50);
		jtaInput.setLineWrap(true);
		jtaInput.setWrapStyleWord(true);
		jtaInput.setEditable(true);

		// JTextArea Output for ISO-8859-7:
		jtaIso8859_7 = new JTextArea(5, 50);
		jtaIso8859_7.setLineWrap(true);
		jtaIso8859_7.setWrapStyleWord(true);
		jtaIso8859_7.setEditable(true);

	}

	private void createJTable() {
		jTableAlphabet = new JTable(GreekAlphabet.greekAlphabet, columnNames);
	}

	private void createAllJLabels() {
		labelAlphabet = new JLabel(Messages
				.getString("TransformerJFrame.label.alphabet.table")); //$NON-NLS-1$
		labelPlaceholder = new JLabel(Messages
				.getString("TransformerJFrame.label.placeholder")); //$NON-NLS-1$
		labelInput = new JLabel(Messages
				.getString("TransformerJFrame.label.input.latin")); //$NON-NLS-1$
		labelHtmlEntitys = new JLabel(Messages
				.getString("TransformerJFrame.label.output.htmlentitys")); //$NON-NLS-1$
		labelUnicode = new JLabel(Messages
				.getString("TransformerJFrame.label.output.unicode")); //$NON-NLS-1$
		labelIso8859_7 = new JLabel(Messages
				.getString("TransformerJFrame.label.output.iso8859_7")); //$NON-NLS-1$
		labelPreview = new JLabel(Messages
				.getString("TransformerJFrame.label.preview")); //$NON-NLS-1$
	}

	private void createMenubar() {
		menubar = new JMenuBar();
		createFileMenu();
		// Look and Feel menu
		menuLookAndFell = new JMenu(Messages
				.getString("TransformerJFrame.menu.item.lookandfeel")); //$NON-NLS-1$
		menuLookAndFell.setMnemonic('L');
		createHelpMenu();
		menuHelp = createHelpMenu();
		// Neu
		mifNew = new JMenuItem(Messages
				.getString("TransformerJFrame.menu.item.new"), 'n'); //$NON-NLS-1$
		MenuExtensions.setCtrlAccelerator(mifNew, 'N');
		mifNew.addActionListener(new NewFileAction("NewFileAction"));
		menuFile.add(mifNew);
		// Oeffnen
		mifOpen = new JMenuItem(Messages
				.getString("TransformerJFrame.menu.item.open"), 'o'); //$NON-NLS-1$
		MenuExtensions.setCtrlAccelerator(mifOpen, 'O');
		mifOpen.addActionListener(new OpenFileAction("OpenFileAction"));
		menuFile.add(mifOpen);
		// Speichern
		mifSave = new JMenuItem(Messages
				.getString("TransformerJFrame.menu.item.save"), 's'); //$NON-NLS-1$
		MenuExtensions.setCtrlAccelerator(mifSave, 'S');
		mifSave.addActionListener(new SaveFileAction(Constants.SAVE));
		menuFile.add(mifSave);
		// Speichern unter
		mifSaveAs = new JMenuItem(Messages
				.getString("TransformerJFrame.menu.item.saveas"), 'u'); //$NON-NLS-1$
		MenuExtensions.setCtrlAccelerator(mifSaveAs, 'U');
		mifSaveAs.addActionListener(new SaveFileAction(Constants.SAVE_AS));
		menuFile.add(mifSaveAs);
		// Separator
		menuFile.addSeparator();
		// Beenden
		mifClose = new JMenuItem(Messages
				.getString("TransformerJFrame.menu.item.exit"), 'e'); //$NON-NLS-1$
		MenuExtensions.setCtrlAccelerator(mifClose, 'E');
		mifClose.addActionListener(new ExitApplicationAction("ExitApplicationAction"));
		menuFile.add(mifClose);
		// Look and Feel JMenuItems
		// Metal
		milafMetal = new JMenuItem(
				Messages
						.getString("TransformerJFrame.menu.item.lookandfeel.metal"), 'm'); //$NON-NLS-1$
		MenuExtensions.setCtrlAccelerator(milafMetal, 'M');
		milafMetal.addActionListener(new LookAndFeelMetalAction("LookAndFeelMetalAction", this));
		menuLookAndFell.add(milafMetal);
		// Motif
		milafMotiv = new JMenuItem(
				Messages
						.getString("TransformerJFrame.menu.item.lookandfeel.motif"), 't'); //$NON-NLS-1$
		MenuExtensions.setCtrlAccelerator(milafMotiv, 'T');
		milafMotiv.addActionListener(new LookAndFeelMotifAction("LookAndFeelMotifAction", this));
		menuLookAndFell.add(milafMotiv);
		// Windows
		milafWindows = new JMenuItem(
				Messages
						.getString("TransformerJFrame.menu.item.lookandfeel.windows"), 'd'); //$NON-NLS-1$
		MenuExtensions.setCtrlAccelerator(milafWindows, 'W');
		milafWindows.addActionListener(new LookAndFeelWindowsAction("LookAndFeelWindowsAction", this));
		menuLookAndFell.add(milafWindows);

		menuEdit.add(menuLookAndFell);
		// Add Menus
		menubar.add(menuFile);
		menubar.add(menuEdit);
		menubar.add(menuHelp);
		setJMenuBar(menubar);
	}

	private JMenu createHelpMenu() {
		// Help menu
		JMenu menuHelp = new JMenu(Messages
				.getString("TransformerJFrame.menu.item.help")); //$NON-NLS-1$
		menuHelp.setMnemonic('H');

		// Help JMenuItems
		// Help content
		JMenuItem mihHelpContent = new JMenuItem(Messages
				.getString("TransformerJFrame.menu.item.content"), 'c'); //$NON-NLS-1$
		MenuExtensions.setCtrlAccelerator(mihHelpContent, 'H');

		menuHelp.add(mihHelpContent);
		// found bug with the javax.help
		// Exception in thread "main" java.lang.SecurityException: no manifiest
		// section for signature file entry
		// com/sun/java/help/impl/TagProperties.class
		// Solution is to remove the rsa files from the jar

		HelpSet hs = getHelpSet();
		DefaultHelpBroker helpBroker = (DefaultHelpBroker) hs
				.createHelpBroker();
		WindowPresentation pres = helpBroker.getWindowPresentation();
		pres.createHelpWindow();
		helpWindow = pres.getHelpWindow();

		helpWindow.setLocationRelativeTo(null);

		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		SwingUtilities.updateComponentTreeUI(helpWindow);

		// 2. assign help to components
		CSH.setHelpIDString(mihHelpContent, "Overview");
		// 3. handle events
		CSH.DisplayHelpFromSource displayHelpFromSource = new CSH.DisplayHelpFromSource(
				helpBroker);
		mihHelpContent.addActionListener(displayHelpFromSource);
		mihHelpContent.addActionListener(new ShowHelpDialogAction("Content"));

		// Donate
		JMenuItem mihDonate = new JMenuItem(Messages
				.getString("TransformerJFrame.menu.item.donate")); //$NON-NLS-1$


		mihDonate.addActionListener(new OpenBrowserAction("Donate", this, Constants.URL_TO_DONATE));
		menuHelp.add(mihDonate);

		// Licence
		JMenuItem mihLicence = new JMenuItem(Messages
				.getString("TransformerJFrame.menu.item.licence")); //$NON-NLS-1$
		mihLicence.addActionListener(new ShowLicenseFrameAction("Licence"));
		menuHelp.add(mihLicence);
		// Info
		JMenuItem mihInfo = new JMenuItem(Messages
				.getString("TransformerJFrame.menu.item.info"), 'i'); //$NON-NLS-1$
		MenuExtensions.setCtrlAccelerator(mihInfo, 'I');
		mihInfo.addActionListener(new ShowInfoDialogAction("Info"));
		menuHelp.add(mihInfo);

		return menuHelp;
	}

	public HelpSet getHelpSet() {
		HelpSet hs = null;

		URL hsURL = getClass().getClassLoader().getResource(
				"gr/frame/help/simple-hs.xml");
		try {

			hs = new HelpSet(null, hsURL);
		} catch (HelpSetException e) {
			// TODO log the exception
			e.printStackTrace();
		}
		return hs;
	}

	private void createFileMenu() {
		// File menu
		menuFile = new JMenu(Messages
				.getString("TransformerJFrame.menu.item.file")); //$NON-NLS-1$
		menuFile.setMnemonic('D');
		// Edit menu
		menuEdit = new JMenu(Messages
				.getString("TransformerJFrame.menu.item.edit")); //$NON-NLS-1$
		menuEdit.setMnemonic('B');
	}

}
