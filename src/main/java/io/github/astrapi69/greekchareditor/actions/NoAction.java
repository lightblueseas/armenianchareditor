package io.github.astrapi69.greekchareditor.actions;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * The class {@link NoAction} as the name say there is no action
 */
public class NoAction extends AbstractAction
{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new {@link NoAction} object
	 *
	 * @param name
	 *            the name
	 */
	public NoAction(final String name)
	{
		super(name);
	}

	/**
	 * Instantiates a new {@link NoAction} object
	 */
	public NoAction()
	{
		this("No action");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override public void actionPerformed(final ActionEvent e)
	{
	}

}
