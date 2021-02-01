package io.github.astrapi69.chareditor;

import de.alpharogroup.swing.base.AbstractApplicationFrame;
import de.alpharogroup.swing.base.BasePanel;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

/**
 * The class {@link ApplicationPanelFrame}
 *
 * @param <T>
 *            the generic type of the model object
 */
@Getter
@Setter
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public abstract class ApplicationPanelFrame<T> extends AbstractApplicationFrame<T, BasePanel<T>>
{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new {@link ApplicationPanelFrame}
	 *
	 * @param title
	 *            the title
	 */
	public ApplicationPanelFrame(String title)
	{
		super(title);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void onInitializeComponents()
	{
		super.onInitializeComponents();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected abstract BasePanel<T> newMainComponent();

}
