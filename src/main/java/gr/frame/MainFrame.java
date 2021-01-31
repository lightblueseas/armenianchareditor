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
import gr.frame.actions.ShowHelpDialogAction;
import gr.frame.actions.ShowInfoDialogAction;
import gr.frame.actions.ShowLicenseFrameAction;
import gr.frame.events.NewFileAction;
import gr.frame.events.OpenFileAction;
import gr.frame.events.SaveFileAction;
import gr.frame.util.Constants;
import io.github.astrapi69.greekchareditor.panels.MainPanel;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import javax.help.*;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URL;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MainFrame extends JFrame {

	private static final long serialVersionUID = -8104731925219304594L;

	public static final String TITLE = Messages
			.getString("TransformerJFrame.title"); //$NON-NLS-1$

	public static final String ISO_8859_7 = Messages
			.getString("TransformerJFrame.iso8859_7"); //$NON-NLS-1$

	public static final String[] columnNames = {
			Messages.getString("TransformerJFrame.column.greek"), Messages.getString("TransformerJFrame.column.latin"), Messages.getString("TransformerJFrame.column.htmlentitys"), ISO_8859_7}; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$

	// JMenuBar and JMenus
	JMenuBar menubar;

	JMenu menuFile;

	JMenu menuEdit;

	JMenu menuLookAndFell;

	JMenu menuHelp;

	// File-MenuItems
	JMenuItem mifNew;

	JMenuItem mifOpen;

	JMenuItem mifSave;

	JMenuItem mifSaveAs;

	JMenuItem mifClose;

	// Look and Feel-MenuItems
	JMenuItem milafMetal;

	JMenuItem milafMotiv;

	JMenuItem milafWindows;

	CloseWindow closeWindow;

	JFileChooser jfileChooser;

	Window helpWindow;

	MainPanel mainPanel;

	private static MainFrame instance = new MainFrame();

	public static MainFrame getInstance() {
		return instance;
	}

	private LookAndFeels currentLookAndFeels = LookAndFeels.SYSTEM;

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
		mainPanel = new MainPanel();
		addWindowListener(closeWindow);
		createTransformPanel();
		createMenubar();
	}

	private void createTransformPanel() {
		getContentPane().add(mainPanel);
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
				"help/simple-hs.xml");
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
