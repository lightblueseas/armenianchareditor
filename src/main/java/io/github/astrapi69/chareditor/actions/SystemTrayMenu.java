package io.github.astrapi69.chareditor.actions;

import de.alpharogroup.lang.ClassExtensions;
import de.alpharogroup.swing.actions.OpenBrowserAction;
import gr.frame.MainFrame;
import io.github.astrapi69.chareditor.util.Constants;

import java.awt.AWTException;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

//import net.sourceforge.jaulp.lang.ClassUtils;
//import net.sourceforge.jaulp.swing.actions.OpenBrowserAction;


public class SystemTrayMenu {


    private static final String TRAYICON = "TRAYICON";
    private static final String QUIT = "QUIT";
    private static final String FRONT = "FRONT";

    private static final SystemTrayMenu instance = new SystemTrayMenu();

    private PopupMenu systemTrayPopupMenu;

    private TrayIcon systemTrayIcon;

    /**
     * Returns the field <code>instance</code>.
     * @return The field <code>instance</code>.
     */
    public static SystemTrayMenu getInstance() {
        return instance;
    }



    /**
     * Returns the field <code>systemTrayIcon</code>.
     * @return The field <code>systemTrayIcon</code>.
     */
    public TrayIcon getSystemTrayIcon() {
        if(null == systemTrayIcon){
            systemTrayIcon = createTrayIcon();
        }
        return systemTrayIcon;
    }

    /**
     * Returns the field <code>systemTrayPopupMenu</code>.
     * @return The field <code>systemTrayPopupMenu</code>.
     */
    public PopupMenu getSystemTrayPopupMenu() {
        if(null == systemTrayPopupMenu) {
            systemTrayPopupMenu = createPopupMenu();
        }
        return systemTrayPopupMenu;
    }

    private SystemTrayMenu() {
        super();
        try {
            SystemTray.getSystemTray().add( getSystemTrayIcon() );
        } catch ( AWTException e1 ) {
            e1.printStackTrace();
        }
    }


    public static SystemTray getSystemTray() {
        SystemTray tray = null;
        if ( SystemTray.isSupported() ) {
            tray = SystemTray.getSystemTray();
        }
        return tray;
    }

    private TrayIcon createTrayIcon(){
    	URL urlFromImage = ClassExtensions.getResource("/images/logo.gif");
        Image image = Toolkit.getDefaultToolkit().getImage( urlFromImage );
        TrayIcon trayIcon = new TrayIcon(image, getApplicationName(), getSystemTrayPopupMenu());
        trayIcon.setActionCommand( TRAYICON );
        trayIcon.addActionListener( new ActionListener(){
            @Override
            public void actionPerformed( ActionEvent e ) {
                MainFrame.getInstance().toFront();
            }
        } );
        return trayIcon;

    }

    protected String getApplicationName(){
    	return "Greek char editor";
    }

    protected PopupMenu createPopupMenu() {
        PopupMenu popupMenu = new PopupMenu();

        MenuItem miBringToFront = new MenuItem("Bring to front");
        miBringToFront.setActionCommand( FRONT );
        popupMenu.add( miBringToFront );

        miBringToFront.addActionListener( new ActionListener(){

            @Override
            public void actionPerformed( ActionEvent e ) {
            	MainFrame.getInstance().toFront();
            }

        } );

        MenuItem miDonate = new MenuItem("Donate");
        miDonate.addActionListener(new OpenBrowserAction("Donate", MainFrame.getInstance(), Constants.URL_TO_DONATE));
        popupMenu.add( miDonate );

        MenuItem miQuit = new MenuItem("Quit");
        miQuit.setActionCommand( QUIT );
        popupMenu.add( miQuit );
        miQuit.addActionListener(  new ActionListener(){

            @Override
            public void actionPerformed( ActionEvent e ) {
                System.exit( 0 );
            }

        } );

        return popupMenu;
    }

}
