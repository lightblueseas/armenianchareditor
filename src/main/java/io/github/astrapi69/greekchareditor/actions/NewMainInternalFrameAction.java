package io.github.astrapi69.greekchareditor.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JInternalFrame;

import de.alpharogroup.swing.components.factories.JComponentFactory;
import de.alpharogroup.swing.utils.JInternalFrameExtensions;
import io.github.astrapi69.greekchareditor.SpringBootSwingApplication;
import io.github.astrapi69.greekchareditor.panels.MainPanel;

/**
 * The class {@link NewMainInternalFrameAction}.
 */
public class NewMainInternalFrameAction extends AbstractAction
{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new new {@link NewMainInternalFrameAction}.
	 *
	 * @param name
	 *            the name
	 */
	public NewMainInternalFrameAction(final String name)
	{
		super(name);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void actionPerformed(final ActionEvent e)
	{
		// create internal frame
		final JInternalFrame internalFrame = JComponentFactory
			.newInternalFrame("GreekCharactersHTMLEditor", true, true, true, true);

		final MainPanel component = new MainPanel();
		JInternalFrameExtensions.addComponentToFrame(internalFrame, component);
		JInternalFrameExtensions.addJInternalFrame(
			SpringBootSwingApplication.getInstance().getMainComponent(), internalFrame);
	}

}
